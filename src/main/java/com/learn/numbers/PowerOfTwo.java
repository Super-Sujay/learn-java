package com.learn.numbers;

public class PowerOfTwo {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " is power of 2: " + powerOfTwo(i));
		}
	}
	
	static boolean powerOfTwo(int n) {
		if (n == 0) return false;
		while (n != 1) {
			if (n % 2 != 0) return false;
			n /= 2;
		}
		return true;
	}

}
