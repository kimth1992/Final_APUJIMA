package apus.domain;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
  private int no;
  private String name;
  private String id;
  private String password;
  private Date birthday;
  private String email;
  private String tel;
  private String photo;
  private String sex;
  private Date registeredDate;
  private String nickname;
  private int doctorOrNot;
  private int point;
  private int active; // 활성화 여부 => 1 : 활성화  0 : 비활성화
  private Doctor doctor;



  public Date getBirthday() {
    return birthday;
  }
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
  }
  public int getDoctorOrNot() {
    return doctorOrNot;
  }
  public void setDoctorOrNot(int doctorOrNot) {
    this.doctorOrNot = doctorOrNot;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getActive() {
    return active;
  }
  public void setActive(int active) {
    this.active = active;
  }
  public Doctor getDoctor() {
    return doctor;
  }
  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

}
