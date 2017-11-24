package com.ls.service;


import com.ls.model.Attendance;

import java.util.List;

/**
 * Created by LS on 2017/11/2 15:59.
 * To Be or Not to Be
 */
public interface AttendanceService {
    void queryADayAttendance(int empId);

    List<Attendance> queryAttendanceByIdOfAMonth(int empId);

    List<Attendance> queryCurrentMonthById(int id);

    void saveAttendance();

    List<Attendance> queryLastAttendance();

    List<Attendance> queryCurrentMonth();

}
