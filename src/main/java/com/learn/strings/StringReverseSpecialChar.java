package com.learn.strings;

import java.util.HashMap;
import java.util.Map;

public class StringReverseSpecialChar {

	public static void reverse(char str[]) {
		for (int r = str.length - 1, l = 0; l < r;) {
			if (!Character.isAlphabetic(str[l])) l++;
			else if (!Character.isAlphabetic(str[r])) r--;
			else {
				char tmp = str[l];
				str[l] = str[r];
				str[r] = tmp;
				l++;
				r--;
			}
		}
	}

	public static void main1(String[] args) {
		String str = "My$name%is#Sujay@Sawant";
		char[] charArray = str.toCharArray();
		System.out.println("Input string : " + str);
		reverse(charArray);
		String revStr = new String(charArray);
		System.out.println("Output string: " + revStr);
	}

	public static void main(String[] args) {
		String str = "My$name%is#Sujay@Sawant";
		System.out.println("Input string : " + str);
		int n = str.length();
		Map<Integer, Character> specialChar = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (!(ch >= 'A' && ch <= 'z'))
				specialChar.put(i, ch);
		}
		str = str.replaceAll("[^a-zA-Z]", "");
		StringBuilder s = new StringBuilder(n);
		for (int i = 0, c = str.length(); i < n; i++) {
			if (specialChar.containsKey(i)) {
				s.append(specialChar.get(i));
				continue;
			}
			s.append(str.charAt(--c));
		}
		String reverseStr = s.toString();
		System.out.println("Output string: " + reverseStr);
	}

}
