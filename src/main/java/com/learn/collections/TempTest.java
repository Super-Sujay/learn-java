package com.learn.collections;

import static java.util.Comparator.reverseOrder;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.TreeSet;

public class TempTest {

	public static void main1(String[] args) {
		String[] names = { "Sujay", null, "Anurag", null, "Prashant" };
		System.out.println("Before: " + Arrays.toString(names));
		// List<String> list = new ArrayList<String>(Arrays.asList(names));
		// list.removeIf(o -> o == null);
		// list.removeAll(Collections.singleton(null));
		// System.out.println(list);
		// List<String> list = Arrays.stream(names).filter(name -> name !=
		// null).collect(Collectors.toList());
		// names = list.toArray(new String[list.size()]);
		names = Arrays.stream(names).filter(name -> name != null).toArray(String[]::new);
		System.out.println("After: " + Arrays.toString(names));
		Arrays.sort(names);
		System.out.println("After sorting: " + Arrays.toString(names));
	}

	public static void main2(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, -1 };
		OptionalInt no = Arrays.stream(numbers).filter(number -> number == 19).findFirst();
		int minimum = Arrays.stream(numbers).reduce(Integer::min).getAsInt();
		System.out.println("Minimum: " + minimum);
		System.out.println(no.orElseThrow(NoSuchElementException::new));
	}

	public static void main(String[] args) {
		int[] numbers = {9, 9, 9, 9, 8, 7, 6, 5, 4, 5, 4, 4, 5};
		NavigableSet<Integer> numSet = new TreeSet<>();
		for (int n : numbers) numSet.add(n);
		System.out.println(numSet.lower(numSet.last()));
	}
	
	public static void main4(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, -1 };
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers) + "\n" + numbers.length);
		numbers = Arrays.stream(numbers).distinct().toArray();
		System.out.println(Arrays.toString(numbers) + "\n" + numbers.length);
	}
	
	public static void printNthLargestNumber(int[] numbers, int nth) {
		Arrays.stream(numbers).distinct().boxed().sorted(reverseOrder()).skip(nth - 1).findFirst().ifPresent(System.out::println);
	}

}