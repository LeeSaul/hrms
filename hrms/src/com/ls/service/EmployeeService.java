package com.ls.service;

import com.ls.model.Employee;

import java.util.List;

/**
 * Created by LS on 2017/10/27 9:41.
 * To Be or Not to Be
 */
public interface EmployeeService {
    Employee empLogin(Employee employee);

    void addEmp(Employee employee);

    void deleteEmp(int empId);

    void updateEmp(Employee employee);

    Employee queryEmp(int id);

    List<Employee> queryEepByDepId(int depId);

    List<Employee> queryEepByPosId(int positionId);

    List<Employee> queryEmpByOpId(int positionId);

    Employee queryEmpByName(String name);

    void changeOp(Employee employee);

    List<Employee> queryDismissEmp(String abnormalStatus);

    void recoveryEmp(Employee employee);

    void updateSocial(Employee employee);

    List<Employee> queryAllEmpByStatus(String normalStatus);

    Employee queryEmpByResumeId(int id);
}
