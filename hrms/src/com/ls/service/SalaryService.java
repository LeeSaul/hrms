package com.ls.service;

import com.ls.model.Salary;

import java.util.List;

/**
 * Created by LS on 2017/11/5 16:35.
 * To Be or Not to Be
 */
public interface SalaryService {

    void countMoney();

    List<Salary> querySalary();

    Salary queryLastSalary(int empId);
}
