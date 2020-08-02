package com.learn.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorsTest {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++)
			if (i % 2 == 0)
				al.add(i);

		System.out.println("Printing from for each loop");
		for (int a : al) //for(int i = 0; i < al.size(); i++)
			System.out.print(a + " ");
		System.out.println("\n");

		ListIterator<Integer> itr = al.listIterator();

		System.out.println("Printing from while loop");
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println("\n");

		System.out.println("Printing from normal for loop");
		for (ListIterator<Integer> i = al.listIterator(); i.hasNext();)
			System.out.print(i.next() + " ");
		System.out.println("\n");

		System.out.println("Printing using new Java 8 functionality of for each");
		al.forEach(a -> System.out.print(a + " "));
		System.out.println("\n");

		itr = al.listIterator(al.size());

		System.out.println("Printing in reverse order using while loop");
		while (itr.hasPrevious())
			System.out.print(itr.previous() + " ");
		System.out.println("\n");

		System.out.println("Printing in reverse order using for loop");
		for (ListIterator<Integer> i = al.listIterator(al.size()); i.hasPrevious();)
			System.out.print(i.previous() + " ");
		System.out.println("\n");

	}

}