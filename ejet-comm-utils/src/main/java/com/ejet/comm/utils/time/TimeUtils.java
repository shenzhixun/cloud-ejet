package com.ejet.comm.utils.time;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 *
 * 返回指定格式日期类
 *
 */
public class TimeUtils {

	public static final String TAG = TimeUtils.class.getSimpleName();
	/**
	 * 日期格式 ：yyyyMMddHHmmsss
	 */
	public static final SimpleDateFormat yyyyMMddHHmmSSS = new SimpleDateFormat("yyyyMMddHHmmsss");
	/**
	 * 日期格式 ： yyyyMMdd HH:mm:ss
	 */
	public static final SimpleDateFormat yyyyMMdd_HH_mm_ss = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	/**
	 * 日期格式 ：yyyy-MM-dd HH:mm:ss
	 */
	public static final SimpleDateFormat yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 日期格式 ：yyyy-MM-dd HH:mm:sss
	 */
	public static final SimpleDateFormat yyyy_MM_dd_HH_mm_sss = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	/**
	 * 日期格式 ：MM/dd/yyyy HH:mm:ss.SSS
	 */
	public static final SimpleDateFormat MM_dd_yyy_HH_mm_sss = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
	/**
	 * 日期格式 ：yyyyMMdd
	 */
	public static final SimpleDateFormat yyyMMdd = new SimpleDateFormat("yyyyMMdd");
	/**
	 * 日期格式 ：MM.dd
	 */
	public static final SimpleDateFormat MM_dd = new SimpleDateFormat("MM.dd");
	/**
	 * 日期格式 ：yyyy-MM-dd
	 */
	public static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 日期格式 ：yyyy-MM
	 */
	public static final SimpleDateFormat yyyy_MM = new SimpleDateFormat("yyyy-MM");
	/**
	 * 日期格式 ：yyyy
	 */
	public static final SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");

	private TimeUtils() {
		throw new AssertionError();
	}

