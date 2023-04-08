package com.threesides.date;

/**
 * 日期模式
 *
 * @author Di Wu
 */
public class DatePattern {

	// 年 ----------------------------------------------------------------
	public static final String YEAR_PATTERN = "yyyy";
	public static final String YEAR_CHINESE_PATTERN = "yyyy年";


	// 年 月 ----------------------------------------------------------------
	public static final String YEAR_MONTH_MIDDLE_LINE_PATTERN = "yyyy-MM";
	public static final String YEAR_MONTH_SLASH_PATTERN = "yyyy/MM";
	public static final String YEAR_MONTH_CHINESE_PATTERN = "yyyy年MM月";
	public static final String YEAR_MONTH_NOT_SEPARATOR_PATTERN = "yyyyMM";

	// 年月日 ----------------------------------------------------------------
	public static final String DATE_MIDDLE_LINE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_SLASH_PATTERN = "yyyy/MM/dd";
	public static final String DATE_CHINESE_PATTERN = "yyyy年MM月dd日";
	public static final String DATE_NOT_SEPARATOR_PATTERN = "yyyyMMdd";

	// 月 日 ----------------------------------------------------------------

	public static final String MONTH_DAY_CHINESE_PATTERN = "MM月dd日";
	public static final String MONTH_MIDDLE_LINE_PATTERN = "MM-dd";
	public static final String MONTH_SLASH_PATTERN = "MM/dd";
	public static final String MONTH_NOT_SEPARATOR_PATTERN = "MMdd";

	// 年月日 时分秒 ----------------------------------------------------------------

	public static final String DATETIME_CHINESE_PATTERN = "yyyy年MM月dd日HH时mm分ss秒";
	public static final String DATE_MIDDLE_LINE_TIME_COLON_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_SLASH_TIME_COLON_PATTERN = "yyyy/MM/dd HH:mm:ss";
	public static final String DATETIME_NOT_SEPARATOR_PATTERN = "yyyyMMddHHmmss";


	// 年月日 时分 ----------------------------------------------------------------
	public static final String DATE_MIDDLE_LINE_HOUR_MINUTE_COLON_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String DATE_SLASH_HOUR_MINUTE_COLON_PATTERN = "yyyy/MM/dd HH:mm";
	public static final String DATE_HOUR_MINUTE_CHINESE_PATTERN = "yyyy年MM月dd日HH时mm分";
	public static final String DATE_HOUR_MINUTE_NOT_SEPARATOR_PATTERN = "yyyyMMddHHmm";


	// 年月日 时 ----------------------------------------------------------------
	public static final String DATE_MIDDLE_LINE_HOUR_PATTERN = "yyyy-MM-dd HH";
	public static final String DATE_SLASH_HOUR_PATTERN = "yyyy/MM/dd HH";
	public static final String DATE_HOUR_CHINESE_PATTERN = "yyyy年MM月dd日HH时";
	public static final String DATE_NOT_SEPARATOR_HOUR_PATTERN = "yyyyMMdd HH";
	public static final String DATE_HOUR_NOT_SEPARATOR_PATTERN = "yyyyMMddHH";


	// 时分秒 ----------------------------------------------------------------
	public static final String TIME_COLON_PATTERN = "HH:mm:ss";
	public static final String TIME_NOT_SEPARATOR_PATTERN = "HHmmss";
	public static final String TIME_CHINESE_PATTERN = "HH时mm分ss秒";

	// 时分  ----------------------------------------------------------------
	public static final String HOUR_MINUTE_COLON_PATTERN = "HH:mm";
	public static final String HOUR_MINUTE_NOT_SEPARATOR_PATTERN = "HHmm";
	public static final String HOUR_MINUTE_CHINESE_PATTERN = "HH时mm秒";




}
