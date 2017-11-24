package com.ls.model;

/**
 * Created by LS on 2017/10/26 11:23.
 * To Be or Not to Be
 */
public class Tourist {
    private int id;
    private String tourName;
    private String tourPassword;
    private String tourStatus;
    private Resume resume;
    public Tourist() {
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Tourist(String tourName, String tourPassword, String tourStatus) {
        this.tourName = tourName;
        this.tourPassword = tourPassword;
        this.tourStatus = tourStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourPassword() {
        return tourPassword;
    }

    public void setTourPassword(String tourPassword) {
        this.tourPassword = tourPassword;
    }

    public String getTourStatus() {
        return tourStatus;
    }

    public void setTourStatus(String tourStatus) {
        this.tourStatus = tourStatus;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                ", tourName='" + tourName + '\'' +
                ", tourPassword='" + tourPassword + '\'' +
                ", tourStatus='" + tourStatus + '\'' +
                '}';
    }
}
