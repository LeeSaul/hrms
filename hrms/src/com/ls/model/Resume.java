package com.ls.model;


import java.util.List;

/**
 * Created by LS on 2017/10/26 15:46.
 * To Be or Not to Be
 */
public class Resume {

  private int id;
  private int touristId;
  private String resumeName;
  private String age;
  private String gender;
  private String phone;
  private String birthdate;
  private String birthplace;
  private String job;
  private String education;
  private String image;
  private String specialSkill;
  private String hobbies;
  private String awards;
  private String marry;
  private String email;
  private String selfEvaluation;
  private String workExperience;
  private String projectExperience;
  private String educationExperience;
  private List<Delivery> deliveries;
  public Resume() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTouristId() {
    return touristId;
  }

  public void setTouristId(int touristId) {
    this.touristId = touristId;
  }

  public String getResumeName() {
    return resumeName;
  }

  public void setResumeName(String resumeName) {
    this.resumeName = resumeName;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getSpecialSkill() {
    return specialSkill;
  }

  public void setSpecialSkill(String specialSkill) {
    this.specialSkill = specialSkill;
  }

  public String getHobbies() {
    return hobbies;
  }

  public void setHobbies(String hobbies) {
    this.hobbies = hobbies;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }

  public String getMarry() {
    return marry;
  }

  public void setMarry(String marry) {
    this.marry = marry;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSelfEvaluation() {
    return selfEvaluation;
  }

  public void setSelfEvaluation(String selfEvaluation) {
    this.selfEvaluation = selfEvaluation;
  }

  public String getWorkExperience() {
    return workExperience;
  }

  public void setWorkExperience(String workExperience) {
    this.workExperience = workExperience;
  }

  public String getProjectExperience() {
    return projectExperience;
  }

  public void setProjectExperience(String projectExperience) {
    this.projectExperience = projectExperience;
  }

  public String getEducationExperience() {
    return educationExperience;
  }

  public void setEducationExperience(String educationExperience) {
    this.educationExperience = educationExperience;
  }

  public List<Delivery> getDeliveries() {
    return deliveries;
  }

  public void setDeliveries(List<Delivery> deliveries) {
    this.deliveries = deliveries;
  }

  @Override
  public String toString() {
    return "Resume{" +
            "id=" + id +
            ", touristId=" + touristId +
            ", resumeName='" + resumeName + '\'' +
            ", age='" + age + '\'' +
            ", gender='" + gender + '\'' +
            ", phone='" + phone + '\'' +
            ", birthdate='" + birthdate + '\'' +
            ", birthplace='" + birthplace + '\'' +
            ", job='" + job + '\'' +
            ", education='" + education + '\'' +
            ", image='" + image + '\'' +
            ", specialSkill='" + specialSkill + '\'' +
            ", hobbies='" + hobbies + '\'' +
            ", awards='" + awards + '\'' +
            ", marry='" + marry + '\'' +
            ", email='" + email + '\'' +
            ", selfEvaluation='" + selfEvaluation + '\'' +
            ", workExperience='" + workExperience + '\'' +
            ", projectExperience='" + projectExperience + '\'' +
            ", educationExperience='" + educationExperience + '\'' +
            ", deliveries=" + deliveries +
            '}';
  }
}
