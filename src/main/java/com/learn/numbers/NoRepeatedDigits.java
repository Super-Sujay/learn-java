package com.learn.numbers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class NoRepeatedDigits {

	public static void main(String[] args) {
		int[] numbers = IntStream.rangeClosed(1, 10000).toArray();
		int count = 0;
		for (int n : numbers) {
			Set<Integer> s = new HashSet<>();
			while (n != 0) {
				int d = n % 10;
				if (s.contains(d))
					break;
				s.add(d);
				n = n / 10;
			}
			if (n == 0)
				count++;
		}
		System.out.println(count);
	}

}
