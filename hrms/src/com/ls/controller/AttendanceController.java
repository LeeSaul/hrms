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

    //打卡
    @RequestMapping(value = "/clock",method = RequestMethod.POST)
    public void clock(HttpSession session, HttpServletResponse response){
        Employee emp = (Employee) session.getAttribute("emp");
        attendanceService.queryADayAttendance(emp.getId());
        try {
            response.getWriter().write("打卡成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //某个员工上个月的打卡记录
    @RequestMapping(value = "/queryAttendanceByIdOfAMonth",method = RequestMethod.GET)
    public String queryAttendanceByIdOfAMonth(HttpSession session, Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        List<Attendance> attendances = attendanceService.queryAttendanceByIdOfAMonth(emp.getId());
        model.addAttribute("attendances",attendances);
        model.addAttribute("info","上月1号至本月1号");
        return "page/emp/attendancesList";
    }
    //查看本月某员工打卡记录
    @RequestMapping(value = "/queryCurrentMonthById",method = RequestMethod.GET)
    public String queryCurrentMonthById(HttpSession session, Model model){
        Employee emp = (Employee) session.getAttribute("emp");
        List<Attendance> attendances = attendanceService.queryCurrentMonthById(emp.getId());
        model.addAttribute("attendances",attendances);
        model.addAttribute("info","本月1号到现在");
        return "page/emp/attendancesList";
    }

    //上个月的打卡记录
    @RequestMapping(value = "/queryLastAttendance",method = RequestMethod.GET)
    public String queryLastAttendance(Model model){
        List<Attendance> attendances = attendanceService.queryLastAttendance();
        model.addAttribute("attendances",attendances);
        model.addAttribute("info","上月1号至本月1号考勤记录");
        return "page/admin/attendancesList";
    }

    //查看本月打卡记录
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
        model.addAttribute("info","本月1号到当天考勤记录");
        return "page/admin/attendancesList";
    }


    //管理员登录之后自动生成奖惩记录
    @RequestMapping(value = "/checkWork",method = RequestMethod.POST)
    public void checkWork(){
        System.out.println("123456789");
        //先判断是否有上个月的奖罚记录，如果有就删除掉
        attendanceService.saveAttendance();
    }
}
