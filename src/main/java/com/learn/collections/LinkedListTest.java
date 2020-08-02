package com.learn.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list1 = new LinkedList<String>();
		list1.add("Java");
		list1.add("Ruby");
		list1.add(2, "Python");
		list1.add(null);
		System.out.println(list1);
		list1.remove(2);
		System.out.println(list1);
		list1.set(0, "C++");
		System.out.println(list1);
		
		List<String> list2 = new ArrayList<String>(4);
		list2.add("JAVA");
		list2.add("RUBY");
		list2.add(null);
		list2.add(null);
		System.out.println(list2);
		list2.set(1, "PYTHON");
		System.out.println(list2);
//		list2.removeAll(Collections.singleton(null));
		list2.removeIf(str -> str == null);
		System.out.println(list2);
	}

}
