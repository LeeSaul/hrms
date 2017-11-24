package com.ls.dao;

import com.ls.model.Salary;

import java.util.List;

/**
 * Created by LS on 2017/11/4 12:43.
 * To Be or Not to Be
 */
public interface SalaryDao {

    void updateSocialRePun(Salary salary);

    Salary queryAMonthSalary(int empId, String startTime, String endTime);

    void saveSalary(Salary salary);

    List<Salary> querySalary(String startTime, String endTime);

    Salary queryCurrentSalary(int empId, String date);

}
