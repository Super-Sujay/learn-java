package com.learn.collections;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class NavigableSetTest {

	public static void main(String[] args) {
		NavigableSet<Integer> navSet = IntStream.of(65, 54, 34, 12, 99).collect(TreeSet::new, NavigableSet::add, NavigableSet::addAll);
		System.out.println("Numbers: " + navSet);
		System.out.println("Number less than or equal to 34: " + navSet.floor(34));
		System.out.println("Number less than 34: " + navSet.lower(34));
		System.out.println("Number greater than or equal to 34: " + navSet.ceiling(34));
		System.out.println("Number greater than 34: " + navSet.higher(34));
		
		System.out.println("Numbers less than 54: " + navSet.headSet(54));
		System.out.println("Numbers greater than or equal to 54: " + navSet.tailSet(54));
		
		System.out.println("Numbers between 20(inclusive) and 80(exclusive): " + navSet.subSet(20, 80));
		System.out.println("Numbers between 34(inclusive) and 99(exclusive): " + navSet.subSet(34, 99));
		System.out.println("Numbers between 34(inclusive) and 99(inclusive): " + navSet.subSet(34, true, 99, true));
		System.out.println("Numbers between 34(exclusive) and 99(inclusive): " + navSet.subSet(34, false, 99, true));
	}

}
