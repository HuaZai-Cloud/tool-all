package com.threesides.lang;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ArrayUtil 数组工具
 *
 * @author Di Wu
 * @since 2023-03-21
 */
public class ArrayUtil {

	/**
	 * 是否是数组
	 *
	 * @param obj 对象
	 * @return true：是 、false：不是
	 *
	 * @since 2023-04-08
	 */
	public static boolean isArray(Object obj) {
		return null != obj && obj.getClass().isArray();
	}

	/**
	 * 很空
	 *
	 * @param array 对象
	 * @return true：是、false：不是
	 *
	 * @since 2023-04-08
	 */
	public static boolean isEmpty(Object array) {
		if (array != null) {
			if (isArray(array)) {
				return 0 == Array.getLength(array);
			}
			return false;
		}
		return true;
	}

	/**
	 * 包含空元素
	 *
	 * @param array 对象
	 * @return true：包含、false：不包含
	 *
	 * @since 2023-04-08
	 */
	public static boolean containsEmptyElements(Object array){
		if (isArray(array)) {
			int len = Array.getLength(array);
			for(int i = 0; i < len; i++) {
				if (Array.get(array, i) == null) {
					return true;
				}
			}
			return false;
		}
		return array == null;
	}

	/**
	 * 转字符串
	 *
	 * @param obj 对象
	 * @return 字符串
	 *
	 * @since 2023-04-08
	 */
	public static String toString(Object obj) {
		if (null == obj) {
			return null;
		}
		if (obj instanceof long[]) {
			return Arrays.toString((long[]) obj);
		} else if (obj instanceof int[]) {
			return Arrays.toString((int[]) obj);
		} else if (obj instanceof short[]) {
			return Arrays.toString((short[]) obj);
		} else if (obj instanceof char[]) {
			return Arrays.toString((char[]) obj);
		} else if (obj instanceof byte[]) {
			return Arrays.toString((byte[]) obj);
		} else if (obj instanceof boolean[]) {
			return Arrays.toString((boolean[]) obj);
		} else if (obj instanceof float[]) {
			return Arrays.toString((float[]) obj);
		} else if (obj instanceof double[]) {
			return Arrays.toString((double[]) obj);
		} else if (ArrayUtil.isArray(obj)) {
			// 对象数组
			try {
				return Arrays.deepToString((Object[]) obj);
			} catch (Exception ignore) {
				//ignore
			}
		}
		return obj.toString();
	}
}
