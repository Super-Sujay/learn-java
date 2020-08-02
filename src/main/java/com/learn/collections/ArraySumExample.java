package com.learn.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraySumExample {

	public static void main1(String[] args) {
		int[] numbers = { 2, 4, 3, 5, 6, -2, 3, 7, 8, 9 };
		int output = 7, count = 0;
		Set<Integer> set = new HashSet<Integer>(numbers.length);
		for (int value : numbers) {
			int target = output - value;
			if (set.contains(target))
				count++;
			set.add(value);
			System.out.println(set);
		}
		System.out.println(count);
	}

	public static void main2(String[] args) {
		int[] numbers = { 2, 4, 3, 5, 6, -2, 3, 7, 8, 9 };
		int output = 7, count = 0;
		for (int i = 0; i < numbers.length; i++)
			for (int j = i + 1; j < numbers.length; j++)
				if (numbers[i] + numbers[j] == output)
					count++;
//					System.out.printf("(%d, %d) %n", numbers[i], numbers[j]);
		System.out.println(count);
	}
	
	private static int count = 0;
	
	public static void main3(String[] args) {
		int[] numbers = { 2, 4, 3, 5, 6, -2, 3, 7, 8, 9 };
		int output = 7;
		Set<Integer> set = new HashSet<>(numbers.length);
		Arrays.stream(numbers).parallel().forEach(value -> {
			int target = output - value;
			if (set.contains(target))
//				count++;
				System.out.printf("(%d, %d) %n", value, target);
			set.add(value);
		});
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		int[] numbers = { 2, 4, 3, 5, 6, -2, 3, 7, 8, 9 };
		int output = 7;
		List<int[]> result = Arrays.stream(numbers)
			.boxed()
			.flatMap(i -> Arrays.stream(numbers)
					.boxed()
					.filter(j -> i + j == output)
					.map(j -> new int[]{i, j}))
			.distinct()
			.collect(Collectors.toList());
		result.stream().map(Arrays::toString).forEach(System.out::println);
	}
}
