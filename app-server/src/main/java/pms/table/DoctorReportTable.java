package pms.table;

import pms.domain.DoctorBoard;
import server.DataProcessor;
import server.Request;
import server.Response;

public class DoctorReportTable extends JsonDataTable<DoctorBoard> implements DataProcessor{

  public DoctorReportTable() {
    super("doctorReport.json", DoctorBoard.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "doctorReport.insert": insert(request, response); break;
      case "doctorReport.selectList": selectList(request, response); break;
      case "doctorReport.selectOne": selectOne(request, response); break;
      case "doctorReport.delete": delete(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    DoctorBoard doctorBoard = request.getObject(DoctorBoard.class);
    list.add(doctorBoard);
    System.out.println("서버에 신고 데이터 저장 성공!");
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    if(list.size() == 0) {
      response.setStatus(Response.FAIL);
      return;
    }
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    DoctorBoard b = findByNo(no);

    if (b != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(b);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void delete(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    int index = indexOf(no);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("삭제 목록 게시판에 입력하신 게시판 번호가 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

  private DoctorBoard findByNo(int no) {
    for (DoctorBoard b : list) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }


}