package com.learn.numbers;

import static java.util.Comparator.reverseOrder;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NthLargestNumber {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, -1 };
		printNthLargestNumber(numbers, 5);
	}
	
	/**
	 * Second Largest
	 * @param args
	 */
	public static void main1(String[] args) {
		int[] numbers = {9, 9, 9, 9, 8, 7, 6, 5, 4, 5, 4, 4, 5};
		NavigableSet<Integer> numSet = new TreeSet<>();
		for (int n : numbers) numSet.add(n);
		System.out.println(numSet.lower(numSet.last()));
	}
	
	private static void printNthLargestNumber(int[] numbers, int nth) {
		Arrays.stream(numbers).distinct().boxed().sorted(reverseOrder()).skip(nth - 1).findFirst().ifPresent(System.out::println);
	}

}
