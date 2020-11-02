package com.learn.arrays;

import java.util.Arrays;

public class ZeroArray {

	public static void main1(String[] args) {
		int[] numbers = { 1, 0, 2, 0, 3, 0, 4, 0, 5, 0 };
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] == 0) {
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = 0;
					System.out.println(Arrays.toString(numbers));
				}
			}
		}
		System.out.println(Arrays.toString(numbers));
	}

	public static void main2(String[] args) {
		int[] numbers = { 1, 0, 2, 0, 3, 0, 4, 0, 5, 0 };
		numbers = Arrays.copyOf(Arrays.stream(numbers).filter(i -> i != 0).toArray(), 10);
		System.out.println(Arrays.toString(numbers));
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 0, 2, 0, 3, 0, 4, 0, 5, 0 };
		int count = 0, n = numbers.length;
		for (int i = 0; i < n; i++)
			if (numbers[i] != 0)
				numbers[count++] = numbers[i];
		while (count < n)
			numbers[count++] = 0;
		System.out.println(Arrays.toString(numbers));
	}

}
