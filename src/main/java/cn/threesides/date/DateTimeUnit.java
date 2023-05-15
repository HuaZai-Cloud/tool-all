package cn.threesides.date;



import java.time.temporal.ChronoUnit;

/**
 * 时间单位
 *
 * @author Di Wu
 */
public enum DateTimeUnit {

	/**
	 * 一毫秒
	 */
	MS(1),
	/**
	 * 一秒的毫秒数
	 */
	SECOND(1000),
	/**
	 * 一分钟的毫秒数
	 */
	MINUTE(SECOND.getMillis() * 60),
	/**
	 * 一小时的毫秒数
	 */
	HOUR(MINUTE.getMillis() * 60),
	/**
	 * 一天的毫秒数
	 */
	DAY(HOUR.getMillis() * 24),
	/**
	 * 一周的毫秒数
	 */
	WEEK(DAY.getMillis() * 7);

	private final long millis;

	DateTimeUnit(long millis) {
		this.millis = millis;
	}

	/**
	 * @return 单位对应的毫秒数
	 */
	public long getMillis() {
		return this.millis;
	}


	public ChronoUnit toChronoUnit() {
		return DateTimeUnit.toChronoUnit(this);
	}


	public static DateTimeUnit of(ChronoUnit unit) {
		switch (unit) {
			case MICROS:
				return DateTimeUnit.MS;
			case SECONDS:
				return DateTimeUnit.SECOND;
			case MINUTES:
				return DateTimeUnit.MINUTE;
			case HOURS:
				return DateTimeUnit.HOUR;
			case DAYS:
				return DateTimeUnit.DAY;
			case WEEKS:
				return DateTimeUnit.WEEK;
		}
		return null;
	}


	public static ChronoUnit toChronoUnit(DateTimeUnit unit) {
		switch (unit) {
			case MS:
				return ChronoUnit.MICROS;
			case SECOND:
				return ChronoUnit.SECONDS;
			case MINUTE:
				return ChronoUnit.MINUTES;
			case HOUR:
				return ChronoUnit.HOURS;
			case DAY:
				return ChronoUnit.DAYS;
			case WEEK:
				return ChronoUnit.WEEKS;
		}
		return null;
	}
}
