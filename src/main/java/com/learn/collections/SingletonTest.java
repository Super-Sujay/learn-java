package com.learn.collections;

class MySingleton {

	private static MySingleton instance;
	public int x;

	private MySingleton() {
		x = 10;
	}

	public static MySingleton getInstance() {
		if (instance == null)
			instance = new MySingleton();
		return instance;
	}

}

public class SingletonTest {

	public static void main(String[] args) {
		MySingleton a = MySingleton.getInstance();
		MySingleton b = MySingleton.getInstance();

		a.x += 10;

		System.out.println("Value of a.x = " + a.x);
		System.out.println("Value of b.x = " + b.x);
	}

}