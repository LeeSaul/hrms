package com.ls.model;

import java.io.Serializable;

/**
 * Created by LS on 2017/11/8 9:03.
 * To Be or Not to Be
 */
public class Suggest implements Serializable{
    private int id;
    private String suggestInfo;
    private int empId;
    private String status;
    public static final String reviewStatus="…Û“È";
    public static final String agreeStatus="Õ¨“‚";
    public static final String refuseStatus="æ‹æ¯";
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuggestInfo() {
        return suggestInfo;
    }

    public void setSuggestInfo(String suggestInfo) {
        this.suggestInfo = suggestInfo;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
