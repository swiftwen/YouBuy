package com.wp.youbuy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by chunxiaoli on 6/13/16.
 */
public class DateUtil {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String SP1 = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyyMMddHHmmss
     */
    public static final String SP2 = "yyyyMMddHHmmss";

    /**
     * yyyy-MM-dd
     */
    public static final String SP3 = "yyyy-MM-dd";

    /**
     * yyyyMMdd
     */
    public static final String SP4 = "yyyyMMdd";

    /**
     * yyyy/MM/dd
     */
    public static final String SP5 = "yyyy/MM/dd";

    /**
     * 将时间以指定格式格式化
     *
     * @param time            待转换时间
     * @param formatStrBefore 转换前时间格式
     * @param formatStrAfter  转换后时间格式
     * @return
     * @throws Exception
     */
    public static String parseTime(String time, String formatStrBefore, String formatStrAfter)
            throws ParseException {
        SimpleDateFormat bfSp = new SimpleDateFormat(formatStrBefore);
        SimpleDateFormat afSp = new SimpleDateFormat(formatStrAfter);
        return afSp.format(bfSp.parse(time));
    }

    /**
     * 比较时间前后
     *
     * @param time1     时间1
     * @param time2     时间2
     * @param formatStr 时间格式
     * @return 时间1比时间2早则返回1 时间1比时间2晚则返回-1 时间1等于时间2则返回0
     * @throws ParseException
     */
    public static int compareTime(String time1, String time2, String formatStr)
            throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        Date date1 = sp.parse(time1);
        Date date2 = sp.parse(time2);
        if (date1.before(date2)) {
            return 1;
        } else if (date1.after(date2)) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 获得指定格式的当前时间
     *
     * @param formatStr 时间格式
     * @return
     */
    public static String getCurrentTime(String formatStr) {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        return sp.format(new Date());
    }

