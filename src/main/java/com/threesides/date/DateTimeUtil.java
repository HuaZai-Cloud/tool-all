package com.threesides.date;





import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONDAY;


/**
 * @author Di Wu
 */
public class DateTimeUtil {


	// TODO DateTime ----------------------------------------------------------------
	public static Date getDateTime() {
		return new Date();
	}

	public static Date getDateTime(Calendar calendar) {
		return calendar.getTime();
	}

	public static Date getDateTime(long millisecondTimestamp) {
		return new Date(millisecondTimestamp);
	}

	public static Date getDateTime(int secondTimestamp) {
		return new Date(secondTimestamp * 1000L);
	}

	public static Calendar getCalendar(long millisecondTimestamp) {
		Calendar calendar = getCalendar();
		Date dateTime = getDateTime(millisecondTimestamp);
		calendar.setTime(dateTime);
		return calendar;
	}

	public static Calendar getCalendar(int secondTimestamp) {
		Calendar calendar = getCalendar();
		Date dateTime = getDateTime(secondTimestamp);
		calendar.setTime(dateTime);
		return calendar;
	}

	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	public static Calendar getCalendar(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		return calendar;
	}

	public static Long getMillisecondTimestamp() {
		return getDateTime().getTime();
	}

	public static Long getMillisecondTimestamp(Date date) {
		return date.getTime();
	}

	public static Long getMillisecondTimestamp(Calendar calendar) {
		return calendar.getTime().getTime();
	}

	public static Integer getSecondTimestamp() {
		return Integer.valueOf(String.valueOf(getDateTime().getTime() / 1000));
	}

	public static Integer getSecondTimestamp(Date date) {
		return Integer.valueOf(String.valueOf(date.getTime() / 1000));
	}

	public static Integer getSecondTimestamp(Calendar calendar) {
		return Integer.valueOf(String.valueOf(calendar.getTime().getTime() / 1000));
	}



	public static String format(Date date, String datePattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		return dateFormat.format(date);
	}

