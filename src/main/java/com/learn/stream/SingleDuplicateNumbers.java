package com.learn.stream;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SingleDuplicateNumbers {
	
	/**
	 * In Java 8
	 * @param args
	 */
	public static void main2(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 2, 4, 6, 8, 10, 2, 4, 6, 8 };
		List<Integer> duplicateNumbers = stream(numbers)
				.boxed()
				.collect(groupingBy(identity(), counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.map(Entry::getKey)
				.collect(toList());
		List<Integer> singleNumbers = stream(numbers)
				.boxed()
				.collect(groupingBy(identity(), counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() == 1)
				.map(Entry::getKey)
				.collect(toList());
		int[] duplicates = stream(numbers)
				.boxed()
				.collect(groupingBy(identity(), counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.mapToInt(Entry::getKey)
				.toArray();
		int[] singles = stream(numbers)
				.boxed()
				.collect(groupingBy(identity(), counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() == 1)
				.mapToInt(Entry::getKey)
				.toArray();
		System.out.println("Duplicate Numbers: " + duplicateNumbers);
		System.out.println("Single Numbers: " + singleNumbers);
		System.out.println("Duplicate Numbers in array: " + Arrays.toString(duplicates));
		System.out.println("Single Numbers in array: " + Arrays.toString(singles));
	}
	
	/**
	 * In Java 7
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 2, 4, 6, 8, 10, 2, 4, 6, 8 };
		List<Integer> duplicateNumbers = new ArrayList<Integer>();
		List<Integer> singleNumbers = new ArrayList<Integer>();
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		for (Integer number : numbers) {
			Integer val = numberMap.get(number);
			if (val == null)
				numberMap.put(number, 1);
			else
				numberMap.put(number, ++val);
		}
		for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) 
			if (entry.getValue() == 1)
				singleNumbers.add(entry.getKey());
			else
				duplicateNumbers.add(entry.getKey());
		int[] duplicates = duplicateNumbers.stream().mapToInt(Integer::intValue).toArray();
		int[] singles = singleNumbers.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("Duplicate Numbers: " + Arrays.toString(duplicates));
		System.out.println("Single Numbers: " + Arrays.toString(singles));
	}
	
	public static void main3(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 2, 4, 6, 8, 10, 2, 4, 6, 8 };
		int[] duplicates = stream(numbers).boxed().collect(groupingBy(identity(), counting())).entrySet().stream().filter(e -> e.getValue() > 1).mapToInt(Entry::getKey).toArray();
		int[] singles = stream(numbers).boxed().collect(groupingBy(identity(), counting())).entrySet().stream().filter(e -> e.getValue() == 1).mapToInt(Entry::getKey).toArray();
		System.out.println("Duplicate Numbers in array: " + Arrays.toString(duplicates));
		System.out.println("Single Numbers in array: " + Arrays.toString(singles));
	}

}
