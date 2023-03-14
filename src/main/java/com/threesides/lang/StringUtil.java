package com.threesides.lang;


import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * StringUtil
 *
 * @author Di Wu
 * @since 2023-02-27
 */
public class StringUtil {

	private static final int STRING_BUILDER_SIZE = 256;

	public static final String SPACE = " ";

	public static final String EMPTY = "";

	//-----------------------------------------------------------------------

	/**
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 *
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
	 *
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 *
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 *
	 * <pre>
	 * StringUtils.isNotBlank(null)      = false
	 * StringUtils.isNotBlank("")        = false
	 * StringUtils.isNotBlank(" ")       = false
	 * StringUtils.isNotBlank("bob")     = true
	 * StringUtils.isNotBlank("  bob  ") = true
	 * </pre>
	 *
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	/**
	 * <pre>
	 * StringUtils.isNotEmpty(null)      = false
	 * StringUtils.isNotEmpty("")        = false
	 * StringUtils.isNotEmpty(" ")       = true
	 * StringUtils.isNotEmpty("bob")     = true
	 * StringUtils.isNotEmpty("  bob  ") = true
	 * </pre>
	 *
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}

	/**
	 * <pre>
	 * StringUtils.isMixedCase(null)    = false
	 * StringUtils.isMixedCase("")      = false
	 * StringUtils.isMixedCase("ABC")   = false
	 * StringUtils.isMixedCase("abc")   = false
	 * StringUtils.isMixedCase("aBc")   = true
	 * StringUtils.isMixedCase("A c")   = true
	 * StringUtils.isMixedCase("A1c")   = true
	 * StringUtils.isMixedCase("a/C")   = true
	 * StringUtils.isMixedCase("aC\t")  = true
	 * </pre>
	 *
	 */
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


