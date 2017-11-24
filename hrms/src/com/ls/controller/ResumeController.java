package com.ls.controller;

import com.ls.model.Employee;
import com.ls.model.Resume;
import com.ls.model.Tourist;
import com.ls.service.EmployeeService;
import com.ls.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by LS on 2017/10/26 16:49.
 * To Be or Not to Be
 */
@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;
    @Resource
    private EmployeeService employeeService;

    //游客添加简历
    @RequestMapping(value = "/addResume",method = RequestMethod.POST)
    public String tourAddResume(Resume resume){
        boolean b = resumeService.addResume(resume);
        if (b){
            return "page/tour/tourIndex";
        }
        return "fail";
    }

    //查看简历
    @RequestMapping(value = "/queryResumeById",method = RequestMethod.GET)
    public String queryResumeById(int num,int depId,int opId,int id,Model model){
        Resume resume = resumeService.queryDetailResume(id);
        Employee employee = employeeService.queryEmpByResumeId(id);
        model.addAttribute("employee",employee);
        model.addAttribute("resume",resume);
        model.addAttribute("depId",depId);
        model.addAttribute("opId",opId);
        model.addAttribute("num",num);
        return "page/dep/aResume";
    }

    //查看简历
    @RequestMapping(value = "/queryAResume",method = RequestMethod.GET)
    public String queryAResume(int id,Model model){
        Resume resume = resumeService.queryDetailResume(id);
        model.addAttribute("resume",resume);
        return "page/recruitment/aResume";
    }

    //修改或者添加简历页面
    @RequestMapping(value = "/queryMyResume",method = RequestMethod.GET)
    public String queryMyResume(Model model, HttpSession session){
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        Resume resume = resumeService.queryResume(tourist.getId());
        model.addAttribute("resume",resume);
        return "page/tour/addResume";
    }

    //员工修改
    @RequestMapping(value = "/updateEmpResume",method = RequestMethod.POST)
    public String updateEmpResume(Resume resume){
        resumeService.updateEmpResume(resume);
        return "page/emp/empIndex";
    }
    //游客修改
    @RequestMapping(value = "/updateResume",method = RequestMethod.POST)
    public String updateResume(Resume resume,HttpSession session){
        Tourist tourist = (Tourist) session.getAttribute("tourist");
        resume.setTouristId(tourist.getId());
        resumeService.updateResume(resume);
        return "page/tour/tourIndex";
    }
}
