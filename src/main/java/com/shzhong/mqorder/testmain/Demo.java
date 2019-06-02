package com.shzhong.mqorder.testmain;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        String dateStr = "";
        Date date = new Date();


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.toString());

        //format的格式可以任意
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
        try {
            dateStr = sdf.format(date);
            System.out.println(dateStr);
            dateStr = sdf2.format(date);
            System.out.println(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
