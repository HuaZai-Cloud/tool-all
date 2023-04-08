package com.threesides.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * StringUtilTest
 *
 * @author Di Wu
 * @since 2023-03-29
 */
public class StringUtilTest {

	@Test
	public void isBlank() {
	}

	@Test
	public void isEmpty() {
	}

	@Test
	public void isNotBlank() {
	}

	@Test
	public void isNotEmpty() {
	}

	@Test
	public void isMixedCase() {
	}

	@Test
	public void isNumeric() {
	}

	@Test
	public void isNumericSpace() {
	}

	@Test
	public void isWhitespace() {
	}

	@Test
	public void join() {
	}

	@Test
	public void testJoin() {
	}

	@Test
	public void testJoin1() {
	}

	@Test
	public void testJoin2() {
	}

	@Test
	public void testJoin3() {
	}

	@Test
	public void testJoin4() {
	}

	@Test
	public void testJoin5() {
	}

	@Test
	public void testJoin6() {
	}

	@Test
	public void testJoin7() {
	}

	@Test
	public void testJoin8() {
	}

	@Test
	public void testJoin9() {
	}

	@Test
	public void testJoin10() {
	}

	@Test
	public void testJoin11() {
	}

	@Test
	public void testJoin12() {
	}

	@Test
	public void testJoin13() {
	}

	@Test
	public void testJoin14() {
	}

	@Test
	public void testJoin15() {
	}

	@Test
	public void testJoin16() {
	}

	@Test
	public void testJoin17() {
	}

	@Test
	public void testJoin18() {
	}

	@Test
	public void testJoin19() {
	}

	@Test
	public void testJoin20() {
	}

	@Test
	public void testJoin21() {
	}

	@Test
	public void testJoin22() {
	}

	@Test
	public void length() {
	}

	@Test
	public void isIntegerNumeric() {
		System.out.println("StringUtil.isIntegerNumeric(\"-10\") = " + StringUtil.isIntegerNumeric("-10"));
		System.out.println("StringUtil.isIntegerNumeric(\"+2\") = " + StringUtil.isIntegerNumeric("+2"));
		System.out.println("StringUtil.isIntegerNumeric(\"3\") = " + StringUtil.isIntegerNumeric("3 "));
		System.out.println("StringUtil.isIntegerNumeric(\"-10.5\") = " + StringUtil.isIntegerNumeric("-10.5"));
		System.out.println("StringUtil.isIntegerNumeric(\"10.0\") = " + StringUtil.isIntegerNumeric("10.0"));
		System.out.println("StringUtil.isIntegerNumeric(\"0\") = " + StringUtil.isIntegerNumeric("0"));
	}

	@Test
	public void testJoin23() {

		Object[] args = new Integer[3];
		int[] result = {1, 2, 3};
		args[0] = 1;
		args[1] = 2;
		args[2] = 3;
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("w");
		arrayList.add("3");
		arrayList.add("dewjkf");
		arrayList.add("fwqgt");

		ArrayList<Boolean> booList = new ArrayList<>();
		booList.add(true);
		booList.add(true);
		booList.add(false);
		booList.add(true);
		booList.add(false);


		boolean[] booleans = {true, false, true};

		HashSet<String> set = new HashSet<>();
		set.add("ssss");
		set.add("aaaa");
		set.add("bbbb");

		System.out.println("StringUtil.join(args, \",\") = " + StringUtil.join(set, ","));
	}
}