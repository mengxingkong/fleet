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

    public static String caculateduration(Date startTime, Date endTime ){
        long dif = endTime.getTime()-startTime.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli*60;
        long hoursInMilli = minutesInMilli*60;
        long daysInMilli = hoursInMilli*24;

        long elapseDays = dif / daysInMilli;
        if(elapseDays>0){
            return elapseDays+"d";
        }
        dif %= daysInMilli;
        long elapseHours = dif / hoursInMilli;
        if(elapseHours>0){
            return elapseHours+"h";
        }
        dif %= hoursInMilli;
        long elapseMinutes = dif / minutesInMilli;
        if(elapseMinutes>0){
            return elapseMinutes+"m";
        }
        dif %= minutesInMilli;
        long elapseSeconds = dif / secondsInMilli;
        return elapseSeconds+"s";
    }
}
