package com.learn.collections;

import java.util.Hashtable;
import java.util.Map;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> h1 = new Hashtable<Integer, String>();
		Map<Integer, String> h2 = new HashMap<Integer, String>();
		h1.put(0, "Zero");
		h1.put(1, "One");
		h1.put(2, "Two");
		h1.put(3, "Three");
		h1.put(4, "Four");
		h2.put(null, "null");
		h2.put(0, null);
		h2.put(1, "One");
		h2.put(3, "Three");
		h2.put(2, "Two");
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h1.keySet());
		System.out.println(h2.keySet());
		System.out.println(h1.values());
		System.out.println(h2.values());
		System.out.println(h1.get(3));
		System.out.println(h2.get(2));
		
		h1.forEach((k,v) -> System.out.println("Key is: " + k + "\tValue is: " + v));
		h2.forEach((k,v) -> System.out.println("Key is: " + k + "\tValue is: " + v));
		
		System.out.println("h1 with even keys:");
		h1.entrySet().stream().filter(e -> e.getKey() % 2 == 0).forEach(System.out::println);
		System.out.println("h2 with non null values:");
		h2.entrySet().stream().filter(e -> e.getValue() != null).forEach(System.out::println);
		
		System.out.println(h1.getOrDefault(5, "Number not found"));
		h1.computeIfAbsent(5, String::valueOf);
		System.out.println(h1);
		
//		for (Map.Entry<Integer, String> m : h1.entrySet()) {
//			System.out.println(m.getKey() + " = " + m.getValue());
//		}
//		for (Map.Entry<Integer, String> m : h2.entrySet()) {
//			System.out.println(m.getKey() + " = " + m.getValue());
//		}
	}
}