	/**
	 *
	 * <pre>
	 * StringUtils.isNumeric(null)   = false
	 * StringUtils.isNumeric("")     = false
	 * StringUtils.isNumeric("  ")   = false
	 * StringUtils.isNumeric("123")  = true
	 * StringUtils.isNumeric("\u0967\u0968\u0969")  = true
	 * StringUtils.isNumeric("12 3") = false
	 * StringUtils.isNumeric("ab2c") = false
	 * StringUtils.isNumeric("12-3") = false
	 * StringUtils.isNumeric("12.3") = false
	 * StringUtils.isNumeric("-123") = false
	 * StringUtils.isNumeric("+123") = false
	 * </pre>
	 */
	public static boolean isNumeric(final CharSequence cs) {
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

	/**
	 * <pre>
	 * StringUtils.isNumericSpace(null)   = false
	 * StringUtils.isNumericSpace("")     = true
	 * StringUtils.isNumericSpace("  ")   = true
	 * StringUtils.isNumericSpace("123")  = true
	 * StringUtils.isNumericSpace("12 3") = true
	 * StringUtils.isNumeric("\u0967\u0968\u0969")  = true
	 * StringUtils.isNumeric("\u0967\u0968 \u0969")  = true
	 * StringUtils.isNumericSpace("ab2c") = false
	 * StringUtils.isNumericSpace("12-3") = false
	 * StringUtils.isNumericSpace("12.3") = false
	 * </pre>
	 */
	public static boolean isNumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * <pre>
	 * StringUtils.isWhitespace(null)   = false
	 * StringUtils.isWhitespace("")     = true
	 * StringUtils.isWhitespace("  ")   = true
	 * StringUtils.isWhitespace("abc")  = false
	 * StringUtils.isWhitespace("ab2c") = false
	 * StringUtils.isWhitespace("ab-c") = false
	 * </pre>
	 */
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

	/**
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 */
	public static String join(final byte[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final byte[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final char[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 *
	 */
	public static String join(final char[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final double[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**

	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final double[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final float[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final float[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final int[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final int[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <p>Joins the elements of the provided {@code Iterable} into
	 * a single String containing the provided elements.</p>
	 *
	 * <p>No delimiter is added before or after the list. Null objects or empty
	 * strings within the iteration are represented by empty strings.</p>
	 *
	 * <p>See the examples here: {@link #join(Object[],char)}. </p>
	 *
	 * @param iterable  the {@code Iterable} providing the values to join together, may be null
	 * @param separator  the separator character to use
	 * @return the joined String, {@code null} if null iterator input
	 * @since 2.3
	 */
	public static String join(final Iterable<?> iterable, final char separator) {
		if (iterable == null) {
			return null;
		}
		return join(iterable.iterator(), separator);
	}

	/**
	 * <p>Joins the elements of the provided {@code Iterable} into
	 * a single String containing the provided elements.</p>
	 *
	 * <p>No delimiter is added before or after the list.
	 * A {@code null} separator is the same as an empty String ("").</p>
	 *
	 * <p>See the examples here: {@link #join(Object[],String)}. </p>
	 *
	 * @param iterable  the {@code Iterable} providing the values to join together, may be null
	 * @param separator  the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null iterator input
	 * @since 2.3
	 */
	public static String join(final Iterable<?> iterable, final String separator) {
		if (iterable == null) {
			return null;
		}
		return join(iterable.iterator(), separator);
	}

	/**
	 * <p>Joins the elements of the provided {@code Iterator} into
	 * a single String containing the provided elements.</p>
	 *
	 * <p>No delimiter is added before or after the list. Null objects or empty
	 * strings within the iteration are represented by empty strings.</p>
	 *
	 * <p>See the examples here: {@link #join(Object[],char)}. </p>
	 *
	 * @param iterator  the {@code Iterator} of values to join together, may be null
	 * @param separator  the separator character to use
	 * @return the joined String, {@code null} if null iterator input
	 * @since 2.0
	 */
	public static String join(final Iterator<?> iterator, final char separator) {

		// handle null, zero and one elements before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {
			return Objects.toString(first, EMPTY);
		}

		// two or more elements
		final StringBuilder buf = new StringBuilder(STRING_BUILDER_SIZE); // Java default is 16, probably too small
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

	/**
	 * <p>Joins the elements of the provided {@code Iterator} into
	 * a single String containing the provided elements.</p>
	 *
	 * <p>No delimiter is added before or after the list.
	 * A {@code null} separator is the same as an empty String ("").</p>
	 *
	 * <p>See the examples here: {@link #join(Object[],String)}. </p>
	 *
	 * @param iterator  the {@code Iterator} of values to join together, may be null
	 * @param separator  the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null iterator input
	 */
	public static String join(final Iterator<?> iterator, final String separator) {

		// handle null, zero and one elements before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {
			return Objects.toString(first, "");
		}

		// two or more elements
		final StringBuilder buf = new StringBuilder(STRING_BUILDER_SIZE); // Java default is 16, probably too small
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			if (separator != null) {
				buf.append(separator);
			}
			final Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 */
	public static String join(final List<?> list, final char separator, final int startIndex, final int endIndex) {
		if (list == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final List<?> subList = list.subList(startIndex, endIndex);
		return join(subList.iterator(), separator);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 */
	public static String join(final List<?> list, final String separator, final int startIndex, final int endIndex) {
		if (list == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final List<?> subList = list.subList(startIndex, endIndex);
		return join(subList.iterator(), separator);
	}


	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final long[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final long[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 */
	public static String join(final Object[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 *
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
	 * StringUtils.join(["a", "b", "c"], null) = "abc"
	 * StringUtils.join([null, "", "a"], ';')  = ";;a"
	 * </pre>
	 */
	public static String join(final Object[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
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

	/**
	 * <pre>
	 * StringUtils.join(null, *)                = null
	 * StringUtils.join([], *)                  = ""
	 * StringUtils.join([null], *)              = ""
	 * StringUtils.join(["a", "b", "c"], "--")  = "a--b--c"
	 * StringUtils.join(["a", "b", "c"], null)  = "abc"
	 * StringUtils.join(["a", "b", "c"], "")    = "abc"
	 * StringUtils.join([null, "", "a"], ',')   = ",,a"
	 * </pre>
	 */
	public static String join(final Object[] array, final String separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *, *, *)                = null
	 * StringUtils.join([], *, *, *)                  = ""
	 * StringUtils.join([null], *, *, *)              = ""
	 * StringUtils.join(["a", "b", "c"], "--", 0, 3)  = "a--b--c"
	 * StringUtils.join(["a", "b", "c"], "--", 1, 3)  = "b--c"
	 * StringUtils.join(["a", "b", "c"], "--", 2, 3)  = "c"
	 * StringUtils.join(["a", "b", "c"], "--", 2, 2)  = ""
	 * StringUtils.join(["a", "b", "c"], null, 0, 3)  = "abc"
	 * StringUtils.join(["a", "b", "c"], "", 0, 3)    = "abc"
	 * StringUtils.join([null, "", "a"], ',', 0, 3)   = ",,a"
	 * </pre>
	 */
	public static String join(final Object[] array, String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		if (separator == null) {
			separator = EMPTY;
		}

		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
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

	/**

	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final short[] array, final char separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	/**
	 * <pre>
	 * StringUtils.join(null, *)               = null
	 * StringUtils.join([], *)                 = ""
	 * StringUtils.join([null], *)             = ""
	 * StringUtils.join([1, 2, 3], ';')  = "1;2;3"
	 * StringUtils.join([1, 2, 3], null) = "123"
	 * </pre>
	 */
	public static String join(final short[] array, final char separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return EMPTY;
		}
		final StringBuilder buf = newStringBuilder(noOfItems);
		buf.append(array[startIndex]);
		for (int i = startIndex + 1; i < endIndex; i++) {
			buf.append(separator);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static int length(final CharSequence cs) {
		return cs == null ? 0 : cs.length();
	}

	private static StringBuilder newStringBuilder(final int noOfItems) {
		return new StringBuilder(noOfItems * 16);
	}


}
