package com.ls.dao;

import com.ls.model.Attendance;

import java.util.List;

/**
 * Created by LS on 2017/11/2 16:46.
 * To Be or Not to Be
 */
public interface AttendanceDao {
    Attendance queryADayAttendance(String curDate,String nextDate,int empId);

    void updateEndTime(Attendance getAttendance);

    void saveAttendance(Attendance temp);

    List<Attendance> queryAttendanceByIdOfAMonth(String last,String current,int empId);

    List<Attendance> queryLastAttendance(String last, String current);

    List<Attendance> queryCurrentMonth(String currentMonthFirst, String currentTime);
}
