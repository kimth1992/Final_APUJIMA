package pms.domain;

import java.sql.Date;

public class MailBox {

  private int mailNo;
  private String sender;
  private String title;
  private String content;
  private String receiver;
  private Date sendingTime;


  public int getMailNo() {
    return mailNo;
  }
  public void setMailNo(int mailNo) {
    this.mailNo = mailNo;
  }
  public String getSender() {
    return sender;
  }
  public void setSender(String sender) {
    this.sender = sender;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  public Date getSendingTime() {
    return sendingTime;
  }
  public void setSendingTime(Date sendingTime) {
    this.sendingTime = sendingTime;
  }
  public String getReceiver() {
    return receiver;
  }
  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }





}
