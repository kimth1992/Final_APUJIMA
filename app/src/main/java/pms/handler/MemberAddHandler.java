package pms.handler;

import java.sql.Date;
import java.util.List;
import pms.domain.Member;
import util.Prompt;

public class MemberAddHandler extends AbstractMemberHandler{

  public MemberAddHandler(List<Member> memberList) {
    super(memberList); 

  }

  @Override
  public void execute(CommandRequest request) {
    System.out.println();
    System.out.println("[회원가입] 페이지입니다.");
    Member member = new Member();

    while (true) {
      try {
        String input = Prompt.inputString("1.일반 2.의사 선택 (뒤로가기 #)> ");

        if(input.equals("#")) {
          return;
        }
        member.setDoctorOrNot(Integer.parseInt(input));

        if (member.getDoctorOrNot() == 1) {
          break;
        } else if (member.getDoctorOrNot() == 2) {
          member.setDoctorLicense(Prompt.inputString("의료인 면허 증명서> "));
          member.setInterest(Prompt.inputString("전문 분야> "));
          break;
        } else {
          System.out.println("1 or 2 중에 하나로 입력해 주세요.");
          continue;
        }
      } catch (Exception e) {
        System.out.println("1 or 2 중에 하나로 입력해 주세요.");
      }
    }



    while(true) {
      member.setName(Prompt.inputString("이름> "));
      if (member.getName().contains("#")) {
        System.out.println("이름에는 특수문자를 사용할 수 없습니다.");
        System.out.println();
      } else {
        break;
      }
    }
    while(true) {
      member.setId(Prompt.inputString("아이디> "));
      if (member.getId().contains("#")) {
        System.out.println("아이디에는 특수문자를 사용할 수 없습니다.");
        System.out.println();
        continue;
      } 

      for(int i = 0 ; i < memberList.size() ; i++) {
        if(member.getId().equals(memberList.get(i).getId())) {
          System.out.println("중복되는 아이디 입니다. 다른 아이디를 사용해 주세요.");
          member.setId("");
          continue;
        }
      }
      if(member.getId() != "")
        break;
    }

    if(member.getName().equals("관리자") && member.getId().equals("admin")) {
      member.setDoctorOrNot(3);
    }

    member.setPassword(Prompt.inputString("비밀번호> "));
    member.setBirthDay(Prompt.inputDate("생년월일> "));
    while(true) {
      member.setEmail(Prompt.inputString("이메일> "));
      if(member.getEmail().contains("@") && member.getEmail().length() > 2) {
        break;
      } else {
        System.out.println("올바른 양식으로 이메일을 작성해주세요.(@만 입력하실 수 없습니다.)");
      }
    }
    member.setPhoneNum(Prompt.inputString("전화번호> "));
    member.setPhoto(Prompt.inputString("회원 사진> "));

    while(true) {
      member.setSex(Prompt.inputString("성별(남/여)> "));
      if(member.getSex().equalsIgnoreCase("남") || member.getSex().equalsIgnoreCase("여")) {
        break;
      } else {
        System.out.println("남 or 여 중에 하나로 다시 입력해주세요");
      }
    }
    member.setCount(1000);
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
    System.out.println();
    System.out.println("회원가입 완료!");
    System.out.println("신규 회원가입 이벤트로 1000포인트가 지급되었습니다!");
  }


}
