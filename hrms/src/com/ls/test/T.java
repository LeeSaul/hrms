package com.ls.test;

import com.ls.service.ResumeService;
import com.ls.service.impl.ResumeServiceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LS on 2017/10/27 10:12.
 * To Be or Not to Be
 */
public class T {
    public static void main(String[] args) {
        String abv = reverse("abcdefg");
        System.out.println(abv);
    }
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        String s = reverse(originStr.substring(1)) + originStr.charAt(0);
        System.out.print(originStr.substring(1));
        System.out.println("--"+originStr.charAt(0));
        return s;
    }
}
