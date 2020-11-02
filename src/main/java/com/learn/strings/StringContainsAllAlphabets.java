package com.learn.strings;

import java.util.HashSet;
import java.util.Set;

public class StringContainsAllAlphabets {

	public static void main(String[] args) {
		String str = "aAbBcCdDeEf FgGhHiIjJkKl LmMnNoOpP qQrRsStTuUvV wWxXyYzZ";
		Set<Integer> compareSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".chars().collect(HashSet::new, Set::add, Set::addAll);
		Set<Integer> mySet = str.chars().collect(HashSet::new, Set::add, Set::addAll);
		boolean ans = mySet.equals(compareSet); 
		System.out.println(ans);
	}
	
	public static void main1(String[] args) {
		String str1 = "abcdefghijklmnopqrstuvwxyz";
		String str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		boolean ans1 = str1.chars().allMatch(i -> i >= 97 && i <= 122);
		boolean ans1 = str1.chars().allMatch(i -> i >= 'a' && i <= 'z');
//		boolean ans2 = str2.chars().allMatch(i -> i >= 65 && i <= 90);
		boolean ans2 = str2.chars().allMatch(i -> i >= 'A' && i <= 'Z');
		System.out.println(ans1 + " " + ans2);
	}

}
