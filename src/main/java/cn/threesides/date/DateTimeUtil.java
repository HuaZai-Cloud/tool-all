package cn.threesides.date;





import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONDAY;


/**
 * 日期时间工具
 *
 * @author Di Wu
 */
public class DateTimeUtil {


	// TODO DateTime ----------------------------------------------------------------

	/**
	 * 获取当前日期
	 *
	 * @return 日期
	 */
	public static Date getDateTime() {
		return new Date();
	}

	/**
	 * 根据日历获取日期
	 *
	 * @param calendar 日历
	 * @return 日期
	 */
	public static Date getDateTime(Calendar calendar) {
		return calendar.getTime();
	}

	/**
	 * 根据毫秒时间戳获取日期
	 *
	 * @param millisecondTimestamp 毫秒时间戳
	 * @return 日期
	 */
	public static Date getDateTime(long millisecondTimestamp) {
		return new Date(millisecondTimestamp);
	}

	/**
	 * 根据秒时间戳获取日期
	 *
	 * @param secondTimestamp 秒时间戳
	 * @return 日期
	 */
	public static Date getDateTime(int secondTimestamp) {
		return new Date(secondTimestamp * 1000L);
	}

	/**
	 * 根据毫秒时间戳获取日历
	 *
	 * @param millisecondTimestamp 毫秒时间戳
	 * @return 日历
	 */
	public static Calendar getCalendar(long millisecondTimestamp) {
		Calendar calendar = getCalendar();
		Date dateTime = getDateTime(millisecondTimestamp);
		calendar.setTime(dateTime);
		return calendar;
	}

	/**
	 * 根据秒时间戳获取日历
	 *
	 * @param secondTimestamp 秒时间戳
	 * @return 日历
	 */
	public static Calendar getCalendar(int secondTimestamp) {
		Calendar calendar = getCalendar();
		Date dateTime = getDateTime(secondTimestamp);
		calendar.setTime(dateTime);
		return calendar;
	}

	/**
	 * 获取当前日历
	 *
	 * @return 日历
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 根据日期获取日历
	 *
	 * @param date 日期
	 * @return 日历
	 */
	public static Calendar getCalendar(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 获取当前毫秒时间戳
	 *
	 * @return 毫秒时间戳
	 */
	public static Long getMillisecondTimestamp() {
		return getDateTime().getTime();
	}

	/**
	 * 根据日期获取毫秒时间戳
	 *
	 * @param date 日期
	 * @return 毫秒时间戳
	 */
	public static Long getMillisecondTimestamp(Date date) {
		return date.getTime();
	}

	/**
	 * 根据日历获取毫秒时间戳
	 *
	 * @param calendar 日历
	 * @return 毫秒时间戳
	 */
	public static Long getMillisecondTimestamp(Calendar calendar) {
		return calendar.getTime().getTime();
	}

	/**
	 * 获取当前秒时间戳
	 *
	 * @return 秒时间戳
	 */
	public static Integer getSecondTimestamp() {
		return Integer.valueOf(String.valueOf(getDateTime().getTime() / 1000));
	}

	/**
	 * 根据日期获取秒时间戳
	 *
	 * @param date 日期
	 * @return 秒时间戳
	 */
	public static Integer getSecondTimestamp(Date date) {
		return Integer.valueOf(String.valueOf(date.getTime() / 1000));
	}

	/**
	 * 根据日历获取秒时间戳
	 *
	 * @param calendar 日历
	 * @return 秒时间戳
	 */
	public static Integer getSecondTimestamp(Calendar calendar) {
		return Integer.valueOf(String.valueOf(calendar.getTime().getTime() / 1000));
	}

	/**
	 * 根据日期格式格式化日期
	 *
	 * @param date 日期
	 * @param datePattern 日期格式
	 * @return 格式化日期
	 */
	public static String format(Date date, String datePattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		return dateFormat.format(date);
	}

	/**
	 * 根据日期格式解析日期
	 *
	 * @param dateTime 字符串日期
	 * @param datePattern 日期格式
	 * @return 日期
	 */
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

	/**
	 * 获取当前年份
	 *
	 * @return 年份
	 */
	public static int getThisYear() {
		return getYear(Calendar.getInstance());
	}

	/**
	 * 根据日期获取年份
	 *
	 * @param date 日期
	 * @return 年份
	 */
	public static int getYear(Date date) {
		Calendar calendar = getCalendar(date);
		return getYear(calendar);
	}

	/**
	 * 根据日历获取年份
	 *
	 * @param calendar 日历
	 * @return 年份
	 */
	public static int getYear(Calendar calendar) {
		return calendar.get(Calendar.YEAR);
	}


	// beginOfYear ----------------------------------------------------------------

	/**
	 * 获取当前年开始时间
	 *
	 * @return 年开始时间
	 */
	public static Date beginOfThisYear() {
		Calendar calendar = getCalendar();
		return beginOfYear(calendar);
	}

	/**
	 * 根据年份获取年开始时间
	 *
	 * @param year 年份
	 * @return 年开始时间
	 */
	public static Date beginOfYear(int year) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		return beginOfYear(calendar);
	}

