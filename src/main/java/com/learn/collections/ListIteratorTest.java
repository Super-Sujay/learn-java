package com.learn.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			al.add(i);
		System.out.println(al);

		ListIterator<Integer> itr = al.listIterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();

		itr = al.listIterator(al.size());
		while (itr.hasPrevious())
			System.out.print(itr.previous() + " ");
	}

}