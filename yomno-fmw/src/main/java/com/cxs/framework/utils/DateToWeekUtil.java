package com.cxs.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToWeekUtil {

    private static final String DAY = "day";
    private static final String WEEK = "week";
    private static final String MONTH = "month";


    public DateToWeekUtil() {
    }

    /**
     * @param args
    /* */
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String startTime = sdf.format(new Date());
        String startTime = "20180706";
        String endTime = "20180301";
        int time = timeBettwen(startTime, endTime, WEEK);
        System.out.println(time);
    }

    public  static int timeBettwen(String startTime, String endTime, String datetype) {
        //天数
        int days = 0;
        int weeks = 0;
        int months = 0;
        try {
            //时间转换类
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date1 = sdf.parse(startTime);
            Date date2 = sdf.parse(endTime);
            Calendar can1 = Calendar.getInstance();
            can1.setTime(date1);
            Calendar can2 = Calendar.getInstance();
            can2.setTime(date2);
            int year1 = can1.get(Calendar.YEAR);
            int year2 = can2.get(Calendar.YEAR);
            Calendar can = null;
            if(can1.before(can2)){
                days -= can1.get(Calendar.DAY_OF_YEAR);
                days += can2.get(Calendar.DAY_OF_YEAR);
                weeks -= can1.get(Calendar.WEEK_OF_YEAR);
                weeks += can2.get(Calendar.WEEK_OF_YEAR);
                months -= can1.get(Calendar.MONTH);
                months += can2.get(Calendar.MONTH);
                can = can1;
            }else{
                days -= can2.get(Calendar.DAY_OF_YEAR);
                days += can1.get(Calendar.DAY_OF_YEAR);
                weeks -= can2.get(Calendar.WEEK_OF_YEAR);
                weeks += can1.get(Calendar.WEEK_OF_YEAR);
                months -= can2.get(Calendar.MONTH);
                months += can1.get(Calendar.MONTH);
                can = can2;
            }
            for (int i = 0; i < Math.abs(year2-year1); i++) {
                days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
                weeks += can.getActualMaximum(Calendar.WEEK_OF_YEAR);
                months += can.getActualMaximum(Calendar.MONTH) + 1;
                can.add(Calendar.YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (datetype.equals(DAY)) {
            return days;
        } else if (datetype.equals(WEEK)) {
            return weeks;
        } else if (datetype.equals(MONTH)) {
            return months;
        }
        return 0;
    }
}
