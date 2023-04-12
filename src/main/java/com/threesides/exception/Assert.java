package com.threesides.exception;




import com.threesides.collection.CollectionUtil;
import com.threesides.lang.ArrayUtil;
import com.threesides.lang.ObjectUtil;
import com.threesides.lang.StringUtil;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Assert 断言
 *
 * @author Di Wu
 * @since 2023-04-03
 */
public abstract class Assert {

	private static final String TEMPLATE_VALUE_MUST_BE_BETWEEN_AND = "The value must be between {} and {}.";

	public static void isTrue(boolean expression) {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}

	public static  void isTrue(boolean expression,String errorMsgTemplate ){
		if (!expression) {
			throw new BusinessException(errorMsgTemplate);
		}
	}

	public static void isTrue(boolean expression, String errorCode, String errMessage) {
		if (!expression) {
			throw new BusinessException(errorCode, errMessage);
		}
	}

	public static void isFalse(boolean expression) {
		isFalse(expression, "[Assertion failed] - this expression must be false");
	}

	public static void isFalse(boolean expression, String errorMsgTemplate) {
		if (expression) {
			throw new BusinessException(errorMsgTemplate);
		}
	}

	public static void isFalse(boolean expression,String errorCode, String errorMsgTemplate) throws IllegalArgumentException {
		if (expression) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}


	public static void isNull(Object object) {
		isNull(object, "[Assertion failed] - the object argument must be null");
	}

	public static void isNull(Object object, String errorMsgTemplate)  {
		if (ObjectUtil.isNotNull(object)) {
			throw new BusinessException(errorMsgTemplate);
		}
	}

