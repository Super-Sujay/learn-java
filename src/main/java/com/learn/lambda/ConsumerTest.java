package com.learn.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;

public class ConsumerTest {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Sujay");
		map.put(2, "Basker");
		map.put(3, "Naveen");
		map.put(4, "Stuti");
		map.put(5, "Tejaswini");
		map.put(6, "Sujay");
		
		List<String> list = new ArrayList<>();
		
		Set<String> set = new TreeSet<>();
		
		//Create BiConsumer Actions to add elements to list and set
		BiConsumer<Integer, String> c1 = (k,v) -> list.add(v);
		BiConsumer<Integer, String> c2 = (k,v) -> System.out.println(v);
		BiConsumer<Integer, String> c3 = (k,v) -> set.add(v);
		
		//Use andThen to do the BiConsumer Tasks one after the other
		map.forEach(c1.andThen(c2).andThen(c3));
		
		System.out.println("List is:\n" + list);
		
		System.out.println("Set is:\n" + set);
		
	}

}
