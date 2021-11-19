package apus.web;

import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import apus.dao.BoardDao;
import apus.dao.CommentDao;
import apus.dao.MemberDao;
import apus.domain.Board;
import apus.domain.Comment;
import apus.domain.Member;

@Controller
public class CommentController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired CommentDao commentDao;
  @Autowired MemberDao memberDao;
  @Autowired BoardDao boardDao;
  @Autowired ServletContext sc;

  @GetMapping("/comment/add")
  public ModelAndView add(String content, String board_no, HttpSession session) {

    Member Commenter = (Member)session.getAttribute("loginUser");

    try {
      Board board = boardDao.findByNo(Integer.parseInt(board_no));

      Collection<Comment> commentList = commentDao.findBoardComment(board.getNo());

      Comment comment = new Comment();
      comment.setContent(content);
      comment.setCommenter(Commenter);
      comment.setCommentBoard(board);

      commentDao.insert(comment);
      sqlSessionFactory.openSession().commit();
      // 데이터는 잘 넘어감

      ModelAndView mv = new ModelAndView();
      mv.setViewName("redirect:../board/detail?no="+board.getNo());
      // mv.setViewName("board/detail?no="+board.getNo());
      return mv;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }


  @GetMapping("/comment/delete")
  public ModelAndView delete(String no, String board_no) throws Exception {
    Comment comment = commentDao.findByNo(Integer.parseInt(no));

    commentDao.delete(comment.getNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../board/detail?no="+board_no);
    return mv;
  }



  @GetMapping("/comment/update")
  public ModelAndView update(String no, String board_no, HttpSession session, String content) throws Exception {

    //   Member Commenter = (Member)session.getAttribute("loginUser");


    Comment comment = commentDao.findByNo(Integer.parseInt(no));
    Board board = boardDao.findByNo(Integer.parseInt(board_no));
    comment.setContent(content);
    commentDao.update(comment);
    boardDao.update(board);
    sqlSessionFactory.openSession().commit();


    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../board/detail?no="+board_no);
    return mv;
  }


}
