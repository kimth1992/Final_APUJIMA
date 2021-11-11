package apus.servlet;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import apus.dao.BoardDao;
import apus.dao.LikeDao;
import apus.dao.MemberDao;
import apus.domain.Board;
import apus.domain.Like;
import apus.domain.Member;

@WebServlet("/like/add")
public class LikeAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  BoardDao boardDao;
  MemberDao memberDao;
  LikeDao likeDao;
  SqlSession sqlSession;


  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
    boardDao = (BoardDao) 웹애플리케이션공용저장소.getAttribute("boardDao");
    likeDao = (LikeDao)웹애플리케이션공용저장소.getAttribute("likeDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");

  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession(false);


    if (session.getAttribute("loginUser") == null) {
      response.sendRedirect("/apus/index.jsp");
      return;
    }
    try {
      Member liker = (Member) request.getSession(false).getAttribute("loginUser");

      if(liker == null) {
        throw new Exception("해당 번호의 회원이 없습니다.");
      }
      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findByNo(no);

      if(board == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      }

      Collection<Like> likeList = likeDao.findBoardLike(board.getNo());


      int count = likeList.size()+1;

      Like like = new Like();


      String likedUser = null;
      if (request.getParameter("liker")!= null) {
        likedUser = request.getParameter("liker"); 
      }

      String likedBoard = null;
      if (request.getParameter("likeBoard") != null) {
        likedBoard = request.getParameter("likeBoard");
      }

      like.setLiker(liker);
      like.setLikeBoard(board);


      likeDao.insert(like);
      sqlSession.commit();

      request.setAttribute("likeList", likeList);
      request.setAttribute("like", like);
      response.sendRedirect("../board/detail?no=" + board.getNo());

    }  
    catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}