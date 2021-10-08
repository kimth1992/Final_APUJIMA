package pms.handler;

import java.util.List;
import pms.domain.Plant;
import request.RequestAgent;
import util.Prompt;


public class PlantListHandler implements Command {

  RequestAgent requestAgent;
  public PlantListHandler(RequestAgent requestAgent ) {
    this.requestAgent = requestAgent;
  }
  @Override
  public void execute(CommandRequest request) throws Exception {

    int findCount = 0;
    System.out.println();
    System.out.println("[화분 목록]");




    requestAgent.request("plant.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("화분 조회 실패!");
      return;
    }

    List<Plant> plantList = (List<Plant>) requestAgent.getObjects(Plant.class);




    for (Plant plant : plantList) {
      System.out.printf("%s, %s\n",
          plant.getPlantName(),
          plant.getOwnerName()
          );
      // plant.getExp(),
      // plant.getLevel(),
      //  plant.getShape());
    }

    while (true) {
      String input = Prompt.inputString("[검색(S) / 뒤로가기(0)] ");

      switch (input) {
        case "S":
        case "s":
          System.out.println("[화분 상세검색] 페이지입니다. ");
          String find = Prompt.inputString("검색할 화분이나 Id를 입력해주세요> ");
          for(Plant findplantList : plantList) {
            if(!findplantList.getOwnerName().contains(find) &&  !findplantList.getPlantName().contains(find)) {
              continue;
            }
            findCount++;
            System.out.println();
            System.out.println("화분 이름: " + findplantList.getPlantName());
            System.out.println("화분 주인: " + findplantList.getOwnerName());
            System.out.println("화분 누적 경험치: " + findplantList.getExp());
            System.out.println("화분 레벨: " + findplantList.getLevel());
            System.out.println("화분 모양: " + findplantList.getShape());

            System.out.println("화분을 키운 날짜: " + findplantList.getRegisteredDate());
            System.out.println();
          } if (findCount == 0) {
            System.out.println("찾는 ID나 화분이 없습니다.");
          }



        case "0" :
          return;
        default :
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }



}