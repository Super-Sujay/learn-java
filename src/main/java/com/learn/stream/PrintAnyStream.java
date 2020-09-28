package com.learn.stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

import java.util.List;

public class PrintAnyStream {

	public static void main(String[] args) {

		List<String> names = asList("Sujay", "Shailesh", "Samidha");
		List<Integer> numbers = asList(1, 2, 3, 4, 5);
		List<Double> decimals = asList(1.1, 2.2, 3.3, 4.4);
		String list = stringList(names);
		System.out.println(list);
		list = stringList(numbers);
		System.out.println(list);
		list = stringList(decimals);
		System.out.println(list);
	}

	public static String stringList(List<?> content) {
		return content.stream().map(Object::toString).collect(joining(", "));
	}

}