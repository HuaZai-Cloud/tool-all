package com.threesides.beans;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BeanUtil
 *
 * @author Di Wu
 * @since 2023-02-27
 */
public class BeanUtil {

	/**
	 * 拷贝属性值
	 *
	 * @param source 来源
	 * @param target 目标
	 * @param <S> S
	 * @param <T> T
	 *
	 * @since 2023-04-08
	 */
	public static <S,T> void copyProperties(S source, T target ) {
		if (Objects.isNull(source) || Objects.isNull(target)) {
			return ;
		}
		Class<?> sourceClazz = source.getClass();
		Class<?> targetClazz = target.getClass();
		List<Field> sourceFieldList = getFieldList(sourceClazz);
		List<Field> targetFieldsList = getFieldList(targetClazz);
		copyProperties(source,target, targetClazz, sourceFieldList,targetFieldsList);
	}


	/**
	 * 拷贝属性值
	 *
	 * @param source 来源
	 * @param target 目标
	 * @param targetClazz 目标Clazz
	 * @param sourceFieldList 来源字段集合
	 * @param targetFieldsList 目标字段集合
	 * @param <S> S
	 * @param <T> T
	 *
	 * @since 2023-04-08
	 */
	private static <S,T> void copyProperties(S source,T target, Class<?> targetClazz, List<Field> sourceFieldList,List<Field> targetFieldsList) {

		try {
			List<String> targetFieldsNameList = targetFieldsList.stream().map(Field::getName).collect(Collectors.toList());
			for (Field sourceField : sourceFieldList) {
				sourceField.setAccessible(true);
				String sourceTypeName = sourceField.getType().getTypeName();
				if (targetFieldsNameList.contains(sourceField.getName())) {
					Field targetField = targetClazz.getDeclaredField(sourceField.getName());
					targetField.setAccessible(true);
					if (targetField.getType().getTypeName().equals(sourceTypeName)) {
						targetField.set(target,sourceField.get(source));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取字段集合
	 *
	 * @param clazz Class对象
	 * @return 字段集合
	 *
	 * @since 2023-04-08
	 */
	private static List<Field> getFieldList(Class<?> clazz) {
		List<Field> fieldList = new ArrayList<>();
		Field[] fields = clazz.getDeclaredFields();
		if (fields.length > 0) {
			fieldList.addAll(Arrays.asList(fields));
		}
		return getSuperClassFieldList(clazz, fieldList);
	}

	/**
	 * 获取父类字段集合
	 *
	 * @param clazz Class对象
	 * @param allFields 所有字段集合
	 * @return 字段集合
	 *
	 * @since 2023-04-08
	 */
	private static List<Field> getSuperClassFieldList(Class<?> clazz, List<Field> allFields) {
		Class<?> superclass = clazz.getSuperclass();
		if (Objects.isNull(superclass) || Object.class.getName().equals(superclass.getName())) {
			return allFields;
		}
		Field[] fields = superclass.getDeclaredFields();
		if (fields.length == 0) {
			return allFields;
		}
		allFields.addAll(Arrays.asList(fields));
		return getSuperClassFieldList(superclass, allFields);
	}

}