	public static void isNull(Object object,String errorCode ,String errorMsgTemplate)  {
		if (ObjectUtil.isNotNull(object)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}

	public static void notNull(Object object) {
		 notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}

	public static void notNull(Object object, String errorMsgTemplate) {
		if (ObjectUtil.isNull(object)) {
			throw new BusinessException(errorMsgTemplate);
		}
	}


	public static void notNull(Object object,String errorCode , String errorMsgTemplate) {
		if (ObjectUtil.isNull(object)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}

	public static void notEmpty(Object text) {
		notEmpty(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
	}

	public static void notEmpty(Object text, String errorMsgTemplate) {
		if (ObjectUtil.isEmpty(text)) {
			throw new BusinessException(errorMsgTemplate);
		}
	}


	public static void notEmpty(Object text,String errorCode , String errorMsgTemplate) {
		if (ObjectUtil.isEmpty(text)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}

	public static void notBlank(String text) {
		 notBlank(text, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
	}

	public static void notBlank(String text, String errorMsgTemplate) {
		if (StringUtil.isBlank(text)) {
			throw new BusinessException(errorMsgTemplate);
		}

	}


	public static void notBlank(String text,String errorCode , String errorMsgTemplate) {
		if (StringUtil.isBlank(text)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}


	public static void notContain(String textToSearch, String substring){
		notContain(textToSearch, substring, "[Assertion failed] - this String argument must not contain the substring [{}]");
	}


	public static void notContain(CharSequence textToSearch, CharSequence substring, String errorMsgTemplate)  {
		if (!textToSearch.toString().contains(substring)) {
			throw new BusinessException(errorMsgTemplate);
		}

	}


	public static void notContain(CharSequence textToSearch, CharSequence substring,String errorCode , String errorMsgTemplate)  {
		if (!textToSearch.toString().contains(substring)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}


	public static void notEmpty(Object[] array) throws IllegalArgumentException {
		notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
	}


	public static void  notEmpty(Object[] array, String errorMsgTemplate) {
		if (ArrayUtil.isEmpty(array)) {
			throw new BusinessException(errorMsgTemplate);
		}
	}

	public static void  notEmpty(Object[] array,String errorCode , String errorMsgTemplate) {
		if (ArrayUtil.isEmpty(array)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}


	public static void noNullElements(Object[] array) {
		 noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
	}


	public static void noNullElements(Object[] array,  String errorMsgTemplate)  {
		if (ArrayUtil.containsEmptyElements(array)) {
			throw new BusinessException(errorMsgTemplate);
		}

	}

	public static void noNullElements(Object[] array,String errorCode ,  String errorMsgTemplate)  {
		if (ArrayUtil.containsEmptyElements(array)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}

	public static void notEmpty(Collection<?> collection) throws IllegalArgumentException {
		notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
	}

	public static void notEmpty(Collection<?> collection, String errorMsgTemplate)  {
		if (CollectionUtil.isEmpty(collection)) {
			throw new BusinessException(errorMsgTemplate);
		}

	}

	public static void notEmpty(Collection<?> collection,String errorCode , String errorMsgTemplate)  {
		if (CollectionUtil.isEmpty(collection)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}

	}


	public static void notEmpty(Map<?, ?> map){
		 notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
	}


	public static void notEmpty( Map<?, ?> map, String errorMsgTemplate)   {
		if (CollectionUtil.isEmpty(map)) {
			throw new BusinessException(errorMsgTemplate);
		}
	}

	public static void notEmpty( Map<?, ?> map,String errorCode , String errorMsgTemplate)   {
		if (CollectionUtil.isEmpty(map)) {
			throw new BusinessException(errorMsgTemplate,errorCode);
		}
	}




	public static void isInstanceOf(Class<?> type, Object obj) {
		 isInstanceOf(type, obj, "Object [{}] is not instanceof [{}]");
	}


	public static void isInstanceOf(Class<?> type, Object obj, String errorMsgTemplate){
		notNull(type, "Type to check against must not be null");
		if (!type.isInstance(obj)) {
			throw new BusinessException(errorMsgTemplate);
		}
	}


	public static void isAssignable(Class<?> superType, Class<?> subType){
		isAssignable(superType, subType, "{} is not assignable to {})");
	}


	public static void isAssignable(Class<?> superType, Class<?> subType, String errorMsgTemplate){
		notNull(superType, "Type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw new BusinessException(StringUtil.format(errorMsgTemplate, superType,subType));
		}
	}




	public static void checkIndex(int index, int size) {
		checkIndex(index, size, "[Assertion failed]");
	}


	public static void checkIndex(int index, int size, String errorMsgTemplate)  {
		if (index < 0 || index >= size) {
			badIndexMsg(index, size, errorMsgTemplate);
		}

	}


	public static void checkBetween(int value, int min, int max, String errorMsgTemplate) {
		if (value < min || value > max) {
			throw new BusinessException(errorMsgTemplate);
		}

	}


	public static void checkBetween(int value, int min, int max) {
		 checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}


	public static void  checkBetween(long value, long min, long max, String errorMsgTemplate) {
		if (value < min || value > max) {
			throw new BusinessException(errorMsgTemplate);
		}
	}


	public static void checkBetween(long value, long min, long max) {
		 checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}


	public static void checkBetween(double value, double min, double max, String errorMsgTemplate) {
		if (value < min || value > max) {
			throw new BusinessException(errorMsgTemplate);
		}
	}

	public static void checkBetween(double value, double min, double max) {
		 checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}


	public static void checkBetween(Number value, Number min, Number max) {
		notNull(value);
		notNull(min);
		notNull(max);
		double valueDouble = value.doubleValue();
		double minDouble = min.doubleValue();
		double maxDouble = max.doubleValue();
		if (valueDouble < minDouble || valueDouble > maxDouble) {
			throw new BusinessException(TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
		}
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


	private static void badIndexMsg(int index, int size, String errorMsgTemplate) {
		if (index < 0) {
			throw new BusinessException(" must not be negative"+errorMsgTemplate);
		} else if (size < 0) {
			throw new BusinessException("size must not be negative: " + size);
		} else { // index >= size
			throw new BusinessException(" must be less than size"+errorMsgTemplate);
		}
	}
}
