package com.threesides.math;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.threesides.lang.ArrayUtil;
import com.threesides.lang.StringUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * NumberUtil
 *
 * @author Di Wu
 * @since 2023-03-21
 */
public class NumberUtil {

	private static final int DEFAULT_DIVIDE_SCALE = 10;


	public static boolean equals(BigDecimal bigNum1, BigDecimal bigNum2) {
		// noinspection NumberEquality
		if (bigNum1 == bigNum2) {
			// 如果用户传入同一对象，省略compareTo以提高性能。
			return true;
		}
		if (bigNum1 == null || bigNum2 == null) {
			return false;
		}
		return 0 == bigNum1.compareTo(bigNum2);
	}

	// add ----------------------------------------------------------------
	public static double add(float addend1, float addend2) {
		return add(Float.toString(addend1), Float.toString(addend2)).doubleValue();
	}

	public static double add(double addend1, double addend2) {
		return add(Double.toString(addend1), Double.toString(addend2)).doubleValue();
	}
	public static double add(float addend1, double addend2) {
		return add(Float.toString(addend1), Double.toString(addend2)).doubleValue();
	}

	public static double add(double addend1, float addend2) {
		return add(Double.toString(addend1), Float.toString(addend2)).doubleValue();
	}

	public static double add(Double addend1, Double addend2){
		return add(Double.toString(addend1), Double.toString(addend2)).doubleValue();
	}

	public static BigDecimal add(Number... addends){
		if (ArrayUtil.isEmpty(addends)) {
			return BigDecimal.ZERO;
		}

		Number addend = addends[0];
		BigDecimal result = toBigDecimal(addend);
		for (int i = 1; i < addends.length; i++) {
			addend = addends[i];
			if (addend !=null) {
				result = result.add(toBigDecimal(addend));
			}
		}
		return result;
	}

	public static BigDecimal add(BigDecimal... values) {
		if (cn.hutool.core.util.ArrayUtil.isEmpty(values)) {
			return BigDecimal.ZERO;
		}

		BigDecimal value = values[0];
		BigDecimal result = toBigDecimal(value);
		for (int i = 1; i < values.length; i++) {
			value = values[i];
			if (null != value) {
				result = result.add(value);
			}
		}
		return result;
	}

	public static BigDecimal add(String... addends) {

		if (ArrayUtil.isEmpty(addends)) {
			return BigDecimal.ZERO;
		}

		String addend = addends[0];
		BigDecimal result = toBigDecimal(addend);
		for (int i = 1; i < addends.length; i++) {
			addend = addends[i];
			if (StringUtil.isNotBlank(addend)) {
				result = result.add(toBigDecimal(addend));
			}
		}
		return result;
	}

	// subtract ----------------------------------------------------------------
	public static double subtract(double subtrahend, double minuend) {
		return subtract(Double.toString(subtrahend), Double.toString(minuend)).doubleValue();
	}

	public static double subtract(float subtrahend, float minuend) {
		return subtract(Float.toString(subtrahend), Float.toString(minuend)).doubleValue();
	}
	public static double subtract(double subtrahend, float minuend) {
		return subtract(Double.toString(subtrahend), Float.toString(minuend)).doubleValue();
	}

	public static BigDecimal subtract(Number... numbers) {
		if (ArrayUtil.isEmpty(numbers)) {
			return BigDecimal.ZERO;
		}

		Number number = numbers[0];
		BigDecimal result = toBigDecimal(number);
		for (int i = 1; i < numbers.length; i++) {
			number = numbers[i];
			if (number !=null) {
				result = result.subtract(toBigDecimal(number));
			}
		}
		return result;
	}

	public static BigDecimal subtract(String... values) {
		if (ArrayUtil.isEmpty(values)) {
			return BigDecimal.ZERO;
		}

		String value = values[0];
		BigDecimal result = toBigDecimal(value);
		for (int i = 1; i < values.length; i++) {
			value = values[i];
			if (StrUtil.isNotBlank(value)) {
				result = result.subtract(toBigDecimal(value));
			}
		}
		return result;
	}


