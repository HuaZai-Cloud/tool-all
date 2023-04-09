package com.threesides.collection;


import com.threesides.constant.text.StringTextConstant;
import com.threesides.lang.StringUtil;

import java.util.*;

/**
 * CollectionUtil 集合工具
 *
 * @author Di Wu
 * @since 2023-02-27
 */
public class CollectionUtil {

	/**
	 * 集合是否为空
	 *
	 * @param collection 集合
	 * @return true：空 false：不是空
	 *
	 * @since 2023-04-08
	 */
	public static boolean isEmpty(final Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * 集合是否不是空
	 *
	 * @param collection 集合
	 * @return true：不是空 false：是空
	 *
	 * @since 2023-04-08
	 */
	public static boolean isNotEmpty(final Collection<?> collection) {
		return !isEmpty(collection);
	}

	/**
	 * Map是否为空
	 *
	 * @param map map
	 * @return true：空 false：不是空
	 *
	 * @since 2023-04-08
	 */
	public static boolean isEmpty( Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	/**
	 * Map是否不是空
	 *
	 * @param map map
	 * @return true：不是空 false：是空
	 *
	 * @since 2023-04-08
	 */
	public static boolean isNotEmpty( Map<?, ?> map) {
		return !isEmpty(map);
	}

	/**
	 * Iterable是否为空
	 *
	 * @param iterable iterable
	 * @return true：空 false：不是空
	 *
	 * @since 2023-04-08
	 */
	public static boolean isEmpty(Iterable<?> iterable) {
		return null == iterable || isEmpty(iterable.iterator());
	}

	/**
	 * Iterator是否为空
	 *
	 * @param iterator iterator
	 * @return true：空 false：不是空
	 *
	 * @since 2023-04-08
	 */
	public static boolean isEmpty(Iterator<?> iterator) {
		return null == iterator || !iterator.hasNext();
	}

	/**
	 *
	 *
	 * @param collection
	 * @return
	 *
	 * @since 2023-04-09
	 */
	public static String toString(final Collection<?> collection) {
		return join(collection,",",0,collection.size());
	}

	public static String toString(final Map<?, ?> map) {
		String separator = ",";
		String keyValueSeparator = ":";
		return join(map, separator, keyValueSeparator);
	}

	private static String join(Map<?, ?> map, String separator, String keyValueSeparator) {
		Iterator<? extends Map.Entry<?, ?>> iterator = map.entrySet().iterator();

		if (!iterator.hasNext()) {
			return "{}";
		}
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		while (iterator.hasNext()){
			Map.Entry<?, ?> e = iterator.next();
			Object key = e.getKey();
			Object value = e.getValue();
			sb.append(key);
			sb.append(keyValueSeparator);
			sb.append(value);
			if (!iterator.hasNext())
				return sb.append('}').toString();
			sb.append(separator);
		}
		return sb.toString();
	}

	public static String join(final Collection<?> collection, final String separator, final int startIndex, final int endIndex) {
		if (collection == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		return join(collection.iterator(), separator);
	}

	private static String join(final Iterator<?> iterator, final String separator) {

		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return StringTextConstant.EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {
			return Objects.toString(first, StringTextConstant.EMPTY);
		}

		final StringBuilder buf = new StringBuilder(StringUtil.STRING_BUILDER_SIZE);
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			buf.append(separator);
			final Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}

		return buf.toString();
	}
}
