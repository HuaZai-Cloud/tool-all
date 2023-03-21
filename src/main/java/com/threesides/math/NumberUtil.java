package com.threesides.math;

import java.math.BigDecimal;

/**
 * NumberUtil
 *
 * @author Di Wu
 * @since 2023-03-21
 */
public class NumberUtil {

	public static boolean equals(BigDecimal bigNum1, BigDecimal bigNum2) {
		//noinspection NumberEquality
		if (bigNum1 == bigNum2) {
			// 如果用户传入同一对象，省略compareTo以提高性能。
			return true;
		}
		if (bigNum1 == null || bigNum2 == null) {
			return false;
		}
		return 0 == bigNum1.compareTo(bigNum2);
	}
}