	public static BigDecimal subtract(BigDecimal... values) {
		if (ArrayUtil.isEmpty(values)) {
			return BigDecimal.ZERO;
		}

		BigDecimal value = values[0];
		BigDecimal result = toBigDecimal(value);
		for (int i = 1; i < values.length; i++) {
			value = values[i];
			if (null != value) {
				result = result.subtract(value);
			}
		}
		return result;
	}

	// 乘 ----------------------------------------------------------------
	public static double multiply(double multiply1, double multiply2) {
		return multiply(Double.toString(multiply1), Double.toString(multiply2)).doubleValue();
	}

	public static double multiply(float multiply1, float multiply2) {
		return multiply(Float.toString(multiply1), Float.toString(multiply2)).doubleValue();
	}

	public static double multiply(double multiply1, float multiply2) {
		return multiply(Double.toString(multiply1), Float.toString(multiply2)).doubleValue();
	}

	public static double multiply(float multiply1, double multiply2) {
		return multiply(Float.toString(multiply1), Double.toString(multiply2)).doubleValue();
	}


	public static BigDecimal multiply(Number... values) {
		if (ArrayUtil.isEmpty(values)) {
			return BigDecimal.ZERO;
		}

		Number value = values[0];
		BigDecimal result = new BigDecimal(value.toString());
		for (int i = 1; i < values.length; i++) {
			value = values[i];
			result = result.multiply(new BigDecimal(value.toString()));
		}
		return result;
	}



	public static BigDecimal multiply(String... values) {
		if (ArrayUtil.isEmpty(values)) {
			return BigDecimal.ZERO;
		}

		BigDecimal result = new BigDecimal(values[0]);
		for (int i = 1; i < values.length; i++) {
			result = result.multiply(new BigDecimal(values[i]));
		}

		return result;
	}


	public static BigDecimal multiply(BigDecimal... values) {
		if (ArrayUtil.isEmpty(values) ) {
			return BigDecimal.ZERO;
		}

		BigDecimal result = values[0];
		for (int i = 1; i < values.length; i++) {
			result = result.multiply(values[i]);
		}
		return result;
	}

	// 除 ----------------------------------------------------------------
	public static double divide(double v1, double v2) {
		return divide(toBigDecimal(v1), toBigDecimal(v2)).doubleValue();
	}

	public static double divide(double v1, double v2, int scale) {
		return divide(v1, v2, scale,RoundingMode.HALF_UP);
	}

	public static double divide(double v1, double v2, int scale,RoundingMode roundingMode) {
		return divide(toBigDecimal(v1), toBigDecimal(v2), scale,roundingMode).doubleValue();
	}

	public static double divide(float v1, float v2) {
		return divide(toBigDecimal(v1), toBigDecimal(v2)).doubleValue();
	}

	public static double divide(float v1, float v2, int scale) {
		return divide(v1, v2, scale,RoundingMode.HALF_UP);
	}

	public static double divide(float v1, float v2, int scale,RoundingMode roundingMode) {
		return divide(toBigDecimal(v1), toBigDecimal(v2), scale,roundingMode).doubleValue();
	}

	public static double divide(double v1, float v2) {
		return divide(toBigDecimal(v1), toBigDecimal(v2)).doubleValue();
	}

	public static double divide(double v1, float v2, int scale) {
		return divide(v1, v2, scale,RoundingMode.HALF_UP);
	}

	public static double divide(double v1, float v2, int scale,RoundingMode roundingMode) {
		return divide(toBigDecimal(v1), toBigDecimal(v2), scale,roundingMode).doubleValue();
	}

	public static double divide(float v1, double v2) {
		return divide(toBigDecimal(v1), toBigDecimal(v2)).doubleValue();
	}

