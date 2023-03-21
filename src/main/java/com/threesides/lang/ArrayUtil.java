package com.threesides.lang;

import java.lang.reflect.Array;

/**
 * ArrayUtil
 *
 * @author Di Wu
 * @since 2023-03-21
 */
public class ArrayUtil {

	public static boolean isArray(Object obj) {
		return null != obj && obj.getClass().isArray();
	}

	public static boolean isEmpty(Object array) {
		if (array != null) {
			if (isArray(array)) {
				return 0 == Array.getLength(array);
			}
			return false;
		}
		return true;
	}
}
