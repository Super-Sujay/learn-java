package com.learn.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintFrequencyTest {

	private static void printFreqHash(int[] array) {

		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			Integer c = hash.get(array[i]);
			if (c == null)
				hash.put(array[i], 1);
			else
				hash.put(array[i], ++c);
		}

		hash.forEach((k, v) -> System.out.println("Frequency of " + k + " is " + v));

	}
	
	private static void printFreqTree(int[] array) {

		SortedMap<Integer, Integer> hash = new TreeMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			Integer c = hash.get(array[i]);
			if (c == null)
				hash.put(array[i], 1);
			else
				hash.put(array[i], ++c);
		}

		hash.forEach((k, v) -> System.out.println("Frequency of " + k + " is " + v));

	}
	
	private static void printFreqStream(int[] array) {
		Arrays.stream(array)
			.boxed()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.forEach((k, v) -> System.out.println("Frequency of " + k + " is " + v));
	}

	public static void main(String[] args) {
		int[] a = { 10, 34, 5, 10, 3, 5, 10 };
		System.out.println("Printing from printFreqHash");
		printFreqHash(a);
		System.out.println("Printing from printFreqTree");
		printFreqTree(a);
		System.out.println("Printing from printFreqStream");
		printFreqStream(a);
	}

}
