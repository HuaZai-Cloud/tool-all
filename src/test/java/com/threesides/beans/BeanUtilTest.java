package com.threesides.beans;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * BeanUtilTest
 *
 * @author Di Wu
 * @since 2023-03-24
 */
public class BeanUtilTest {


	@Test
	public void copy() {

		User user = new User();
		user.setUserId(0L);
		user.setUsername("WuDI");
		user.setSex("男");
		user.setPassword("123456");

		UserVO vo = new UserVO();

		BeanUtil.copyProperties(user, vo);
		System.out.println("user = " + user);
		System.out.println("vo = " + vo);

		user.setUsername("dragon");
		vo.setUsername("wudi");

		System.out.println("user = " + user);
		System.out.println("vo = " + vo);

		new HashMap<>();
		new HashSet<>();

	}
}