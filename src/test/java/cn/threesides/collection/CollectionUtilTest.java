package cn.threesides.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

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

	@Test
	public void testToString() {

		HashMap<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		String s = CollectionUtil.toString(map);
		System.out.println("s = " + s);
	}
}