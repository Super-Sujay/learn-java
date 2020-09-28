package com.learn.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachOrdered {

	public static void main(String[] args) {
		List<Integer> numbers = IntStream.range(0, 10).collect(ArrayList::new, List::add, List::addAll);
		System.out.println(numbers);
		System.out.println("Stream For each:");
		numbers.stream().forEach(System.out::print);
		System.out.println("\nParallel Stream For each:");
		numbers.parallelStream().forEach(System.out::print);
		System.out.println("\nParallel Stream For each ordered:");
		numbers.parallelStream().forEachOrdered(System.out::print);
	}

}
