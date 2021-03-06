package pms.handler;

import java.util.List;
import pms.domain.Medicine;
import util.Prompt;

public class AdminApprovalHandler implements Command {

  List<Medicine> requestList;
  List<Medicine> medicineList;


  public AdminApprovalHandler(List<Medicine> requestList, List<Medicine> medicineList) {
    this.requestList = requestList;
    this.medicineList = medicineList;
  }

  @Override
  public void execute(CommandRequest request) {
    System.out.println();
    System.out.println("[약품 등록 허가]");

    if(requestList.size() == 0) {
      System.out.println("약품 등록 요청건이 없습니다.");
      return;
    }

    for(int i = 0; i< requestList.size(); i++) {
      System.out.printf("약품명 : %s\n"
          + "권장나이 : %d\n"
          + "모  양 : %s\n"
          + "색  상 : %s\n"
          + "효  능 : %s\n" ,
          requestList.get(i).getName(), requestList.get(i).getAgeLimit(), requestList.get(i).getShape(),
          requestList.get(i).getColor(), requestList.get(i).getEffect());
      System.out.println();
    }

    System.out.println("승인 허가할 약품의 이름을 입력하세요.");

    String input = Prompt.inputString("약품명 (뒤로가기 #)> ");
    if(input.equals("#"))
      return;

    for(int i = 0; i< requestList.size(); i++) {
      if(input.equals(requestList.get(i).getName()) ) {
        medicineList.add(requestList.get(i));
        System.out.println("약품이 등록되었습니다.");
        requestList.remove(i);
        break;
      } else if(i == (requestList.size() -1)){
        System.out.println("입력하신 약품명이 잘못되었습니다.");
        break;
      }
    } 
  }
}

