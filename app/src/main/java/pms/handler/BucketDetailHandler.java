package pms.handler;

import java.util.List;
import pms.domain.Bucket;
import util.Prompt;

public class BucketDetailHandler extends AbstractBucketListHandler {

  public BucketDetailHandler(List<Bucket> bucketList) {
    super(bucketList);
  }


  @Override
  public void execute(CommandRequest request) throws Exception{

    System.out.println();
    System.out.println("[나만의 버킷리스트 상세보기] 페이지입니다.");
    System.out.println();


    int num = Prompt.inputInt("버킷리스트 번호> ");

    Bucket bucket = findByNo(num);

    if (bucket == null) {
      System.out.println("해당 번호의 버킷리스트가 없습니다.");
      return;
    }
    System.out.printf("번호: %d\n", bucket.getNo());
    System.out.printf("제목: %s\n", bucket.getTitle());
    System.out.printf("내용: %s\n", bucket.getContent());
    System.out.printf("등록일: %s\n", bucket.getRegisteredDate());

    request.setAttribute("num", num);
    while(true) {
      String input = Prompt.inputString("달성체크(C), 이전(0)> ");
      switch(input) {
        case "C":
        case "c": 
          request.getRequestDispatcher("/bucket/complete").forward(request);
          return;

        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }

}
