package com.ls.controller;

import com.ls.model.Delivery;
import com.ls.model.DepOption;
import com.ls.model.Department;
import com.ls.model.Employee;
import com.ls.service.DeliveryService;
import com.ls.service.DepOptionService;
import com.ls.service.DepartmentService;
import com.ls.service.EmployeeService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/10/29 10:39.
 * To Be or Not to Be
 */

@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepOptionService depOptionService;

    //���Ӳ���
    @RequestMapping(value = "/addDep",method = RequestMethod.POST)
    public String addDep(Department department){
        //Ҫ��ȡ��ǰ������
        Date date = new Date();
        //����Ҫ��ȡ��ʲô����ʱ��
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //��ȡString���͵�ʱ��
        String createdate = sdf.format(date);
        System.out.println(createdate);
        department.setDepCreatedate(createdate);
        departmentService.addDep(department);
        return "forward:/queryAllDep";
    }
    //��ѯ���в���
    @RequestMapping(value = "/queryAllDep",method = {RequestMethod.GET,RequestMethod.POST})
    public String queryAllDep(Model model){
        List<Department> departments = departmentService.queryAllDep();
        model.addAttribute("departments",departments);
        return "page/dep/depList";
    }
    //ɾ��ĳ������
    @RequestMapping(value = "/deleteDepById",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteDepById(int id,Model model){
        //1����ѯ�ò����Ƿ����ˣ�û�˲���ɾ��
        int depId=id;
        List<Employee> employees = employeeService.queryEepByDepId(depId);
        if (employees!=null){
            model.addAttribute("info","�ò��Ŵ�����Ա���޷�ɾ��������");
        }else {
            departmentService.deleteDepById(id);
            depOptionService.deleteOptionByDepId(depId);
        }
        List<Department> departments = departmentService.queryAllDep();
        model.addAttribute("departments",departments);
        return "page/dep/depList";
    }
    //����ĳ��������Ϣ
    @RequestMapping(value = "/updateDepByIdJsp",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateDepByIdJsp(int id,Model model){
        Department department = departmentService.queryDepById(id);
        model.addAttribute("department",department);
        return "page/dep/updateDep";
    }

    //���ĳɹ�֮��������ҳ��
    @RequestMapping(value = "/updateDepById",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateDepById(Department department,Model model){
        Date date = new Date();
        //����Ҫ��ȡ��ʲô����ʱ��
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //��ȡString���͵�ʱ��
        String createdate = sdf.format(date);
        department.setDepCreatedate(createdate);
        departmentService.updateDepById(department);
        String s = queryAllDep(model);
        return s;
    }
    //��ѯ���еĲ��ź��Ѿ�¼ȡ����
    @RequestMapping(value = "/queryDepAndHasHired",method = {RequestMethod.GET,RequestMethod.POST})
    public String queryDepAndHasHired(HttpSession session){
        List<Department> departments = departmentService.queryAllDep();
        String status=Delivery.ADMISSION;
        List<Delivery> deliveries = deliveryService.queryDepByStatus(status);
        session.setAttribute("departments",departments);
        session.setAttribute("deliveries",deliveries);
        return "page/dep/addEmp";
    }

    //��ѯĳ������
    @RequestMapping(value = "/queryDepById",method = {RequestMethod.GET,RequestMethod.POST})
    public String queryDepById(int id,Model model){
        Department department = departmentService.queryDepById(id);
        List<DepOption> depOptions = depOptionService.queryOptionByDepId(id);
        department.setDepOptions(depOptions);
        model.addAttribute("department",department);
        return "page/dep/aDep";
    }
    //��������ҳ��
    @RequestMapping(value = "/changeJsp",method = {RequestMethod.GET,RequestMethod.POST})
    public String changeJsp(int empId,Model model){
        model.addAttribute("empId",empId);
        return "page/dep/changeOption";
    }

    //��ѯ���в����Լ���Ӧ��ְλ
    @RequestMapping(value = "/queryAllDepAndOption",method = {RequestMethod.GET,RequestMethod.POST})
    public void queryAllDepAndOption(HttpServletResponse response){
        List<Department> departments = departmentService.queryAllDep();
        for (Department department : departments) {
            List<DepOption> depOptions = depOptionService.queryOptionByDepId(department.getId());
            department.setDepOptions(depOptions);
        }
        JSONArray jsonArray = JSONArray.fromObject(departments);
        try {
            response.getWriter().print(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //��ѯĳ�����������е�ְλ�Լ���Ӧ����
    @RequestMapping(value = "/queryAllEmp",method = RequestMethod.POST)
    public void queryAllEmp(String depName, HttpServletResponse response){
        Department department = departmentService.queryDepByDepName(depName);
        System.out.println(department);
        JSONArray jsonArray = JSONArray.fromObject(department);
        try {
            response.getWriter().println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //�鿴������
    @RequestMapping(value = "/queryAllDepEmp",method = {RequestMethod.GET,RequestMethod.POST})
    public String queryAllEmp(Model model) {
        List<Department> departments = departmentService.queryAllDep();
        for (Department department : departments) {
            List<Employee> employees = employeeService.queryEepByDepId(department.getId());
            department.setEmployees(employees);
        }
        System.out.println("+++++"+departments);
        model.addAttribute("departments",departments);
        return "page/dep/allEmp";
    }
}

