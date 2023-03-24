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

	public static <S,T> void copyProperties(S source, T target ) {
		if (Objects.isNull(source) || Objects.isNull(target)) {
			return ;
		}
		Class<?> sourceClazz = source.getClass();
		Class<?> targetClazz = target.getClass();
		List<Field> sourceFieldList = getFields(sourceClazz);
		List<Field> targetFieldsList = getFields(targetClazz);
		copyProperties(source,target, targetClazz, sourceFieldList,targetFieldsList);
	}


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

	private static List<Field> getFields(Class<?> c) {
		List<Field> fieldList = new ArrayList<>();
		Field[] fields = c.getDeclaredFields();
		if (fields.length > 0) {
			fieldList.addAll(Arrays.asList(fields));
		}
		return getSuperClassFields(c, fieldList);
	}
	private static List<Field> getSuperClassFields(Class<?> o, List<Field> allFields) {
		Class<?> superclass = o.getSuperclass();
		if (Objects.isNull(superclass) || Object.class.getName().equals(superclass.getName())) {
			return allFields;
		}
		Field[] fields = superclass.getDeclaredFields();
		if (fields.length == 0) {
			return allFields;
		}
		allFields.addAll(Arrays.asList(fields));
		return getSuperClassFields(superclass, allFields);
	}

}
