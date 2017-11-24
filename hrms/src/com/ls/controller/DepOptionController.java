package com.ls.controller;

import com.ls.model.DepOption;
import com.ls.model.Employee;
import com.ls.service.DepOptionService;
import com.ls.service.DepartmentService;
import com.ls.service.EmployeeService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LS on 2017/10/31 10:51.
 * To Be or Not to Be
 */
@Controller
public class DepOptionController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private DepOptionService depOptionService;
    @Resource
    private EmployeeService employeeService;
    //跳转到添加职位页面
    @RequestMapping(value = "/addOptionJsp",method = {RequestMethod.GET,RequestMethod.POST})
    public String jumpAddOptionJsp(int id,Model model){
        model.addAttribute("depId",id);
        System.out.println("===+"+id);
        return "page/dep/addOption";
    }

    //添加职位
    @RequestMapping(value = "/addOption",method = {RequestMethod.GET,RequestMethod.POST})
    public String addOption(DepOption depOption, Model model){
        depOptionService.addOption(depOption);
        return "forward:/queryDepById?id="+depOption.getDepId();
    }

    //回显职位信息（修改页面）
    @RequestMapping(value = "/updateOptionByIdJsp",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateOptionByIdJsp(int id,Model model){
        DepOption depOption = depOptionService.queryOptionById(id);
        model.addAttribute("depOption",depOption);
        return "page/dep/updateOption";
    }

    //修改职位名称
    @RequestMapping(value = "/updateOption",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateOption(DepOption depOption){
        depOptionService.updateOption(depOption);
        return "forward:/queryDepById?id="+depOption.getDepId();
    }

    //删除职位
    @RequestMapping(value = "/deleteOption",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteOption(int positionId,int depId, Model model){
        //先查询这个职位下的是否有员工
        List<Employee> employee = employeeService.queryEepByPosId(positionId);
        if (employee!=null){
            model.addAttribute("info","该职位下有人，无法删除该职位");
        }else {
            model.addAttribute("info","删除成功");
            depOptionService.deleteOption(positionId);
        }
        return "forward:/queryDepById?id="+depId;
    }
    //查询某个部门的所有职位
    @RequestMapping(value = "/queryOptionByDepId",method = {RequestMethod.GET,RequestMethod.POST})
    public String queryOptionByDepId(int depId, Model model){
        depOptionService.queryOptionByDepId(depId);
        return "page/emp/optionManager";
    }
    //查询某个部门的所有职位以及所有员工
    @RequestMapping(value = "/queryAllEmpByDepId",method = RequestMethod.POST)
    public void queryAllEmpByDepId(int depId, HttpServletResponse response){
        List<DepOption> depOptions = depOptionService.queryOptionByDepId(depId);
        JSONArray jsonArray = JSONArray.fromObject(depOptions);
        try {
            response.getWriter().print(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询某个部门的所有职位
    @RequestMapping(value = "/changeOp",method = {RequestMethod.GET,RequestMethod.POST})
    public String changeOp(int depId,int empId,int opId,Model model){
        Employee employee=new Employee();
        employee.setDepId(depId);
        employee.setPositionId(opId);
        employee.setId(empId);
        employeeService.changeOp(employee);
        model.addAttribute("info","换岗成功");
        return "page/dep/changeOption";
    }
}