	public static Date parse(String dateTime, String datePattern) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
			return dateFormat.parse(dateTime);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// TODO year ----------------------------------------------------------------
	public static int getThisYear() {
		return getYear(Calendar.getInstance());
	}

	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getYear(calendar);
	}

	public static int getYear(Calendar calendar) {
		return calendar.get(Calendar.YEAR);
	}


	// beginOfYear

	public static Date beginOfThisYear() {
		Calendar calendar = Calendar.getInstance();
		return beginOfYear(calendar);
	}

	public static Date beginOfYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		return beginOfYear(calendar);
	}

	public static Date beginOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return beginOfYear(calendar);
	}

	public static Date beginOfYear(Calendar calendar) {
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		return setBeginTimeOfDay(calendar).getTime();
	}

	// endOfYear
	public static Date endOfThisYear() {
		Calendar calendar = Calendar.getInstance();
		return endOfYear(calendar);
	}

	public static Date endOfYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		return endOfYear(calendar);
	}

	public static Date endOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return endOfYear(calendar);
	}

	public static Date endOfYear(Calendar calendar) {
		int monthsOfYear = calendar.getActualMaximum(Calendar.MONTH);
		calendar.set(Calendar.MONTH, monthsOfYear);
		int daysOfMonth = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, daysOfMonth);
		return setEndTimeOfDay(calendar).getTime();
	}

	// betweenYear
	public static int betweenYear(Date beginDate, Date endDate) {
		return getYear(endDate) - getYear(beginDate);
	}

	public static int betweenYear(Calendar beginCalendar, Calendar endCalendar) {
		return getYear(endCalendar) - getYear(beginCalendar);
	}

	// TODO month ----------------------------------------------------------------

	public static int getThisMonth() {
		return getMonth(Calendar.getInstance());
	}

	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getMonth(calendar);
	}

	public static int getMonth(Calendar calendar) {
		return calendar.get(Calendar.MONTH) + 1;
	}


	// beginOfMonth

	public static Date beginOfThisMonth() {
		Calendar calendar = Calendar.getInstance();
		return beginOfMonth(calendar);
	}

	public static Date beginOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return beginOfMonth(calendar);
	}

	public static Date beginOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return beginOfMonth(calendar);
	}

	public static Date beginOfMonth(Calendar calendar) {
		calendar.set(Calendar.DATE, 1);
		return setBeginTimeOfDay(calendar).getTime();
	}

	public static Date endOfThisMonth() {
		Calendar calendar = Calendar.getInstance();
		return endOfMonth(calendar);
	}

	public static Date endOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return endOfMonth(calendar);
	}

	public static Date endOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return endOfMonth(calendar);
	}

	public static Date endOfMonth(Calendar calendar) {
		int daysOfMonth = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, daysOfMonth);
		return setEndTimeOfDay(calendar).getTime();
	}

	public static int betweenMonth(Date beginDate, Date endDate) {
		int betweenYear = betweenYear(beginDate, endDate);
		int betweenMonth = getMonth(endDate) - getMonth(beginDate);
		return betweenYear * 12 + betweenMonth;
	}

	public static int betweenMonth(Calendar beginCalendar, Calendar endCalendar) {
		int betweenYear = betweenYear(beginCalendar, endCalendar);
		int betweenMonth = getMonth(endCalendar) - getMonth(beginCalendar);
		return betweenYear * 12 + betweenMonth;
	}

	// TODO DAY ----------------------------------------------------------------

	public static int getThisDayOfYear() {
		return getDayOfYear(Calendar.getInstance());
	}

	public static int getDayOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getDayOfYear(calendar);
	}

	public static int getDayOfYear(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	public static int getThisDayOfMonth() {
		return getDayOfMonth(Calendar.getInstance());
	}

	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return getDayOfMonth(calendar);
	}

	public static int getDayOfMonth(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	// beginOfDay
	public static Date beginOfThisDay() {
		return beginOfDay(Calendar.getInstance());
	}

	public static Date beginOfDay(int year, int month, int dayOfMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return beginOfDay(calendar);
	}

	public static Date beginOfDay(int year, int dayOfYear) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return beginOfDay(calendar);
	}

	public static Date beginOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return beginOfDay(calendar);
	}


	public static Date beginOfDay(Calendar calendar) {
		return setBeginTimeOfDay(calendar).getTime();
	}


	// endOfDay
	public static Date endOfThisDay() {
		return endOfDay(Calendar.getInstance());
	}

	public static Date endOfDay(int year, int dayOfYear) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return endOfDay(calendar);
	}

	public static Date endOfDay(int year, int month, int dayOfMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return endOfDay(calendar);
	}

	public static Date endOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return endOfDay(calendar);
	}

	public static Date endOfDay(Calendar calendar) {
		return setEndTimeOfDay(calendar).getTime();
	}

	public static long betweenDay(Calendar beginCalendar, Calendar endCalendar) {
		return betweenDay(beginCalendar.getTime(), endCalendar.getTime());
	}

	public static long betweenDay(Date beginDate, Date endDate) {
		return between(beginDate, endDate, DateTimeUnit.DAY);

	}


	// TODO WEEK ----------------------------------------------------------------
	// 获取周数
	public static int weekOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return weekOfYear(calendar);
	}

	public static int weekOfYear(Calendar calendar) {
		calendar.setFirstDayOfWeek(MONDAY);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	// 按每年最大周数计算周数
	public static int weekOfYearMaxWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return weekOfYearMaxWeek(calendar);
	}

	public static int weekOfYearMaxWeek(Calendar calendar) {
		calendar.setFirstDayOfWeek(MONDAY);
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		int year = getYear(calendar);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		int endWeekYear = getYear(calendar);
		if (year != endWeekYear) {
			week = calendar.getMaximum(Calendar.WEEK_OF_YEAR);
		}
		return week;
	}


	// beginOfWeek
	public static Date beginOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return beginOfWeek(calendar);
	}

	public static Date beginOfWeek(int year, int weekOfYear) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		return beginOfWeek(calendar);
	}


	public static Date beginOfWeek(Calendar calendar) {
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, MONDAY);
		return setBeginTimeOfDay(calendar).getTime();
	}

	// endOfWeek

	public static Date endOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return endOfWeek(calendar);
	}

	public static Date endOfWeek(int year, int weekOfYear) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		return endOfWeek(calendar);
	}

	public static Date endOfWeek(Calendar calendar) {
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return setEndTimeOfDay(calendar).getTime();
	}

	public static long betweenWeek(Calendar beginCalendar, Calendar endCalendar) {
		return betweenWeek(beginCalendar.getTime(), endCalendar.getTime());
	}

	public static long betweenWeek(Date beginDate, Date endDate) {
		return between(beginOfWeek(beginDate), beginOfWeek(endDate), DateTimeUnit.WEEK);
	}

	public static long between(Date beginDate, Date endDate, DateTimeUnit unit) {
		long betweenMillis = endDate.getTime() - beginDate.getTime();
		return betweenMillis / unit.getMillis();
	}

	public static Date offsetMillisecond(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return offsetMillisecond(calendar, offset);
	}

	public static Date offsetMillisecond(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.MILLISECOND);
	}

	public static Date offsetSecond(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return offsetSecond(calendar, offset);
	}

	public static Date offsetSecond(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.SECOND);
	}

	public static Date offsetMinute(Date date, int offset) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return offsetMinute(calendar, offset);
	}

	public static Date offsetMinute(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.MINUTE);
	}

	public static Date offsetHour(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return offsetHour(calendar, offset);
	}

	public static Date offsetHour(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.HOUR);
	}

	public static Date offsetDay(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return offsetDay(calendar, offset);
	}

	public static Date offsetDay(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.DAY_OF_YEAR);
	}

	public static Date offsetWeek(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return offsetWeek(calendar, offset);
	}

	public static Date offsetWeek(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.DAY_OF_WEEK);
	}

	public static Date offsetMonth(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return offsetMonth(calendar, offset);
	}

	public static Date offsetMonth(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.MONTH);
	}

	private static Date offset(Calendar calendar, int offset, int unit) {
		calendar.add(unit, offset);
		return calendar.getTime();
	}


	private static Calendar setBeginTimeOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	private static Calendar setEndTimeOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar;
	}


}
