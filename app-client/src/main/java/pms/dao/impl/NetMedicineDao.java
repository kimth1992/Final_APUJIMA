package pms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pms.dao.MedicineDao;
import pms.domain.Medicine;
import request.RequestAgent;

public class NetMedicineDao implements MedicineDao {
  RequestAgent requestAgent;

  public NetMedicineDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }


  @Override
  public void insert(Medicine medicine) throws Exception {
    requestAgent.request("medicine.insert", medicine);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception(requestAgent.getObject(String.class));
    }
  }

  @Override
  public List<Medicine> findAll() throws Exception {
    requestAgent.request("medicine.selectList", null);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception(requestAgent.getObject(String.class));
    }

    return new ArrayList<>(requestAgent.getObjects(Medicine.class));
  }

  @Override
  public List<Medicine> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("medicine.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("약품 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(Medicine.class));
  }

  @Override
  public Medicine findByNo(int no) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("no", String.valueOf(no));

    requestAgent.request("medicine.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(Medicine.class);
  }

  @Override
  public Medicine findByName(String name) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("name", name);

    requestAgent.request("medicine.selectOneByName", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(Medicine.class);
  }

  @Override
  public void update(Medicine medicine) throws Exception {
    requestAgent.request("medicine.update", medicine);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("약품 변경 실패!");
    }
  }

  @Override
  public void delete(String name) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("name", String.valueOf(name));

    requestAgent.request("medicine.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("약품 삭제 실패!");
    }
  }

  @Override
  public void check(Medicine medicine) throws Exception {
    requestAgent.request("medicine.check", medicine);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("이미 등록된 약품 입니다.");
    }
  }



}
