package com.fmcq.util.datautil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;


/**
 * 日期操作
 * 
 * @author udbfkuk
 */
@SuppressWarnings("boxing")
public class DateUtil2 {
	// ////////////////////////////////////////////////////////////////
	// 日期格式
	public static final String TIME_FORMAT = "HH:mm:ss";

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String START_DATE_FORMAT = "yyyy-MM-dd 00:00:00";

	public static final String END_DATE_FORMAT = "yyyy-MM-dd 23:59:59";

	public static final String FULL_OTHER_FORMAT = "yyyyMMddHHmmss";
	// ////////////////////////////////////////////////////////////////

	public final static String YYYY_MM_DD_HH_MM_SS_SS = "yyyy-MM-dd HH:mm:ss:SS";

	public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public final static String YYYY_MM_DD = "yyyy-MM-dd";

	public final static String YYYYMM = "yyyyMM";

	public final static String YYMM = "yyMM";

	public final static String YYYY = "yyyy";

	public final static String YEAR = "year";

	public final static String MONTH = "month";

	public final static String DAY = "day";

	public final static String HOUR = "hour";

	public final static String MINUTE = "minute";

	public final static String SECOND = "second";

	private DateUtil2() {
	}

	/**
	 * 按指定格式返回系统当前日期 format 格式
	 * @param format null时返回系统时间，非null则按指定格式返回
	 * @return java.util.Date
	 */
	public final static java.util.Date getNow(String format) {
		if(format != null && !format.equals("")){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
			try {
				return sdf.parse(getNowTime(format));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return new java.util.Date();
	}

	/**
	 * 按指定格式返回系统当前日期 format 格式
	 * 
	 * @return String
	 */
	public final static String getNowTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new GregorianCalendar().getTime());

	}

	/**
	 * 按指定格式将String转换成Date
	 * 
	 * @param date
	 *            要转换的日期字符串

	 * @param pattern
	 *            格式
	 * @return Date
	 * @throws ParseException
	 */
	public final static java.util.Date stringTodate(String date, String pattern)
			throws ParseException {
		if (date == null || pattern == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(date);
	}

	/**
	 * 计算两个日期间相差的天数
	 * 
	 * @param startDate
	 *            开始日期

	 * @param endDate
	 *            结束日期
	 * @return Long
	 */

	public final static Long calculateDate(Date startDate, Date endDate) {
		if (startDate.compareTo(endDate) > 0) {
			return Long.valueOf(0);
		}
		Long temp = endDate.getTime() - startDate.getTime();
		return (temp / 1000 / 60 / 60 / 24);
	}

	/**
	 * 按指定格式将Date转换成String
	 * 
	 * @param date
	 *            要转换的date
	 * @param pattern
	 *            格式
	 * @return String
	 */
	public final static String convDateToString(Date date, String pattern) {
		if (date == null || pattern == null)
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 该方法与上个方法相同 根据日期得到年，月，日

	 * 
	 * @param date
	 * @param part
	 *            yyyy,MM,dd
	 * @return String
	 */
	public final static String getPartDate(Date date, String part) {
		if (date == null || part == null)
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(part);
		return sdf.format(date);
	}

	/**
	 * Calendar转化为Date
	 */
	public final static Date CalendarToDate(Calendar cal) {
		Date date = cal.getTime();
		return date;
	}

	/**
	 * Date转化为Calendar
	 */
	public final static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 取出年月日时分秒,不足两位的前面补0
	 */
	public final static Map<String, String> getYMDHMS(Calendar cal) {
		Map<String, String> map = new HashMap<String, String>();
		String year, month, day, hour, minute, second;
		year = String.valueOf(cal.get(Calendar.YEAR));
		month = getAddZero(cal.get(Calendar.MONTH));
		day = getAddZero(cal.get(Calendar.DATE));
		hour = getAddZero(cal.get(Calendar.HOUR));
		minute = getAddZero(cal.get(Calendar.MINUTE));
		second = getAddZero(cal.get(Calendar.SECOND));
		map.put(YEAR, year);
		map.put(MONTH, month);
		map.put(DAY, day);
		map.put(HOUR, hour);
		map.put(MINUTE, minute);
		map.put(SECOND, second);
		return map;
	}

	/**
	 * 将月，日，时，分，秒不足两位的前面补零

	 * 
	 * @param month
	 * 
	 * @return String
	 */
	public final static String getAddZero(Integer param) {
		if (param == null || param.compareTo(0) == 0)
			return "";
		if (param > 0 && param < 10) {
			return "0" + String.valueOf(param);
		}
		return String.valueOf(param);
	}

	/**
	 * 获取某个日期所在当月的天数
	 */
	public final static int dateInMonthWithDayCount(Calendar a) {
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天

		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天

		int maxDate = a.get(Calendar.DATE); // a就是最后一天的日期
		return maxDate;
	}

	/**
	 * 获取某个日期所在当月的最后一天的日期
	 */
	public final static Date dateIsLastDate(Calendar a) {
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天

		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天

		return a.getTime();
	}

	/**
	 * 从1970年到现在的毫秒数
	 */
	public final static long getMilliseconds() {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		return d.getTime();
	}

	/**
	 * 时间加减运算<br>
	 * java中对日期的加减操作<br>
	 * gc.add(1,-1)表示年份减一.<br>
	 * gc.add(2,-1)表示月份减一.<br>
	 * gc.add(3.-1)表示周减一.<br>
	 * gc.add(5,-1)表示天减一.<br>
	 * gc.add(5,+1)表示天加一. 以此类推应该可以精确的毫秒吧.没有再试.大家可以试试.<br>
	 * GregorianCalendar类的add(int field,int amount)方法表示年月日加减.<br>
	 * field参数表示年,月.日等.<br>
	 * amount参数表示要加减的数量.<br>
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @param category
	 *            运算种类，例如：天之间运算，月之间运算

	 * @param number
	 *            正数代表加、负数代表减
	 * @return String
	 */
	public final static String calcDate(Date date, String pattern,
			int category, int number) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(category, number);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
				.get(Calendar.DATE));
		return convDateToString(gc.getTime(), pattern);
	}

