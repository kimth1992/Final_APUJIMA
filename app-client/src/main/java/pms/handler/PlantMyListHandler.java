package pms.handler;


import java.util.List;
import pms.dao.PlantDao;
import pms.domain.Plant;

public class PlantMyListHandler implements Command {

  PlantDao plantDao;

  public PlantMyListHandler(PlantDao plantDao) {
    this.plantDao = plantDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    String loginUser = AuthLoginHandler.getLoginUser().getId();


    int count = 0;
    System.out.println();
    System.out.println("[내 화분 목록]");



    List<Plant> plantList = plantDao.findAll();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }

    if (plantList == null) {
      System.out.println("목록 불러오기 실패.");
    }


    for (Plant plant :plantList) {
      if(plant.getOwnerName().equals(loginUser)) {
        count++;
        System.out.printf("화분 번호: %d\n", count);
        System.out.printf("화분 이름: %s\n", plant.getPlantName());
        System.out.printf("화분 누적 경험치: %d\n", plant.getExp());
        System.out.printf("화분 레벨: %d\n", plant.getLevel());
        System.out.printf("화분 모양: %s\n", plant.getShape());
        System.out.printf("화분을 키운 날짜: %s\n", plant.getRegisteredDate());
      }
    }

    if (count == 0) {
      System.out.println("심은 식물이 없습니다.");
    }

  }
}