package pms.table;

import java.util.ArrayList;
import pms.domain.Medicine;
import server.DataProcessor;
import server.Request;
import server.Response;

public class MedicineTable extends JsonDataTable<Medicine> implements DataProcessor{

  public MedicineTable() {
    super("medicine.json", Medicine.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "medicine.insert": insert(request, response); break;
      case "medicine.selectList": selectList(request, response); break;
      case "medicine.selectListByKeyword": selectListByKeyword(request, response); break;
      case "medicine.selectOne": selectOne(request, response); break;
      case "medicine.delete": delete(request, response); break;
      case "medicine.selectOneByName": selectOneByName(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    Medicine medicine = request.getObject(Medicine.class);
    list.add(medicine);
    response.setStatus(Response.SUCCESS);
  }


  private void selectList(Request request, Response response) throws Exception {
    if(list.size() == 0) {
      response.setStatus(Response.FAIL);
      response.setValue(null);
      return;
    }
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  //이름으로 불러옴
  private void selectOne(Request request, Response response) throws Exception {
    String name = request.getParameter("name");
    Medicine medicine = findByName(name);
    if (medicine != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(medicine);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 약품이 없습니다.");
    }

  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("keyword");

    ArrayList<Medicine> searchResult = new ArrayList<>();
    for (Medicine medicine : list) {
      if (!medicine.getName().contains(keyword) &&
          !medicine.getEffect().contains(keyword) /*&&
          !medicine.getWriter().getName().contains(keyword)*/) {
        continue;
      }
      searchResult.add(medicine);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOneByName(Request request, Response response) throws Exception {
    String name = request.getParameter("input");
    Medicine medicine = null;
    for (Medicine m : list) {
      if (m.getName().equals(name)) {
        medicine = m;
        break;
      }
    }

    if (medicine != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(medicine);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 이름의 약품을 찾을 수 없습니다.");
    }
  }

  private void delete(Request request, Response response) throws Exception {
    Medicine medicine = request.getObject(Medicine.class);
    int index = indexOf(medicine.getName());

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 이름의 약품을 찾을 수 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }

  private Medicine findByName(String name) {
    for (Medicine m : list) {
      if (m.getName() == name) {
        return m;
      }
    }
    return null;
  }


  private int indexOf(String name) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName() == name) {
        return i;
      }
    }
    return -1;
  }






}
