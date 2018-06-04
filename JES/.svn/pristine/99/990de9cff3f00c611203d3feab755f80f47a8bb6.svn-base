package com.fmcq.util.datautil;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil {
	private static final int[] dayArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final String TIME_FORMAT_HHmmss = "HHmmss";
	public static final String DATE_FORMAT_STRING = "MM/dd/yyyy";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	public static final String DATE_TIME_FORMAT_STRING = "MM/dd/yyyy HH:mm";
	private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	public static final String ORA_DATE_FORMAT_STRING = "yyyyMMdd";
	private static final SimpleDateFormat ORA_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	public static final String ORA_DATE_TIME_FORMAT_STRING = "yyyyMMddHHmm";
	private static final SimpleDateFormat ORA_DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");
	public static final String LONG_DATE_TIME_FORMAT_STRING = "yyyyMMddHHmmss";
	public static final String format6chars = "yyyyMM";
	public static final String format8chars = "yyyyMMdd";
	public static final String format12chars = "yyyyMMddHHmm";
	public static final String format14chars = "yyyyMMddHHmmss";
	public static final String format16chars = "yyyy-MM-dd HH:mm";
	public static final String format19chars = "yyyy-MM-dd HH:mm:ss";
	public static final String format23chars = "yyyy-MM-dd HH:mm:ss,SSS";
	public static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

	public static Timestamp parse2Timestamp(String theDate) throws ParseException {
		return new Timestamp(parse(theDate).getTime());
	}

	public static synchronized Calendar getCalendar() {
		return GregorianCalendar.getInstance();
	}

	public static java.util.Date getDateTime() {
		return getCalendar().getTime();
	}

	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(1);
	}

	public static int getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		return 1 + calendar.get(2);
	}

	public static int getCurrentQuarter() {
		Calendar calendar = Calendar.getInstance();
		int monthInt = 1 + calendar.get(2);
		int quarterInt = 1;
		switch (monthInt) {
		case 1:
			quarterInt = 1;
			break;
		case 2:
			quarterInt = 1;
			break;
		case 3:
			quarterInt = 1;
			break;
		case 4:
			quarterInt = 2;
			break;
		case 5:
			quarterInt = 2;
			break;
		case 6:
			quarterInt = 2;
			break;
		case 7:
			quarterInt = 3;
			break;
		case 8:
			quarterInt = 3;
			break;
		case 9:
			quarterInt = 3;
			break;
		case 10:
			quarterInt = 4;
			break;
		case 11:
			quarterInt = 4;
			break;
		case 12:
			quarterInt = 4;
			break;
		default:
			quarterInt = 1;
		}

		return quarterInt;
	}

	public static int getCurrentDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(5);
	}

	public static int getCurrentDayOfYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(6);
	}

	public static int getCurrentWeekOfYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(3);
	}

	public static int getCurrentWeekOfMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(4);
	}

	public static int getCurrentDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(7);
	}

	public static int getCurrentHour() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(11);
	}

	public static int getCurrentMinute() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(12);
	}

	public static int getCurrentSecond() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(13);
	}

	public static int getCurrentMillisecond() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(14);
	}

	public static int getEra() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(0);
	}

	public static String getUSTimeZone() {
		String[] zones = { "Hawaii", "Alaskan", "Pacific", "Mountain", "Central", "Eastern" };

		return zones[(10 + getZoneOffset())];
	}

	public static int getZoneOffset() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(15) / 3600000;
	}

	public static int getDSTOffset() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(16) / 3600000;
	}

	public static int getAMPM() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(9);
	}

	public static synchronized String getDateMilliFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateMilliFormat(cal);
	}

	public static String getDateMilliFormat(Calendar cal) {
		return getDateFormat(cal, "yyyy-MM-dd HH:mm:ss,SSS");
	}

	public static String getDateMilliFormat(java.util.Date date) {
		return getDateFormat(date, "yyyy-MM-dd HH:mm:ss,SSS");
	}

	public static Calendar parseCalendarMilliFormat(String strDate) {
		return parseCalendarFormat(strDate, "yyyy-MM-dd HH:mm:ss,SSS");
	}

	public static java.util.Date parseDateMilliFormat(String strDate) {
		return parseDateFormat(strDate, "yyyy-MM-dd HH:mm:ss,SSS");
	}

	public static String getDateSecondFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateSecondFormat(cal);
	}

	public static String getDateSecondFormat(Calendar cal) {
		return getDateFormat(cal, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateSecondFormat(java.util.Date date) {
		return getDateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static Calendar parseCalendarSecondFormat(String strDate) {
		return parseCalendarFormat(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static java.util.Date parseDateSecondFormat(String strDate) {
		return parseDateFormat(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateMinuteFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateMinuteFormat(cal);
	}

	public static String getDateMinuteFormat(Calendar cal) {
		return getDateFormat(cal, "yyyy-MM-dd HH:mm");
	}

	public static String getDateMinuteFormat(java.util.Date date) {
		return getDateFormat(date, "yyyy-MM-dd HH:mm");
	}

	public static Calendar parseCalendarMinuteFormat(String strDate) {
		return parseCalendarFormat(strDate, "yyyy-MM-dd HH:mm");
	}

	public static java.util.Date parseDateMinuteFormat(String strDate) {
		return parseDateFormat(strDate, "yyyy-MM-dd HH:mm");
	}

	public static String getTimeHHmmssFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateFormat(cal, "HHmmss");
	}

	public static String getDateDayFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateDayFormat(cal);
	}

	public static String getDateFormat(String pattern) {
		Calendar cal = Calendar.getInstance();
		if (StringUtil.isEmpty(pattern)) {
			pattern = "yyyyMMdd";
		}
		return getDateFormat(cal, pattern);
	}

	public static String getDateDayFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(cal, pattern);
	}

	public static String getDateDayFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd";
		return getDateFormat(date, pattern);
	}

	public static Calendar parseCalendarDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseCalendarFormat(strDate, pattern);
	}

	public static java.util.Date parseDateDayFormat(String strDate) {
		String pattern = "yyyy-MM-dd";
		return parseDateFormat(strDate, pattern);
	}

	public static String getDateFileFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateFileFormat(cal);
	}

	public static String getDateFileFormat(Calendar cal) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return getDateFormat(cal, pattern);
	}

	public static String getDateFileFormat(java.util.Date date) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return getDateFormat(date, pattern);
	}

	public static Calendar parseCalendarFileFormat(String strDate) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return parseCalendarFormat(strDate, pattern);
	}

	public static java.util.Date parseDateFileFormat(String strDate) {
		String pattern = "yyyy-MM-dd_HH-mm-ss";
		return parseDateFormat(strDate, pattern);
	}

	public static String getDateW3CFormat() {
		Calendar cal = Calendar.getInstance();
		return getDateW3CFormat(cal);
	}

	public static String getDateW3CFormat(Calendar cal) {
		return getDateFormat(cal, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateW3CFormat(java.util.Date date) {
		return getDateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static Calendar parseCalendarW3CFormat(String strDate) {
		return parseCalendarFormat(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static java.util.Date parseDateW3CFormat(String strDate) {
		return parseDateFormat(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateFormat(Calendar cal) {
		return getDateFormat(cal, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateFormat(java.util.Date date) {
		return getDateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static Calendar parseCalendarFormat(String strDate) {
		return parseCalendarFormat(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static java.util.Date parseDateFormat(String strDate) {
		return parseDateFormat(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateFormat(Calendar cal, String pattern) {
		return getDateFormat(cal.getTime(), pattern);
	}

	public static String getDateFormat(java.util.Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		String str = null;
		sdf.applyPattern(pattern);
		str = sdf.format(date);
		return str;
	}

	public static Calendar parseCalendarFormat(String strDate, String pattern) {
		if (StringUtil.isEmpty(strDate)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		Calendar cal = null;
		sdf.applyPattern(pattern);
		try {
			sdf.parse(strDate);
			cal = sdf.getCalendar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cal;
	}

	public static java.util.Date parseDateFormat(String strDate, String pattern) {
		if (StringUtil.isEmpty(strDate)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		java.util.Date date = null;
		sdf.applyPattern(pattern);
		try {
			date = sdf.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static java.util.Date getAddDays(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(5, days);
		return cal.getTime();
	}

	public static int getLastDayOfMonth(int month) {
		if ((month < 1) || (month > 12)) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear())
				retn = 29;
			else
				retn = dayArray[(month - 1)];
		} else {
			retn = dayArray[(month - 1)];
		}
		return retn;
	}

	public static int getLastDayOfMonth(int year, int month) {
		if ((month < 1) || (month > 12)) {
			return -1;
		}
		int retn = 0;
		if (month == 2) {
			if (isLeapYear(year))
				retn = 29;
			else
				retn = dayArray[(month - 1)];
		} else {
			retn = dayArray[(month - 1)];
		}
		return retn;
	}

	public static boolean isLeapYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(1);
		return isLeapYear(year);
	}

	public static boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;
		if (year % 4 == 0) {
			return year % 100 != 0;
		}

		return false;
	}

	public static boolean isLeapYear(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		int year = gc.get(1);
		return isLeapYear(year);
	}

	public static boolean isLeapYear(Calendar gc) {
		int year = gc.get(1);
		return isLeapYear(year);
	}

	public static java.util.Date getPreviousMonth(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(2, -1);
		return gc.getTime();
	}

	public static Calendar getPreviousMonth(Calendar gc) {
		gc.add(2, -1);
		return gc;
	}

	public static java.util.Date getPreviousWeekDay(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return getPreviousWeekDay(gc);
	}

	public static java.util.Date getPreviousWeekDay(Calendar gc) {
		switch (gc.get(7)) {
		case 2:
			gc.add(5, -3);
			break;
		case 1:
			gc.add(5, -2);
			break;
		default:
			gc.add(5, -1);
		}

		return gc.getTime();
	}

	public static java.util.Date getPreviousDay(java.util.Date date, int days) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(5, -days);
		return gc.getTime();
	}

	public static Calendar getPreviousDay(Calendar gc, int days) {
		gc.add(5, -days);
		return gc;
	}

	public static java.util.Date getNextWeekDay(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(7)) {
		case 6:
			gc.add(5, 3);
			break;
		case 7:
			gc.add(5, 2);
			break;
		default:
			gc.add(5, 1);
		}

		return gc.getTime();
	}

	public static Calendar getNextWeekDay(Calendar gc) {
		switch (gc.get(7)) {
		case 6:
			gc.add(5, 3);
			break;
		case 7:
			gc.add(5, 2);
			break;
		default:
			gc.add(5, 1);
		}

		return gc;
	}

	public static java.util.Date getLastDayOfNextMonth(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(getNextMonth(gc.getTime()));
		gc.setTime(getLastDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	public static java.util.Date getLastDayOfNextWeek(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(getNextWeek(gc.getTime()));
		gc.setTime(getLastDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	public static java.util.Date getFirstDayOfNextMonth(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(getNextMonth(gc.getTime()));
		gc.setTime(getFirstDayOfMonth(gc.getTime()));
		return gc.getTime();
	}

	public static Calendar getFirstDayOfNextMonth(Calendar gc) {
		gc.setTime(getNextMonth(gc.getTime()));
		gc.setTime(getFirstDayOfMonth(gc.getTime()));
		return gc;
	}

	public static java.util.Date getFirstDayOfNextWeek(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setTime(getNextWeek(gc.getTime()));
		gc.setTime(getFirstDayOfWeek(gc.getTime()));
		return gc.getTime();
	}

	public static Calendar getFirstDayOfNextWeek(Calendar gc) {
		gc.setTime(getNextWeek(gc.getTime()));
		gc.setTime(getFirstDayOfWeek(gc.getTime()));
		return gc;
	}

	public static java.util.Date getNextMonth(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(2, 1);
		return gc.getTime();
	}

	public static Calendar getNextMonth(Calendar gc) {
		gc.add(2, 1);
		return gc;
	}

	public static java.util.Date getNextDay(java.util.Date date) {
		return getNextDay(date, 1);
	}

	public static java.util.Date getNextDay(java.util.Date date, int day) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(5, day);
		return gc.getTime();
	}

	public static Calendar getNextDay(Calendar gc) {
		return getNextDay(gc, 1);
	}

	public static Calendar getNextDay(Calendar gc, int day) {
		gc.add(5, day);
		return gc;
	}

	public static java.util.Date getNextWeek(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(5, 7);
		return gc.getTime();
	}

	public static Calendar getNextWeek(Calendar gc) {
		gc.add(5, 7);
		return gc;
	}

	public static java.util.Date getLastDayOfWeek(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(7)) {
		case 1:
			gc.add(5, 6);
			break;
		case 2:
			gc.add(5, 5);
			break;
		case 3:
			gc.add(5, 4);
			break;
		case 4:
			gc.add(5, 3);
			break;
		case 5:
			gc.add(5, 2);
			break;
		case 6:
			gc.add(5, 1);
			break;
		case 7:
			gc.add(5, 0);
		}

		return gc.getTime();
	}

	public static java.util.Date getFirstDayOfWeek(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(7)) {
		case 1:
			gc.add(5, 0);
			break;
		case 2:
			gc.add(5, -1);
			break;
		case 3:
			gc.add(5, -2);
			break;
		case 4:
			gc.add(5, -3);
			break;
		case 5:
			gc.add(5, -4);
			break;
		case 6:
			gc.add(5, -5);
			break;
		case 7:
			gc.add(5, -6);
		}

		return gc.getTime();
	}

	public static Calendar getFirstDayOfWeek(Calendar gc) {
		switch (gc.get(7)) {
		case 1:
			gc.add(5, 0);
			break;
		case 2:
			gc.add(5, -1);
			break;
		case 3:
			gc.add(5, -2);
			break;
		case 4:
			gc.add(5, -3);
			break;
		case 5:
			gc.add(5, -4);
			break;
		case 6:
			gc.add(5, -5);
			break;
		case 7:
			gc.add(5, -6);
		}

		return gc;
	}

	public static String getWeek(String dateStr) {
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyy-MM-dd");
		SimpleDateFormat formatter2 = new SimpleDateFormat("E");
		java.util.Date date = null;
		try {
			date = formatter1.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatter2.format(date);
	}

	public static java.util.Date getLastDayOfMonth(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		switch (gc.get(2)) {
		case 0:
			gc.set(5, 31);
			break;
		case 1:
			gc.set(5, 28);
			break;
		case 2:
			gc.set(5, 31);
			break;
		case 3:
			gc.set(5, 30);
			break;
		case 4:
			gc.set(5, 31);
			break;
		case 5:
			gc.set(5, 30);
			break;
		case 6:
			gc.set(5, 31);
			break;
		case 7:
			gc.set(5, 31);
			break;
		case 8:
			gc.set(5, 30);
			break;
		case 9:
			gc.set(5, 31);
			break;
		case 10:
			gc.set(5, 30);
			break;
		case 11:
			gc.set(5, 31);
		}

		if ((gc.get(2) == 1) && (isLeapYear(gc.get(1)))) {
			gc.set(5, 29);
		}
		return gc.getTime();
	}

	public static Calendar getLastDayOfMonth(Calendar gc) {
		switch (gc.get(2)) {
		case 0:
			gc.set(5, 31);
			break;
		case 1:
			gc.set(5, 28);
			break;
		case 2:
			gc.set(5, 31);
			break;
		case 3:
			gc.set(5, 30);
			break;
		case 4:
			gc.set(5, 31);
			break;
		case 5:
			gc.set(5, 30);
			break;
		case 6:
			gc.set(5, 31);
			break;
		case 7:
			gc.set(5, 31);
			break;
		case 8:
			gc.set(5, 30);
			break;
		case 9:
			gc.set(5, 31);
			break;
		case 10:
			gc.set(5, 30);
			break;
		case 11:
			gc.set(5, 31);
		}

		if ((gc.get(2) == 1) && (isLeapYear(gc.get(1)))) {
			gc.set(5, 29);
		}
		return gc;
	}

	public static java.util.Date getFirstDayOfMonth(java.util.Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(5, 1);
		return gc.getTime();
	}

	public static Calendar getFirstDayOfMonth(Calendar gc) {
		gc.set(5, 1);
		return gc;
	}

	public static String toOraString(java.util.Date theDate, boolean hasTime) {
		DateFormat theFormat;
		DateFormat theFormat1;
		if (hasTime)
			theFormat1 = getOraDateTimeFormat();
		else {
			theFormat1 = getOraDateFormat();
		}
		return toString(theDate, theFormat1);
	}

	public static String toString(java.util.Date theDate, boolean hasTime) {
		DateFormat theFormat;
		DateFormat theFormat1;
		if (hasTime)
			theFormat1 = getDateTimeFormat();
		else {
			theFormat1 = getDateFormat();
		}
		return toString(theDate, theFormat1);
	}

	public static DateFormat getDateFormat() {
		SimpleDateFormat theDateFormat = (SimpleDateFormat) DATE_FORMAT.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	public static DateFormat getDateTimeFormat() {
		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) DATE_TIME_FORMAT.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	public static DateFormat getOraDateFormat() {
		SimpleDateFormat theDateFormat = (SimpleDateFormat) ORA_DATE_FORMAT.clone();
		theDateFormat.setLenient(false);
		return theDateFormat;
	}

	public static DateFormat getOraDateTimeFormat() {
		SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) ORA_DATE_TIME_FORMAT.clone();
		theDateTimeFormat.setLenient(false);
		return theDateTimeFormat;
	}

	public static String toString(java.util.Date theDate, DateFormat theDateFormat) {
		if (theDate == null) {
			return "";
		}
		return theDateFormat.format(theDate);
	}

	public static boolean afterByDay(String strDate1, String strDate2) {
		java.util.Date date1 = parseDateDayFormat(strDate1);
		java.util.Date date2 = parseDateDayFormat(strDate2);
		return afterByDay(date1, date2);
	}

	public static boolean afterByDay(java.util.Date date1, java.util.Date date2) {
		long millis1 = date1.getTime() / 86400000L;
		long millis2 = date2.getTime() / 86400000L;

		return millis1 > millis2;
	}

	public static boolean beforeByDay(String strDate1, String strDate2) {
		java.util.Date date1 = parseDateDayFormat(strDate1);
		java.util.Date date2 = parseDateDayFormat(strDate2);
		return beforeByDay(date1, date2);
	}

	public static boolean beforeByDay(java.util.Date date1, java.util.Date date2) {
		long millis1 = date1.getTime() / 86400000L;
		long millis2 = date2.getTime() / 86400000L;

		return millis1 < millis2;
	}

	public static boolean equalsByDay(java.util.Date date1, java.util.Date date2) {
		long millis1 = date1.getTime() / 86400000L;
		long millis2 = date2.getTime() / 86400000L;

		return millis1 == millis2;
	}

	public static int getAge(java.util.Date date) {
		return getAge(date, getCalendar());
	}

	public static int getAge(java.util.Date date, TimeZone timeZone) {
		return getAge(date, new GregorianCalendar(timeZone));
	}

	public static int getAge(java.util.Date date, Calendar today) {
		Calendar birthday = getCalendar();

		birthday.setTime(date);

		int yearDiff = today.get(1) - birthday.get(1);

		if (today.get(2) < birthday.get(2))
			yearDiff--;
		else if ((today.get(2) == birthday.get(2)) && (today.get(5) < birthday.get(5))) {
			yearDiff--;
		}

		return yearDiff;
	}

	public static int compareTo(java.util.Date date1, java.util.Date date2) {
		return compareTo(date1, date2, false);
	}

	public static int compareTo(java.util.Date date1, java.util.Date date2, boolean ignoreMilliseconds) {
		if ((date1 != null) && (date2 == null))
			return -1;
		if ((date1 == null) && (date2 != null))
			return 1;
		if ((date1 == null) && (date2 == null)) {
			return 0;
		}

		long time1 = date1.getTime();
		long time2 = date2.getTime();

		if (ignoreMilliseconds) {
			time1 /= 1000L;
			time2 /= 1000L;
		}

		if (time1 == time2)
			return 0;
		if (time1 < time2) {
			return -1;
		}
		return 1;
	}

	public static boolean equals(java.util.Date date1, java.util.Date date2) {
		return compareTo(date1, date2) == 0;
	}

	public static boolean equals(java.util.Date date1, java.util.Date date2, boolean ignoreMilliseconds) {
		if (!ignoreMilliseconds) {
			return equals(date1, date2);
		}

		long time1 = 0L;

		if (date1 != null) {
			time1 = date1.getTime() / 1000L;
		}

		long time2 = 0L;

		if (date2 != null) {
			time2 = date2.getTime() / 1000L;
		}

		return time1 == time2;
	}

	public static int getDaysBetween(java.util.Date startDate, java.util.Date endDate, TimeZone timeZone) {
		int offset = timeZone.getRawOffset();

		Calendar startCal = new GregorianCalendar(timeZone);

		startCal.setTime(startDate);
		startCal.add(14, offset);

		Calendar endCal = new GregorianCalendar(timeZone);

		endCal.setTime(endDate);
		endCal.add(14, offset);

		int daysBetween = 0;

		while (beforeByDay(startCal.getTime(), endCal.getTime())) {
			startCal.add(5, 1);

			daysBetween++;
		}

		return daysBetween;
	}

	public static java.util.Date newDate() {
		return new java.util.Date();
	}

	public static java.util.Date newDate(long date) {
		return new java.util.Date(date);
	}

	public static java.util.Date getStartOfDay(java.util.Date day) {
		return getStartOfDay(day, Calendar.getInstance());
	}

	public static java.util.Date getStartOfDay(java.util.Date day, Calendar cal) {
		if (day == null) {
			day = new java.util.Date();
		}
		cal.setTime(day);
		cal.set(11, cal.getMinimum(11));
		cal.set(12, cal.getMinimum(12));
		cal.set(13, cal.getMinimum(13));
		cal.set(14, cal.getMinimum(14));
		return cal.getTime();
	}

	public static java.util.Date getEndOfDay(java.util.Date day) {
		return getEndOfDay(day, Calendar.getInstance());
	}

	public static java.util.Date getEndOfDay(java.util.Date day, Calendar cal) {
		if (day == null) {
			day = new java.util.Date();
		}
		cal.setTime(day);
		cal.set(11, cal.getMaximum(11));
		cal.set(12, cal.getMaximum(12));
		cal.set(13, cal.getMaximum(13));
		cal.set(14, cal.getMaximum(14));
		return cal.getTime();
	}

	public static java.util.Date getStartOfHour(java.util.Date day) {
		return getStartOfHour(day, Calendar.getInstance());
	}

	public static java.util.Date getStartOfHour(java.util.Date day, Calendar cal) {
		if (day == null) {
			day = new java.util.Date();
		}
		cal.setTime(day);
		cal.set(12, cal.getMinimum(12));
		cal.set(13, cal.getMinimum(13));
		cal.set(14, cal.getMinimum(14));
		return cal.getTime();
	}

	public static java.util.Date getEndOfHour(java.util.Date day) {
		return getEndOfHour(day, Calendar.getInstance());
	}

	public static java.util.Date getEndOfHour(java.util.Date day, Calendar cal) {
		if ((day == null) || (cal == null)) {
			return day;
		}

		cal.setTime(day);
		cal.set(12, cal.getMaximum(12));
		cal.set(13, cal.getMaximum(13));
		cal.set(14, cal.getMaximum(14));
		return cal.getTime();
	}

	public static java.util.Date getStartOfMinute(java.util.Date day) {
		return getStartOfMinute(day, Calendar.getInstance());
	}

	public static java.util.Date getStartOfMinute(java.util.Date day, Calendar cal) {
		if (day == null) {
			day = new java.util.Date();
		}
		cal.setTime(day);
		cal.set(13, cal.getMinimum(13));
		cal.set(14, cal.getMinimum(14));
		return cal.getTime();
	}

	public static java.util.Date getEndOfMinute(java.util.Date day) {
		return getEndOfMinute(day, Calendar.getInstance());
	}

	public static java.util.Date getEndOfMinute(java.util.Date day, Calendar cal) {
		if ((day == null) || (cal == null)) {
			return day;
		}

		cal.setTime(day);
		cal.set(13, cal.getMaximum(13));
		cal.set(14, cal.getMaximum(14));
		return cal.getTime();
	}

	public static java.util.Date getStartOfMonth(java.util.Date day) {
		return getStartOfMonth(day, Calendar.getInstance());
	}

	public static java.util.Date getStartOfMonth(java.util.Date day, Calendar cal) {
		if (day == null) {
			day = new java.util.Date();
		}
		cal.setTime(day);

		cal.set(11, cal.getMinimum(11));
		cal.set(12, cal.getMinimum(12));
		cal.set(13, cal.getMinimum(13));
		cal.set(14, cal.getMinimum(14));

		cal.set(5, 1);

		return cal.getTime();
	}

	public static java.util.Date getEndOfMonth(java.util.Date day) {
		return getEndOfMonth(day, Calendar.getInstance());
	}

	public static java.util.Date getEndOfMonth(java.util.Date day, Calendar cal) {
		if (day == null) {
			day = new java.util.Date();
		}
		cal.setTime(day);

		cal.set(11, cal.getMaximum(11));
		cal.set(12, cal.getMaximum(12));
		cal.set(13, cal.getMaximum(13));
		cal.set(14, cal.getMaximum(14));

		cal.set(5, 1);

		cal.add(2, 1);

		cal.add(5, -1);

		return cal.getTime();
	}

	public static java.util.Date getNoonOfDay(java.util.Date day, Calendar cal) {
		if (day == null) {
			day = new java.util.Date();
		}
		cal.setTime(day);
		cal.set(11, 12);
		cal.set(12, cal.getMinimum(12));
		cal.set(13, cal.getMinimum(13));
		cal.set(14, cal.getMinimum(14));
		return cal.getTime();
	}

	public static int compareDate(String param0, String param1, String param2, String param3) throws Exception {
		String s = "";
		if ((param0.length() == 8) && (param2.length() == 8)) {
			s = "yyyyMMdd";
		} else if ((param0.length() == 10) && (param2.length() == 10)) {
			s = "yyyy-MM-dd";
		} else {
			throw new Exception("日期格式错误，支持格式yyyyMMdd");
		}

		java.util.Date dateOne = new java.util.Date();
		java.util.Date dateTwo = new java.util.Date();
		SimpleDateFormat simpledateformat = null;
		simpledateformat = new SimpleDateFormat(s);

		dateOne = simpledateformat.parse(param0);
		dateTwo = simpledateformat.parse(param2);
		if (dateOne.compareTo(dateTwo) == 0) {
			if (Integer.parseInt(param1) > Integer.parseInt(param3)) {
				System.out.println("日期1>日期2 (日期一时段大于日期二的时段)");
				return 1;
			}

			if (Integer.parseInt(param1) < Integer.parseInt(param3)) {
				System.out.println("日期1<日期2 (日期一时段小于日期二的时段)");
				return -1;
			}

			System.out.println("日期1=日期2");
			return 0;
		}

		if (dateOne.compareTo(dateTwo) > 0) {
			System.out.println("日期1>日期2");
			return 1;
		}

		System.out.println("日期1<日期2");
		return -1;
	}

	public static int getDateDiff(java.util.Date s1, java.util.Date s2, String s3) {
		if (s3.equalsIgnoreCase("s")) {
			long l1 = s1.getTime() - s2.getTime();
			return (int) (l1 / 1000L);
		}

		if (s3.equalsIgnoreCase("mi")) {
			long l2 = s1.getTime() - s2.getTime();
			return (int) (l2 / 60000L);
		}

		if (s3.equalsIgnoreCase("h")) {
			long l3 = s1.getTime() - s2.getTime();
			return (int) (l3 / 3600000L);
		}

		if (s3.equalsIgnoreCase("d")) {
			long l4 = s1.getTime() - s2.getTime();
			return (int) (l4 / 86400000L);
		}

		if (s3.equalsIgnoreCase("m")) {
			int iMonth = 0;
			int flag = 0;
			try {
				Calendar objCalendarDate1 = Calendar.getInstance();
				objCalendarDate1.setTime(s1);

				Calendar objCalendarDate2 = Calendar.getInstance();
				objCalendarDate2.setTime(s2);

				if (objCalendarDate2.equals(objCalendarDate1))
					return 0;
				if (objCalendarDate1.after(objCalendarDate2)) {
					Calendar temp = objCalendarDate1;
					objCalendarDate1 = objCalendarDate2;
					objCalendarDate2 = temp;
				}
				if (objCalendarDate2.get(5) < objCalendarDate1.get(5)) {
					flag = 1;
				}
				if (objCalendarDate2.get(1) > objCalendarDate1.get(1))
					iMonth = (objCalendarDate2.get(1) - objCalendarDate1.get(1)) * 12 + objCalendarDate2.get(2) - flag - objCalendarDate1.get(2);
				else
					iMonth = objCalendarDate2.get(2) - objCalendarDate1.get(2) - flag;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return iMonth;
		}

		if (s3.equalsIgnoreCase("y")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(s1);
			int year1 = cal.get(1);
			cal.setTime(s2);
			int year2 = cal.get(1);
			return year1 - year2;
		}
		return -14444;
	}

	public static String getWeekType(String theDate) throws Exception {
		String s = "yyyyMMdd";
		if (theDate.length() == 10) {
			s = "yyyy-MM-dd";
		} else if (theDate.length() == 8) {
			s = "yyyyMMdd";
		} else if (theDate.length() == 14) {
			s = "yyyyMMddHHmmss";
		} else {
			System.out.println("日期格式错误");
			return "";
		}

		java.util.Date now = new java.util.Date();
		Calendar cal = Calendar.getInstance();

		cal.setTime(now);
		int day = cal.get(7);
		if (day == 1) {
			cal.add(5, -6);
		} else {
			cal.add(5, -day + 1);
		}
		java.util.Date mondayDate = cal.getTime();

		SimpleDateFormat simpledateformat3 = new SimpleDateFormat(s);

		java.util.Date date = simpledateformat3.parse(theDate);

		long l = date.getTime() - mondayDate.getTime();
		int i = (int) (l / 86400000L);
		if (Math.abs(i) < 14) {
			if (i < 0) {
				return "";
			}

			if (i < 7) {
				return "本周";
			}

			return "下周";
		}

		return "";
	}

	public static int getYearIndex(java.util.Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		return c.get(1);
	}

	public static int getMonthIndex(java.util.Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		return c.get(2);
	}

	public static int getDayIndex(java.util.Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		return c.get(5);
	}

	public static int getHour(java.util.Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		return c.get(11);
	}

	public static int getMinute(java.util.Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		return c.get(12);
	}

	public static int getSecond(java.util.Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		return c.get(13);
	}

	public static int getWeekOfMonth(String theDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		int weekID = -1;
		try {
			Calendar c = Calendar.getInstance();

			c.setTime(sdf.parse(theDate));

			weekID = c.get(4);
		} catch (Exception e) {
			System.out.println("获取指定日期是第几周出错" + e.getMessage());
		}
		return weekID;
	}

	public static int getDayOfWeek(String theDate, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		int dayID = -1;
		try {
			GregorianCalendar gregoriancalendar = new GregorianCalendar();
			gregoriancalendar.setTime(sdf.parse(theDate));

			dayID = gregoriancalendar.get(7) - 1;
		} catch (Exception e) {
			System.out.println("获取指定日期是星期几出错" + e.getMessage());
		}
		return dayID;
	}

	public static int getDayOfWeek(java.util.Date theDate) {
		int dayID = -1;
		try {
			GregorianCalendar gregoriancalendar = new GregorianCalendar();
			gregoriancalendar.setTime(theDate);

			dayID = gregoriancalendar.get(7) - 1;
		} catch (Exception e) {
			System.out.println("获取指定日期是星期几出错" + e.getMessage());
		}
		return dayID;
	}

	public static java.sql.Date getNowDate() {
		return new java.sql.Date(new java.util.Date().getTime());
	}

	public static Timestamp getNowDateTime() {
		return new Timestamp(new java.util.Date().getTime());
	}

	public static String getNow(String strFormat) throws ParseException {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat(strFormat);
		return format.format(date);
	}

	public static java.util.Date parse(String theDate) throws ParseException {
		if (theDate == null) {
			return null;
		}
		int len = theDate.length();
		String format = "";
		switch (len) {
		case 6:
			format = "yyyyMM";
			break;
		case 8:
			format = "yyyyMMdd";
			break;
		case 10:
			format = "yyyy-MM-dd";
			break;
		case 14:
			format = "yyyyMMddHHmmss";
			break;
		case 16:
			format = "yyyyMMddHH:mm:ss";
			break;
		case 19:
			format = "yyyy-MM-dd HH:mm:ss";
			break;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		return sdf.parse(theDate);
	}

	public static String formatDate(String theDate, String sourceFormat, String targetFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(sourceFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(theDate));
		sdf = new SimpleDateFormat(targetFormat);
		return sdf.format(c.getTime());
	}

	public static String formatDate1(java.util.Date date, String strFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(strFormat);
		return format.format(date);
	}

	public static String addMonthStr(String theDate, int monthcount, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar c = Calendar.getInstance();

		c.setTime(sdf.parse(theDate));
		c.add(2, monthcount);
		return sdf.format(c.getTime());
	}

	public static java.util.Date addMonthDate(java.util.Date theDate, int monthcount) throws ParseException {
		Calendar c = Calendar.getInstance();

		c.setTime(theDate);
		c.add(2, monthcount);
		return c.getTime();
	}

	public static String addSecond(String theDate, int count, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar c = Calendar.getInstance();

		c.setTime(sdf.parse(theDate));
		c.add(13, count);
		return sdf.format(c.getTime());
	}

	public static void main(String[] args) throws Exception {
		String amstarttime = "2013-11-12 07:00:00";
		String amendtime = "2013-11-12 12:30:00";

		int i = getDateDiff(parse(amendtime), parse(amstarttime), "mi");
		System.out.println(i);
	}

	public static String addMinute(String theDate, int count, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(theDate));
		c.add(12, count);
		return sdf.format(c.getTime());
	}

	public static java.util.Date addDay(java.util.Date theDate, int days) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(theDate);
		c.add(5, days);
		return c.getTime();
	}

	public static String addDate(String theDate, int days, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar c = Calendar.getInstance();

		c.setTime(sdf.parse(theDate));
		c.add(5, days);
		return sdf.format(c.getTime());
	}

	public static String addDate(String theDate, int days) throws ParseException {
		String format = "yyyy-MM-dd";
		theDate = theDate.trim();
		if (theDate.length() == 19) {
			format = "yyyy-MM-dd HH:mm:ss";
		} else if (theDate.length() == 14) {
			format = "yyyyMMddHHmmss";
		} else if (theDate.length() == 8) {
			format = "yyyyMMdd";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar c = Calendar.getInstance();

		c.setTime(sdf.parse(theDate));
		c.add(5, days);
		return sdf.format(c.getTime());
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToStr(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短String转换date
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 * @throws ParseException
	 */
	public static String dateToStr1(String str, String str2) throws ParseException {
		String dateString = DateUtil.formatDate1(DateUtil.parse(str), str2);
		return dateString;
	}
}
