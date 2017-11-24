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

        //Ҫ��ȡ��ǰ������
        Date cur = new Date();
        //����Ҫ��ȡ��ʲô����ʱ��
        long next = cur.getTime() + 24 * 60 * 60 * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        //��ȡString���͵�ʱ��
        String curDate=sdf.format(cur);
        String nextDate = sdf.format(next);
        /*��string����תΪtimestamp
        Timestamp st=Timestamp.valueOf(curDate);
        Timestamp end=Timestamp.valueOf(nextDate);*/
        Attendance getAttendance = attendanceDao.queryADayAttendance(curDate,nextDate,empId);
        //�鵽�����¼˵�������Ѿ����ˣ������ڲ����¼
        if (getAttendance!=null){
            Timestamp s=new Timestamp(System.currentTimeMillis());
            getAttendance.setEndTime(s);
            //������ʱ�����
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
            //û���������°�ʱ��
            return;
        }
        //ÿ�¹�������
        int days = work.getDays();
        //��ȡ�ϰ�ʱ����°�ʱ���Ӧ�ĺ��������Լ��Ӱ�ʱ��
        long workMillis = work.getWorkMillis();
        long offMillis = work.getOffMillis();
        long overMillis = work.getOverMillis();
        double overPay = work.getOverPay();
        //��ѯ��ǰ���е�Ա��
        List<Employee> employees = employeeDao.queryAllEmpByStatus(Employee.normalStatus);
        for (Employee employee : employees) {
            System.out.println("Ա���ϸ��¿��ڱ�:Ա��id"+employee.getId());
            //��ȡԱ���Ĺ���ʱ��ļ���
            List<String> workList = WorkDate.getWorkList();
            //ȱ�ڴ���
            int times=0;
            for (int i = 0; i < workList.size(); i++) {
                String s1 = workList.get(i);
                String s2 = WorkDate.nextDay(s1);
                Attendance attendance = attendanceDao.queryADayAttendance(s1, s2, employee.getId());
                System.out.println(s1+"~"+s2+":"+attendance+"///");
                if (attendance!=null){
                    //������ڿ��ڼ�¼����ѯ�Ƿ��Ѿ����͹���
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
                        //�ж��Ƿ����ɼ�¼
                        boolean flag=false;
                        if (attendance.getEndTime()==null){
                            info+="δ���°࿨���۳������������";
                            fine-=employee.getBasicWage()/days;
                        }else {
                            if (startMillis>workMillis){
                                //�鿴Ա���Ļ���н�ʱ�
                                morningOut=(startMillis-workMillis)/1000/60;
                                //δ������Сʱ
                                if (morningOut<180){
                                    flag=true;
                                    info+="�ϰ����"+morningOut+"����";
                                }else{
                                    flag=true;
                                    info+="�ϰ�򿨳ٵ�3Сʱ";
                                }
                            }
                            if (endMillis<offMillis){
                                //���˶��ٷ���
                                afternoonOut=(offMillis-endMillis)/1000/60;
                                if (afternoonOut<180){
                                    flag=true;
                                    info+="�°���ǰ��"+afternoonOut+"����";
                                }else{
                                    flag=true;
                                    info+="�°���ǰ�򿨳���3Сʱ";
                                }
                            }
                            fine=-(morningOut+afternoonOut);
                            if (-fine>=180){
                                flag=true;
                                fine=employee.getBasicWage()/days;
                                info+="--����ٵ����˳�����Сʱ���۳������������";
                            }else {
                                if (fine<0){
                                    flag=true;
                                    info+="--����ٵ�����"+(-fine)+"����"+"�۳�����"+(-fine)+"Ԫ";
                                }
                            }
                            if (endMillis>overMillis){
                                flag=true;
                                //�Ӱಹ��
                                info="--�Ӱಹ��"+overPay+"Ԫ";
                                fine+=overPay;
                            }
                        }
                        if (flag){
                            addRecord.setCaption(info);
                            addRecord.setRewardsFine(fine);
                            addRecord.setCreateTime(s1);
                            System.out.println("000111"+addRecord);
                            //���ɳͷ���¼
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
            punishment.setCaption(workList.get(0)+"~"+workList.get(workList.size()-1)+"ȱ��"+times+"��"+"�۳���������"+punish+"Ԫ");
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
