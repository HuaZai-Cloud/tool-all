package com.threesides.lang;

import com.threesides.collection.CollectionUtil;
import com.threesides.math.NumberUtil;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

/**
 * ObjectUtil
 *
 * @author Di Wu
 * @since 2023-02-27
 */
public class ObjectUtil {

	public static boolean equals(Object obj1, Object obj2) {
		if (obj1 instanceof BigDecimal && obj2 instanceof BigDecimal) {
			return NumberUtil.equals((BigDecimal) obj1, (BigDecimal) obj2);
		}
		return Objects.equals(obj1, obj2);
	}

	public static boolean notEqual(Object obj1, Object obj2) {
		return !equals(obj1, obj2);
	}

	public static int length(Object obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof CharSequence) {
			return ((CharSequence) obj).length();
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).size();
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).size();
		}

		int count;
		if (obj instanceof Iterator) {
			Iterator<?> iter = (Iterator<?>) obj;
			count = 0;
			while (iter.hasNext()) {
				count++;
				iter.next();
			}
			return count;
		}
		if (obj instanceof Enumeration) {
			Enumeration<?> enumeration = (Enumeration<?>) obj;
			count = 0;
			while (enumeration.hasMoreElements()) {
				count++;
				enumeration.nextElement();
			}
			return count;
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj);
		}
		return -1;
	}


	public static boolean contains(Object obj, Object element) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof String) {
			if (element == null) {
				return false;
			}
			return ((String) obj).contains(element.toString());
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).contains(element);
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).containsValue(element);
		}

		if (obj instanceof Iterator) {
			Iterator<?> iter = (Iterator<?>) obj;
			while (iter.hasNext()) {
				Object o = iter.next();
				if (equals(o, element)) {
					return true;
				}
			}
			return false;
		}
		if (obj instanceof Enumeration) {
			Enumeration<?> enumeration = (Enumeration<?>) obj;
			while (enumeration.hasMoreElements()) {
				Object o = enumeration.nextElement();
				if (equals(o, element)) {
					return true;
				}
			}
			return false;
		}
		if (obj.getClass().isArray()) {
			int len = Array.getLength(obj);
			for (int i = 0; i < len; i++) {
				Object o = Array.get(obj, i);
				if (equals(o, element)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isNull(Object obj) {
		//noinspection ConstantConditions
		return null == obj || obj.equals(null);
	}

	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		}
		if (obj instanceof CharSequence) {
			return StringUtil.isEmpty((CharSequence) obj);
		} else if (obj instanceof Map) {
			return CollectionUtil.isEmpty((Map) obj);
		} else if (obj instanceof Iterable) {
			return CollectionUtil.isEmpty((Iterable) obj);
		} else if (obj instanceof Iterator) {
			return CollectionUtil.isEmpty((Iterator) obj);
		} else if (ArrayUtil.isArray(obj)) {
			return ArrayUtil.isEmpty(obj);
		}
		return false;
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

}
