package com.learn.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {

	public static void main1(String[] args) {
		System.out.println(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
	}

	public static void main2(String[] args) {
		System.out.println(new Random().nextInt(Integer.MAX_VALUE));
	}

	public static void main(String[] args) {
		System.out.println(random(100, 1000));
	}

	private static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
