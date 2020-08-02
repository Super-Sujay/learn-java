package com.learn.generics;

import java.util.StringJoiner;

public class PrintGenericTest {

	public static <T> void printArray(T[] inputArray) {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for (T element : inputArray)
			sj.add(element.toString());
		System.out.println(sj);
	}

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Character[] charArray = { 'A', 'B', 'C', 'D', 'E' };
		String[] stringArray = { "Aa", "Bb", "Cc", "Dd", "Ee" };

		System.out.println("intArray");
		printArray(intArray);

		System.out.println("doubleArray");
		printArray(doubleArray);

		System.out.println("charArray");
		printArray(charArray);

		System.out.println("stringArray");
		printArray(stringArray);
	}

}
