package com.ls.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LS on 2017/11/2 14:59.
 * To Be or Not to Be
 */
public class Work implements Serializable{
    private int id;
    private String workTime;
    private String offWorkTime;
    private long workMillis;
    private long offMillis;
    private long overMillis;
    private int days;
    private String overTime;
    private double overPay;
    private SimpleDateFormat format;


    public Work() {
        format=new SimpleDateFormat("HH:mm");
    }

    public double getOverPay() {
        return overPay;
    }

    public void setOverPay(double overPay) {
        this.overPay = overPay;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public long getOverMillis() {
        setOverMillis();
        return overMillis;
    }

    public void setOverMillis() {
        Date date=new Date();
        try {
            date = format.parse(overTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar overCalendar=Calendar.getInstance();
        overCalendar.setTime(date);
        this.overMillis = overCalendar.getTimeInMillis();
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public long getWorkMillis() {
        setWorkMillis();
        return workMillis;
    }

    public void setWorkMillis() {
        Date date=new Date();
        try {
            date = format.parse(workTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar workCalendar=Calendar.getInstance();
        workCalendar.setTime(date);
        this.workMillis = workCalendar.getTimeInMillis();
    }

    public long getOffMillis() {
        setOffMillis();
        return offMillis;
    }

    public void setOffMillis() {
        Date date=new Date();
        try {
            date = format.parse(offWorkTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar offCalendar=Calendar.getInstance();
        offCalendar.setTime(date);
        this.offMillis = offCalendar.getTimeInMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(String offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", workTime='" + workTime + '\'' +
                ", offWorkTime='" + offWorkTime + '\'' +
                '}';
    }
}
