package com.learn.collections;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.valueOf;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest {

	public static void main(String[] args) {
		NavigableMap<Integer, Character> navMap = new TreeMap<>();
		for (char alphabet = 65; alphabet <= 90; alphabet = (char) (alphabet + 3))
			navMap.put(getNumericValue(alphabet) - 9, alphabet);
		System.out.println("Alphabets: " + navMap);

		System.out.println("Alphabet less than or equal to 13: " + navMap.floorEntry(13));
		System.out.println("Alphabet less than 13: " + navMap.lowerEntry(13));
		System.out.println("Alphabet greater than or equal to 22: " + navMap.ceilingEntry(22));
		System.out.println("Alphabet greater than 22: " + navMap.higherEntry(22));

		System.out.println("Alphabets less than 22: " + navMap.headMap(22));
		System.out.println("Alphabets greater than or equal to 22: " + navMap.tailMap(22));

		System.out.println("Alphabets between 10(inclusive) and 22(exclusive): " + navMap.subMap(10, 22));
	}

	public static void main2(String[] args) {
		String str = "This is an awesome occasion. This has never happened before.";
		Map<String, Long> wordOccurances = stream(str.split("\\s")).collect(groupingBy(identity(), counting()));
		System.out.println(wordOccurances);
		Map<String, Long> characterOccurances = stream(str.split("(?!^)")).collect(groupingBy(identity(), counting()));
		System.out.println(characterOccurances);
		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray())
			chars.add(valueOf(ch));
		Map<Character, Long> alphabetOccurances = chars.stream().collect(groupingBy(identity(), counting()));
		System.out.println(alphabetOccurances);
	}

}
