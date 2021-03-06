package pms.handler;

import java.util.List;
import pms.domain.Medicine;
import util.Prompt;

public class MedicineSearchHandler extends AbstractMedicineHandler{

  public MedicineSearchHandler(List<Medicine> medicineList) {
    super(medicineList);
  }

  @Override
  public void execute(CommandRequest request) {

    System.out.println();
    String input = Prompt.inputString("검색할 약품명을 입력해주세요 > ");
    System.out.println();


    int count = 0;
    for (Medicine medicineList : medicineList) {
      if (!medicineList.getName().contains(input))
      {
        continue;
      }
      count++;
      System.out.printf("약품명: %s\n", medicineList.getName());
      System.out.printf("권장연령: %d\n", medicineList.getAgeLimit());
      System.out.printf("모  양: %s\n", medicineList.getShape()); // 우리는 익명이기 때문에 Id로
      System.out.printf("색  상: %s\n", medicineList.getColor());
      System.out.printf("효  능: %s\n", medicineList.getEffect());
      System.out.println();

    }
    if (count == 0 ) {
      System.out.println("찾는 약품이 없습니다.");
    }
  }


}






