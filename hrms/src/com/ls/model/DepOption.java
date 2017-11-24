package com.ls.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by LS on 2017/10/31 10:50.
 * To Be or Not to Be
 */
public class DepOption implements Serializable{
    private int id;
    private int depId;
    private String optionName;
    private String optionDesc;
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionDesc() {
        return optionDesc;
    }

    public void setOptionDesc(String optionDesc) {
        this.optionDesc = optionDesc;
    }

    @Override
    public String toString() {
        return "DepOption{" +
                "id=" + id +
                ", depId=" + depId +
                ", optionName='" + optionName + '\'' +
                ", optionDesc='" + optionDesc + '\'' +
                '}';
    }
}
