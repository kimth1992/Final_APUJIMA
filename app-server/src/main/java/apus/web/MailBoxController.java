package apus.web;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import apus.dao.MailBoxDao;
import apus.dao.MemberDao;
import apus.domain.MailBox;
import apus.domain.Member;

@Controller
public class MailBoxController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired MailBoxDao mailBoxDao;
  @Autowired MemberDao memberDao;



  @GetMapping("/mailbox/list")
  public ModelAndView list(HttpSession session) throws Exception {
    List<Member> memberList = memberDao.findAll();
    List<MailBox> mailBoxList = mailBoxDao.findAll();

    Member member = ((Member) session.getAttribute("loginUser"));

    int count = 0;
    for (int i = 0; i < mailBoxList.size(); i++) {
      if (member.getNickname().equals(mailBoxList.get(i).getReceiver().getNickname())) {
        if (mailBoxList.get(i).getReceivedTime() == null) {
          count++;
        }
      }
    }


    ModelAndView mv = new ModelAndView();
    mv.addObject("mailBoxList", mailBoxList);
    mv.addObject("memberList", memberList);
    mv.addObject("uncheckedMail", count);
    mv.addObject("pageTitle", "쪽지함목록");
    mv.addObject("contentUrl", "/mailbox/MailBoxList.jsp");
    mv.setViewName("template4");
    return mv;
  }

  @GetMapping("/mailbox/detail")
  public ModelAndView detail(int no) throws Exception {
    MailBox mailBox = mailBoxDao.findByNo(no);
    mailBox.setReceivedTime(new Date(System.currentTimeMillis()));
    mailBoxDao.update(mailBox);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "쪽지함상세");
    mv.addObject("mailBox", mailBox);
    mv.addObject("contentUrl", "/mailbox/MailBoxDetail.jsp");
    mv.setViewName("template4");
    return mv;
  }

  @GetMapping("/mailbox/readlist")
  public ModelAndView readlist() throws Exception {
    Collection<Member> memberList = memberDao.findAll();
    List<MailBox> mailBoxList = mailBoxDao.findByCheckedTime();

    ModelAndView mv = new ModelAndView();
    mv.addObject("mailBoxList", mailBoxList);
    mv.addObject("memberList", memberList);
    mv.addObject("pageTitle", "읽은쪽지함");
    mv.addObject("contentUrl", "/mailbox/MailBoxReadList.jsp");
    mv.setViewName("template4");
    return mv;
  }

  @GetMapping("/mailbox/notreadlist")
  public ModelAndView notreadlist() throws Exception {
    Collection<Member> memberList = memberDao.findAll();
    List<MailBox> mailBoxList = mailBoxDao.findByTime();

    ModelAndView mv = new ModelAndView();
    mv.addObject("mailBoxList", mailBoxList);
    mv.addObject("memberList", memberList);
    mv.addObject("pageTitle", "읽은쪽지함");
    mv.addObject("contentUrl", "/mailbox/MailBoxReadList.jsp");
    mv.setViewName("template4");
    return mv;
  }

  @PostMapping("/mailbox/send")
  public ModelAndView send(MailBox mailBox, String nickname, HttpSession session,
      String title, String content) throws Exception {

    Member member = memberDao.findByNickname(nickname);
    mailBox.setSender((Member) session.getAttribute("loginUser"));
    mailBox.setReceiver(member);
    mailBox.setTitle(title);
    mailBox.setContent(content);


    mailBoxDao.insert(mailBox);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }


}