    /**
     * 获取指定格式的某时间,例如1小时前 或者1小时后
     *
     * @param field     例如Calendar.DAY_OF_MONTH
     * @param amount    整数 例如-1
     * @param formatStr 时间格式
     * @return
     */
    public static String getTimeAfter(int field, int amount, String formatStr) {
        Calendar cal = Calendar.getInstance();
        cal.add(field, amount);
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        return sp.format(cal.getTime());
    }
    /**
     * 
     * @desc 日期前移或后移N天
     * @param date
     * @param day
     * @return 
     * @Author wenpeng
     * @2017年8月16日 下午4:27:43
     */
    public static Date getDayAfter(Date date,int day) {
    	 Calendar calendar   =   new   GregorianCalendar(); 
	     calendar.setTime(date); 
	     calendar.add(Calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动 
	     date=calendar.getTime();   
	     return date;
    }

    /**
     * 获取当月第一天
     *
     * @param formatStr
     * @return
     */
    public static String getFirstDayOfMonth(String formatStr) {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        Calendar date = Calendar.getInstance();// 今天
        date.set(Calendar.DAY_OF_MONTH, 1);// 设置日期为本月第1天
        date.set(Calendar.HOUR_OF_DAY, 0);// 设置时
        date.set(Calendar.MINUTE, 0);// 设置分
        date.set(Calendar.SECOND, 0);// 设置秒
        return sp.format(date.getTime());
    }

    /**
     * 日期/时间 计算 这个方法只能对yyyy-MM-dd HH:mm:ss 格式的时间进行运算
     * 该方法已经由calculateTime(String time,String formatStr, String addpart, int num) 取代,为做兼容没有删掉
     *
     * @param time    待计算时间
     * @param addpart 可选 Y M D H F S
     * @param num     增加或者减少量(整数)
     * @return
     * @throws Exception
     */
    @Deprecated
    public static String calculateTime(String time, String addpart, int num) throws ParseException {
        DateFormat yyyyMMddHHmmssDateFormat = new SimpleDateFormat(SP1);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(yyyyMMddHHmmssDateFormat.parse(time));
        if (addpart.equalsIgnoreCase("Y")) {
            cal.add(Calendar.YEAR, num);
        } else if (addpart.equalsIgnoreCase("M")) {
            cal.add(Calendar.MONTH, num);
        } else if (addpart.equalsIgnoreCase("D")) {
            cal.add(Calendar.DATE, num);
        } else if (addpart.equalsIgnoreCase("H")) {
            cal.add(Calendar.HOUR, num);
        } else if (addpart.equalsIgnoreCase("F")) {
            cal.add(Calendar.MINUTE, num);
        } else if (addpart.equalsIgnoreCase("S")) {
            cal.add(Calendar.SECOND, num);
        }
        return yyyyMMddHHmmssDateFormat.format(cal.getTime());
    }

    /**
     * 日期/时间 计算
     *
     * @param time      待计算时间
     * @param formatStr 时间格式
     * @param addpart   可选 Y M D H F S
     * @param num       增加或者减少量(整数)get
     * @return
     * @throws Exception
     */
    public static String calculateTime(String time, String formatStr, String addpart, int num)
            throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dateFormat.parse(time));
        if (addpart.equalsIgnoreCase("Y")) {
            cal.add(Calendar.YEAR, num);
        } else if (addpart.equalsIgnoreCase("M")) {
            cal.add(Calendar.MONTH, num);
        } else if (addpart.equalsIgnoreCase("D")) {
            cal.add(Calendar.DATE, num);
        } else if (addpart.equalsIgnoreCase("H")) {
            cal.add(Calendar.HOUR, num);
        } else if (addpart.equalsIgnoreCase("F")) {
            cal.add(Calendar.MINUTE, num);
        } else if (addpart.equalsIgnoreCase("S")) {
            cal.add(Calendar.SECOND, num);
        }
        return dateFormat.format(cal.getTime());
    }

    /**
     * 返回两个时间之间的差(毫秒数)
     *
     * @param time1
     * @param time2
     * @param formatStr
     * @return
     * @throws ParseException
     */
    public static long dateDiffer(String time1, String time2, String formatStr)
            throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        Date date1 = sp.parse(time1);
        Date date2 = sp.parse(time2);
        long differ = Math.abs(date1.getTime() - date2.getTime());
        return differ;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     */
	public static int daysBetween(Date smdate, Date bdate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
		}
		return 0;
	}

    public static long increaseDatebyDay(Date date, int day) {
        Long dateTime = date.getTime();
        Long afterDateTime = dateTime + (long) 1000 * 3600 * 24 * day;
        return afterDateTime;
    }

    public static Date pareDate(String dateString, String formatString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.parse(dateString);
    }


    public static String formatDate(Date date, String formatString) {
        return new SimpleDateFormat(formatString).format(date);
    }

    public static String formatWithYYMMDD(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String formatWithYYMMDD(Long  date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String formatWithYYMMDDHHMMSS(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static Date parseStr2Date(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    /**
     * 
     * @desc 
     * @return 
     * @Author wuweibing
     * @2017年8月15日 下午5:28:35
     */
	public static String getStartTimeOfMonth(String formatStr, String monthStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(monthStr));
		} catch (ParseException e) {
			return null;
		}
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		sdf = new SimpleDateFormat(SP1);
		return sdf.format(calendar.getTime());
	}

	/**
	 * @desc 获取某月结束时间
	 * @return
	 * @Author wuweibing
	 * @2017年8月15日 下午5:28:04
	 */
	public static String getEndTimeOfMonth(String formatStr, String monthStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(monthStr));
		} catch (ParseException e) {
			return null;
		}
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.add(Calendar.HOUR_OF_DAY, 23);
		calendar.add(Calendar.MINUTE, 59);
		calendar.add(Calendar.SECOND, 59);
		sdf = new SimpleDateFormat(SP1);
		return sdf.format(calendar.getTime());
	}
	
	public static boolean isInTime(Date start, Date end, Date time) {
		return time.compareTo(start) > 0 && time.compareTo(end) < 0;
	}
}
