package com.learn.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MissingNumber {

	public static void main(String[] args) {
		List<Integer> numbers = IntStream.rangeClosed(1, 1000).collect(ArrayList::new, List::add, List::addAll);
		numbers.remove(956);
		int[] arr = numbers.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(arr));
		System.out.println(1000 * (1000 + 1) / 2);
		System.out.println(Arrays.stream(arr).sum());
		int missingNumber = 1000 * (1000 + 1) / 2 - Arrays.stream(arr).sum();
		System.out.println(missingNumber);
	}

}
