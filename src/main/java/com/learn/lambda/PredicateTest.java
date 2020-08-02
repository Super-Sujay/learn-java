package com.learn.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateTest {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("One", "Two", "Three", "Four", "Five");
		List<String> list = new ArrayList<String>();

		// Returns Boolean for the condition defined
		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("Two");
		Predicate<String> p3 = Predicate.isEqual("Three");

		// stream can be used only once
		 stream.filter(p1).forEach(System.out::println);
		 stream.filter(p2.or(p3)).forEach(System.out::println);

		// peek is an intermediary operation
		stream
			.peek(System.out::println)
			.filter(p2.or(p3))
			.peek(list::add);

		// forEach is a final operation
		stream
			.peek(System.out::println)
			.filter(p2.or(p3))
			.forEach(list::add);

		System.out.println("Done");
		System.out.println("List Size: " + list.size());

	}

}
