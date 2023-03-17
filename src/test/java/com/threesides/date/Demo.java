package com.threesides.date;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Demo
 *
 * @author Di Wu
 * @since 2023-03-17
 */
public class Demo {

	public static void main(String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			Random b = new Random();
			arr[i] = b.nextInt(9)+2;
			System.out.print(arr[i]+",");
		}

		System.out.println("请输入20-40之间的数字");
		Scanner rs = new Scanner(System.in);
		int w = rs.nextInt();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (w == arr[i]) {
				count++;
			}
		}
		System.out.println("元素" + w + "在数组中出现" + count + "次");
	}
}
