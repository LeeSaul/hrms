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
    //Ա����¼
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
        model.addAttribute("info","�û��������벻����");
        return "companyLogin";
    }

    //����Ա����ӽ��棬ֻ�ܲ鵽Ͷ�ݼ�¼Ϊ¼�õ���
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


    //Ա������
    @RequestMapping(value = "/addEmp",method = RequestMethod.POST)
    public String addEmp(Employee employee,int deId,Model model){
        System.out.println("===123"+employee);
        //���һ��Ա����¼�������������ʺ��籣ռ��
        employeeService.addEmp(employee);
        //��Ͷ�ݼ�¼�����״̬��Ϊ��ʽ
        Delivery delivery=new Delivery();
        delivery.setId(deId);
        delivery.setStatus(Delivery.FORMAL);
        deliveryService.updateDelivery(delivery);
        model.addAttribute("info","��ӳɹ�");
        String s = addEmpJsp(employee.getDepId(), employee.getPositionId(), model);
        return s;
    }
    //Ա��ɾ��
    @RequestMapping(value = "/deleteEmp",method = RequestMethod.GET)
    public String deleteEmp(int empId,int opId,Model model){
        employeeService.deleteEmp(empId);
        model.addAttribute("info","ɾ���ɹ�");
        String s = queryEmpByOpId(opId, model);
        return s;
    }

    //Ա�������޸�
    @RequestMapping(value = "/updateEmpJsp",method = RequestMethod.GET)
    public String updateEmp(HttpSession session,Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        Resume resume = resumeService.queryDetailResume(emp.getResumeId());
        model.addAttribute(resume);
        return "page/emp/updateEmp";
    }

    //Ա�������޸�
    @RequestMapping(value = "/updateEmpPassword",method = RequestMethod.POST)
    public String updateEmpPassword(String password,HttpSession session,Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        emp.setEmpPassword(password);
        employeeService.updateEmp(emp);
        return "companyLogin";
    }
    //�鿴ĳ��Ա������Ϣ
    @RequestMapping(value = "/queryEmp",method = RequestMethod.POST)
    public String queryEmp(int id, HttpSession session, HttpServletResponse response){
        Employee employee = employeeService.queryEmp(id);
        return "";
    }

    //��ѯĳ��ְλ�µ�Ա��
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
    //��ѯԱ����
    @RequestMapping(value = "/queryEmpName",method = RequestMethod.POST)
    public void queryEmpName(String name,HttpServletResponse response){
        Employee employee = employeeService.queryEmpByName(name);
        String info="";
        if (employee!=null){
            info="�˻��Ѵ���";
        }
        try {
            response.getWriter().write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //��ѯɾ��Ա��
    @RequestMapping(value = "/queryDismissEmp",method = RequestMethod.GET)
    public String queryDismissEmp(Model model){
        List<Employee> employees = employeeService.queryDismissEmp(Employee.abnormalStatus);
        model.addAttribute("employees",employees);
        return "page/admin/queryDismissEmp";
    }


    //��ѯĳ��ְλ�µ�Ա��
    @RequestMapping(value = "/recoveryEmp",method = RequestMethod.GET)
    public String recoveryEmp(int id,Model model){
        Employee employee=new Employee();
        employee.setId(id);
        employee.setEmpStatus(Employee.normalStatus);
        employeeService.recoveryEmp(employee);
        model.addAttribute("info","�ָ��ɹ�");
        String s = queryDismissEmp(model);
        return s;
    }

    //�����籣����
    @RequestMapping(value = "/updateSocialPay",method = RequestMethod.GET)
    public String updateSocialPay(double social){
        Employee employee=new Employee();
        employee.setProportion(social);
        employeeService.updateSocial(employee);
        return "forward:/queryProportion";
    }

    //��ȡ��ǰ�籣����
    @RequestMapping(value = "/queryProportion",method = RequestMethod.GET)
    public String queryProportion(Model model){
        Employee employee = employeeService.queryEmpByName("admin");
        model.addAttribute("proportion",employee.getProportion());
        return "page/money/moneyManage";
    }

    //��ȡ��ǰ�籣����
    @RequestMapping(value = "/queryPhone",method = RequestMethod.GET)
    public String queryPhone(Model model){
        List<Employee> employees = employeeService.queryAllEmpByStatus(Employee.normalStatus);
        model.addAttribute("employees",employees);
        return "page/emp/queryPhone";
    }
    //�˳���¼
    @RequestMapping(value = "/empExit",method = RequestMethod.GET)
    public String empExit(HttpSession session){
        session.setAttribute("emp",null);
        return "companyLogin";
    }
}
