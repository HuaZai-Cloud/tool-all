package cn.threesides.beans;

import org.junit.Test;

/**
 * BeanUtilTest
 *
 * @author Di Wu
 * @since 2023-03-24
 */
public class BeanUtilTest {


	@Test
	public void copyProperties() {

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

	}

}