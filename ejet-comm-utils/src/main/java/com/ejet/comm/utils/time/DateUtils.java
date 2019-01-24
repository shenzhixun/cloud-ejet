package com.ejet.comm.utils.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ejet.comm.utils.StringUtils;

/***
 * 日期操作 工具
 *
 * @author ShenYijie
 *
 */
@SuppressWarnings("unchecked")
public class DateUtils {
	public static final String HH_mm_ss = "HH:mm:ss";
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String yy_MM_dd_HH_mm_ss = "yy-MM-dd HH:mm:ss";

	/**
	 * 获取 当天零点时间
	 *
	 * @return
	 */
	public static long getZeroTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (cal.getTimeInMillis());
	}

	/**
	 * 获得 几天后的时间
	 */
	public static Date getAfterDate(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, amount);
		return cal.getTime();

	}
	/**
	 * 获取指定时间后的小时、分钟时间
	 *
	 * @param date
	 * @param hour
	 * @param min
	 * @return
	 */
	public static Date getAfterDate(Date date, int hour, int min) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, hour);
		cal.add(Calendar.MINUTE, min);
		return cal.getTime();

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
	 * 判断 2个日期 相差的时间 默认格式"yyyy-MM-dd"
	 *
	 * @param startTime
	 * @param endTime
	 * @return 返回 一个 数组 每个 元素 依次 表示 相差的天数 小时 分钟 秒
	 */
	public static long[] dateDiff(String startTime, String endTime) {
		return dateDiff(startTime, endTime, yyyy_MM_dd);
	}

	/**
	 * 判断 2个日期 相差的时间
	 *
	 * @param startTime
	 * @param endTime
	 * @param format
	 *            日期的格式 比如 yyyy-MM-dd HH:mm:ss date[0] = day; date[1] = hour;
	 *            date[2] = min; date[3] = sec;
	 *
	 * @return 返回 一个 数组 每个 元素 依次 表示 相差的天数 小时 分钟 秒
	 */
	public static long[] dateDiff(String startTime, String endTime, String format) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数
		long diff;
		long[] date = new long[4];
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			long day = diff / nd;// 计算差多少天
			long hour = diff % nd / nh;// 计算差多少小时
			long min = diff % nd % nh / nm;// 计算差多少分钟
			long sec = diff % nd % nh % nm / ns;// 计算差多少秒
			date[0] = day;
			date[1] = hour;
			date[2] = min;
			date[3] = sec;

		} catch (ParseException e) {
			//e.printStackTrace();
		}
		return date;
	}

	/**
	 * 功能描述：格式化日期
	 *
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {

		}
		return date;
	}

	/**
	 * 功能描述：格式化日期
	 *
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, yyyy_MM_dd);
	}

	/**
	 * 功能描述：格式化输出日期
	 *
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				DateFormat dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {

		}
		return result;
	}

	/**
	 * 功能描述：
	 *
	 * @param date
	 *            Date 日期
	 * @return
	 */
	public static String format(Date date) {
		return format(date, yyyy_MM_dd);
	}

	/**
	 * 功能描述：返回年份
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月份
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日份
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小时
	 *
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分钟
	 *
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫秒
	 *
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * 功能描述：返回字符型日期
	 *
	 * @param date
	 *            日期
	 * @return 返回字符型日期 yyyy/MM/dd 格式
	 */
	public static String getDate(Date date) {
		return format(date, yyyy_MM_dd);
	}

	/**
	 * 功能描述：返回字符型时间
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回字符型时间 HH:mm:ss 格式
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 功能描述：返回字符型日期时间
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy/MM/dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 功能描述：日期相加
	 *
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * 功能描述：日期相减
	 *
	 * 返回的 是long 的毫秒
	 *
	 * @param date
	 *            Date 日期
	 * @param date1
	 *            Date 日期
	 * @return 返回相减后的日期
	 */
	public static long diffDate(Date date, Date date1) {
		return ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * 功能描述：取得指定月份的第一天
	 *
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		Date date = parseDate(strdate);
		return format(addDate(date, 0), "yyyy-MM") + "-01";
	}

	/**
	 * 功能描述：取得指定月份的最后一天
	 *
	 * @param strdate
	 *            String 字符型日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String getMonthEnd(String strdate) {
		Date date = parseDate(getMonthBegin(strdate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 功能描述：常用的格式化日期
	 *
	 * @param date
	 *            Date 日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, yyyy_MM_dd);
	}

	/**
	 * 功能描述：以指定的格式来格式化日期
	 *
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return String 日期字符串
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				//ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 得到当前日期是星期几。
	 *
	 * @return 当为周日时，返回0，当为周一至周六时，则返回对应的1-6。
	 */
	public static final int getCurrentDayOfWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 等到两个日期之间的间隔
	 *
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public int getDateSpace(String date1, String date2) throws ParseException {
		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		calst.setTime(parseDate("yyyyMMdd", date1));
		caled.setTime(parseDate("yyyyMMdd", date2));
		// 设置时间为0时
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
		return days;
	}
	/**
	 * 获得两个时间间隔天数
	 *
	 * @param early
	 * @param late
	 * @return
	 */
	public static final int daysBetween(Date early, Date late) {
		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		calst.setTime(early);
		caled.setTime(late);
		// 设置时间为0时
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;

		return days;
	}

	/**
	 * 获得指定日期距离当前日期的时间
	 *
	 * @param early
	 * @return
	 */
	public static int getDaysDistance(String early, String dateFormatter) {
		int days = 0;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatter);
			Date earlydate = dateFormat.parse(early);

			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.setTime(earlydate);
			end.setTime(new Date());
			// 设置时间为0时
			start.set(Calendar.HOUR_OF_DAY, 0);
			start.set(Calendar.MINUTE, 0);
			start.set(Calendar.SECOND, 0);
			end.set(Calendar.HOUR_OF_DAY, 0);
			end.set(Calendar.MINUTE, 0);
			end.set(Calendar.SECOND, 0);
			// 得到两个日期相差的天数
			days = ((int) (end.getTime().getTime() / 1000) - (int) (start.getTime().getTime() / 1000)) / 3600 / 24;
		} catch (Exception e) {

		}
		return days;
	}

	/**
	 * 获得起始日期至结束日期之间的所有日期的字符串(包括起始和结束日期)， 日期字符串格式为"yyyyMMdd"
	 *
	 * @param startDate
	 *            格式为"yyyyMMdd"
	 * @param endDate
	 *            格式为"yyyyMMdd" return List<String>
	 * @throws ParseException
	 */
	public static List<String> getAllDays(String startDate, String endDate) throws ParseException {
		long time = 0l;
		long perDayMilSec = 24 * 60 * 60 * 1000;// 一天的毫秒数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		List<String> result = new ArrayList<String>();
		while (startDate.compareTo(endDate) <= 0) {
			result.add(startDate);
			time = sdf.parse(startDate).getTime();
			time += perDayMilSec;
			startDate = sdf.format(new Date(time));
		}
		return result;
	}

	/**
	 * 获取起始日期至结束日期之间的所有月份(包括起始日期和结束日期在内)， 获取的月份格式为"yyyyMM"
	 *
	 * @param startMon
	 *            格式为"yyyyMM"
	 * @param endMon
	 *            格式为"yyyyMM"
	 * @return
	 */
	public static List getAllMonths(String startMon, String endMon) {
		List dateList = new ArrayList();
		if (startMon == null || startMon.length() == 0 || endMon == null || endMon.length() == 0) {
			return dateList;
		}

		try {
			SimpleDateFormat startDF = new SimpleDateFormat("yyyyMM");
			startDF.parse(startMon);
			Calendar startCal = startDF.getCalendar();
			SimpleDateFormat endDF = new SimpleDateFormat("yyyyMM");
			endDF.parse(endMon);
			Calendar endCal = endDF.getCalendar();
			while (startCal.before(endCal)) {
				dateList.add(formatMonth(startCal.getTime(), 1));
				startCal.add(Calendar.MONTH, 1);
			}
			dateList.add(endMon);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dateList;
	}

	/**
	 * 获得指定日期字符串(格式为"yyyyMM")所在月份的总天数
	 *
	 * @param date
	 * @return
	 */
	public static int getDaysNum(String date) {
		date = formatDate_5(date);
		String[] date1 = date.split("-");
		int year = Integer.parseInt(date1[0]);
		int month = Integer.parseInt(date1[1]);
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, year);
		time.set(Calendar.MONTH, month - 1);
		int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);
		return day;
	}

	/**
	 * 获得指定日期的前一天的日期字符串，格式为"yyyyMMdd"
	 *
	 * @param date
	 *            格式为"yyyyMMdd"
	 * @return String
	 */
	public static String getPreviousDate(String date) {
		String str = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			formatter.parse(date);
			Calendar tempCal = formatter.getCalendar();
			tempCal.add(Calendar.DATE, -1);
			str = formatter.format(tempCal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 将"yyyyMM"格式的日期字符串转换为"yyyy-MM"格式
	 *
	 * @param datetime
	 *            String
	 * @return String
	 */
	public static String formatDate_5(String datetime) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
			Date date1 = df.parse(datetime);
			df = new SimpleDateFormat("yyyy-MM");
			datetime = df.format(date1);
		} catch (Exception ex) {
			datetime = "";
		}
		return datetime;
	}

	/**
	 * 将指定的日期转换为指定格式的日期字符串， 根据type决定转换后的格式， type等于1时，格式为"yyyyMM"，
	 * type等于2时，格式为"yyyy-MM"
	 *
	 * @param date
	 * @param type
	 * @return
	 */
	public static String formatMonth(Date date, int type) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat bartDateFormat = null;
		if (type == 1) {
			bartDateFormat = new SimpleDateFormat("yyyyMM");
		}
		if (type == 2) {
			bartDateFormat = new SimpleDateFormat("yyyy-MM");
		}
		String disp = bartDateFormat.format(date);
		return disp;
	}

	/**
	 * 获取字符最大值，也可以用于日期大小比较（格式一致）
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String getMax(String date1, String date2) {
		String rs = date1;
		if (StringUtils.isBlank(date1)) {
			return date2;
		}
		if (StringUtils.isBlank(date2)) {
			return date1;
		}
		rs = date2.compareTo(date1) > 0 ? date2 : date1;
		return rs;
	}
	/**
	 * 获取字符串最小值，也可以用于日期大小比较（格式一致）
	 *
	 * @param date1
	 * @param date2
	 * @return
	 * @throws Exception
	 */
	public static String getMin(String date1, String date2) {
		String rs = date1;
		if (StringUtils.isBlank(date1)) {
			return date2;
		}
		if (StringUtils.isBlank(date2)) {
			return date1;
		}
		rs = date2.compareTo(date1) < 0 ? date2 : date1;
		return rs;
	}

	/**
	 * 判断两组时间是否存在交叉
	 *
	 * true: 有交叉，false无交叉
	 *
	 * @return
	 */
	public static boolean hasAcross(String[] date0, String[] date1) {
		return date1[0].compareTo(date0[1])<0 && date1[1].compareTo(date0[0])>0; // 返回true
	}
	/**
	 * 如果跨月返回1， 时间交叉返回2，不交叉不跨月返回0
	 *
	 * @param list
	 * @param checkInOneMonth 是否检查跨月
	 * @param monthLen			月份长度
	 * @return
	 * @throws Exception
	 */
	public static int checkTimes(List<String[]> list, boolean checkInOneMonth, int monthLen) {
		String minTime = null; // 最小日期
		String maxTime = null; // 最大日期
		for(String[] item : list) {
			minTime = minTime==null ? item[0] : getMin(minTime, item[0]); //获得最大
			maxTime = maxTime==null ? item[1] : getMin(maxTime, item[1]);
			if( checkInOneMonth &&
				(minTime.substring(0, monthLen).compareTo(maxTime.substring(0, monthLen))!=0) ) {
				//比较前6位yyyyMM是否一致。根据日期格式取位数不同
				return 1; //时间存在跨月
			}
			for(String[] item2 : list) { //判断时间是否交叉
				if(hasAcross(item, item2)) {
					return 2; //时间存在交叉
				}
			}
		}
		return 0;
	}


}
