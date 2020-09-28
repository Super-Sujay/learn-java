package com.learn.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import static java.util.stream.Collectors.*;

public class JavaStream {

	public static void main(String[] args) {

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		System.out.println("Using Java7:");

		System.out.println("String list: " + strings);

		long count = getCountEmptyStringUsingJava7(strings);
		System.out.println("No of empty strings: " + count);

		count = getCountLength3UsingJava7(strings);
		System.out.println("No of strings with length 3: " + count);

		List<String> filteredStrings = deleteEmptyStringUsingJava7(strings);
		System.out.println("Filtered strings: " + filteredStrings);

		String mergedString = getMergedStringUsingJava7(strings, ", ");
		System.out.println("Merged string is: " + mergedString);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		System.out.println("Number list: " + numbers);

		List<Integer> squares = getSquaresUsingJava7(numbers);
		System.out.println("Square list: " + squares);

		System.out.println("Maximum number in numbers list: " + getMax(numbers));
		System.out.println("Minimum number in numbers list: " + getMin(numbers));
		System.out.println("Sum of all the numbers in numbers list: " + getSum(numbers));
		System.out.println("Average of all the numbers in numbers list: " + getAverage(numbers));

		System.out.println("Printing Random Numbers: ");
		Random random = new Random();
		for (int i = 0; i < 10; i++)
			System.out.println(random.nextInt());

		System.out.println("Using Java8:");

		System.out.println("String list: " + strings);

		count = strings.stream().filter(String::isEmpty).count();
		System.out.println("No of empty strings: " + count);

		count = strings.stream().filter(s -> s.length() == 3).count();
		System.out.println("No of strings with length 3: " + count);

		filteredStrings = strings.stream().filter(s -> !s.isEmpty()).collect(toList());
		System.out.println("Filtered strings: " + filteredStrings);

		mergedString = strings.stream().collect(joining(", "));
		System.out.println("Merged string is: " + mergedString);

		System.out.println("Number list: " + numbers);

		squares = numbers.stream().map(i -> i * i).distinct().collect(toList());
		System.out.println("Square list: " + squares);

		IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();

		System.out.println("Maximum number in numbers list: " + stats.getMax());
		System.out.println("Minimum number in numbers list: " + stats.getMin());
		System.out.println("Sum of all the numbers in numbers list: " + stats.getSum());
		System.out.println("Average of all the numbers in numbers list: " + stats.getAverage());

		System.out.print("Random Numbers: ");
		random.ints().limit(10).sorted().forEach(System.out::println);

	}

	public static long getCountEmptyStringUsingJava7(List<String> strings) {
		int count = 0;
		for (String string : strings) {
			if (string.isEmpty())
				count++;
		}
		return count;
	}

	public static long getCountLength3UsingJava7(List<String> strings) {
		int count = 0;
		for (String string : strings) {
			if (string.length() == 3)
				count++;
		}
		return count;
	}

	public static List<String> deleteEmptyStringUsingJava7(List<String> strings) {
		List<String> filteredList = new ArrayList<String>();
		for (String string : strings) {
			if (!string.isEmpty())
				filteredList.add(string);
		}
		return filteredList;
	}

	public static String getMergedStringUsingJava7(List<String> strings, String separator) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			stringBuilder.append(string);
			stringBuilder.append(separator);
		}
		return stringBuilder.substring(0, stringBuilder.length() - 2);
	}

	public static List<Integer> getSquaresUsingJava7(List<Integer> numbers) {
		List<Integer> squares = new ArrayList<>();
		for (Integer integer : numbers) {
			int square = integer * integer;
			if (!squares.contains(square))
				squares.add(square);
		}
		return squares;
	}

	public static int getMax(List<Integer> numbers) {
		int max = numbers.get(0);
		for (Integer integer : numbers) {
			if (integer > max)
				max = integer;
		}
		return max;
	}

	public static int getMin(List<Integer> numbers) {
		int min = numbers.get(0);
		for (Integer integer : numbers) {
			if (integer < min)
				min = integer;
		}
		return min;
	}

	public static int getSum(List<Integer> numbers) {
		int sum = 0;
		for (Integer integer : numbers) {
			sum += integer;
		}
		return sum;
	}

	public static double getAverage(List<Integer> numbers) {
		return (double) getSum(numbers) / (double) numbers.size();
	}

}
