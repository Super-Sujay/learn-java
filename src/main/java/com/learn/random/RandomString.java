package com.learn.random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomString {

	public static void main(String[] args) {
		System.out.println(randomString(9));
	}
	
	public static String randomString(int size) {
//		String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
		String alphaNumeric = "0123456789";
		StringBuilder sb = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			int index = ThreadLocalRandom.current().nextInt(alphaNumeric.length());
			sb.append(alphaNumeric.charAt(index));
		}
		return sb.toString();
	}

}
