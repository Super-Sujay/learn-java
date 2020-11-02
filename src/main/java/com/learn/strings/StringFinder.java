package com.learn.strings;

public class StringFinder {

	public static void main(String[] args) {
		String str = "hi i am higher than the highest mountain", findStr = "hi";
		System.out.println("Count of occurence: " + countOfStringOccurance(str, findStr));
	}

	private static int countOfStringOccurance(String data, String sub) {
		int lastIndex = 0, count = 0;
		while (lastIndex != -1) {
			lastIndex = data.indexOf(sub, lastIndex);
			if (lastIndex != -1) {
				count++;
				lastIndex += sub.length();
			}
		}
		return count;
	}

}
