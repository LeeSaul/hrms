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
        //����Ҫ��ȡ��ʲô����ʱ��
        long next = cur.getTime() + 24 * 60 * 60 * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01 00:00:00");
        //��ȡString���͵�ʱ��
        String curDate=sdf.format(cur);
        System.out.println(curDate);
        String nextDate = sdf.format(next);
        Timestamp st=Timestamp.valueOf(curDate);
        Timestamp end=Timestamp.valueOf(nextDate);
        Timestamp s=new Timestamp(System.currentTimeMillis());
        System.out.println(s);*/

//       ��ȡ��ǰ�·ݵĵ�һ����ϸ��µ�һ��

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
