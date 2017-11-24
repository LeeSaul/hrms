package com.ls.model;

import java.io.Serializable;

/**
 * Created by LS on 2017/11/2 8:13.
 * To Be or Not to Be
 */
public class TrainNotice implements Serializable{
    private int id;
    private int trainId;
    private int empId;
    private Employee employee;
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "TrainNotice{" +
                "id=" + id +
                ", trainId=" + trainId +
                ", empId=" + empId +
                '}';
    }
}
