package com.ls.model;

import javax.annotation.Resource;

/**
 * Created by LS on 2017/10/26 11:26.
 * To Be or Not to Be
 */
public class Employee {
    private int id;
    private int resumeId;
    private int positionId;
    private int depId;
    private String empName;
    private String empPassword;
    private String empStatus;
    private String empType;
    private String realName;
    private double basicWage;
    private double proportion;
    private Resume resume;
    private DepOption depOption;
    private Department department;
    public static final String normalStatus="可用";
    public static final String abnormalStatus="不可用";
    private Salary salary;
    public Employee() {
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        this.basicWage = basicWage;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepOption getDepOption() {
        return depOption;
    }

    public void setDepOption(DepOption depOption) {
        this.depOption = depOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", positionId=" + positionId +
                ", depId=" + depId +
                ", empName='" + empName + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", empStatus='" + empStatus + '\'' +
                ", empType='" + empType + '\'' +
                ", realName='" + realName + '\'' +
                ", depOption=" + depOption +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
