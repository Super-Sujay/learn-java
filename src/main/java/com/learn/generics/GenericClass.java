package com.learn.generics;

/**
 * This class is used to test Entry class
 * 
 * @see Entry
 * @author Sujay
 *
 */
public class GenericClass {

	public static void main(String[] args) {

		// Initializing the variables
		Entry<Integer, String> e1 = new Entry<Integer, String>(1, "Sujay");
		Entry<Integer, String> e2 = new Entry<Integer, String>(2, "Vilas");
		Entry<Integer, String> e3 = new Entry<Integer, String>(3, "Supriya");

		// Using different methods of Entry Class
		System.out.println("Entry 1 is: " + e1.toString());
		System.out.println("Entry 2 key is: " + e2.getKey());
		System.out.println("Entry 3 value is: " + e3.getValue());

		// Using conditional statements
		Entry<String, Boolean> e4 = new Entry<String, Boolean>("Payal", false);
		if (e4.getValue())
			System.out.println(e4.getKey() + " is married");
		else
			System.out.println(e4.getKey() + " is not married");

	}

}