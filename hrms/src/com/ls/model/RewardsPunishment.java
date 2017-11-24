package com.ls.model;

import java.io.Serializable;

/**
 * Created by LS on 2017/11/2 14:55.
 * To Be or Not to Be
 */
public class RewardsPunishment implements Serializable{
    private int id;
    private int empId;
    private double rewardsFine;
    private String caption;
    private int attId;
    private String createTime;
    private Employee employee;
    private Department department;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getRewardsFine() {
        return rewardsFine;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public void setRewardsFine(double rewardsFine) {
        this.rewardsFine = rewardsFine;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getAttId() {
        return attId;
    }

    public void setAttId(int attId) {
        this.attId = attId;
    }

    @Override
    public String toString() {
        return "RewardsPunishment{" +
                "id=" + id +
                ", empId=" + empId +
                ", rewardsFine='" + rewardsFine + '\'' +
                ", caption='" + caption + '\'' +
                ", attId=" + attId +
                '}';
    }
}
