package com.learn.collections;

import java.util.Enumeration;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CollectionsTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		for (Integer i = 0; i < 10; i++)
			v.addElement(i.toString());
		System.out.println(v);
		Enumeration<String> e = v.elements();

		while (e.hasMoreElements())
			System.out.print(e.nextElement() + " ");

		System.out.println();

		Consumer<String> c1 = System.out::print;

		v.forEach(c1.andThen(t -> System.out.print(" ")));

		System.out.println();

		System.out.println(v.stream().collect(Collectors.joining(", ", "[", "]")));

	}
}