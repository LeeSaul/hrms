package com.ls.model;



import oracle.sql.DATE;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/11/2 15:57.
 * To Be or Not to Be
 */
public class Attendance implements Serializable{
    private int id;
    private int empId;
    private Timestamp startTime;
    private Timestamp endTime;
    private long startMillis;
    private long endMillis;
    private Employee employee;
    private SimpleDateFormat format;

    public Attendance() {
        format=new SimpleDateFormat("HH:mm");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getStartMillis() {
        setStartMillis();
        return startMillis;
    }

    public void setStartMillis() {
        String format = this.format.format(startTime);
        Date date=null;
        try {
            date = this.format.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar startCalendar=Calendar.getInstance();
        startCalendar.setTime(date);
        this.startMillis = startCalendar.getTimeInMillis();
    }

    public long getEndMillis() {
        setEndMillis();
        return endMillis;
    }

    public void setEndMillis() {
        String format = this.format.format(endTime);
        Date date=null;
        try {
            date = this.format.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar endCalendar=Calendar.getInstance();
        endCalendar.setTime(date);
        this.endMillis = endCalendar.getTimeInMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", empId=" + empId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
