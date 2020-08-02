package com.learn.strings;

import java.util.StringJoiner;

public class StringJoinerTest {
	
	public static void main(String[] args) {
		
		StringJoiner names = new StringJoiner(", ", "[", "]");
		
		names.setEmptyValue("It has no names.");
//		System.out.println(names);
		
		names.add("Sujay");
		names.add("Neha");
		names.add("Vilas");
		names.add("Supriya");
		
//		System.out.println(names.length());
		
		StringJoiner additionalNames = new StringJoiner(", ");
		additionalNames.add("Smit");
		additionalNames.add("Sunil");
		additionalNames.add("Sayli");
		
		StringJoiner mergedString = names.merge(additionalNames);
//		System.out.println(mergedString);
		
		System.out.println(mergedString.toString().charAt(6));
		
	}
	
}
