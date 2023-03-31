package com.threesides.collection;

import com.sun.xml.internal.ws.policy.PolicyMap;
import com.sun.xml.internal.ws.streaming.DOMStreamReader;
import com.sun.xml.internal.ws.util.xml.NamespaceContextExAdaper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * CollectionUtilTest
 *
 * @author Di Wu
 * @since 2023-03-09
 */
public class CollectionUtilTest {

	@Test
	public void isEmpty() {
		boolean emptyList = CollectionUtil.isEmpty(new ArrayList<>());
		assertTrue(emptyList);

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(5);
		boolean notEmptyList = CollectionUtil.isEmpty(arrayList);
		assertFalse(notEmptyList);

	}

	@Test
	public void isNotEmpty() {
		boolean emptyList = CollectionUtil.isNotEmpty(new ArrayList<>());
		assertFalse(emptyList);

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(5);
		boolean notEmptyList = CollectionUtil.isNotEmpty(arrayList);
		assertTrue(notEmptyList);
	}

	@Test
	public void testIsEmpty() {
		boolean emptyMap = CollectionUtil.isEmpty(new HashMap<>());
		assertTrue(emptyMap);
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("isEmpty","isEmpty");
		boolean notEmptyMap = CollectionUtil.isEmpty(hashMap);
		assertFalse(notEmptyMap);
	}

	@Test
	public void testIsNotEmpty() {
		boolean emptyMap = CollectionUtil.isNotEmpty(new HashMap<>());
		assertFalse(emptyMap);
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("isEmpty","isEmpty");
		boolean notEmptyMap = CollectionUtil.isNotEmpty(hashMap);
		assertTrue(notEmptyMap);
	}

}