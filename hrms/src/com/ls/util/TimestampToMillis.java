package com.ls.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LS on 2017/11/4 10:55.
 * To Be or Not to Be
 */
public class TimestampToMillis {
    public static long changeTimestamp(Timestamp timestamp){
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        String dateFormat = format.format(timestamp);
        Date parse =null;
        try {
            parse=format.parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(parse);
        long timeInMillis = calendar.getTimeInMillis();
        return timeInMillis;
    }

    public static void main(String[] args) {
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        timestamp.setTime(1000000);
        long l = changeTimestamp(timestamp);
        System.out.println(l);
    }
}
