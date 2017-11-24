package com.ls.service.impl;

import com.ls.dao.DepartmentDao;
import com.ls.dao.EmployeeDao;
import com.ls.dao.RewardsPunishmentDao;
import com.ls.dao.SalaryDao;
import com.ls.model.Department;
import com.ls.model.Employee;
import com.ls.model.RewardsPunishment;
import com.ls.model.Salary;
import com.ls.service.RewardsPunishmentService;
import com.ls.service.SalaryService;
import com.ls.util.WorkDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LS on 2017/11/5 16:35.
 * To Be or Not to Be
 */
@Transactional
@Service
public class SalaryServiceImpl implements SalaryService{
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private RewardsPunishmentDao rp;
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public void countMoney() {
        //算出所有的在职员工的迟到罚金
        List<Employee> employees = employeeDao.queryAllEmpByStatus(Employee.normalStatus);
        for (Employee employee : employees) {
            Salary salary=new Salary();
            int empId=employee.getId();
            double rePunPay=0;
            double overTimePay=0;
            String startTime= WorkDate.lastMonth();
            String endTime=WorkDate.currentMonth();
            List<RewardsPunishment> rewardsPunishments = rp.queryLastMonthPunishment(empId, startTime, endTime);
            for (RewardsPunishment rewardsPunishment : rewardsPunishments) {
                double rewardsFine = rewardsPunishment.getRewardsFine();
                if (rewardsFine<0){
                    rePunPay+=rewardsFine;
                }else if (rewardsFine>0){
                    overTimePay+=rewardsFine;
                }
            }
            salary.setBasicWage(employee.getBasicWage());
            salary.setEmpId(empId);
            salary.setOverTimePay(overTimePay);
            salary.setRePunPay(rePunPay);
            salary.setCreateDate(startTime);

            double total=rePunPay+overTimePay+employee.getBasicWage();
            double social=total*employee.getProportion()/100;
            double real=total-social;
            System.out.println("==="+total);
            System.out.println("==="+social);
            salary.setRealWage(real);
            salary.setSocialSecurity(social);
            Salary temp = salaryDao.queryAMonthSalary(empId, startTime, endTime);

            if (temp!=null){
                temp.setRealWage(real);
                temp.setSocialSecurity(social);
                temp.setRePunPay(rePunPay);
                temp.setOverTimePay(overTimePay);
                temp.setBasicWage(employee.getBasicWage());
                System.out.println("temp="+temp);
                salaryDao.updateSocialRePun(temp);
            }else {
                salaryDao.saveSalary(salary);
            }

            System.out.println("salary==="+salary);

        }
    }

    @Override
    public List<Salary> querySalary() {
        String startTime= WorkDate.lastMonth();
        String endTime=WorkDate.currentMonth();
        List<Salary> salaries = salaryDao.querySalary(startTime, endTime);
        for (Salary salary : salaries) {
            Employee employee = employeeDao.queryEmp(salary.getEmpId());
            Department department = departmentDao.queryDepById(employee.getDepId());
            employee.setDepartment(department);
            salary.setEmployee(employee);
        }
        return salaries;
    }

    @Override
    public Salary queryLastSalary(int empId) {
        String startTime= WorkDate.lastMonth();
        Salary salary = salaryDao.queryCurrentSalary(empId, startTime);
        return salary;
    }
}
