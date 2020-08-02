package com.learn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceStream {

	public static void main(String[] args) {

		Stream<Integer> stream = Stream.of(1, 2, 3, 4);

		BinaryOperator<Integer> sum = Math::addExact;

		Integer id = 0;

		int red = stream.reduce(id, sum);
		System.out.println(red);

		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		int sum1 = list.stream().reduce(0, Integer::sum);
		System.out.println("Sum is: " + sum1);

		Optional<Integer> max = list.stream().reduce(Integer::max);
		System.out.println("Max is: " + max.orElse(0));

	}

}
