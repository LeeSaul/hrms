package com.ls.service.impl;

import com.ls.dao.*;
import com.ls.model.*;
import com.ls.service.AttendanceService;
import com.ls.service.WorkService;
import com.ls.util.DateDemo;
import com.ls.util.WorkDate;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private WorkDao workDao;
    @Autowired
    private RewardsPunishmentDao rewardsPunishmentDao;
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void queryADayAttendance(int empId) {

        //要获取当前的日期
        Date cur = new Date();
        //设置要获取到什么样的时间
        long next = cur.getTime() + 24 * 60 * 60 * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        //获取String类型的时间
        String curDate=sdf.format(cur);
        String nextDate = sdf.format(next);
        /*将string类型转为timestamp
        Timestamp st=Timestamp.valueOf(curDate);
        Timestamp end=Timestamp.valueOf(nextDate);*/
        Attendance getAttendance = attendanceDao.queryADayAttendance(curDate,nextDate,empId);
        //查到当天记录说明今天已经打卡了，无需在插入记录
        if (getAttendance!=null){
            Timestamp s=new Timestamp(System.currentTimeMillis());
            getAttendance.setEndTime(s);
            //将最后打卡时间更改
            attendanceDao.updateEndTime(getAttendance);
        }else {
            Attendance temp=new Attendance();
            Timestamp s=new Timestamp(System.currentTimeMillis());
            temp.setStartTime(s);
            temp.setEmpId(empId);
            attendanceDao.saveAttendance(temp);
        }
    }

    @Override
    public List<Attendance> queryAttendanceByIdOfAMonth(int empId) {
        Date currentMonth=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentMonth);
        calendar.add(Calendar.MONTH,-1);
        String current = dateFormat.format(currentMonth);
        String last = dateFormat.format(calendar.getTime());
        List<Attendance> attendances = attendanceDao.queryAttendanceByIdOfAMonth(last, current, empId);
        return attendances;
    }

    @Override
    public List<Attendance> queryCurrentMonthById(int empId) {
        Date current=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        String currentMonthFirst = dateFormat.format(current);

        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat1.format(current);
        System.out.println(currentTime);
        List<Attendance> attendances = attendanceDao.queryAttendanceByIdOfAMonth(currentMonthFirst, currentTime, empId);
        return attendances;
    }

    @Override
    public void saveAttendance() {
        String lastMonth = WorkDate.lastMonth();
        String currentMonth = WorkDate.currentMonth();
        System.out.println("123456789");
        System.out.println(lastMonth);
        System.out.println("123456789");
        rewardsPunishmentDao.deleteRewardsPunishment(lastMonth,currentMonth);
        Work work = workDao.queryWork();
        if (work==null){
            //没有设置上下班时间
            return;
        }
        //每月工作天数
        int days = work.getDays();
        //获取上班时间和下班时间对应的毫秒数，以及加班时间
        long workMillis = work.getWorkMillis();
        long offMillis = work.getOffMillis();
        long overMillis = work.getOverMillis();
        double overPay = work.getOverPay();
        //查询当前所有的员工
        List<Employee> employees = employeeDao.queryAllEmpByStatus(Employee.normalStatus);
        for (Employee employee : employees) {
            System.out.println("员工上个月考勤表:员工id"+employee.getId());
            //获取员工的工作时间的集合
            List<String> workList = WorkDate.getWorkList();
            //缺勤次数
            int times=0;
            for (int i = 0; i < workList.size(); i++) {
                String s1 = workList.get(i);
                String s2 = WorkDate.nextDay(s1);
                Attendance attendance = attendanceDao.queryADayAttendance(s1, s2, employee.getId());
                System.out.println(s1+"~"+s2+":"+attendance+"///");
                if (attendance!=null){
                    //如果存在考勤记录，查询是否已经奖惩过了
                    RewardsPunishment rewardsPunishment = rewardsPunishmentDao.queryByAttId(attendance.getId());
                    if (rewardsPunishment==null){
                        RewardsPunishment addRecord=new RewardsPunishment();
                        addRecord.setEmpId(employee.getId());
                        addRecord.setAttId(attendance.getId());
                        long startMillis = attendance.getStartMillis();
                        long endMillis = attendance.getEndMillis();
                        String info=s1+"~"+s2;
                        double fine=0;
                        long morningOut=0;
                        long afternoonOut=0;
                        //判断是否生成记录
                        boolean flag=false;
                        if (attendance.getEndTime()==null){
                            info+="未打下班卡，扣除当天基本工资";
                            fine-=employee.getBasicWage()/days;
                        }else {
                            if (startMillis>workMillis){
                                //查看员工的基本薪资表
                                morningOut=(startMillis-workMillis)/1000/60;
                                //未超过三小时
                                if (morningOut<180){
                                    flag=true;
                                    info+="上班打卡晚"+morningOut+"分钟";
                                }else{
                                    flag=true;
                                    info+="上班打卡迟到3小时";
                                }
                            }
                            if (endMillis<offMillis){
                                //早退多少分钟
                                afternoonOut=(offMillis-endMillis)/1000/60;
                                if (afternoonOut<180){
                                    flag=true;
                                    info+="下班提前走"+afternoonOut+"分钟";
                                }else{
                                    flag=true;
                                    info+="下班提前打卡超过3小时";
                                }
                            }
                            fine=-(morningOut+afternoonOut);
                            if (-fine>=180){
                                flag=true;
                                fine=employee.getBasicWage()/days;
                                info+="--当天迟到早退超过三小时，扣除当天基本工资";
                            }else {
                                if (fine<0){
                                    flag=true;
                                    info+="--当天迟到早退"+(-fine)+"分钟"+"扣除工资"+(-fine)+"元";
                                }
                            }
                            if (endMillis>overMillis){
                                flag=true;
                                //加班补助
                                info="--加班补助"+overPay+"元";
                                fine+=overPay;
                            }
                        }
                        if (flag){
                            addRecord.setCaption(info);
                            addRecord.setRewardsFine(fine);
                            addRecord.setCreateTime(s1);
                            System.out.println("000111"+addRecord);
                            //生成惩罚记录
                            rewardsPunishmentDao.saveRewardsPunishment(addRecord);
                        }
                    }
                }else {
                    times++;
                }
            }
            RewardsPunishment punishment=new RewardsPunishment();
            punishment.setEmpId(employee.getId());
            System.out.println("==="+employee);
            double punish =times*employee.getBasicWage()/days;
            punishment.setCaption(workList.get(0)+"~"+workList.get(workList.size()-1)+"缺勤"+times+"次"+"扣除基本工资"+punish+"元");
            punishment.setRewardsFine(-punish);
            punishment.setCreateTime(workList.get(0));
            rewardsPunishmentDao.saveRewardsPunishment(punishment);
        }
    }

    @Override
    public List<Attendance> queryLastAttendance() {
//        Date currentMonth=DateDemo.getNetworkTime();
        Date currentMonth=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentMonth);
        calendar.add(Calendar.MONTH,-1);
        String current = dateFormat.format(currentMonth);
        String last = dateFormat.format(calendar.getTime());
        List<Attendance> attendances = attendanceDao.queryLastAttendance(last, current);
        for (Attendance attendance : attendances) {
            Employee employee = employeeDao.queryEmp(attendance.getEmpId());
            Department department = departmentDao.queryDepById(employee.getDepId());
            employee.setDepartment(department);
            attendance.setEmployee(employee);
        }
        return attendances;
    }

    @Override
    public List<Attendance> queryCurrentMonth() {
        Date current=new Date();
        System.out.println("===+"+current);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        String currentMonthFirst = dateFormat.format(current);

        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat1.format(current);
        List<Attendance> attendances = attendanceDao.queryCurrentMonth(currentMonthFirst, currentTime);
        for (Attendance attendance : attendances) {
            Employee employee = employeeDao.queryEmp(attendance.getEmpId());
            Department department = departmentDao.queryDepById(employee.getDepId());
            employee.setDepartment(department);
            attendance.setEmployee(employee);
        }
        System.out.println("12345+"+attendances);
        return attendances;
    }
}
