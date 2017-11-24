package com.ls.controller;

import com.ls.model.Employee;
import com.ls.model.Salary;
import com.ls.service.EmployeeService;
import com.ls.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by LS on 2017/11/5 21:38.
 * To Be or Not to Be
 */
@Controller
public class SalaryController {
    @Resource
    private SalaryService salaryService;
    //结算薪资
    @RequestMapping(value = "/countMoney",method = RequestMethod.GET)
    public String countMoney(Model model){
        salaryService.countMoney();
        model.addAttribute("info","结算成功");
        return "page/money/moneyManage";
    }

    //查看上个月薪资
    @RequestMapping(value = "/querySalary",method = RequestMethod.GET)
    public String querySalary(Model model){
        List<Salary> salaries = salaryService.querySalary();
        model.addAttribute("salaries",salaries);
        return "page/admin/salaryList";
    }

    //员工查看上个月薪资
    @RequestMapping(value = "/queryLastSalary",method = RequestMethod.GET)
    public String queryLastSalary(Model mode, HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        int empId = emp.getId();
        Salary salary = salaryService.queryLastSalary(empId);
        if (salary==null){
            mode.addAttribute("info","上月薪资尚未结算，请等待管理员结算");
        }else {
            mode.addAttribute("info","上月薪资");
        }
        mode.addAttribute("salary",salary);
        return "page/emp/empSalary";
    }
}
