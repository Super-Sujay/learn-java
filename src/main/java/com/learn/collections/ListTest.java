package com.learn.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		System.out.println("Creating a list");
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(0, 1);
		l1.add(1, 2);
		System.out.println(l1);

		System.out.println("Creating another list");
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		System.out.println(l2);

		System.out.println("Will add list l2 from index 1");
		l1.addAll(1, l2);
		System.out.println(l1);

		System.out.println("Remove element from index 1");
		l1.remove(1);
		System.out.println(l1);

		System.out.println("Prints the element at the index 3");
		System.out.println(l1.get(3));

		System.out.println("Replace the 0th element with 5");
		l1.set(0, 5);
		System.out.println(l1);
		
		int[] numbers = l1.stream().mapToInt(Integer::valueOf).toArray();
		System.out.println("List converted to Int Array");
		System.out.println(Arrays.toString(numbers));

	}

}
