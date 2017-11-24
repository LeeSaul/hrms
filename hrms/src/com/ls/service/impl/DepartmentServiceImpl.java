package com.ls.service.impl;

import com.ls.dao.DepartmentDao;
import com.ls.model.Delivery;
import com.ls.model.DepOption;
import com.ls.model.Department;
import com.ls.model.Employee;
import com.ls.service.DepOptionService;
import com.ls.service.DepartmentService;
import com.ls.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/10/29 10:40.
 * To Be or Not to Be
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepOptionService depOptionService;
    @Override
    public boolean addDep(Department department) {
        return departmentDao.addDep(department);
    }

    @Override
    public List<Department> queryAllDep() {
        List<Department> departments = departmentDao.queryAllDep();
        for (Department department : departments) {
            List<DepOption> depOptions = depOptionService.queryOptionByDepId(department.getId());
            List<Employee> employees = employeeService.queryEepByDepId(department.getId());
            department.setEmployees(employees);
            department.setDepOptions(depOptions);
        }
        return departments;
    }

    @Override
    public boolean deleteDepById(int id) {
        return departmentDao.deleteDepById(id);
    }

    @Override
    public void updateDepById(Department department) {
        departmentDao.updateDepById(department);
    }

    @Override
    public Department queryDepById(int id) {
        return departmentDao.queryDepById(id);
    }

    @Override
    public Department queryDepByDepName(String depName) {
        System.out.println("===!!");
        System.out.println(depName);
        Department department = departmentDao.queryDepByDepName(depName);
        System.out.println("123"+department);
        List<Employee> employees = employeeService.queryEepByDepId(department.getId());
        department.setEmployees(employees);
        return department;
    }

}
