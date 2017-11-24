package com.ls.service.impl;

import com.ls.dao.DepOptionDao;
import com.ls.dao.EmployeeDao;
import com.ls.model.DepOption;
import com.ls.model.Employee;
import com.ls.service.DepOptionService;
import com.ls.service.EmployeeService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/10/31 10:51.
 * To Be or Not to Be
 */
@Transactional
@Service
public class DepOptionServiceImpl implements DepOptionService{
    @Autowired
    private DepOptionDao depOptionDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void addOption(DepOption depOption) {
        depOptionDao.addOption(depOption);
    }

    @Override
    public void updateOption(DepOption depOption) {
        depOptionDao.updateOption(depOption);
    }

    @Override
    public List<DepOption> queryOptionByDepId(int depId) {
        List<DepOption> depOptions = depOptionDao.queryOptionByDepId(depId);
        for (DepOption depOption : depOptions) {
            List<Employee> employees = employeeDao.queryEepByPosId(depOption.getId());
            depOption.setEmployeeList(employees);
        }
        return depOptions;
    }

    @Override
    public void deleteOption(int id) {
        depOptionDao.deleteOption(id);
    }

    @Override
    public void deleteOptionByDepId(int depId) {
        depOptionDao.deleteOptionByDepId(depId);
    }

    @Override
    public DepOption queryOptionById(int id) {
        return depOptionDao.queryOptionById(id);
    }
}
