package com.cxs.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeekToDateUtil {
    public static void main(String[] args) throws ParseException {
        plusDay(14, "20180301");
        getWeekMondayByDate(plusDay(14,"20180301"));
    }

    /**
     * 16      * 指定日期加上天数后的日期
     * 17      * @param num 为增加的天数
     * 18      * @param startDate 创建时间
     * 19      * @return
     * 20      * @throws ParseException
     * 21
     */
    public static String plusDay(int num, String startDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); // 日期格式
        Date date = null;
        Date newDate = null;
        try {
            date = dateFormat.parse(startDate); // 指定日期
            newDate = addDate(date, num); // 指定日期天数
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(newDate);
    }



    public static Date addDate(Date date, long day) throws ParseException {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
        time += day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }

    public static String  getWeekMondayByDate(String time) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 设置时间格式
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String imptimeBegin = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 2);
        cal.add(Calendar.DATE, 2);
        return imptimeBegin;

    }
    public static String getWeekFirDayByDate(String time) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 设置时间格式
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, 2);
        cal.add(Calendar.DATE, 2);
        String imptimeEnd = sdf.format(cal.getTime());
        return imptimeEnd;

    }


}
