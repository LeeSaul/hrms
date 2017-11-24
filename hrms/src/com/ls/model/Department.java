package com.ls.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by LS on 2017/10/29 10:33.
 * To Be or Not to Be
 */
public class Department {
    private int id;
    private String depName;
    private String depType;
    private String depDescription;
    private String depCreatedate;
    private List<DepOption> depOptions;
    private List<Employee> employees;
    public Department() {
    }

    public String getDepCreatedate() {
        return depCreatedate;
    }

    public void setDepCreatedate(String depCreatedate) {
        this.depCreatedate = depCreatedate;
    }

    public Department(String depName, String depType, String depDescription) {
        this.depName = depName;
        this.depType = depType;
        this.depDescription = depDescription;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepType() {
        return depType;
    }

    public void setDepType(String depType) {
        this.depType = depType;
    }

    public String getDepDescription() {
        return depDescription;
    }

    public void setDepDescription(String depDescription) {
        this.depDescription = depDescription;
    }

    public List<DepOption> getDepOptions() {
        return depOptions;
    }

    public void setDepOptions(List<DepOption> depOptions) {
        this.depOptions = depOptions;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depName='" + depName + '\'' +
                ", depType='" + depType + '\'' +
                ", depDescription='" + depDescription + '\'' +
                ", depCreatedate='" + depCreatedate + '\'' +
                ", depOptions=" + depOptions +
                ", employees=" + employees +
                '}';
    }
}
