package com.cxs.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MondayAndFridayUtil {

    public static String getWeekMonday(Date date){
        SimpleDateFormat formater=new SimpleDateFormat("yyyyMMdd");
        Calendar cal=new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        Date first=cal.getTime();
        return formater.format(first);
    }
    /**
     * 得到本周周五日期
     * @return
     */
    public static String getWeekFriday(){
        SimpleDateFormat formater=new SimpleDateFormat("yyyyMMdd");
        Calendar cal=new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 4);
        Date last=cal.getTime();
        return  formater.format(last);
    }
}
