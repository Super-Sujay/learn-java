package com.learn.generics;

import java.util.Arrays;

public class StringMethods {

	public static void main(String[] args) {

		String str = "My name is Sujay Sawant";

		// Character at specific position
		char c = str.charAt(11);
		System.out.println("The character at 11 position is: " + c);

		// Unicode number of character at specific position
		int i = str.codePointAt(11);
		System.out.println("Unicode number of character at 11 position which is " + (char) i + " is " + i);

		// Unicode number of character before the specific position
		int j = str.codePointBefore(9);
		System.out.println("Unicode number of character at 8 position which is " + (char) j + " is " + j);

		// Checks the whole string value is same or not
		StringBuilder str1 = new StringBuilder("Sujay");
		System.out.println("String str contains str1: " + str.contentEquals(str1));

		// Checks wheter the string values are same
		// Returns int value of the difference in length of string
		String s1 = "Sujay";
		String s2 = "Sujay Sawant";
		System.out.println("Is String s1 and s2 same: " + s1.compareTo(s2));

		// Add one String to another
		String s3 = s1.concat(" Sawant");
		System.out.println("Concatinated String is: " + s3);

		// One string contains another string
		System.out.println("Does String s2 contain s1: " + s2.contains(s1));

		// Replace Strings
		s1 = "Sujay Sawant Sujay Sawant Sujay Sawant";
		s3 = s1.replace("Sujay", "Vilas");
		String s4 = s1.replaceFirst("Sujay", "Vilas");
		System.out.println("Replaced String is: " + s3);
		System.out.println("Replaced First String is: " + s4);

		// Split Strings into string array
		String[] split = str.split(" ");
		System.out.println("Split string array is: " + Arrays.toString(split));
	}

}