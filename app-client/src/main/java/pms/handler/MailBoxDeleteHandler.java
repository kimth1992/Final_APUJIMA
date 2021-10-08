package pms.handler;

import java.util.Collection;
import pms.domain.MailBox;
import request.RequestAgent;
import util.Prompt;

public class MailBoxDeleteHandler implements Command{
  RequestAgent requestAgent;

  public MailBoxDeleteHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[쪽지 삭제] 페이지입니다.");
    System.out.println();
    while(true) {
      String no = Prompt.inputString("쪽지 번호(쪽지함 리스트 보기 : @)> ");
      if(no.equals("@")) {
        int mailNo = 0;
        int count = 0;

        requestAgent.request("mailBox.selectList", null);


        if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
          System.out.println("쪽지함이 비어 있습니다.");
          return;
        }

        Collection<MailBox> mailBoxList = requestAgent.getObjects(MailBox.class);

        for (MailBox mailBox : mailBoxList) {
          if(mailBox.getReceiver().equals(AuthLoginHandler.getLoginUser().getId())) {
            mailNo++;
            mailBox.setMailNo(mailNo);
            requestAgent.request("mailBox.update", mailBox);

            System.out.printf("쪽지 번호 : %d\n"
                +"보낸 사람 : %s\n"
                +"쪽지 제목 : %s\n",
                mailBox.getMailNo(),
                mailBox.getSender(),
                mailBox.getTitle()); 
            count++;
            System.out.println();

          }
        }

        if (count == 0 ){
          System.out.println("받은 쪽지가 없습니다.");
          continue;
        }
      }

      else {

        requestAgent.request("mailBox.selectList", null);
        if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
          System.out.println("입력한 숫자의 쪽지가 없습니다.");
          return;
        } else {
          Collection<MailBox> mailBoxList = requestAgent.getObjects(MailBox.class);

          String input = Prompt.inputString(" ❗ 정말 삭제하시겠습니까? (y/N)> ");
          if(input.equalsIgnoreCase("n") || input.length() == 0) {
            System.out.println("쪽지 삭제를 취소하였습니다.");
            return;
          }

          for (MailBox mailBox : mailBoxList) {
            if(mailBox.getReceiver().equals(AuthLoginHandler.getLoginUser().getId()) && mailBox.getNo() == Integer.parseInt(no)) {
              requestAgent.request("mailBox.delete", mailBox);
            }
          }

          if(requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
            System.out.println("선택한 쪽지를 삭제하였습니다.");
            return;
          } else {
            System.out.println("입력한 숫자의 쪽지가 없습니다.");
          }
        }
      }
    }
  }
}



