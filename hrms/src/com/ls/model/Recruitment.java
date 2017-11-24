package com.ls.model;


import java.sql.Timestamp;
import java.util.List;

public class Recruitment {
  private int id;
  private String workingPlace;
  private String salary;
  private String positionType;
  private String description;
  private Timestamp createDate;
  private String otherInfo;
  private String recStatus;
  private List<Resume> resume;

  public void setOtherInfo(String otherInfo) {
    this.otherInfo = otherInfo;
  }

  public List<Resume> getResume() {
    return resume;
  }

  public void setResume(List<Resume> resume) {
    this.resume = resume;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getWorkingPlace() {
    return workingPlace;
  }

  public void setWorkingPlace(String workingPlace) {
    this.workingPlace = workingPlace;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getPositionType() {
    return positionType;
  }

  public void setPosition_type(String positionType) {
    this.positionType = positionType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }


  public void setPositionType(String positionType) {
    this.positionType = positionType;
  }

  public String getOtherInfo() {
    return otherInfo;
  }

  public String getRecStatus() {
    return recStatus;
  }

  public void setRecStatus(String recStatus) {
    this.recStatus = recStatus;
  }
}
