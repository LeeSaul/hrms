package com.ls.service.impl;

import com.ls.dao.*;
import com.ls.model.DepOption;
import com.ls.model.Department;
import com.ls.model.Employee;
import com.ls.model.Resume;
import com.ls.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/10/27 9:41.
 * To Be or Not to Be
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private DepOptionDao depOptionDao;
    @Override
    public Employee empLogin(Employee employee) {
        return employeeDao.empLogin(employee);
    }

    @Override
    public void addEmp(Employee employee) {
        employeeDao.addEmp(employee);
    }

    @Override
    public void deleteEmp(int empId) {
        //更新员工的状态
        Employee e=new Employee();
        e.setId(empId);
        e.setEmpStatus(Employee.abnormalStatus);
        employeeDao.updateEmpStatus(e);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
    }

    @Override
    public Employee queryEmp(int id) {
        return employeeDao.queryEmp(id);
    }

    @Override
    public List<Employee> queryEepByDepId(int depId) {
        return employeeDao.queryEepByDepId(depId);
    }

    @Override
    public List<Employee> queryEepByPosId(int positionId) {
        return employeeDao.queryEepByPosId(positionId);
    }

    @Override
    public List<Employee> queryEmpByOpId(int positionId) {
        return employeeDao.queryEmpByOpId(positionId);
    }

    @Override
    public Employee queryEmpByName(String name) {
        return employeeDao.queryEmpByName(name);
    }

    @Override
    public void changeOp(Employee employee) {
        employeeDao.changeOp(employee);
    }

    @Override
    public List<Employee> queryDismissEmp(String abnormalStatus) {
        return employeeDao.queryDismissEmp(abnormalStatus);
    }

    @Override
    public void recoveryEmp(Employee employee) {
        employeeDao.recoveryEmp(employee);
    }

    @Override
    public void updateSocial(Employee employee) {
        employeeDao.updateSocial(employee);
    }

    @Override
    public List<Employee> queryAllEmpByStatus(String normalStatus) {
        List<Employee> employees = employeeDao.queryAllEmpByStatus(normalStatus);
        for (Employee employee : employees) {
            Resume resume = resumeDao.queryDetailResume(employee.getResumeId());
            employee.setResume(resume);
            Department department = departmentDao.queryDepById(employee.getDepId());
            employee.setDepartment(department);
            DepOption depOption = depOptionDao.queryOptionById(employee.getPositionId());
            employee.setDepOption(depOption);
        }
        return employees;
    }

    @Override
    public Employee queryEmpByResumeId(int resumeId) {
        return employeeDao.queryEmpByResumeId(resumeId);
    }
}
