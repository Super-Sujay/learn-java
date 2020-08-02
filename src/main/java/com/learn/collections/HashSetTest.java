package com.learn.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> hashSet1 = new HashSet<String>();
		hashSet1.add("India");
		hashSet1.add("Australia");
		hashSet1.add("New Zealand");
		hashSet1.add("Sumatra");
		hashSet1.add("Indonesia");
		hashSet1.add("India");

		System.out.println(hashSet1);

		hashSet1.remove("India");

		System.out.println(hashSet1);

		hashSet1.forEach(e -> System.out.print(e + " "));
		System.out.println();

		Iterator<String> itr = hashSet1.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");

		System.out.println();
		SortedSet<String> hashSet2 = new TreeSet<String>(hashSet1);
		System.out.println(hashSet2);

	}

}