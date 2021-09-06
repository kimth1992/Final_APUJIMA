package pms.handler;

import java.util.List;
import pms.domain.DoctorBoard;
import util.Prompt;

public class DoctorBoardDelete  extends AbstractDoctorBoard{

  public DoctorBoardDelete(List<DoctorBoard> doctorBoardList) {
    super(doctorBoardList);
  }

  public void delete() {
    System.out.println();
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    DoctorBoard doctorBoard = findByNo(no);

    if (doctorBoard == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    doctorBoardList.remove(doctorBoard);

    System.out.println("게시글을 삭제하였습니다.");
  }

}
