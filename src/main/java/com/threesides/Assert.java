package com.threesides;




import com.threesides.collection.CollectionUtil;
import com.threesides.lang.ArrayUtil;
import com.threesides.lang.ObjectUtil;
import com.threesides.lang.StringUtil;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Assert
 *
 * @author Di Wu
 * @since 2023-04-03
 */
public class Assert {

	private static final String TEMPLATE_VALUE_MUST_BE_BETWEEN_AND = "The value must be between {} and {}.";

	public static <X extends Throwable> void isTrue(boolean expression, Supplier<? extends X> supplier) throws X {
		if (!expression) {
			throw supplier.get();
		}
	}

	public static void isTrue(boolean expression, String errorMsgTemplate) throws IllegalArgumentException {
		isTrue(expression, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static void isTrue(boolean expression) throws IllegalArgumentException {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}

	public static <X extends Throwable> void isFalse(boolean expression, Supplier<X> errorSupplier) throws X {
		if (expression) {
			throw errorSupplier.get();
		}
	}

	public static void isFalse(boolean expression, String errorMsgTemplate) throws IllegalArgumentException {
		isFalse(expression, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static void isFalse(boolean expression) throws IllegalArgumentException {
		isFalse(expression, "[Assertion failed] - this expression must be false");
	}


	public static <X extends Throwable> void isNull(Object object, Supplier<X> errorSupplier) throws X {
		if (null != object) {
			throw errorSupplier.get();
		}
	}

	public static void isNull(Object object, String errorMsgTemplate) throws IllegalArgumentException {
		isNull(object, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static void isNull(Object object) throws IllegalArgumentException {
		isNull(object, "[Assertion failed] - the object argument must be null");
	}


	public static <T, X extends Throwable> T notNull(T object, Supplier<X> errorSupplier) throws X {
		if (null == object) {
			throw errorSupplier.get();
		}
		return object;
	}


	public static <T> T notNull(T object, String errorMsgTemplate) throws IllegalArgumentException {
		return notNull(object, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <T> T notNull(T object) throws IllegalArgumentException {
		return notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}


	public static <T extends CharSequence, X extends Throwable> T notEmpty(T text, Supplier<X> errorSupplier) throws X {
		if (StringUtil.isEmpty(text)) {
			throw errorSupplier.get();
		}
		return text;
	}


	public static <T extends CharSequence> T notEmpty(T text, String errorMsgTemplate) throws IllegalArgumentException {
		return notEmpty(text, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <T extends CharSequence> T notEmpty(T text) throws IllegalArgumentException {
		return notEmpty(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
	}


	public static <T extends CharSequence, X extends Throwable> T notBlank(T text, Supplier<X> errorMsgSupplier) throws X {
		if (StringUtil.isBlank(text)) {
			throw errorMsgSupplier.get();
		}
		return text;
	}


	public static <T extends CharSequence> T notBlank(T text, String errorMsgTemplate) throws IllegalArgumentException {
		return notBlank(text, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <T extends CharSequence> T notBlank(T text) throws IllegalArgumentException {
		return notBlank(text, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
	}


	public static <T extends CharSequence, X extends Throwable> T notContain(CharSequence textToSearch, T substring, Supplier<X> errorSupplier) throws X {
		if (textToSearch.toString().contains(substring)) {

			return substring;
		}
		return (T) "";
	}


	public static String notContain(String textToSearch, String substring, String errorMsgTemplate) throws IllegalArgumentException {
		return notContain(textToSearch, substring, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static String notContain(String textToSearch, String substring) throws IllegalArgumentException {
		return notContain(textToSearch, substring, "[Assertion failed] - this String argument must not contain the substring [{}]");
	}


	public static <T, X extends Throwable> T[] notEmpty(T[] array, Supplier<X> errorSupplier) throws X {
		if (ArrayUtil.isEmpty(array)) {
			throw errorSupplier.get();
		}
		return array;
	}


	public static <T> T[] notEmpty(T[] array, String errorMsgTemplate) throws IllegalArgumentException {
		return notEmpty(array, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <T> T[] notEmpty(T[] array) throws IllegalArgumentException {
		return notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
	}


	public static <T, X extends Throwable> T[] noNullElements(T[] array, Supplier<X> errorSupplier) throws X {
		// if (ArrayUtil.hasNull(array)) {
		// 	throw errorSupplier.get();
		// }
		return array;
	}


	public static <T> T[] noNullElements(T[] array, String errorMsgTemplate) throws IllegalArgumentException {
		return noNullElements(array, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <T> T[] noNullElements(T[] array) throws IllegalArgumentException {
		return noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
	}


	public static <E, T extends Iterable<E>, X extends Throwable> T notEmpty(T collection, Supplier<X> errorSupplier) throws X {
		if (CollectionUtil.isEmpty(collection)) {
			throw errorSupplier.get();
		}
		return collection;
	}


	public static <E, T extends Iterable<E>> T notEmpty(T collection, String errorMsgTemplate) throws IllegalArgumentException {
		return notEmpty(collection, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <E, T extends Iterable<E>> T notEmpty(T collection) throws IllegalArgumentException {
		return notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
	}


	public static <K, V, T extends Map<K, V>, X extends Throwable> T notEmpty(T map, Supplier<X> errorSupplier) throws X {
		if (CollectionUtil.isEmpty(map)) {
			throw errorSupplier.get();
		}
		return map;
	}


	public static <K, V, T extends Map<K, V>> T notEmpty(T map, String errorMsgTemplate) throws IllegalArgumentException {
		return notEmpty(map, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <K, V, T extends Map<K, V>> T notEmpty(T map) throws IllegalArgumentException {
		return notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
	}


	public static <T> T isInstanceOf(Class<?> type, T obj) {
		return isInstanceOf(type, obj, "Object [{}] is not instanceof [{}]");
	}


	public static <T> T isInstanceOf(Class<?> type, T obj, String errorMsgTemplate) throws IllegalArgumentException {
		notNull(type, "Type to check against must not be null");
		if (false == type.isInstance(obj)) {
			throw new IllegalArgumentException(errorMsgTemplate);
		}
		return obj;
	}


	public static void isAssignable(Class<?> superType, Class<?> subType) throws IllegalArgumentException {
		isAssignable(superType, subType, "{} is not assignable to {})");
	}


	public static void isAssignable(Class<?> superType, Class<?> subType, String errorMsgTemplate) throws IllegalArgumentException {
		notNull(superType, "Type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw new IllegalArgumentException(errorMsgTemplate);
		}
	}


	public static void state(boolean expression, Supplier<String> errorMsgSupplier) throws IllegalStateException {
		if (false == expression) {
			throw new IllegalStateException(errorMsgSupplier.get());
		}
	}


	public static void state(boolean expression, String errorMsgTemplate) throws IllegalStateException {
		if (false == expression) {
			throw new IllegalStateException(errorMsgTemplate);
		}
	}


	public static void state(boolean expression) throws IllegalStateException {
		state(expression, "[Assertion failed] - this state invariant must be true");
	}


	public static int checkIndex(int index, int size) throws IllegalArgumentException, IndexOutOfBoundsException {
		return checkIndex(index, size, "[Assertion failed]");
	}


	public static int checkIndex(int index, int size, String errorMsgTemplate, Object... params) throws IllegalArgumentException, IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(badIndexMsg(index, size, errorMsgTemplate, params));
		}
		return index;
	}


	public static <X extends Throwable> int checkBetween(int value, int min, int max, Supplier<? extends X> errorSupplier) throws X {
		if (value < min || value > max) {
			throw errorSupplier.get();
		}

		return value;
	}


	public static int checkBetween(int value, int min, int max, String errorMsgTemplate) {
		return checkBetween(value, min, max, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static int checkBetween(int value, int min, int max) {
		return checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}


	public static <X extends Throwable> long checkBetween(long value, long min, long max, Supplier<? extends X> errorSupplier) throws X {
		if (value < min || value > max) {
			throw errorSupplier.get();
		}

		return value;
	}


	public static long checkBetween(long value, long min, long max, String errorMsgTemplate) {
		return checkBetween(value, min, max, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static long checkBetween(long value, long min, long max) {
		return checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}


	public static <X extends Throwable> double checkBetween(double value, double min, double max, Supplier<? extends X> errorSupplier) throws X {
		if (value < min || value > max) {
			throw errorSupplier.get();
		}

		return value;
	}


	public static double checkBetween(double value, double min, double max, String errorMsgTemplate) {
		return checkBetween(value, min, max, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static double checkBetween(double value, double min, double max) {
		return checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}


	public static Number checkBetween(Number value, Number min, Number max) {
		notNull(value);
		notNull(min);
		notNull(max);
		double valueDouble = value.doubleValue();
		double minDouble = min.doubleValue();
		double maxDouble = max.doubleValue();
		if (valueDouble < minDouble || valueDouble > maxDouble) {
			throw new IllegalArgumentException(TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
		}
		return value;
	}


	public static void notEquals(Object obj1, Object obj2) {
		notEquals(obj1, obj2, "({}) must be not equals ({})");
	}


	public static void notEquals(Object obj1, Object obj2, String errorMsgTemplate) throws IllegalArgumentException {
		notEquals(obj1, obj2, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <X extends Throwable> void notEquals(Object obj1, Object obj2, Supplier<X> errorSupplier) throws X {
		if (ObjectUtil.equals(obj1, obj2)) {
			throw errorSupplier.get();
		}
	}

	public static void equals(Object obj1, Object obj2) {
		equals(obj1, obj2, "({}) must be equals ({})");
	}


	public static void equals(Object obj1, Object obj2, String errorMsgTemplate) throws IllegalArgumentException {
		equals(obj1, obj2, () -> new IllegalArgumentException(errorMsgTemplate));
	}


	public static <X extends Throwable> void equals(Object obj1, Object obj2, Supplier<X> errorSupplier) throws X {
		if (ObjectUtil.notEqual(obj1, obj2)) {
			throw errorSupplier.get();
		}
	}


	private static String badIndexMsg(int index, int size, String desc, Object... params) {
		if (index < 0) {
			return "{} ({}) must not be negative";
		} else if (size < 0) {
			throw new IllegalArgumentException("negative size: " + size);
		} else { // index >= size
			return "{} ({}) must be less than size ({})";
		}
	}
}
