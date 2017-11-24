package com.ls.dao;

import com.ls.model.Employee;
import com.ls.model.Salary;

import java.util.List;

/**
 * Created by LS on 2017/10/27 9:37.
 * To Be or Not to Be
 */
public interface EmployeeDao {
    Employee empLogin(Employee employee);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void updateEmpStatus(Employee employee);

    Employee queryEmp(int id);

    List<Employee> queryEepByDepId(int depId);

    List<Employee> queryEepByPosId(int positionId);

    List<Employee> queryEmpByOpId(int positionId);

    Employee queryEmpByName(String name);

//    List<Employee> queryAllEmp();

    void changeOp(Employee employee);

    List<Employee> queryDismissEmp(String abnormalStatus);

    void recoveryEmp(Employee employee);

    List<Employee> queryAllEmpByStatus(String normalStatus);

    void updateSocial(Employee employee);

    Employee queryEmpByResumeId(int resumeId);
}
