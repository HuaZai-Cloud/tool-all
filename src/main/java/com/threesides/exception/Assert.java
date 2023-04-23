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

	/**
	 * 是True
	 *
	 * @param expression 参数
	 *
	 * @since 2023-04-16
	 */
	public static void isTrue(boolean expression) {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}

	/**
	 * 是True
	 *
	 * @param expression 参数
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-17
	 */
	public static  void isTrue(boolean expression,String errorMessage ){
		if (!expression) {
			throw new BusinessException(errorMessage);
		}
	}

	/**
	 * 是True
	 *
	 * @param expression 参数
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-17
	 */
	public static void isTrue(boolean expression, Object errorCode, String errorMessage) {
		if (!expression) {
			throw new BusinessException( errorMessage,errorCode);
		}
	}

	/**
	 * 是False
	 *
	 * @param expression 参数
	 *
	 * @since 2023-04-17
	 */
	public static void isFalse(boolean expression) {
		isFalse(expression, "[Assertion failed] - this expression must be false");
	}

	/**
	 * 是False
	 *
	 * @param expression 参数
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-17
	 */
	public static void isFalse(boolean expression, String errorMessage) {
		if (expression) {
			throw new BusinessException(errorMessage);
		}
	}

	/**
	 * 是False
	 *
	 * @param expression 参数
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void isFalse(boolean expression,String errorCode, String errorMessage){
		if (expression) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}

	/**
	 * 是null
	 *
	 * @param object object
	 *
	 * @since 2023-04-18
	 */
	public static void isNull(Object object) {
		isNull(object, "[Assertion failed] - the object argument must be null");
	}

	/**
	 * 是Null
	 *
	 * @param object object
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void isNull(Object object, String errorMessage)  {
		if (ObjectUtil.isNotNull(object)) {
			throw new BusinessException(errorMessage);
		}
	}

	/**
	 * 是Null
	 *
	 * @param object object
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void isNull(Object object,String errorCode ,String errorMessage)  {
		if (ObjectUtil.isNotNull(object)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}

	/**
	 * 不是Null
	 *
	 * @param object object
	 *
	 * @since 2023-04-18
	 */
	public static void notNull(Object object) {
		 notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}

	/**
	 * 不是Null
	 *
	 * @param object object
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notNull(Object object, String errorMessage) {
		if (ObjectUtil.isNull(object)) {
			throw new BusinessException(errorMessage);
		}
	}


	/**
	 * 不是Null
	 *
	 * @param object object
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notNull(Object object,String errorCode , String errorMessage) {
		if (ObjectUtil.isNull(object)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}

	/**
	 * 不是空
	 * @param object object
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Object object) {
		notEmpty(object, "[Assertion failed] - this String argument must have length; it must not be null or empty");
	}

	/**
	 * 不是空
	 *
	 * @param object object
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Object object, String errorMessage) {
		if (ObjectUtil.isEmpty(object)) {
			throw new BusinessException(errorMessage);
		}
	}

	/**
	 * 不是空
	 *
	 * @param object object
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Object object,String errorCode , String errorMessage) {
		if (ObjectUtil.isEmpty(object)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}

	/**
	 * 不是空白
	 *
	 * @param string string
	 *
	 * @since 2023-04-18
	 */
	public static void notBlank(String string) {
		 notBlank(string, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
	}

	/**
	 * 不是空白
	 *
	 * @param string string
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notBlank(String string, String errorMessage) {
		if (StringUtil.isBlank(string)) {
			throw new BusinessException(errorMessage);
		}

	}


	/**
	 * 不是空台
	 *
	 * @param string string
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notBlank(String string,String errorCode , String errorMessage) {
		if (StringUtil.isBlank(string)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}

	/**
	 * 不是空
	 *
	 * @param collection collection
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Collection<?> collection){
		notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
	}

	/**
	 * 不是空
	 *
	 * @param collection collection
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Collection<?> collection, String errorMessage)  {
		if (CollectionUtil.isEmpty(collection)) {
			throw new BusinessException(errorMessage);
		}

	}

	/**
	 * 不是空
	 *
	 * @param collection collection
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Collection<?> collection,String errorCode , String errorMessage)  {
		if (CollectionUtil.isEmpty(collection)) {
			throw new BusinessException(errorMessage,errorCode);
		}

	}


	/**
	 * 不是空
	 *
	 * @param map map
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Map<?, ?> map){
		notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
	}

	/**
	 * 不是空
	 *
	 * @param map map
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty( Map<?, ?> map, String errorMessage)   {
		if (CollectionUtil.isEmpty(map)) {
			throw new BusinessException(errorMessage);
		}
	}

	/**
	 * 不是空
	 *
	 * @param map map
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty( Map<?, ?> map,String errorCode , String errorMessage)   {
		if (CollectionUtil.isEmpty(map)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}

	/**
	 * 不是空
	 *
	 * @param array 数组
	 *
	 * @since 2023-04-18
	 */
	public static void notEmpty(Object[] array)  {
		notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
	}

	/**
	 * 不是空
	 *
	 * @param array 数组
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void  notEmpty(Object[] array, String errorMessage) {
		if (ArrayUtil.isEmpty(array)) {
			throw new BusinessException(errorMessage);
		}
	}

	/**
	 * 不是空
	 *
	 * @param array 数组
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void  notEmpty(Object[] array,String errorCode , String errorMessage) {
		if (ArrayUtil.isEmpty(array)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}


	/**
	 * 不包含
	 *
	 * @param textToSearch 要搜索的文本
	 * @param substring 子字符串
	 *
	 * @since 2023-04-18
	 */
	public static void notContain(String textToSearch, String substring){
		notContain(textToSearch, substring, "[Assertion failed] - this String argument must not contain the substring [{}]");
	}

	/**
	 * 不包含
	 *
	 * @param textToSearch 要搜索的文本
	 * @param substring 子字符串
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notContain(CharSequence textToSearch, CharSequence substring, String errorMessage)  {
		if (!textToSearch.toString().contains(substring)) {
			throw new BusinessException(errorMessage);
		}

	}

	/**
	 * 不包含
	 *
	 * @param textToSearch 要搜索的文本
	 * @param substring 子字符串
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notContain(CharSequence textToSearch, CharSequence substring,String errorCode , String errorMessage)  {
		if (!textToSearch.toString().contains(substring)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}




	/**
	 * 没有元素
	 *
	 * @param array 数组
	 *
	 * @since 2023-04-18
	 */
	public static void notNullElements(Object[] array) {
		 notNullElements(array, "[Assertion failed] - this array must not contain any null elements");
	}

	/**
	 * 没有null元素
	 *
	 * @param array
	 * @param errorMessage
	 *
	 * @since 2023-04-18
	 */
	public static void notNullElements(Object[] array,  String errorMessage)  {
		if (ArrayUtil.containsEmptyElements(array)) {
			throw new BusinessException(errorMessage);
		}

	}

	/**
	 * 没有null元素
	 *
	 * @param array 数组
	 * @param errorCode 异常状态
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void notNullElements(Object[] array,String errorCode ,  String errorMessage)  {
		if (ArrayUtil.containsEmptyElements(array)) {
			throw new BusinessException(errorMessage,errorCode);
		}
	}

	/**
	 * 是实例
	 *
	 * @param clazz clazz
	 * @param obj obj
	 *
	 * @since 2023-04-18
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj) {
		 isInstanceOf(clazz, obj, "Object [{}] is not instanceof [{}]");
	}


	/**
	 * 是实例
	 *
	 * @param clazz clazz
	 * @param obj obj
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj, String errorMessage){
		notNull(clazz, "Clazz to check against must not be null");
		if (!clazz.isInstance(obj)) {
			throw new BusinessException(errorMessage);
		}
	}


	/**
	 * 子类是否是继承父类
	 *
	 * @param superClazz 父类Clazz
	 * @param subClazz 子类Clazz
	 *
	 * @since 2023-04-18
	 */
	public static void isAssignable(Class<?> superClazz, Class<?> subClazz){
		isAssignable(superClazz, subClazz, "{} is not assignable to {})");
	}

	/**
	 * 子类是否是继承父类
	 *
	 * @param superClazz 父类Clazz
	 * @param subClazz 子类Clazz
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void isAssignable(Class<?> superClazz, Class<?> subClazz, String errorMessage){
		notNull(superClazz, "Type to check against must not be null");
		if (subClazz == null || !superClazz.isAssignableFrom(subClazz)) {
			throw new BusinessException(StringUtil.format(errorMessage, subClazz,superClazz));
		}
	}

	/**
	 * 索引检查
	 *
	 * @param index 索引
	 * @param size 大小
	 *
	 * @since 2023-04-18
	 */
	public static void checkIndex(int index, int size) {
		checkIndex(index, size, "[index out of bounds]");
	}

	/**
	 * 索引检查
	 *
	 * @param index 索引
	 * @param size 大小
	 * @param errorMessage 异常信息
	 *
	 * @since 2023-04-18
	 */
	public static void checkIndex(int index, int size, String errorMessage)  {
		if (index < 0 || index >= size) {
			badIndexMsg(index, size, errorMessage);
		}

	}

	/**
	 *
	 *
	 * @param value
	 * @param min
	 * @param max
	 *
	 * @since 2023-04-18
	 */
	public static void checkBetween(int value, int min, int max) {
		checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}

	public static void checkBetween(int value, int min, int max, String errorMessage) {
		if (value < min || value > max) {
			throw new BusinessException(errorMessage);
		}

	}


	public static void checkBetween(long value, long min, long max) {
		checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}

	public static void  checkBetween(long value, long min, long max, String errorMessage) {
		if (value < min || value > max) {
			throw new BusinessException(errorMessage);
		}
	}


	public static void checkBetween(double value, double min, double max) {
		checkBetween(value, min, max, TEMPLATE_VALUE_MUST_BE_BETWEEN_AND);
	}

	public static void checkBetween(double value, double min, double max, String errorMessage) {
		if (value < min || value > max) {
			throw new BusinessException(errorMessage);
		}
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


	public static void notEquals(Object obj1, Object obj2, String errorMessage) throws IllegalArgumentException {
		notEquals(obj1, obj2, () -> new IllegalArgumentException(errorMessage));
	}


	public static <X extends Throwable> void notEquals(Object obj1, Object obj2, Supplier<X> errorSupplier) throws X {
		if (ObjectUtil.equals(obj1, obj2)) {
			throw errorSupplier.get();
		}
	}

	public static void equals(Object obj1, Object obj2) {
		equals(obj1, obj2, "({}) must be equals ({})");
	}


	public static void equals(Object obj1, Object obj2, String errorMessage) throws IllegalArgumentException {
		equals(obj1, obj2, () -> new BusinessException(errorMessage));
	}


	public static <X extends Throwable> void equals(Object obj1, Object obj2, Supplier<X> errorSupplier) throws X {
		if (ObjectUtil.notEqual(obj1, obj2)) {
			throw errorSupplier.get();
		}
	}


	private static void badIndexMsg(int index, int size, String errorMessage) {
		if (index < 0) {
			throw new BusinessException("index not be negative: "+ errorMessage);
		} else if (size < 0) {
			throw new BusinessException("size must not be negative: " + errorMessage);
		} else { // index >= size
			throw new BusinessException("index be less than size: "+ errorMessage);
		}
	}
}
