package com.learn.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Sujay", "Shailesh", "Samidha");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Double> decimals = Arrays.asList(1.1, 2.2, 3.3, 4.4);
		String list = stringList(names);
		System.out.println(list);
		list = stringList(numbers);
		System.out.println(list);
		list = stringList(decimals);
		System.out.println(list);

	}

	public static String stringList(List<?> content) {
		return content.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
	}

}