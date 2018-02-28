package com.cxs.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil
 * @Description:
 * @author: ryan.guo
 * @email: chinazan@qq.com
 * @date: 2017年3月9日 下午1:40:45
 *
 */
public class DateUtil {

	/**
	 * 常用时间转换
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

	private static SimpleDateFormat simpleDateFormat = null;

	/**
	 * 将时间字符串格式化传出
	 *
	 * @param dateTime
	 *            时间字符串
	 * @param formatString
	 *            格式
	 * @return
	 * @throws ParseException
	 *             转换异常
	 */
	public static Long StrFormatNumber(String dateTime, String formatString) throws ParseException {
		simpleDateFormat = new SimpleDateFormat(formatString);
		Date date = simpleDateFormat.parse(dateTime);
		return date.getTime();
	}

	/**
	 * 将时间戳转变换成对应格式的时间字符串
	 *
	 * @param dateTime
	 *            时间戳
	 * @param formatString
	 *            格式字符串
	 * @return
	 */
	public static String NumberFormatStr(Long dateTime, String formatString) {
		Date date = new Date(dateTime);
		simpleDateFormat = new SimpleDateFormat(formatString);
		return simpleDateFormat.format(date);
	}

	/**
	 * 将当前时间格式化、传出
	 *
	 * @param formatStrimg
	 * @return
	 */
	public static String dateFormat() {
		Date date = new Date();
		simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		String timeStr = simpleDateFormat.format(date);
		return timeStr;
	}

	/**
	 * 将当前时间格式化、传出
	 *
	 * @param formatStrimg
	 * @return
	 */
	public static String dateFormat(String formatStrimg) {
		Date date = new Date();
		simpleDateFormat = new SimpleDateFormat(formatStrimg);
		String timeStr = simpleDateFormat.format(date);
		return timeStr;
	}

	/**
	 * 根据传入时间、和格式字符串、格式化
	 *
	 * @param date
	 * @param formatStrimg
	 * @return
	 */
	public static String dateFormat(Date date, String formatStrimg) {
		simpleDateFormat = new SimpleDateFormat(formatStrimg);
		String timeStr = simpleDateFormat.format(date);
		return timeStr;
	}

	/**
	 * 时间对比
	 *
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String timeCompart(Date startTime, Date endTime) {
		long diffTime = endTime.getTime() - startTime.getTime();
		String result = "";
		// 数组时间判断：年、月、天、小时、分钟、秒
		long[] itimes = new long[] { 365 * 24 * 60 * 60 * 1000L, 30 * 24 * 60 * 60 * 1000L, 24 * 60 * 60 * 1000L,
				60 * 60 * 1000L, 60 * 1000, 1000L };
		String[] sunits = new String[] { "年", "月", "天", "小时", "分钟", "秒" };

		for (int i = 0, len = itimes.length; i < len; i++) {
			long itemp = itimes[i];
			if (diffTime < itemp) {
				continue;
			}
			long temp2 = diffTime / itemp;
			if (temp2 > 0) {
				result = temp2 + sunits[i];
				break;
			}
		}
		return result;
	}

	/**
	 * 计算两个日期之间相差天数
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int getDiscrepantDays(Date dateStart, Date dateEnd) {
		return (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24);
	}

	public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}
	
	/**
	 * 长整形时间转字符串时间，返回格式为yyy-MM-dd HH:mm:ss
	 * @param time 时间
	 * @return 字符串时间
	 */
	public static String long2String(long time){
		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = simpleDateFormat.format(date);
		return timeStr;
	}	
	
	/**
	 * 长整形时间转指定格式的字符串时间
	 * @param time 时间
	 * @param format 字符串时间格式，例如：yyyy-MM-dd HH:mm:ss
	 * @return 字符串时间
	 */
	public static String long2String(long time, String format){
		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String timeStr = simpleDateFormat.format(date);
		return timeStr;
	}	

}
