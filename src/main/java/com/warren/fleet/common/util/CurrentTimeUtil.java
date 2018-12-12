package com.warren.fleet.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeUtil {


    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date prase(String date) throws ParseException  {
        return  threadLocal.get().parse(date);
    }

    public static String format( Date date ){
        return threadLocal.get().format(date);
    }
}
