package com.ls.model;

import java.io.Serializable;

/**
 * Created by LS on 2017/11/4 9:45.
 * To Be or Not to Be
 */
public class WorkDay implements Serializable{
    private String ymd;
    private String name;
    private int isWorkDay;

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsWorkDay() {
        return isWorkDay;
    }

    public void setIsWorkDay(int isWorkDay) {
        this.isWorkDay = isWorkDay;
    }
}
