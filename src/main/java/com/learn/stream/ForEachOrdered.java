package com.learn.stream;

import java.util.ArrayList;
import java.util.List;

public class ForEachOrdered {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++) numbers.add(i);
		System.out.println(numbers);
		System.out.println("Stream For each:");
		numbers.stream().forEach(System.out::print);
		System.out.println("\nParallel Stream For each:");
		numbers.parallelStream().forEach(System.out::print);
		System.out.println("\nParallel Stream For each ordered:");
		numbers.parallelStream().forEachOrdered(System.out::print);
	}

}