	/**
	 * 返回格式化日期字符串 比如：dateFormat为 yyyyMMddHHmmsss 则输出：201602121501001
	 *
	 * @param timeInMillis
	 * @param dateFormat
	 * @return
	 */
	public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
		return dateFormat.format(new Date(timeInMillis));
	}

	/**
	 * long time to string, format is {@link #yyyyMMddHHmmSSS}
	 *
	 * @param timeInMillis
	 * @return
	 */
	public static String getTime(long timeInMillis) {
		return getTime(timeInMillis, yyyyMMddHHmmSSS);
	}

	/**
	 * @param timeInMillis
	 * @return
	 */
	public static String getTime(long timeInMillis, String format) {

		return getTime(timeInMillis, new SimpleDateFormat(format));
	}

	public static String getMMdd(String time) {
		try {
			return MM_dd.format(MM_dd.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回 指定 年 的 月份的天数
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthDay(int year, int month) {
		return getMonthDayByYear(year)[--month];
	}

	/**
	 * 通过 年份 返回 每个月 有几天
	 *
	 * @param year
	 * @return
	 */
	public static int[] getMonthDayByYear(int year) {

		int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			monthDay[1]++;
		return monthDay;
	}

	/**
	 * get current time in milliseconds
	 *
	 * @return
	 */
	public static long getCurrentTimeInLong() {
		return System.currentTimeMillis();
	}

	/**
     * 返回yyyyMMddHHmmSSS字符串
	 * @return
	 */
	public static String getCurrentTimeInString() {
		return getTime(getCurrentTimeInLong());
	}

	public static String getCurrentTime() {
        return getTime(System.currentTimeMillis(), yyyy_MM_dd_HH_mm_sss);
    }

	/**
	 * 返回指定格式dateFormat字符串
	 * @return
	 */
	public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
		return getTime(getCurrentTimeInLong(), dateFormat);
	}

	/**
	 * 格式化时间yyyy-MM-dd
	 */
	public static String getCurrentTime(String time) {
		try {
			return yyyy_MM_dd.format(yyyy_MM_dd.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	};

	/**
	 * 获得当前时间
	 *
	 * @param dateFormat
	 * @return
	 */
	public static String getCurrentTimeInString(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return getCurrentTimeInString(sdf);
	}

	/**
	 * 获取网络时间,根据dateFormat格式进行输出 比如：dateFormat为 yyyyMMddHHmmsss 则输出：201602121501001
	 *
	 * @param dateFormat
	 * @return
	 */
	public static String getTimeFromNet(String dateFormat) {
		String bjTime = null;
		Locale locale = Locale.CHINA; // 这是获得本地中国时区
		SimpleDateFormat df = new SimpleDateFormat(dateFormat, locale);// 设定日期格式
		try {
			URL url = new URL("http://open.baidu.com/special/time");// 取得资源对象
			java.net.URLConnection uc = url.openConnection();// 生成连接对象
			uc.setConnectTimeout(1000);// 毫秒
			uc.setReadTimeout(1000);//
			uc.connect(); // 发出连接
			long ld = uc.getDate(); // 取得网站日期时间
			bjTime = getTime(ld, df);
		} catch (Exception e) {
			// Log.e(TAG, "getLocaltime", e);
			bjTime = getCurrentTimeInString(df);
		} finally {
			if (bjTime == null)
				bjTime = getCurrentTimeInString(df);
		}
		return bjTime;
	}

	/**
	 * yyyyMMdd HH:mm:ss
	 * @return
	 */
	public static String getCurrentShortTime() {
		return getCurrentTimeInString(yyyyMMdd_HH_mm_ss);
	}

	/**
	 * yyyyMMdd
	 * @return
	 */
	public static String getCurrentDay() {
		return getCurrentTimeInString(yyyMMdd);
	}

	/**
	 * yyyy-MM-dd
	 * @return
	 */
	public static String getCurrentFullDay() {
		return getCurrentTimeInString(yyyy_MM_dd);
	}

	/**
	 * yyyy-MM-dd HH:mm:sss
	 * @return
	 */
	public static String getCurrentFullTime() {
		return getCurrentTimeInString(yyyy_MM_dd_HH_mm_sss);
	}

	/**
	 * 获取 当前时间，beforeDays前的日期字符串 dateFormat ： 日期格式 beforeDays： 天数
	 *
	 * @param dateFormat
	 * @param beforeDays
	 */
	public static String getCurrentDayBefore(String dateFormat, int beforeDays) {
		String rs = dateFormat;
		try {
			SimpleDateFormat FORMAT_DAY = new SimpleDateFormat(dateFormat);
			Date date = new Date(System.currentTimeMillis());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, -beforeDays);
			date = calendar.getTime();
			rs = FORMAT_DAY.format(date);
		} catch (Exception e) {
			// Log.e(TAG, "getLocaltime", e);
		}
		return rs;
	}

	/**
	 * 获取指定日期格式，当前时间 beforeMonths 以前的时间
	 *
	 * @param dateFormat
	 * @param beforeMonths
	 * @return
	 */
	public static String getCurrentMonthBefore(String dateFormat, int beforeMonths) {
		String rs = dateFormat;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date = new Date(System.currentTimeMillis());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, -beforeMonths);
			date = calendar.getTime();
			rs = sdf.format(date);
		} catch (Exception e) {
			// Log.e(TAG, "getCurrentMonthBefore", e);
		}
		return rs;
	}

	/**
	 * 获取指定格式当前年， 指定beforeYears前的年份
	 * @param dateFormat
	 * @return
	 *
	 */
	public static String getCurrentYearBefore(String dateFormat, int beforeYears) {
		String rs = dateFormat;
		try {
			SimpleDateFormat FORMAT_DAY = new SimpleDateFormat(dateFormat);
			Date date = new Date(System.currentTimeMillis());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, -beforeYears);
			date = calendar.getTime();
			rs = FORMAT_DAY.format(date);
		} catch (Exception e) {
			// Log.e(TAG, "getCurrentYearBefore", e);
		}
		return rs;
	}

	/**
	 * 当前
	 * @param dateFormat
	 * @param beforeMinute
	 * @return
	 */
	public static String getCurrentMinuteBefore(String dateFormat, int beforeMinute) {
		String rs = dateFormat;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date = new Date(System.currentTimeMillis());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, -beforeMinute);
			date = calendar.getTime();
			rs = sdf.format(date);
		} catch (Exception e) {
			// Log.e(TAG, "getCurrentMinuteBefore", e);
		}
		return rs;
	}

	/**
	 * 获取当前时间，几分钟以前的时间
	 *
	 * @param beforeMinute
	 * @return
	 */
	public static Date getCurrentMinuteBefore(int beforeMinute) {
		Date date = new Date(System.currentTimeMillis());
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, -beforeMinute);
			date = calendar.getTime();
		} catch (Exception e) {
			// Log.e(TAG, "getCurrentMinuteBefore", e);
		}
		return date;
	}

	/**
	 * 获取当前时间，几分钟以前的时间，返回时分秒
	 *
	 * @param beforeMinute
	 * @return
	 */
	public static String getNowBeforeTime(int beforeMinute) {
		Date date = new Date(System.currentTimeMillis());
		String time = "";
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, -beforeMinute);
			date = calendar.getTime();
			time = yyyy_MM_dd_HH_mm_ss.format(date);
		} catch (Exception e) {
			// Log.e(TAG, "getCurrentMinuteBefore", e);
		}
		return time.substring(10, time.length());
	}

	/**
	 * 分钟以前
	 *
	 * @param date
	 * @param minutes
	 * @return
	 */
	public static boolean isMinuteAgo(Date date, int minutes) {
		Date currentDate = new Date();
		long time = currentDate.getTime() - date.getTime();
		long b = 60000;
		Long disSec = Long.valueOf(time / b);
		return disSec >= minutes;
	}

	/**
	 * 秒钟以前
	 *
	 * @param date
	 * @param seconds
	 * @return
	 */
	public static boolean isSecondAgo(Date date, int seconds) {
		Date currentDate = new Date();
		long time = currentDate.getTime() - date.getTime();
		Long disSec = Long.valueOf(time / 1000L);
		return disSec >= seconds;
	}

	/**
	 * 秒钟以前时间
	 * @param seconds
	 * @return
	 */
	public static String getSecondAgoTime(int seconds) {
		Date currentDate = new Date();
		long time = currentDate.getTime() - seconds;
		return getTime(time, yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 格式化日期
	 */
	public static Date format2Date(String time, String timeFormat) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

    /**
     * 格式化日期为时间
     */
    public static String formatDate2Time(String dateStr, String dateSDT, String timeSDF) {
        String time = null;
        try {
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat(dateSDT);
            date = sdf.parse(dateStr);

            SimpleDateFormat dest = new SimpleDateFormat(timeSDF);
            time = dest.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 格式化日期为时间
     */
    public static String formatDate2Time00(String dateStr, String dateSDT, String timeSDF) {
        String time = null;
        try {
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat(dateSDT);
            date = sdf.parse(dateStr);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            calendar.set(Calendar.MILLISECOND, 00);
            date = calendar.getTime();

            SimpleDateFormat dest = new SimpleDateFormat(timeSDF);
            time = dest.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
    /**
     * 格式化日期为时间
     */
    public static String formatDate2Time59(String dateStr, String dateSDT, String timeSDF) {
        String time = null;
        try {
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat(dateSDT);
            date = sdf.parse(dateStr);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            date = calendar.getTime();

            SimpleDateFormat dest = new SimpleDateFormat(timeSDF);
            time = dest.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
	 * 格式化日期
	 */
	public static Date format2Date(String time, SimpleDateFormat sdf) {
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 格式化日期
	 *
	 */
	public static String formatSDF(String srcTimeSDF, String destSDF) {
		String r = destSDF;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(destSDF);
			Date date = sdf.parse(srcTimeSDF);
			r = yyyy_MM_dd_HH_mm_ss.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 格式化yyyy-MM-dd日期
	 *
	 */
	public static String formatDate3(String srcSDF, String destSDF, String dateStr) {
		String r = destSDF;
		try {
		    if(srcSDF==null || destSDF==null || dateStr==null || srcSDF.length()!=dateStr.length()) {
		        return dateStr;
            }
			SimpleDateFormat src = new SimpleDateFormat(srcSDF);
			SimpleDateFormat dest = new SimpleDateFormat(destSDF);
			r = dest.format(src.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 自动格式化日期
	 */
	public static String formatAuto(String day, String destSDF) {
		String r = day;
		try {
			day = day.replace(".", "-");
			day = day.replace("/", "-");
            SimpleDateFormat sdf = new SimpleDateFormat(destSDF);
            Date date = yyyy_MM_dd.parse(day);
			return sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 当前
	 *
	 * @param dateFormat
	 * @param beforeMinute
	 *
	 * @return
	 */
	public static String getBefore(String dateFormat, int beforeMonth, int beforeDay, int beforeHour,
			int beforeMinute) {
		String rs = dateFormat;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date = new Date(System.currentTimeMillis());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, -beforeMonth);
			calendar.add(Calendar.DAY_OF_MONTH, -beforeDay);
			calendar.add(Calendar.HOUR_OF_DAY, -beforeHour);
			calendar.add(Calendar.MINUTE, -beforeMinute);
			date = calendar.getTime();
			rs = sdf.format(date);
		} catch (Exception e) {
			// Log.e(TAG, "getCurrentMinuteBefore", e);
		}
		return rs;
	}

	/**
	 * 设定日期的前几日
	 * @param dateFormat
	 * @return
	 */
	public static String getDayBefore(String dateFormat, String day, int beforeDay) {
		String rs = dateFormat;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date = sdf.parse(day);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, -beforeDay);
			date = calendar.getTime();
			rs = sdf.format(date);
		} catch (Exception e) {
			// Log.e(TAG, "getCurrentMinuteBefore", e);
		}
		return rs;
	}

	public static String getTime(String dateFormat, int year, int month, int date, int hourOfDay, int minute) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date, hourOfDay, minute);
		Date d = calendar.getTime();
		return sdf.format(d);
	}

	/**
	 * 获取小时数
	 *
	 * @return
	 */
	public static int getHour() {
		Date date = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取小时数
	 *
	 * @return
	 */
	public static Calendar getCalendar() {
		Date date = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static String judgeFormat(String dateStr, String formatYYYY) {
		HashMap<String, String> dateRegFormat = new HashMap<String, String>();
		dateRegFormat.put("^\\d{8}$", "yyyyMMdd");// 20140312
		dateRegFormat.put("^\\\\d{4}\\\\D+.\\\\d{1,2}\\\\D+.\\\\d{1,2}$", "yyyy.MM.dd");// 20140312
		// dateRegFormat.put("^\\d{4}\\D+-\\d{1,2}\\D+-\\d{1,2}$",
		// "yyyy-MM-dd");//14.10.18(年.月.日)
		// dateRegFormat.put("^\\d{4}\\D+/\\d{1,2}\\D+/\\d{1,2}$",
		// "yyyy/MM/dd");//14.10.18(年.月.日)
		// dateRegFormat.put("^\\d{4}\\D+.\\d{1,2}\\D+.\\d{1,2}$",
		// "yyyy.MM.dd");//14.10.18(年.月.日)
		//
		// dateRegFormat.put("^\\d{4}$", "yyyy");//2014
		// dateRegFormat.put("^\\d{14}$", "yyyyMMddHHmmss");//20140312120534
		// dateRegFormat.put("^\\d{12}$", "yyyyMMddHHmm");//201403121205
		// dateRegFormat.put("^\\d{10}$", "yyyyMMddHH");//2014031212
		// dateRegFormat.put("^\\d{6}$", "yyyyMM");//201403
		// dateRegFormat.put("^\\d{2}\\s*:\\s*\\d{2}\\s*:\\s*\\d{2}$",
		// "yyyy-MM-dd-HH-mm-ss");//13:05:34 拼接当前日期
		// dateRegFormat.put("^\\d{2}\\s*:\\s*\\d{2}$", "yyyy-MM-dd-HH-mm");//13:05
		// 拼接当前日期
		//
		//// dateRegFormat.put("^\\d{2}\\D+\\d{0,1}\\D+\\d{0,1}$",
		// "yy-MM-dd");//14.1.18(年.月.日)
		// dateRegFormat.put("^\\d{1,2}\\D+\\d{1,2}$", "yyyy-dd-MM");//30.12(日.月) 拼接当前年份
		// dateRegFormat.put("^\\d{1,2}\\D+\\d{1,2}\\D+\\d{4}$",
		// "dd-MM-yyyy");//12.21.2013(日.月.年
		// dateRegFormat.put("^\\d{4}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}$",
		// "yyyy-MM-dd-HH-mm");//2014-03-12 12:05
		// dateRegFormat.put("^\\d{4}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}$",
		// "yyyy-MM-dd-HH");//2014-03-12 12
		// dateRegFormat.put("^\\d{4}\\D+\\d{2}\\D+\\d{2}$", "yyyy-MM-dd");//2014-03-12
		// dateRegFormat.put("^\\d{4}\\D+\\d{2}$", "yyyy-MM");//2014-03
		// dateRegFormat.put("^\\d{4}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D*$",
		// "yyyy-MM-dd-HH-mm-ss");//2014年3月12日 13时5分34秒，2014-03-12 12:05:34，2014/3/12
		// 12:5:34
		for (String key : dateRegFormat.keySet()) {
			if (Pattern.compile(key).matcher(dateStr).matches()) {
				return dateRegFormat.get(key);
			}
		}
		return null;
	}

	/***
	 * 获取当前日期 yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDate() {
		return getCurrentTimeInString(yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 获取星期几, 星期天为1，星期六为7
	 *
	 * @return
	 */
	public static Integer getDayOfWeek() {
		Integer weekDay = 1;
		Calendar now = Calendar.getInstance();
		// 设置，星期第一天是星期几：
		now.setFirstDayOfWeek(Calendar.SUNDAY); // Calendar.MONDAY
		// 获取周几
		weekDay = now.get(Calendar.DAY_OF_WEEK);
		// //一周第一天是否为星期天
		// boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
		// 若一周第一天为星期天，则-1
		// if(!isFirstSunday){
		// weekDay = weekDay - 1;
		// if(weekDay == 0){
		// weekDay = 7;
		// }
		// }
		return weekDay;
	}

	/**
	 * nowDate:yyyy-MM-dd 获取星期几
	 */
	public static String getWeek(String nowDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(nowDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		// nowDate是星期日week_index就返回0
		if (week_index == 0) {
			week_index = 7;
		}
		return String.valueOf(week_index);
	}

	/**
	 * 制定分钟之后或之前的 time:yyyy-MM-dd HH:mm:ss
	 */
	public static String addMinute(String time, int minute, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MINUTE, minute);
		return sdf.format(c.getTime());
	}

	/**
	 * 制定分钟之后或之前的 time:yyyy-MM-dd HH:mm:ss
	 */
	public static String addMinute(String time, int minute) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MINUTE, minute);
		return sdf.format(c.getTime());
	}

	/**
	 * 两个时间相减 startTime:yyyy-MM-dd HH:mm:ss endTime:yyyy-MM-dd HH:mm:ss 返回值是：分钟
	 */
	public static String subtractTime(String startTime, String endTime) {
		SimpleDateFormat sdfAll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date startDate = sdfAll.parse(startTime);
			Date endDate = sdfAll.parse(endTime);
			System.out.println("====" + (endDate.getTime() - startDate.getTime()));
			Long minute = (endDate.getTime() - startDate.getTime()) / (60 * 1000);
			return String.valueOf(minute);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description: 两个时间相差多少分钟，不足一分钟按一分钟算
	 * @author yuanyouxiang
	 * @date 2018年7月31日 上午11:04:45
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static Integer timeDiffCeilMin(String startTime, String endTime) {
		SimpleDateFormat sdfAll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date startDate = sdfAll.parse(startTime);
			Date endDate = sdfAll.parse(endTime);
			Long sec = (endDate.getTime() - startDate.getTime()) / 1000;
			Integer min = (int) (sec / 60);
			if (sec % 60 > 0) {
				min++;
			} else if (sec % 60 < 0) {
				min--;
			}
			return min;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * startTime:yyyy-MM-dd endTime:yyyy-MM-dd 获得两起止时间之间所有日期
	 */
	public static List<String> getBetweenDates(String startTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null;
		Date end = null;
		try {
			start = sdf.parse(startTime);
			end = sdf.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<String> result = new ArrayList<>();
		if (startTime.equals(endTime)) {
			result.add(startTime);
			return result;
		}
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		result.add(startTime);
		while (tempStart.before(tempEnd)) {
			result.add(sdf.format(tempStart.getTime()));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(endTime);
		return result;
	}

	/**
	 * 获得两个时间之间的天数(yyyy-MM-dd)
	 */
	public static String getDays(String startTime, String endTime) {
		SimpleDateFormat sdfYTD = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = sdfYTD.parse(startTime);
			Date endDate = sdfYTD.parse(endTime);
			// 获取相减后天数
			long day = ((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000)) + 1;
			return String.valueOf(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得月份(yyyy-MM)
	 */
	public static String getCurrentMonth() {
		SimpleDateFormat sdfYTD = new SimpleDateFormat("yyyy-MM");
		return sdfYTD.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 获取指定月的第一天
	 *
	 * @param datadate
	 * @return
	 */
	public static String getFirstDay(String datadate) {
		Calendar calendar = new GregorianCalendar();
		Date date;
		try {
			date = yyyy_MM.parse(datadate);
			// log.debug("按月格式化：" + date);
			// log.debug("按天格式化：" + sdf.format(date));
			calendar.setTime(date);
			// log.debug("获取设置Calendar时间：" + calendar.getTime());
			calendar.add(calendar.DATE, 0);// 因为格式化时默认了DATE为本月第一天所以此处为0
			// log.debug("获取指定月的第一天：" + sdf.format(calendar.getTime()));
			return yyyy_MM_dd.format(calendar.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取指定月的最后一天
	 *
	 * @param datadate
	 * @return
	 */
	public static String getLastDay(String datadate) {
		Calendar calendar = new GregorianCalendar();
		Date date;
		try {
			date = yyyy_MM.parse(datadate);
			// log.debug("按月格式化：" + date);
			// log.debug("按天格式化：" + sdf.format(date));
			calendar.setTime(date);
			// log.debug("获取设置Calendar时间：" + calendar.getTime());
			calendar.roll(calendar.DATE, -1);// api解释roll()：向指定日历字段添加指定（有符号的）时间量，不更改更大的字段
			// log.debug("获取指定月的最后一天：" + sdf.format(calendar.getTime()));
			return yyyy_MM_dd.format(calendar.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最小天数
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstDayOfMonth = sdf.format(cal.getTime());
		return firstDayOfMonth;
	}

	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		return lastDayOfMonth;
	}

	public static String addDate(String time, long day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = sdf.parse(time);
			long time2 = parse.getTime() + day * 24 * 60 * 60 * 1000;
			return sdf.format(new Date(time2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String addDateTime(String time, long day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date parse = sdf.parse(time);
			long time2 = parse.getTime() + day * 24 * 60 * 60 * 1000;
			return sdf.format(new Date(time2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加减指定月份
	 */
	public static String monthAddFrist(String date, int month) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Calendar ct = Calendar.getInstance();
			ct.setTime(df.parse(date));
			ct.add(Calendar.MONTH, month);
			return df.format(ct.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 带.格式时间转换
	 *
	 * @param time
	 * @return
	 */
	public static String judgeFormat(String time) {
		time = time.replace(".", "-");
		try {
			return yyyy_MM_dd.format(yyyy_MM_dd.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDistanceHour(Date endDate, Date nowDate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// // 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒//输出结果
		long sec = diff % nd % nh % nm / ns;
		return day + "天" + hour + "小时" + min + "分钟";
	}

	/**
	 * 计算差多少分钟
	 *
	 * @param dataFM
	 * @param endDate
	 * @param nowDate
	 * @return
	 * @throws ParseException
	 */
	public static long getDistanceMin(String dataFM, String endDate, String nowDate) throws ParseException {
		long nm = 1000 * 60;
		SimpleDateFormat sdf = new SimpleDateFormat(dataFM);
		// 获得两个时间的毫秒时间差异
		long diff = sdf.parse(endDate).getTime() - sdf.parse(nowDate).getTime();
		// 计算差多少分钟
		long min = diff / nm;
		return min;
	}
	/**
	 * 时间比较
	 * @param date
	 * @param currentDate
	 * @return
	 */
	public static boolean isBefore(Date date, Date currentDate) {
		long time = currentDate.getTime() - date.getTime();
		return time < 0;
	}

	/**
	 * 时间比较
	 * @param date
	 * @param currentDate
	 * @return
	 */
	public static boolean isBefore(String dataFM, String date, String currentDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dataFM);
		long time = sdf.parse(currentDate).getTime() - sdf.parse(date).getTime();
		return time >= 0;
	}

	/**
	 * 时间比较
	 * @param date
	 * @param currentDate
	 * @return
	 */
	public static boolean isAfter(String dataFM, String date, String currentDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dataFM);
		long time = sdf.parse(currentDate).getTime() - sdf.parse(date).getTime();
		return time <= 0;
	}

	/**
	 * 获取两个时间段的交叉时长(分钟数)
	 *
	 * @param Period
	 * @param OutTime
	 * @return
	 * @throws ParseException
	 */
	public static Long arrosMinutes(String FM, String[] Period, String[] OutTime) throws ParseException {
		Long mins = 0L;
		if (TimeUtils.isBefore(FM, OutTime[0], Period[0]) && TimeUtils.isAfter(FM, OutTime[1], Period[1])) { // 时间Period范围完全在时间OutTime范围内
			mins = TimeUtils.getDistanceMin(FM, Period[1], Period[0]);
		} else if (TimeUtils.isBefore(FM, Period[0], OutTime[0]) && TimeUtils.isAfter(FM, Period[1], OutTime[1])) {// 时间Period完全包含了时间OutTime的起始范围
			mins = TimeUtils.getDistanceMin(FM, OutTime[1], OutTime[0]);
		} else if (TimeUtils.isBefore(FM, Period[0], OutTime[0]) && !TimeUtils.isAfter(FM, Period[1], OutTime[1])) {// 时间Period范围相交与时间OutTime范围左边
			mins = TimeUtils.getDistanceMin(FM, Period[1], OutTime[0]);
		} else if (TimeUtils.isBefore(FM, OutTime[0], Period[0]) && TimeUtils.isAfter(FM, Period[1], OutTime[1])) {// 时间Period范围相交与时间OutTime范围右边
			mins = TimeUtils.getDistanceMin(FM, OutTime[1], Period[0]);
		}
		return mins;
	}

	/**
	 * 判断两组时间是否存在交叉
	 *
	 * true: 有交叉，false无交叉
	 *
	 * @return
	 */
	public static boolean hasAcross(String[] date0, String[] date1) {
		return date1[0].compareTo(date0[1]) < 0 && date1[1].compareTo(date0[0]) > 0; // 返回true
	}

	public static String formatFullDateToNormal(String date) {
		String ret = null;
		try {
			ret = yyyy_MM_dd_HH_mm_ss.format(MM_dd_yyy_HH_mm_sss.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ret;
	}


}
