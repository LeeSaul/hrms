package com.ls.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LS on 2017/10/29 20:31.
 * To Be or Not to Be
 */
public class Test {
    public static void main(String[] args) {
       /* Date cur = new Date();
        //设置要获取到什么样的时间
        long next = cur.getTime() + 24 * 60 * 60 * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01 00:00:00");
        //获取String类型的时间
        String curDate=sdf.format(cur);
        System.out.println(curDate);
        String nextDate = sdf.format(next);
        Timestamp st=Timestamp.valueOf(curDate);
        Timestamp end=Timestamp.valueOf(nextDate);
        Timestamp s=new Timestamp(System.currentTimeMillis());
        System.out.println(s);*/

//       获取当前月份的第一天和上个月第一天

        Date currentMonth=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentMonth);
        calendar.add(Calendar.MONTH,-1);
        String current = dateFormat.format(currentMonth);
        String last = dateFormat.format(calendar.getTime());
        System.out.println(current);
        System.out.println(last);

    }
}