	/**
	 * 根据日期获取年开始时间
	 *
	 * @param date 日期
	 * @return 年开始时间
	 */
	public static Date beginOfYear(Date date) {
		Calendar calendar = getCalendar(date);
		return beginOfYear(calendar);
	}

	/**
	 * 根据日历获取年开始时间
	 *
	 * @param calendar 日历
	 * @return 年开始时间
	 */
	public static Date beginOfYear(Calendar calendar) {
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		return setBeginTimeOfDay(calendar).getTime();
	}

	// endOfYear ----------------------------------------------------------------

	/**
	 * 获取当前年结束时间
	 *
	 * @return 年结束时间
	 */
	public static Date endOfThisYear() {
		Calendar calendar = getCalendar();
		return endOfYear(calendar);
	}

	/**
	 * 根据年份获取年结束时间
	 *
	 * @param year 年份
	 * @return 年结束时间
	 */
	public static Date endOfYear(int year) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		return endOfYear(calendar);
	}

	/**
	 * 根据日期获取年结束时间
	 *
	 * @param date 日期
	 * @return 年结束时间
	 */
	public static Date endOfYear(Date date) {
		Calendar calendar = getCalendar(date);
		return endOfYear(calendar);
	}

	/**
	 * 根据日历获取年结束时间
	 *
	 * @param calendar 日历
	 * @return 年结束时间
	 */
	public static Date endOfYear(Calendar calendar) {
		int monthsOfYear = calendar.getActualMaximum(Calendar.MONTH);
		calendar.set(Calendar.MONTH, monthsOfYear);
		int daysOfMonth = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, daysOfMonth);
		return setEndTimeOfDay(calendar).getTime();
	}

	// betweenYear ----------------------------------------------------------------

	/**
	 * 根据开始日期、结束日期 获取间隔年数
	 *
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return 间隔年数
	 */
	public static int betweenYear(Date beginDate, Date endDate) {
		return getYear(endDate) - getYear(beginDate);
	}

	/**
	 * 根据开始日历 、结束日历 获取间隔年数
	 *
	 * @param beginCalendar 开始日历
	 * @param endCalendar 结束日历
	 * @return 间隔年数
	 */
	public static int betweenYear(Calendar beginCalendar, Calendar endCalendar) {
		return getYear(endCalendar) - getYear(beginCalendar);
	}

	// TODO month ----------------------------------------------------------------

	/**
	 * 获取当前年份月份
	 *
	 * @return 月份
	 */
	public static int getThisMonth() {
		return getMonth(getCalendar());
	}

	/**
	 * 根据日期获取月份
	 *
	 * @param date 日期
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = getCalendar(date);
		return getMonth(calendar);
	}

	/**
	 * 根据日历获取月份
	 *
	 * @param calendar 日历
	 * @return 月份
	 */
	public static int getMonth(Calendar calendar) {
		return calendar.get(Calendar.MONTH) + 1;
	}


	// beginOfMonth ----------------------------------------------------------------

	/**
	 * 获取当前月开始时间
	 *
	 * @return 月开始时间
	 */
	public static Date beginOfThisMonth() {
		Calendar calendar = getCalendar();
		return beginOfMonth(calendar);
	}

	/**
	 * 根据年份、月份获取月开始时间
	 *
	 * @param year 年份
	 * @param month 月份
	 * @return 月开始时间
	 */
	public static Date beginOfMonth(int year, int month) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return beginOfMonth(calendar);
	}

	/**
	 * 根据日期获取月开始时间
	 *
	 * @param date 日期
	 * @return 月开始时间
	 */
	public static Date beginOfMonth(Date date) {
		Calendar calendar = getCalendar(date);
		return beginOfMonth(calendar);
	}

	/**
	 * 根据日历获取月开始时间
	 *
	 * @param calendar 日历
	 * @return 月开始时间
	 */
	public static Date beginOfMonth(Calendar calendar) {
		calendar.set(Calendar.DATE, 1);
		return setBeginTimeOfDay(calendar).getTime();
	}

	/**
	 * 获取当前月结束时间
	 *
	 * @return 月结束时间
	 */
	public static Date endOfThisMonth() {
		Calendar calendar = getCalendar();
		return endOfMonth(calendar);
	}

	/**
	 * 根据年份、月份获取月结束时间
	 *
	 * @param year 年份
	 * @param month 月份
	 * @return 月结束时间
	 */
	public static Date endOfMonth(int year, int month) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return endOfMonth(calendar);
	}

	/**
	 * 根据日期获取月结束时间
	 *
	 * @param date 日期
	 * @return 月结束时间
	 */
	public static Date endOfMonth(Date date) {
		Calendar calendar = getCalendar(date);
		return endOfMonth(calendar);
	}

	/**
	 * 根据日历获取月结束时间
	 *
	 * @param calendar 日历
	 * @return 月结束时间
	 */
	public static Date endOfMonth(Calendar calendar) {
		int daysOfMonth = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, daysOfMonth);
		return setEndTimeOfDay(calendar).getTime();
	}

	/**
	 * 根据开始日期、结束日期获取间隔月数
	 *
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return 间隔月数
	 */
	public static int betweenMonth(Date beginDate, Date endDate) {
		int betweenYear = betweenYear(beginDate, endDate);
		int betweenMonth = getMonth(endDate) - getMonth(beginDate);
		return betweenYear * 12 + betweenMonth;
	}

	/**
	 * 根据开始日历、结束日历获取间隔月数
	 *
	 * @param beginCalendar 开始日历
	 * @param endCalendar 结束日历
	 * @return 间隔月数
	 */
	public static int betweenMonth(Calendar beginCalendar, Calendar endCalendar) {
		int betweenYear = betweenYear(beginCalendar, endCalendar);
		int betweenMonth = getMonth(endCalendar) - getMonth(beginCalendar);
		return betweenYear * 12 + betweenMonth;
	}

	// TODO DAY ----------------------------------------------------------------

	/**
	 * 获取今天在今年第几天
	 *
	 * @return 在这一年第几天
	 */
	public static int getThisDayOfYear() {
		return getDayOfYear(getCalendar());
	}

	/**
	 * 根据日期获取在这一年第几天
	 *
	 * @param date 日期
	 * @return 在这一年第几天
	 */
	public static int getDayOfYear(Date date) {
		Calendar calendar = getCalendar(date);
		return getDayOfYear(calendar);
	}

	/**
	 * 根据日历获取在这一年第几天
	 *
	 * @param calendar 日历
	 * @return 在这一年第几天
	 */
	public static int getDayOfYear(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取今天在这个月第几天
	 *
	 * @return 在这个月第几天
	 */
	public static int getThisDayOfMonth() {
		return getDayOfMonth(getCalendar());
	}

	/**
	 * 根据日期获取在这一个月第几天
	 *
	 * @param date 日期
	 * @return 在这一个月第几天
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = getCalendar(date);
		return getDayOfMonth(calendar);
	}

	/**
	 * 根据日历获取在这一个月第几天
	 *
	 * @param calendar 日历
	 * @return 在这一个月第几天
	 */
	public static int getDayOfMonth(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	// beginOfDay -------------------------------------------------------

	/**
	 * 获取今天开始时间
	 *
	 * @return 今天开始时间
	 */
	public static Date beginOfThisDay() {
		return beginOfDay(getCalendar());
	}

	/**
	 * 根据年份、月份、月天数获取一天的开始时间
	 *
	 * @param year 年份
	 * @param month 月份
	 * @param dayOfMonth 一个月的第几天
	 * @return 一天的开始时间
	 */
	public static Date beginOfDay(int year, int month, int dayOfMonth) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return beginOfDay(calendar);
	}

	/**
	 * 根据年份、一年的第几天获取一天的开始时间
	 *
	 * @param year 年份
	 * @param dayOfYear 一年的第几天
	 * @return 一天的开始时间
	 */
	public static Date beginOfDay(int year, int dayOfYear) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return beginOfDay(calendar);
	}

	/**
	 * 根据日期获取一天的开始时间
	 *
	 * @param date 日期
	 * @return 一天的开始时间
	 */
	public static Date beginOfDay(Date date) {
		Calendar calendar = getCalendar(date);
		return beginOfDay(calendar);
	}


	/**
	 * 根据日历获取一天的开始时间
	 *
	 * @param calendar 日历
	 * @return 一天的开始时间
	 */
	public static Date beginOfDay(Calendar calendar) {
		return setBeginTimeOfDay(calendar).getTime();
	}


	// endOfDay ----------------------------------------------------------------

	/**
	 * 获取今天结束时间
	 *
	 * @return 今天结束时间
	 */
	public static Date endOfThisDay() {
		return endOfDay(getCalendar());
	}

	/**
	 * 根据年份、一年的第几天获取一天的结束时间
	 *
	 * @param year 年份
	 * @param dayOfYear 一年的第几天
	 * @return 一天的结束时间
	 */
	public static Date endOfDay(int year, int dayOfYear) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return endOfDay(calendar);
	}

	/**
	 * 根据年份、月份、月的第几天获取一天的结束时间
	 *
	 * @param year 年份
	 * @param month 月份
	 * @param dayOfMonth 月的第几天
	 * @return 一天的结束时间
	 */
	public static Date endOfDay(int year, int month, int dayOfMonth) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return endOfDay(calendar);
	}

	/**
	 * 根据日期获取一天结束时间
	 *
	 * @param date 日期
	 * @return 一天结束时间
	 */
	public static Date endOfDay(Date date) {
		Calendar calendar = getCalendar(date);
		return endOfDay(calendar);
	}

	/**
	 * 根据日历获取一天结束时间
	 *
	 * @param calendar 日历
	 * @return 一天结束时间
	 */
	public static Date endOfDay(Calendar calendar) {
		return setEndTimeOfDay(calendar).getTime();
	}

	/**
	 * 根据开始日历、结束日历获取间隔天数
	 *
	 * @param beginCalendar 开始日历
	 * @param endCalendar 结束日历
	 * @return 间隔天数
	 */
	public static long betweenDay(Calendar beginCalendar, Calendar endCalendar) {
		return betweenDay(beginCalendar.getTime(), endCalendar.getTime());
	}

	/**
	 * 根据开始日期、结束日期获取间隔天数
	 *
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return 间隔天数
	 */
	public static long betweenDay(Date beginDate, Date endDate) {
		return between(beginDate, endDate, DateTimeUnit.DAY);

	}


	// TODO WEEK ----------------------------------------------------------------

	/**
	 * 根据日期获取一年中第几周
	 *
	 * @param date 日期
	 * @return 一年中第几周
	 */
	public static int weekOfYear(Date date) {
		Calendar calendar = getCalendar(date);
		return weekOfYear(calendar);
	}

	/**
	 * 根据日历获取一年中第几周
	 *
	 * @param calendar 日历
	 * @return 一年中第几周
	 */
	public static int weekOfYear(Calendar calendar) {
		calendar.setFirstDayOfWeek(MONDAY);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	// 按每年最大周数计算周数

	/**
	 * 根据日期获取一年最大周数中第几周（一年中一周即使一天也算一周）
	 *
	 * @param date 日期
	 * @return 一年最大周数中第几周
	 */
	public static int weekOfYearMaxWeek(Date date) {
		Calendar calendar = getCalendar(date);
		return weekOfYearMaxWeek(calendar);
	}

	/**
	 * 根据日历获取一年最大周数中第几周（一年中一周即使一天也算一周）
	 *
	 * @param calendar 日历
	 * @return 一年最大周数中第几周
	 */
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


	// beginOfWeek ----------------------------------------------------------------

	/**
	 * 根据日期获取周开始时间
	 *
	 * @param date 日期
	 * @return 周开始时间
	 */
	public static Date beginOfWeek(Date date) {
		Calendar calendar = getCalendar(date);
		return beginOfWeek(calendar);
	}

	/**
	 * 根据年份、一年第几周数获取周开始时间
	 *
	 * @param year 年数
	 * @param weekOfYear 一年第几周
	 * @return 周开始时间
	 */
	public static Date beginOfWeek(int year, int weekOfYear) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		return beginOfWeek(calendar);
	}


	/**
	 * 根据日历获取周开始时间
	 *
	 * @param calendar 日历
	 * @return 周开始时间
	 */
	public static Date beginOfWeek(Calendar calendar) {
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, MONDAY);
		return setBeginTimeOfDay(calendar).getTime();
	}

	// endOfWeek ----------------------------------------------------------------
	/**
	 * 根据日期获取周结束时间
	 *
	 * @param date 日期
	 * @return 周结束时间
	 */
	public static Date endOfWeek(Date date) {
		Calendar calendar = getCalendar(date);
		return endOfWeek(calendar);
	}

	/**
	 * 根据年份、一年第几周数获取周结束时间
	 *
	 * @param year 年份
	 * @param weekOfYear 一年第几周
	 * @return 周结束时间
	 */
	public static Date endOfWeek(int year, int weekOfYear) {
		Calendar calendar = getCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		return endOfWeek(calendar);
	}

	/**
	 * 根据日历获取周结束时间
	 *
	 * @param calendar 日历
	 * @return 周结束时间
	 */
	public static Date endOfWeek(Calendar calendar) {
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return setEndTimeOfDay(calendar).getTime();
	}

	/**
	 * 获取开始日历、结束日历获取相差周数
	 *
	 * @param beginCalendar 开始日历
	 * @param endCalendar 结束日历
	 * @return 相差周数
	 */
	public static long betweenWeek(Calendar beginCalendar, Calendar endCalendar) {
		return betweenWeek(beginCalendar.getTime(), endCalendar.getTime());
	}

	/**
	 * 获取开始日期、结束日期获取相差周数
	 *
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return 相差周数
	 */
	public static long betweenWeek(Date beginDate, Date endDate) {
		return between(beginOfWeek(beginDate), beginOfWeek(endDate), DateTimeUnit.WEEK);
	}

	/**
	 * 根据开始日期、结束日期获取时间单位间隔
	 *
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @param unit 时间单位
	 * @return 时间单位间隔
	 */
	public static long between(Date beginDate, Date endDate, DateTimeUnit unit) {
		long betweenMillis = endDate.getTime() - beginDate.getTime();
		return betweenMillis / unit.getMillis();
	}

	// offset ----------------------------------------------------------------

	/**
	 * 日期偏移毫秒
	 *
	 * @param date 日期
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetMillisecond(Date date, int offset) {
		Calendar calendar = getCalendar(date);
		return offsetMillisecond(calendar, offset);
	}

	/**
	 * 日历偏移毫秒
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetMillisecond(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.MILLISECOND);
	}

	/**
	 * 日期偏移秒
	 *
	 * @param date 日期
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetSecond(Date date, int offset) {
		Calendar calendar = getCalendar(date);
		return offsetSecond(calendar, offset);
	}

	/**
	 * 日历偏移秒
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetSecond(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.SECOND);
	}

	/**
	 * 日期偏移分
	 *
	 * @param date 日期
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetMinute(Date date, int offset) {
		Calendar calendar = getCalendar(date);
		return offsetMinute(calendar, offset);
	}

	/**
	 * 日历偏移分
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetMinute(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.MINUTE);
	}

	/**
	 * 日期偏移时
	 *
	 * @param date 日期
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetHour(Date date, int offset) {
		Calendar calendar =getCalendar(date);
		return offsetHour(calendar, offset);
	}

	/**
	 * 日历偏移时
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetHour(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.HOUR);
	}

	/**
	 * 日期偏移天
	 *
	 * @param date 日期
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetDay(Date date, int offset) {
		Calendar calendar = getCalendar(date);
		return offsetDay(calendar, offset);
	}

	/**
	 * 日历偏移天
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetDay(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.DAY_OF_YEAR);
	}

	/**
	 * 日期偏移周
	 *
	 * @param date 日期
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetWeek(Date date, int offset) {
		Calendar calendar = getCalendar(date);
		return offsetWeek(calendar, offset);
	}

	/**
	 * 日历偏移周
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetWeek(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.DAY_OF_WEEK);
	}

	/**
	 * 日期偏移月
	 *
	 * @param date 日期
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetMonth(Date date, int offset) {
		Calendar calendar = getCalendar(date);
		return offsetMonth(calendar, offset);
	}

	/**
	 * 日历偏移月
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @return 偏移后时间
	 */
	public static Date offsetMonth(Calendar calendar, int offset) {
		return offset(calendar, offset, Calendar.MONTH);
	}

	/**
	 * 日历偏移
	 *
	 * @param calendar 日历
	 * @param offset 偏移数
	 * @param unit 单位
	 * @return 偏移后时间
	 */
	private static Date offset(Calendar calendar, int offset, int unit) {
		calendar.add(unit, offset);
		return calendar.getTime();
	}


	/**
	 * 设置天开始时间
	 *
	 * @param calendar 日历
	 * @return 天开始日历
	 */
	private static Calendar setBeginTimeOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	/**
	 * 设置天结束时间
	 *
	 * @param calendar 日历
	 * @return 天结束时间
	 */
	private static Calendar setEndTimeOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar;
	}


}
