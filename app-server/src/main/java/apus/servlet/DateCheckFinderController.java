package apus.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import apus.dao.DateCheckDao;
import apus.dao.MemberDao;
import apus.domain.DateCheck;
import apus.domain.Member;

@WebServlet("/auth/dateCheckFinder")
public class DateCheckFinderController extends HttpServlet{

  private static final long serialVersionUID = 1L;
  MemberDao memberDao;
  DateCheckDao dateCheckDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
    dateCheckDao = (DateCheckDao) 웹애플리케이션공용저장소.getAttribute("dateCheckDao");

  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {

      HttpSession session = request.getSession(false);

      if (session.getAttribute("loginUser") == null) {
        response.sendRedirect("/apus/index.jsp");
        return;
      }

      //출석 체크 하는 사람.(LoginUser)
      Member member = (Member) request.getSession(false).getAttribute("loginUser");

      if(member == null) {
        throw new Exception("해당 번호의 회원이 없습니다.");
      } 

      int memberNo = member.getNo();
      DateCheck dateCheck = dateCheckDao.findByMemberAndDate(memberNo);


      if (dateCheck == null) {
        request.getRequestDispatcher("/auth/attendanceCheck").forward(request, response);

      } else if (dateCheck != null) {

        request.setAttribute("dateCheck", dateCheck);

        // 출력을 담당할 뷰를 호출한다.
        RequestDispatcher 요청배달자 = request.getRequestDispatcher("/auth/dateCheckPro.jsp");
        요청배달자.forward(request, response);
      }
    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);
      e.printStackTrace();

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }

}
