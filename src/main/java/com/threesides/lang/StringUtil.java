package com.threesides.lang;







import com.threesides.constant.pattern.RegexPattern;
import com.threesides.constant.text.CharTestConstant;
import com.threesides.constant.text.StringTextConstant;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * StringUtil
 *
 * @author Di Wu
 * @since 2023-02-27
 */
public class StringUtil {

	public static final int STRING_BUILDER_SIZE = 256;

	//-----------------------------------------------------------------------

	/**
	 * 是否是空白
	 * <p>例：</p>
	 * <ul>
	 *     <li>{@code StrUtil.isEmptyIfStr(null)     // true}</li>
	 *     <li>{@code StrUtil.isEmptyIfStr("")       // true}</li>
	 *     <li>{@code StrUtil.isEmptyIfStr(" ")      // true}</li>
	 *     <li>{@code StrUtil.isEmptyIfStr("abc")    // false}</li>
	 * </ul>
	 *
	 * @param cs cs
	 * @return true:是 、false:不是
	 *
	 * @since 2023-04-08
	 */
	public static boolean isBlank(final CharSequence cs) {
		final int strLen = length(cs);
		if (strLen == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 是否是空
	 * <p>例：</p>
	 * <ul>
	 *     <li>{@code StrUtil.isEmptyIfStr(null)     // true}</li>
	 *     <li>{@code StrUtil.isEmptyIfStr("")       // true}</li>
	 *     <li>{@code StrUtil.isEmptyIfStr(" ")      // false}</li>
	 *     <li>{@code StrUtil.isEmptyIfStr("abc")    // false}</li>
	 * </ul>
	 *
	 * @param cs cs
	 * @return true:是 、false:不是
	 *
	 * @since 2023-04-08
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}


	public static boolean isMixedCase(final CharSequence cs) {
		if (isEmpty(cs) || cs.length() == 1) {
			return false;
		}
		boolean containsUppercase = false;
		boolean containsLowercase = false;
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (containsUppercase && containsLowercase) {
				return true;
			} else if (Character.isUpperCase(cs.charAt(i))) {
				containsUppercase = true;
			} else if (Character.isLowerCase(cs.charAt(i))) {
				containsLowercase = true;
			}
		}
		return containsUppercase && containsLowercase;
	}


	public static boolean isPureNumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// public static boolean isIntegerNumeric(final CharSequence cs) {
	// 	if (isEmpty(cs)) {
	// 		return false;
	// 	}
	// 	Pattern pattern = Pattern.compile(RegexPattern.INTEGER_NUMERIC_PATTERN);
	// 	Matcher matcher = pattern.matcher(cs);
	// 	return matcher.matches();
	// }

	public static boolean isIntegerNumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		try {
			Long.parseLong(cs.toString());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// public static boolean isFloatingNumber(final CharSequence cs) {
	// 	if (isEmpty(cs)) {
	// 		return false;
	// 	}
	// 	Pattern pattern = Pattern.compile(RegexPattern.FLOATING_NUMBER_PATTERN);
	// 	Matcher matcher = pattern.matcher(cs);
	// 	return matcher.matches();
	// }

	public static boolean isFloatingNumber(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		try {
			Double.parseDouble(cs.toString());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean containsWhitespace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isWhitespace(cs.charAt(i))) {
				return true;
			}
		}
		return false;
	}


	public static boolean isWhitespace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}


	public static String join(final Object obj, final String separator) {
		if (obj == null) {
			return null;
		}
		return join( obj,separator,0, ObjectUtil.length(obj));
	}

	public static String join(final Object obj, final String separator, final int startIndex, final int endIndex) {
		if (obj == null) {
			return null;
		}
		if (obj instanceof long[]) {
			return join((long[]) obj,separator,startIndex, endIndex);
		} else if (obj instanceof int[]) {
			return join((int[]) obj,separator,startIndex, endIndex);
		} else if (obj instanceof short[]) {
			return join((short[]) obj,separator,startIndex, endIndex);
		} else if (obj instanceof char[]) {
			return join((char[]) obj,separator,startIndex, endIndex);
		} else if (obj instanceof byte[]) {
			return join((byte[]) obj,separator,startIndex, endIndex);
		} else if (obj instanceof boolean[]) {
			return join((boolean[]) obj,separator,startIndex, endIndex);
		} else if (obj instanceof float[]) {
			return join((float[]) obj,separator,startIndex, endIndex);
		} else if (obj instanceof double[]) {
			return join((double[]) obj,separator,startIndex, endIndex);
		} else if (ArrayUtil.isArray(obj)) {
			return join((Object[]) obj, separator, startIndex, endIndex);
		} else if (obj instanceof Collection) {
			return join((Collection) obj, separator, startIndex, endIndex);
		}
		return join((Object[]) obj,separator,startIndex, endIndex);
	}

	public static String join(final long[] array, final String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static String join(final int[] array, final String separator, final int startIndex, final int endIndex) {
		if (ArrayUtil.isEmpty(array)) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static String join(final short[] array, final String separator, final int startIndex, final int endIndex) {
		if (ArrayUtil.isEmpty(array)) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}
	public static String join(final char[] array, final String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static String join(final byte[] array, final String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}



	public static String join(final boolean[] array, final String separator, final int startIndex, final int endIndex) {

		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static String join(final float[] array, final String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static String join(final double[] array, final String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static String join(final Object[] array, final String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return StringTextConstant.EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		if (array[startIndex] != null) {
			buf.append(array[startIndex]);
		}
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
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


		final StringBuilder buf = new StringBuilder(STRING_BUILDER_SIZE);
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


	public static int length(final CharSequence cs) {
		return cs == null ? 0 : cs.length();
	}

	private static StringBuilder newStringBuilder(final int noOfItems) {
		return new StringBuilder(noOfItems * 16);
	}

	public static boolean startWithIgnoreEquals(CharSequence str, CharSequence prefix) {
		return startWith(str, prefix, false, true);
	}


	public static boolean startWithIgnoreCase(CharSequence str, CharSequence prefix) {
		return startWith(str, prefix, true);
	}

	public static boolean startWith(CharSequence str, CharSequence prefix, boolean ignoreCase) {
		return startWith(str, prefix, ignoreCase, false);
	}


	public static boolean startWith(CharSequence str, CharSequence prefix, boolean ignoreCase, boolean ignoreEquals) {
		if (null == str || null == prefix) {
			if (ignoreEquals) {
				return false;
			}
			return null == str && null == prefix;
		}

		boolean isStartWith = str.toString()
				.regionMatches(ignoreCase, 0, prefix.toString(), 0, prefix.length());

		if (isStartWith) {
			return (!ignoreEquals) || (!equals(str, prefix, ignoreCase));
		}
		return false;
	}

	public static boolean equals(String obj1, String obj2) {
		return equals(obj1, obj2, false);
	}
	public static boolean equals(CharSequence str1, CharSequence str2, boolean ignoreCase) {
		if (null == str1) {
			// 只有两个都为null才判断相等
			return str2 == null;
		}
		if (null == str2) {
			// 字符串2空，字符串1非空，直接false
			return false;
		}

		if (ignoreCase) {
			return str1.toString().equalsIgnoreCase(str2.toString());
		} else {
			return str1.toString().contentEquals(str2);
		}
	}

	public static String format(final String strPattern, final Object... argArray) {
		if (StringUtil.isBlank(strPattern) || ArrayUtil.isEmpty(argArray)) {
			return strPattern;
		}
		final int strPatternLength = strPattern.length();

		StringBuilder sbuf = new StringBuilder(strPatternLength + 50);

		int handledPosition = 0;// 记录已经处理到的位置
		int delimIndex;// 占位符所在位置
		for (int argIndex = 0; argIndex < argArray.length; argIndex++) {
			delimIndex = strPattern.indexOf(StringTextConstant.EMPTY_JSON, handledPosition);
			if (delimIndex == -1) {// 剩余部分无占位符
				if (handledPosition == 0) { // 不带占位符的模板直接返回
					return strPattern;
				}
				// 字符串模板剩余部分不再包含占位符，加入剩余部分后返回结果
				sbuf.append(strPattern, handledPosition, strPatternLength);
				return sbuf.toString();
			}

			// 转义符
			if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == CharTestConstant.BACKSLASH) {// 转义符
				if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == CharTestConstant.BACKSLASH) {// 双转义符
					// 转义符之前还有一个转义符，占位符依旧有效
					sbuf.append(strPattern, handledPosition, delimIndex - 1);
					sbuf.append(objectToUFTF8String(argArray[argIndex]));
					handledPosition = delimIndex + 2;
				} else {
					// 占位符被转义
					argIndex--;
					sbuf.append(strPattern, handledPosition, delimIndex - 1);
					sbuf.append(StringTextConstant.DELIM_START);
					handledPosition = delimIndex + 1;
				}
			} else {// 正常占位符
				sbuf.append(strPattern, handledPosition, delimIndex);
				sbuf.append(objectToUFTF8String(argArray[argIndex]));
				handledPosition = delimIndex + 2;
			}
		}

		// append the characters following the last {} pair.
		// 加入最后一个占位符后所有的字符
		sbuf.append(strPattern, handledPosition, strPattern.length());

		return sbuf.toString();
	}

	public static String objectToUFTF8String(Object obj) {
		return objectToString(obj, StandardCharsets.UTF_8);
	}
	public static String objectToString(Object obj, Charset charset) {
		if (null == obj) {
			return null;
		}
		if (obj instanceof String) {
			return (String) obj;
		} else if (obj instanceof ByteBuffer) {
			return objectToString((ByteBuffer) obj,charset);
		} else if (ArrayUtil.isArray(obj)) {
			return ArrayUtil.toString(obj);
		}

		return obj.toString();
	}

	public static String objectToString(ByteBuffer data, Charset charset) {
		if (null == charset) {
			charset = Charset.defaultCharset();
		}
		return charset.decode(data).toString();
	}

	// public static String objectToString(Byte[] data, Charset charset) {
	// 	if (data == null) {
	// 		return null;
	// 	}
	//
	// 	byte[] bytes = new byte[data.length];
	// 	Byte dataByte;
	// 	for (int i = 0; i < data.length; i++) {
	// 		dataByte = data[i];
	// 		bytes[i] = (null == dataByte) ? -1 : dataByte;
	// 	}
	//
	// 	return objectToString(bytes, charset);
	// }
	//
	// public static String objectToString(byte[] data, Charset charset) {
	// 	if (data == null) {
	// 		return null;
	// 	}
	//
	// 	if (null == charset) {
	// 		return new String(data);
	// 	}
	// 	return new String(data, charset);
	// }

}
