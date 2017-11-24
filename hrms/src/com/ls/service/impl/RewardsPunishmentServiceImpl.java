package com.ls.service.impl;

import com.ls.dao.DepartmentDao;
import com.ls.dao.EmployeeDao;
import com.ls.dao.RewardsPunishmentDao;
import com.ls.model.Department;
import com.ls.model.Employee;
import com.ls.model.RewardsPunishment;
import com.ls.service.RewardsPunishmentService;
import com.ls.util.DateDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/11/2 15:09.
 * To Be or Not to Be
 */
@Service
@Transactional
public class RewardsPunishmentServiceImpl implements RewardsPunishmentService{
    @Autowired
    private RewardsPunishmentDao rewardsPunishmentDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<RewardsPunishment> queryLastMonthPunishment(int empId, String startTime, String endTime) {
        return rewardsPunishmentDao.queryLastMonthPunishment(empId,startTime,endTime);
    }

    @Override
    public List<RewardsPunishment> queryRewardsPun() {
        Date currentMonth= new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentMonth);
        calendar.add(Calendar.MONTH,-1);
        String current = dateFormat.format(currentMonth);
        String last = dateFormat.format(calendar.getTime());
        List<RewardsPunishment> rewardsPunishments =rewardsPunishmentDao.queryPunishment(last,current);
        for (RewardsPunishment rewardsPunishment : rewardsPunishments) {
            Employee employee = employeeDao.queryEmp(rewardsPunishment.getEmpId());
            Department department = departmentDao.queryDepById(employee.getDepId());
            rewardsPunishment.setEmployee(employee);
            rewardsPunishment.setDepartment(department);
        }
        return rewardsPunishments;
    }
}
