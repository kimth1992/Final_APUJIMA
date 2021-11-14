package apus.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import apus.dao.CounselingDao;
import apus.dao.MemberDao;
import apus.domain.Counseling;

@WebServlet("/counseling/detail")
public class CounselingMemberDetailController extends HttpServlet{

  private static final long serialVersionUID = 1L;
  CounselingDao counselingDao;
  MemberDao memberDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    counselingDao = (CounselingDao) 웹애플리케이션공용저장소.getAttribute("counselingDao");
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    int no = Integer.parseInt(request.getParameter("no"));
    try {
      Counseling counseling = counselingDao.findByNo(no);

      if (counseling == null) {
        throw new Exception("해당 번호의 상담이 없습니다.");
      }

      counseling.getDisease();
      counseling.getContent();
      counseling.getCounselor();
      counseling.getRegisteredDate();

      request.setAttribute("counseling", counseling);
      request.getRequestDispatcher("CounselingMemberDetail.jsp").forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      e.printStackTrace();
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
    //    try {
    //      Collection<Member> memberList = memberDao.findAll();
    //      // 클라이언트 요청을 처리하는데 필요한 데이터 준비
    //      Collection<Counseling> counselingList = counselingDao.findAll();
    //
    //      // 뷰 컴포넌트가 준비한 데이터를 사용할 수 있도록 저장소에 보관한다.
    //      request.setAttribute("counselingList", counselingList);
    //      request.setAttribute("memberList", memberList);
    //      // 출력을 담당할 뷰를 호출한다.
    //      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/counseling/CounselingMemberDetail.jsp");
    //      요청배달자.forward(request, response);
    //
    //    } catch (Exception e) {
    //      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
    //      e.printStackTrace();
    //      request.setAttribute("error", e);
    //
    //      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
    //      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
    //      요청배달자.forward(request, response);
    //    }
  }

}