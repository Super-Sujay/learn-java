package com.learn.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {

		Set<String> hashSet = new HashSet<String>();
		hashSet.add("Red");
		hashSet.add("Blue");
		hashSet.add("Green");
		hashSet.add("Yellow");
		hashSet.add("Orange");
		hashSet.add("Blue");
		System.out.println(hashSet);

		// Directly sorts the set
		SortedSet<String> treeSet = new TreeSet<String>(hashSet);
		System.out.println(treeSet);

		Set<Integer> hashSet1 = new HashSet<Integer>();
		hashSet1.addAll(Arrays.asList(1, 3, 2, 4, 8, 9, 0));
		System.out.println("Hash Set 1\n" + hashSet1);

		Set<Integer> hashSet2 = new HashSet<Integer>();
		hashSet2.addAll(Arrays.asList(new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));
		System.out.println("Hash Set 2\n" + hashSet2);

		// To find union
		Set<Integer> union = new HashSet<Integer>(hashSet1);
		union.addAll(hashSet2);
		System.out.println("Union of the two sets is\n" + union);

		// To find intersection
		Set<Integer> intersection = new HashSet<Integer>(hashSet1);
		intersection.retainAll(hashSet2);
		System.out.println("Intersection of the two sets is\n" + intersection);

		// To find the symmetric difference
		Set<Integer> difference = new HashSet<Integer>(hashSet1);
		difference.removeAll(hashSet2);
		System.out.println("Difference of the two sets is\n" + difference);

		SortedSet<Integer> numbers = new TreeSet<Integer>(Comparator.reverseOrder());
		for (int i = 0; i < 20; i++)
			numbers.add(i);
		System.out.println("Numbers Sorted set is: " + numbers);

	}

}