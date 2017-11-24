package com.ls.controller;

import com.ls.model.Attendance;
import com.ls.model.Employee;
import com.ls.service.AttendanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;

    //��
    @RequestMapping(value = "/clock",method = RequestMethod.POST)
    public void clock(HttpSession session, HttpServletResponse response){
        Employee emp = (Employee) session.getAttribute("emp");
        attendanceService.queryADayAttendance(emp.getId());
        try {
            response.getWriter().write("�򿨳ɹ�");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //ĳ��Ա���ϸ��µĴ򿨼�¼
    @RequestMapping(value = "/queryAttendanceByIdOfAMonth",method = RequestMethod.GET)
    public String queryAttendanceByIdOfAMonth(HttpSession session, Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        List<Attendance> attendances = attendanceService.queryAttendanceByIdOfAMonth(emp.getId());
        model.addAttribute("attendances",attendances);
        model.addAttribute("info","����1��������1��");
        return "page/emp/attendancesList";
    }
    //�鿴����ĳԱ���򿨼�¼
    @RequestMapping(value = "/queryCurrentMonthById",method = RequestMethod.GET)
    public String queryCurrentMonthById(HttpSession session, Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        List<Attendance> attendances = attendanceService.queryCurrentMonthById(emp.getId());
        model.addAttribute("attendances",attendances);
        model.addAttribute("info","����1�ŵ�����");
        return "page/emp/attendancesList";
    }

    //�ϸ��µĴ򿨼�¼
    @RequestMapping(value = "/queryLastAttendance",method = RequestMethod.GET)
    public String queryLastAttendance(Model model){
        List<Attendance> attendances = attendanceService.queryLastAttendance();
        model.addAttribute("attendances",attendances);
        model.addAttribute("info","����1��������1�ſ��ڼ�¼");
        return "page/admin/attendancesList";
    }

    //�鿴���´򿨼�¼
    @RequestMapping(value = "/queryCurrentMonth",method = RequestMethod.GET )
    public String queryCurrentMonth(HttpSession session, Model model,HttpServletResponse response){
        List<Attendance> attendances = attendanceService.queryCurrentMonth();
        /*JSONArray jsonArray = JSONArray.fromObject(attendances);
        try {
            response.getWriter().println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        model.addAttribute("attendances",attendances);
        System.out.println("====="+attendances);
        model.addAttribute("info","����1�ŵ����쿼�ڼ�¼");
        return "page/admin/attendancesList";
    }


    //����Ա��¼֮���Զ����ɽ��ͼ�¼
    @RequestMapping(value = "/checkWork",method = RequestMethod.POST)
    public void checkWork(){
        System.out.println("123456789");
        //���ж��Ƿ����ϸ��µĽ�����¼������о�ɾ����
        attendanceService.saveAttendance();
    }
}