	/**
	 * 根据日期计算这个星期的星期一是多少，并且星期一以00:00:00开头

	 * 
	 * @param queryDate
	 * @return String[]
	 * @throws ParseException
	 */
	public static String calcMonday(String queryDate) throws ParseException {
		String date;
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		gc.setTime(df.parse(queryDate));
		gc.add(5, -1);
		while (gc.get(7) != 1) {
			gc.add(5, -1);
		}
		gc.add(5, 1);
		date = df.format(gc.getTime()) + " 00:00:00";
		return date;
	}

	/**
	 * 根据日期计算这个星期的星期日是多少，并且星期日以23:59:59开头

	 * 
	 * @param queryDate
	 * @return String[]
	 * @throws ParseException
	 */
	public static String calcSunday(String queryDate) throws ParseException {
		String date;
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		gc.setTime(df.parse(queryDate));
		gc.add(5, -1);
		while (gc.get(7) != 7) {
			gc.add(5, 1);
		}
		gc.add(5, 1);
		date = df.format(gc.getTime()) + " 23:59:59";
		return date;
	}

	/**
	 * 根据日期计算这个月的第一天是几号
	 * 
	 * @param queryDate
	 * @return String
	 * @throws ParseException
	 */
	public static Date calcBeginMonth(String queryDate) throws ParseException {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		gc.setTime(df.parse(queryDate));
		int i = gc.get(Calendar.MONTH);
		// 11表示第12月

		while (gc.get(Calendar.MONTH) != (i == 0 ? 11 : i - 1)) {
			gc.add(5, -1);
		}
		gc.add(5, 1);
		return gc.getTime();
	}

	/**
	 * 根据日期计算这个月的最后一天是几号
	 * 
	 * @param queryDate
	 * @return String
	 * @throws ParseException
	 */
	public static Date calcEndMonth(String queryDate) throws ParseException {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		gc.setTime(df.parse(queryDate));
		int i = gc.get(Calendar.MONTH);
		// 11表示第12月

		while (gc.get(Calendar.MONTH) != (i == 11 ? 0 : i + 1)) {
			gc.add(5, 1);
		}
		gc.add(5, -1);
		return gc.getTime();
	}

	/**
	 * 求是星期几

	 */
	public static String calcWeek(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("E");
		return formatter.format(date);
	}

