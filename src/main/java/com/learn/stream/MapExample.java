package com.learn.stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {
		
		Map<Integer, String> students = new HashMap<Integer, String>();
		students.put(1, "Sujay");
		students.put(2, "Anurag");
		students.put(3, "Karthik");
		students.put(4, "Swapnil");
		students.put(5, "Prashant");

		students.entrySet().stream()
				.filter(e -> e.getKey() % 2 == 0)
				.map(Entry::getValue)
				.forEach(System.out::println);
		
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 2, 4, 6, 8, 10, 2, 4, 6, 8 };
		
		Map<Integer, Long> freq = Arrays.stream(numbers).boxed().collect(groupingBy(identity(), counting()));
		System.out.println(freq);
	}

}
