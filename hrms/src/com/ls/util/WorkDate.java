package com.ls.util;

import org.apache.ibatis.jdbc.Null;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by LS on 2017/11/3 18:31.
 * To Be or Not to Be
 */
public class WorkDate {
    public static List<String> getWorkList(){
        //获取上个月的工作日集合
        Date currentTime=new Date();

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy-MM-dd 00:00:00");



        //获取上个月一号时间格式
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.MONTH,-1);
        String lastMonthString = dateFormat.format(calendar.getTime());//上个月1号
//        System.out.println("上个月一号时间格式"+lastMonthString);
        //获取本月一号时间格式
        String currentMonthString = dateFormat.format(currentTime);
//        System.out.println("本月一号时间格式"+currentMonthString);

        List<String> workList=new ArrayList<>();
        Date lastDate = null;
        while (!lastMonthString.equals(currentMonthString)){
            if (calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY&&calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY){
                workList.add(lastMonthString);
                System.out.println(lastMonthString);
            }
            try {
                lastDate=dateFormat1.parse(lastMonthString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(lastDate);
            calendar.add(Calendar.DAY_OF_MONTH,+1);
            lastMonthString = dateFormat1.format(calendar.getTime());
        }
        return workList;
    }
    public static String currentMonth(){
        //获取本月的1号时间
        Date currentTime=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentTime);
        String currentMonthString = dateFormat.format(calendar.getTime());
        return currentMonthString;
    }
    public static String lastMonth(){
        //显示上个月1号时间
        Date currentTime=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.MONTH,-1);
        String lastMonthString = dateFormat.format(calendar.getTime());
        return lastMonthString;
    }

    public static String nextDay(String day){
        SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date parse=null;
        try {
            parse = dateFormat1.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(parse);
        calendar.add(Calendar.DAY_OF_WEEK,+1);
        String nextDay = dateFormat1.format(calendar.getTime());
        return nextDay;
    }

    public static void main(String[] args) {
        String s = nextDay("2017-10-01 00:00:00");
        System.out.println(s);
    }
}
