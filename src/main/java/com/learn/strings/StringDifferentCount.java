package com.learn.strings;

public class StringDifferentCount {

	public static void main1(String[] args) {
		String str = "MyN@me!s$ujayS@want123";
		int upper = 0, lower = 0, number = 0, special = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				upper++;
			else if (ch >= 'a' && ch <= 'z')
				lower++;
			else if (ch >= '0' && ch <= '9')
				number++;
			else
				special++;
		}
		System.out.println("Lower case letters : " + lower);
		System.out.println("Upper case letters : " + upper);
		System.out.println("Number : " + number);
		System.out.println("Special characters : " + special);
	}
	
	public static void main2(String[] args) {
		String str = "MyN@me!s$ujayS@want123";
		int upper = 0, lower = 0, number = 0, special = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch))
				upper++;
			else if (Character.isLowerCase(ch))
				lower++;
			else if (Character.isDigit(ch))
				number++;
			else
				special++;
		}
		System.out.println("Lower case letters : " + lower);
		System.out.println("Upper case letters : " + upper);
		System.out.println("Number : " + number);
		System.out.println("Special characters : " + special);
	}

}
