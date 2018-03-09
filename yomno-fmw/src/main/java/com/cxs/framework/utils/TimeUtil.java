package com.cxs.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class TimeUtil {
    public static void main(String args[]) {
        String[] strs=convertLevelandTimeString("week","201649","201649");
        System.out.println("开始时间："+strs[0]);
        System.out.println("结束时间："+strs[1]);
    }
    public static String[] convertLevelandTimeString(String level,String startTime,String endTime){
        String[] times=new String[2];
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMM");
        //开始日期对象，绑定startTime
        Calendar cal = Calendar.getInstance();
        //结束日期对象，绑定endTime
        Calendar cal1 = Calendar.getInstance();
        try {
            if("day".equals(level)||"天".equals(level)||"日".equals(level)) {
                sf = new SimpleDateFormat("yyyyMMdd");
                Date d=sf.parse(startTime);
                Date d1=sf.parse(endTime);
                cal.setTime(d);
                //开始时间字符串表示形式 201611290000
                times[0]=sf.format(cal.getTime());
                if(startTime.equals(endTime)){
                    //如果开始时间和结束时间字符串相同，那么结束时间为当天23点59分，如201611292359
                    times[1]=sf.format(cal.getTime());
                }else{
                    cal1.setTime(d1);
                    times[1]=sf.format(cal1.getTime());
                }
            }else if("week".equals(level)||"周".equals(level)){
                //根据制定年周获取开始和结束日期，比如获取201649(2016年第49周)的开始日期，目标值：201611280000
                int startyear=Integer.parseInt(startTime.substring(0,4));
                int startweekNumber=Integer.parseInt(startTime.substring(4,6));
                cal.set(Calendar.YEAR, startyear+1);
                cal.set(Calendar.MONTH, 0);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                cal.set(Calendar.HOUR_OF_DAY, 1);
                cal.add(Calendar.DAY_OF_MONTH, -(6+cal.get(Calendar.DAY_OF_WEEK)));
                //指定开始的年共有多少周
                int weeks = cal.get(Calendar.WEEK_OF_YEAR);
                //制定开始的年的周开始日期集合
                String[] days = new String[weeks];
                sf = new SimpleDateFormat("yyyyMMdd");
                for(int i=weeks-1;i>=0;i--){
                    //由于国外从周日算每周开始，中国从周一开始，所以这里减6天才符合中国
                    cal.add(Calendar.DAY_OF_MONTH, -6);
                    days[i] = sf.format(cal.getTime());
                    //上面减了6天，这里加上，不然时间不对
                    cal.add(Calendar.DAY_OF_MONTH, 6);
                    cal.add(Calendar.WEEK_OF_YEAR, -1);
                }
                //从days集合中获得指定第几周的开始日期时间（中国的习惯是每周一开始，而外国习惯周日是每周第一天，这里以中国为主）
                times[0]=days[startweekNumber];
                //--------------------------------------------------------------------
                //根据指定年周获取开始和结束日期，比如获取201649(2016年第49周)的结束日期，目标值：201612042359
                int endyear=Integer.parseInt(endTime.substring(0,4));
                int endweekNumber=Integer.parseInt(endTime.substring(4,6));
                cal1.set(Calendar.YEAR, endyear+1);
                cal1.set(Calendar.MONTH, 0);
                cal1.set(Calendar.DAY_OF_MONTH, 1);
                cal1.set(Calendar.HOUR_OF_DAY, 1);
                cal1.add(Calendar.DAY_OF_MONTH, -(6+cal1.get(Calendar.DAY_OF_WEEK)));
                //指定的年共有多少周
                int weeks1 = cal1.get(Calendar.WEEK_OF_YEAR);
                //制定年的周开始日期集合
                String[] days1 = new String[weeks1];
                sf = new SimpleDateFormat("yyyyMMdd");
                for(int i=weeks1-1;i>=0;i--){
                    days1[i] = sf.format(cal1.getTime());
                    cal1.add(Calendar.WEEK_OF_YEAR, -1);
                }
                //从days集合中获得指定第几周的结束时间（中国的习惯是每周日结束，而外国习惯周日是每周第一天，这里以中国为主）
                times[1]=days1[endweekNumber];

            }else if("month".equals(level)||"月".equals(level)){
                Date monthDate=sf.parse(startTime);
                Date endMonthDate=sf.parse(endTime);
                cal.setTime(monthDate);
                //获取指定年月的开始时间，如，获取201611月的开始日期，目标值：201611010000
                cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
                sf = new SimpleDateFormat("yyyyMMdd");
                times[0]=sf.format(cal.getTime());
                //获取指定年月的结束时间，如，获取201611月的结束日期，目标值：201611302359
                cal1.setTime(endMonthDate);
                //获取指定年月的开始时间，如，获取201611月的开始日期，目标值：201611010000
                cal1.set(Calendar.DAY_OF_MONTH, cal1.getActualMaximum(Calendar.DAY_OF_MONTH));
                sf = new SimpleDateFormat("yyyyMMdd");
                times[1]=sf.format(cal1.getTime());

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return times;
    }

}
