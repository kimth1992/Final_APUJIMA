package pms.handler;

import java.util.List;
import pms.domain.CounselingMember;
import pms.domain.Member;
import util.Prompt;

public class CounselingMemberAddHandler extends AbstractCounselingMemberHandler{

  public CounselingMemberAddHandler(List<CounselingMember> counselingMemberList) {
    super(counselingMemberList);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void execute() {
    System.out.println("[상담 신청]페이지입니다.");
    System.out.println();
    Member loginUser = AuthLoginHandler.getLoginUser();
    CounselingMember counselingMember = new CounselingMember();

    System.out.printf("이름: %s\n", loginUser.getName());
    System.out.printf("연락처: %s\n", loginUser.getPhoneNum());


    counselingMember.setDisease(Prompt.inputString("지병 여부> "));
    counselingMember.setContent(Prompt.inputString("상담 내용> "));

    System.out.println();
    System.out.println("[상담 주제]");
    System.out.println("1. 우울증");
    System.out.println("2. 진로");
    System.out.println("3. 일상생활");
    System.out.println("4. 연애");
    System.out.println("5. 인간관계");
    System.out.println("6. 기타");
    int counselingStatus = (Prompt.inputInt("선택> "));
    System.out.println();

    String stateLabel = null;
    switch (counselingStatus) {
      case 1:
        stateLabel = "우울증";
        break;
      case 2:
        stateLabel = "진로";
        break;
      case 3:
        stateLabel = "일상생활";
        break;
      case 4:
        stateLabel = "연애";
        break;
      case 5:
        stateLabel = "인간관계";
        break;
      case 6:
        stateLabel = "기타";
        break;
    }
    counselingMember.setStateLabel(stateLabel);

    System.out.println();
    System.out.println("상담사 성별> ");
    System.out.println("1. 여성 상담사");
    System.out.println("2. 남성 상담사");
    System.out.println("3. 상관없음");
    int counselorStatus = Prompt.inputInt("선택> ");

    String stateLabel2 = null;
    switch (counselorStatus) {
      case 1:
        stateLabel2 = "여성 상담사";
        break;
      case 2:
        stateLabel2 = "남성 상담사";
        break;
      case 3:
        stateLabel2 = "상관없음";
        break;
    }
    counselingMember.setStateLabel2(stateLabel2);


    counselingMemberList.add(counselingMember);

    //    for (CounselingMember c : counselingmemberList) {
    //      System.out.println(c);
    //    }

    System.out.println();
    //    memberAppList.add(counselingMember);

    System.out.println("신청이 완료되었습니다.");
    System.out.println();
  }

}
