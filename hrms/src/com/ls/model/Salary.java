package com.ls.model;

import java.io.Serializable;

/**
 * Created by LS on 2017/11/4 12:28.
 * To Be or Not to Be
 */
public class Salary implements Serializable{
    private int id;
    private int empId;
    private double basicWage;
    private double socialSecurity;
    private double overTimePay;
    private double performancePay;
    private double rePunPay;
    private double realWage;
    private String createDate;
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public double getRealWage() {
        return realWage;
    }

    public void setRealWage(double realWage) {
        this.realWage = realWage;
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

    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        this.basicWage = basicWage;
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(double socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public double getOverTimePay() {
        return overTimePay;
    }

    public void setOverTimePay(double overTimePay) {
        this.overTimePay = overTimePay;
    }

    public double getPerformancePay() {
        return performancePay;
    }

    public void setPerformancePay(double performancePay) {
        this.performancePay = performancePay;
    }

    public double getRePunPay() {
        return rePunPay;
    }

    public void setRePunPay(double rePunPay) {
        this.rePunPay = rePunPay;
    }


    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", empId=" + empId +
                ", basicWage=" + basicWage +
                ", socialSecurity=" + socialSecurity +
                ", overTimePay=" + overTimePay +
                ", performancePay=" + performancePay +
                ", rePunPay=" + rePunPay +
                ", realWage=" + realWage +
                '}';
    }
}