	public static double divide(float v1, double v2, int scale) {
		return divide(v1, v2, scale,RoundingMode.HALF_UP);
	}

	public static double divide(float v1, double v2, int scale,RoundingMode roundingMode) {
		return divide(toBigDecimal(v1), toBigDecimal(v2), scale,roundingMode).doubleValue();
	}


	public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale, RoundingMode roundingMode) {
		Assert.notNull(v2, "Divisor must be not null !");
		if (null == v1) {
			return BigDecimal.ZERO;
		}
		if (scale < 0) {
			scale = -scale;
		}
		return v1.divide(v2, scale, roundingMode);
	}

	public static BigDecimal divide(BigDecimal v1, BigDecimal v2, RoundingMode roundingMode) {
		Assert.notNull(v2, "Divisor must be not null !");
		if (null == v1) {
			return BigDecimal.ZERO;
		}
		return v1.divide(v2, DEFAULT_DIVIDE_SCALE,  roundingMode);
	}

	public static BigDecimal divide(BigDecimal v1, BigDecimal v2) {
		Assert.notNull(v2, "Divisor must be not null !");
		if (null == v1) {
			return BigDecimal.ZERO;
		}
		return v1.divide(v2);
	}

	// rounding ----------------------------------------------------------------
	public static BigDecimal rounding(BigDecimal number, int scale) {
		return accuracyFormat(number,scale,RoundingMode.HALF_UP);
	}

	public static BigDecimal discard(BigDecimal number, int scale) {

		return accuracyFormat(number,scale,RoundingMode.DOWN);
	}

	public static BigDecimal advance(BigDecimal number, int scale) {
		return accuracyFormat(number,scale,RoundingMode.CEILING);
	}

	public static BigDecimal accuracyFormat(BigDecimal number, int scale, RoundingMode roundingMode) {
		if (null == number) {
			number = BigDecimal.ZERO;
		}
		if (scale < 0) {
			scale = 0;
		}
		if (null == roundingMode) {
			roundingMode = RoundingMode.HALF_UP;
		}

		return number.setScale(scale, roundingMode);
	}



	public static BigDecimal toBigDecimal(Number number) {
		if (null == number) {
			return BigDecimal.ZERO;
		}

		if (number instanceof BigDecimal) {
			return (BigDecimal) number;
		} else if (number instanceof Long) {
			return new BigDecimal((Long) number);
		} else if (number instanceof Integer) {
			return new BigDecimal((Integer) number);
		} else if (number instanceof BigInteger) {
			return new BigDecimal((BigInteger) number);
		}

		// Float、Double等有精度问题，转换为字符串后再转换
		return toBigDecimal(number.toString());
	}

	public static BigDecimal toBigDecimal(String numberStr) {
		if (StrUtil.isBlank(numberStr)) {
			return BigDecimal.ZERO;
		}

		try {
			// 支持类似于 1,234.55 格式的数字
			final Number number = parseNumber(numberStr);
			if (number instanceof BigDecimal) {
				return (BigDecimal) number;
			} else {
				return new BigDecimal(number.toString());
			}
		} catch (Exception ignore) {
			// 忽略解析错误
		}

		return new BigDecimal(numberStr);
	}

	public static Number parseNumber(String numberStr) throws NumberFormatException {
		if (StrUtil.startWithIgnoreCase(numberStr, "0x")) {
			// 0x04表示16进制数
			return Long.parseLong(numberStr.substring(2), 16);
		}

		try {
			final NumberFormat format = NumberFormat.getInstance();
			if (format instanceof DecimalFormat) {
				// issue#1818@Github
				// 当字符串数字超出double的长度时，会导致截断，此处使用BigDecimal接收
				((DecimalFormat) format).setParseBigDecimal(true);
			}
			return format.parse(numberStr);
		} catch (ParseException e) {
			final NumberFormatException nfe = new NumberFormatException(e.getMessage());
			nfe.initCause(e);
			throw nfe;
		}
	}
}
