package com.ls.controller;

import com.ls.model.*;
import com.ls.service.*;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Created by LS on 2017/10/27 9:37.
 * To Be or Not to Be
 */
@Controller
public class EmpController {

    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepOptionService depOptionService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private SalaryService salaryService;
    //员工登录
    @RequestMapping(value = "/companyLogin",method = RequestMethod.POST)
    public String empLogin(Employee employee, HttpSession session,Model model){
        Employee employee1 = employeeService.empLogin(employee);
        if(employee1!=null&&Employee.normalStatus.equals(employee1.getEmpStatus())){
            session.setAttribute("emp",employee1);
            if ("0".equals(employee1.getEmpType())){
                return "page/admin/adminIndex";
            }else if ("1".equals(employee1.getEmpType())){
                return "page/emp/empIndex";
            }
        }
        model.addAttribute("info","用户名或密码不存在");
        return "companyLogin";
    }

    //跳到员工添加界面，只能查到投递记录为录用的人
    @RequestMapping(value = "/addEmpJsp",method = RequestMethod.GET)
    public String addEmpJsp(int depId,int opId,Model model){
        List<Delivery> deliveries = deliveryService.queryDepByStatus(Delivery.ADMISSION);
        for (Delivery delivery : deliveries) {
            Resume resume = resumeService.queryDetailResume(delivery.getResumeId());
            delivery.setResume(resume);
        }
        System.out.println(deliveries);
        System.out.println("====");
        model.addAttribute("deliveries",deliveries);
        model.addAttribute("depId",depId);
        model.addAttribute("opId",opId);
        return "page/dep/addEmp";
    }


    //员工增加
    @RequestMapping(value = "/addEmp",method = RequestMethod.POST)
    public String addEmp(Employee employee,int deId,Model model){
        System.out.println("===123"+employee);
        //添加一条员工记录，包括基本工资和社保占比
        employeeService.addEmp(employee);
        //将投递记录里面的状态改为正式
        Delivery delivery=new Delivery();
        delivery.setId(deId);
        delivery.setStatus(Delivery.FORMAL);
        deliveryService.updateDelivery(delivery);
        model.addAttribute("info","添加成功");
        String s = addEmpJsp(employee.getDepId(), employee.getPositionId(), model);
        return s;
    }
    //员工删除
    @RequestMapping(value = "/deleteEmp",method = RequestMethod.GET)
    public String deleteEmp(int empId,int opId,Model model){
        employeeService.deleteEmp(empId);
        model.addAttribute("info","删除成功");
        String s = queryEmpByOpId(opId, model);
        return s;
    }

    //员工资料修改
    @RequestMapping(value = "/updateEmpJsp",method = RequestMethod.GET)
    public String updateEmp(HttpSession session,Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        Resume resume = resumeService.queryDetailResume(emp.getResumeId());
        model.addAttribute(resume);
        return "page/emp/updateEmp";
    }

    //员工密码修改
    @RequestMapping(value = "/updateEmpPassword",method = RequestMethod.POST)
    public String updateEmpPassword(String password,HttpSession session,Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        emp.setEmpPassword(password);
        employeeService.updateEmp(emp);
        return "companyLogin";
    }
    //查看某个员工的信息
    @RequestMapping(value = "/queryEmp",method = RequestMethod.POST)
    public String queryEmp(int id, HttpSession session, HttpServletResponse response){
        Employee employee = employeeService.queryEmp(id);
        return "";
    }

    //查询某个职位下的员工
    @RequestMapping(value = "/queryEmpByOpId",method = RequestMethod.GET)
    public String queryEmpByOpId(int positionId,Model model){
        List<Employee> employees = employeeService.queryEmpByOpId(positionId);
        DepOption depOption = depOptionService.queryOptionById(positionId);
        Department department = departmentService.queryDepById(depOption.getDepId());
        model.addAttribute("employees",employees);
        model.addAttribute("depOption",depOption);
        model.addAttribute("department",department);
        return "page/dep/empList";
    }
    //查询员工名
    @RequestMapping(value = "/queryEmpName",method = RequestMethod.POST)
    public void queryEmpName(String name,HttpServletResponse response){
        Employee employee = employeeService.queryEmpByName(name);
        String info="";
        if (employee!=null){
            info="账户已存在";
        }
        try {
            response.getWriter().write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询删除员工
    @RequestMapping(value = "/queryDismissEmp",method = RequestMethod.GET)
    public String queryDismissEmp(Model model){
        List<Employee> employees = employeeService.queryDismissEmp(Employee.abnormalStatus);
        model.addAttribute("employees",employees);
        return "page/admin/queryDismissEmp";
    }


    //查询某个职位下的员工
    @RequestMapping(value = "/recoveryEmp",method = RequestMethod.GET)
    public String recoveryEmp(int id,Model model){
        Employee employee=new Employee();
        employee.setId(id);
        employee.setEmpStatus(Employee.normalStatus);
        employeeService.recoveryEmp(employee);
        model.addAttribute("info","恢复成功");
        String s = queryDismissEmp(model);
        return s;
    }

    //更新社保比例
    @RequestMapping(value = "/updateSocialPay",method = RequestMethod.GET)
    public String updateSocialPay(double social){
        Employee employee=new Employee();
        employee.setProportion(social);
        employeeService.updateSocial(employee);
        return "forward:/queryProportion";
    }

    //获取当前社保比例
    @RequestMapping(value = "/queryProportion",method = RequestMethod.GET)
    public String queryProportion(Model model){
        Employee employee = employeeService.queryEmpByName("admin");
        model.addAttribute("proportion",employee.getProportion());
        return "page/money/moneyManage";
    }

    //获取当前社保比例
    @RequestMapping(value = "/queryPhone",method = RequestMethod.GET)
    public String queryPhone(Model model){
        List<Employee> employees = employeeService.queryAllEmpByStatus(Employee.normalStatus);
        model.addAttribute("employees",employees);
        return "page/emp/queryPhone";
    }
    //退出登录
    @RequestMapping(value = "/empExit",method = RequestMethod.GET)
    public String empExit(HttpSession session){
        session.setAttribute("emp",null);
        return "companyLogin";
    }
}
