package com.ls.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LS on 2017/11/3 19:53.
 * To Be or Not to Be
 */
public class DateDemo {

    public static Date getNetworkTime() {
        String webUrl = "http://www.baidu.com";// °Ù¶È
        try {
            URL url = new URL(webUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
            long dateL = conn.getDate();
            Date date = new Date(dateL);
            /*SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String format = dateFormat.format(date);*/
            return date;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Date networkTime = getNetworkTime();
        System.out.println(networkTime);
    }
}
