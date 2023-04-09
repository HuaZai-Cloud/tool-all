package com.threesides.lang;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.sun.tools.javac.util.Assert;
import org.junit.Test;

/**
 * ArrayUtilTest
 *
 * @author Di Wu
 * @since 2023-03-29
 */
public class ArrayUtilTest {

	@Test
	public void isArray() {
	}

	@Test
	public void isEmpty() {
	}

	@Test
	public void isNullElements() {
		String[] array = new String[3];
		array[0] = "0";
		array[1] = "0";
		array[2]= "";
		boolean nullElements = ArrayUtil.containsEmptyElements(array);
		System.out.println("nullElements = " + nullElements);

	}
}