	/**
	 * 年月周求日期 date：要计算的日期 格式： 星期三:年-月 第几个星期 星期几 例：2008-11 2 星期三

	 * 2008年11月的第2个星期三的日期

	 * 
	 * @throws ParseException
	 */
	public static String calcYearMonthWeekWithDate(String date)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM F E");
		Date d = formatter.parse(date);
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(d);
	}

	/**
	 * cal 要计算的日期 计算某一天是一年中的第几星期

	 */

	public static int calcDayIsYearWithWeek(Calendar cal) {
		Map<String, String> map = new HashMap<String, String>();
		map = getYMDHMS(cal);
		cal.set(Calendar.YEAR, Integer.parseInt(map.get(YEAR)));
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * cal 要计算的日期 week:第几星期 计算一年中的第几星期是几号
	 */
	public static String calcWeekIsYearWithDay(Calendar cal, int week) {
		Map<String, String> map = new HashMap<String, String>();
		map = getYMDHMS(cal);
		cal.set(Calendar.YEAR, Integer.parseInt(map.get(YEAR)));
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return convDateToString(cal.getTime(), YYYY_MM_DD_HH_MM_SS);
	}


	/**
	 * 提取一个月中的最后一天

	 * 
	 * @param 传进来的日期 Date类型
	 * @return String类型
	 */
	public static String getLastDate(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.MONTH,1);
        gc.add(GregorianCalendar.DATE,-date.getDate());
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        Date dateTemp = gc.getTime();
        String s = df.format(dateTemp);
        return s;
//		Date date = new Date();
//		long date_3_hm = date.getTime() - 3600000 * 34 * day;
//		Date date_3_hm_date = new Date(date_3_hm);
//		return date_3_hm_date;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 * 
	 * @return
	 */
	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}



	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 * sj1和sj2:表示时间的字符串，如果sj1大于sj2，返回正数，反之返回0
	 */
	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}

	/**
	 * 得到二个日期间的间隔天数
	 * param: sj1和sj2:表示日期的字符串，如果sj1大于sj2，返回正数，反之返回负数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 * sj1表示日期，jj表示分钟,jj正数表示相加，负数表示相减

	 * return string
	 */
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数

	 * delay正数相加，负数相减

	 * return string
	 */
	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = stringTodate(nowdate, YYYY_MM_DD);
			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24
					* 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 判断是否润年
	 * 
	 * @param ddate 日期 
	 * @return
	 * @throws ParseException 
	 */
	public final static boolean isLeapYear(String ddate) throws ParseException {

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年

		 */
		Date d = stringTodate(ddate, YYYY_MM_DD);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 返回美国时间格式 26 Apr 2006
	 * 
	 * @param str 要转换的日期
	 * @return string
	 */
	public final static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	/**
	 * 获取一个月的最后一天

	 * 
	 * @param dat 日期的字符串
	 * @return string
	 * @throws ParseException 
	 */
	public final static String getEndDateOfMonth(String dat) throws ParseException {// yyyy-MM-dd
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(dat)) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}

	/**
	 * 判断二个时间是否在同一个周
	 * 
	 * @param date1
	 * @param date2
	 * @return true:在同一周，false：不在同一周

	 */
	public final static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周

			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 * 
	 * @return
	 */
	public final static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号

	 * 
	 * @param sdate 要查找的日期
	 * @param num  要查找星期几
	 * @return 日期字符串

	 * @throws ParseException 
	 */
	public final static String getWeek(String sdate, String num) throws ParseException {
		// 再转换为时间
		Date dd = stringTodate(sdate, YYYY_MM_DD);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1")) // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate 日期
	 * @return 
	 * @throws ParseException 
	 */
	public final static String getWeek(String sdate) throws ParseException {
		// 再转换为时间
		Date date = stringTodate(sdate, YYYY_MM_DD);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public final static String getWeekStr(String sdate) throws ParseException {
		String str = "";
		str = getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	/**
	 * 计算两个时间之间的天数

	 * 
	 * @param date1 日期
	 * @param date2 日期
	 * @return 天数，date1大于date2，返回正数，反之返回负数
	 */
	public final static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	 * 此函数返回该日历第一行星期日所在的日期
	 * 
	 * @param sdate 日期
	 * @return
	 * @throws ParseException 
	 */
	public final static String getNowMonth(String sdate) throws ParseException {
		// 取该时间所在月的一号

		sdate = sdate.substring(0, 8) + "01";

		// 得到这个月的1号是星期几

		Date date = stringTodate(sdate, YYYY_MM_DD);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(Calendar.DAY_OF_WEEK);
		String newday = getNextDay(sdate, (1 - u) + "");
		return newday;
	}

	/**
	 * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	 * 
	 * @param k
	 *            表示是取几位随机数，可以自己定

	 */

	public static String getNo(int k) {

		return getNowTime("yyyyMMddHHmmss") + getRandom(k);
	}

	/**
	 * 返回一个随机数
	 * 
	 * @param i
	 * @return
	 */
	public static String getRandom(int i) {
		Random jjj = new Random();
		// int suiJiShu = jjj.nextInt(9);
		if (i == 0)
			return "";
		String jj = "";
		for (int k = 0; k < i; k++) {
			jj = jj + jjj.nextInt(9);
		}
		return jj;
	}

	/**
	 * 校验字符串的日期是不是能正确转换成Date类型的日期

	 * @param args 要校验的日期字符串

	 * return ture:正确的字符串，false:不能转换的字符串
	 */
	public static boolean RightDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		;
		if (date == null)
			return false;
		if (date.length() > 10) {
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		try {
			sdf.parse(date);
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
	
	/**
	 * 返回当前日期时间字符串<br>
	 * 默认格式:yyyy-mm-dd hh:mm:ss
	 * 
	 * @return String 返回当前字符串型日期时间
	 */
	public static String getCurrentTime() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}

	/**
	 * 返回自定义格式的当前日期时间字符串
	 * 
	 * @param format
	 *            格式规则
	 * @return String 返回当前字符串型日期时间
	 */
	public static String getCurrentTime(String format) {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat(format);
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}
	
	/**
	 * 判断当前时间是否在起止时间范围内 
	 * @param beginTime
	 * @param endTime
	 * @return true是，false否
	 * @throws ParseException 
	 * @author wind 2011-08-15
	 */
	public static boolean isBetweenDate(String beginTime,String endTime) throws ParseException{
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin=f.parse(beginTime);
		Date end=f.parse(endTime);
		Date now=new Date();	
		if(now.before(begin) || now.after(end)){
			return false;
		}
		return true;	
	}
	
	/**
	 * 判断时间是否在起止时间范围内 采用转换long比较，避免Date和Timestamp精度差异导致无法比较
	 * @param beginTime
	 * @param endTime
	 * @return true是，false否
	 * @throws ParseException 
	 * @author wind 2012-5-29
	 */
	public static boolean isBetweenDate(Date judgeTime,Date beginTime,Date endTime) {
		if(judgeTime.getTime()<beginTime.getTime() || judgeTime.getTime()>(endTime.getTime())){
			return false;
		}
		return true;		
	}
	
	/**
	 * 日期增加
	 * @param d 起始日期
	 * @param type 增加类型，月、年、日Calendar.DATE等

	 * @param num 添加数量
	 * @return
	 */
	public static Date dateAdd(Date d,int type,int num){
		Calendar cal=Calendar.getInstance(); 
		cal.setTime(d);
		cal.add(type, num);
		return cal.getTime();
	}
	/**
	 * 得到�??个时间延后或前移几天的时�??,nowdate为时�??,delay为前移或后延的天�?? delay正数相加，负数相�?? return string
	 */
	public static String getNextDay(String nowdate, int delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					DATE_FORMAT);
			String mdate = "";
			Date d = string2Date(nowdate, DATE_FORMAT);
			long myTime = (d.getTime() / 1000) + delay * 24 * 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 时间前推或后推分�??,其中JJ表示分钟. sj1表示日期，jj表示分钟,jj正数表示相加，负数表示相�?? return string
	 */
	public static Date getPreTime(String sj1, String jj, String fmt) {
		SimpleDateFormat format = new SimpleDateFormat(fmt);
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			return date1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// date转换成string
	public static String date2String(Date date, String _format) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(_format);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	public static String date2String(Date date) {
		return date2String(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date string2Date(String time) {
		return string2Date(time, FULL_FORMAT);
	}

	// string转换成date
	public static Date string2Date(String time, String format_type) {
		String fmt = format_type;
		if (null == fmt) {
			fmt = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(fmt);
		try {
			return format.parse(time);
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * 取得两个时间点间的时间
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return HH:mm:ss
	 */
	public static String getTimeLength(Date beginTime, Date endTime) {
		StringBuilder timeLength = new StringBuilder();
		long length = 0;
		if (endTime != null) {
			length = endTime.getTime() - beginTime.getTime();
			if (length < 0) {
				length = 0 - length;// 变为正数
				timeLength.append("-");
			}
			long hour = length / (60 * 60 * 1000);
			long minute = length % (60 * 60 * 1000) / (60 * 1000);
			long second = length % (60 * 1000) / 1000;
			timeLength.append(hour).append(":").append(minute).append(":")
					.append(second);
		}
		return timeLength.toString();
	}
	
	/**
	 * 获取两个日期相差的毫秒数
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static long getTimeDiffMillis(Date endTime,Date beginTime){
		return endTime.getTime()-beginTime.getTime();
	}

	/**
	 * 获取两个日期相差的秒数
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static long getTimeDiffSecs(Date endTime,Date beginTime){
		return (endTime.getTime()-beginTime.getTime())/1000;
	}
	
	// 获取系统当前日期
	public static String getSysDate(String fmt) {
		Calendar cal = Calendar.getInstance();
		return date2String(cal.getTime(), fmt);
	}
	
	// 处理日期字段
	public static String getDateStr() {
		Calendar cal = Calendar.getInstance();
		return date2String(cal.getTime(), "yyyy-MM-dd");
	}
	
	// 优化
	public static boolean getOpt(String sdata) {
		boolean flag=false;
		String m="";
		String d="";
		String date[]=new String[3];
		date=getDateStr().split("-");
		if(hasLength(sdata)){
			m=sdata.substring(0, 2);
			d=sdata.substring(2, sdata.length());
		}
		if(m.equals(date[1]) && d.equals(date[2])){
			flag=true;
		}
		return flag;
	}
	public static boolean hasLength(String str) {
		return hasLength(str, 1);
	}

	// 判断数组是否为空
	public static boolean hasLength(String str, int length) {
		if (str == null || str.equals("")) {
			return false;
		}
		return str.length() >= length;
	}
}
