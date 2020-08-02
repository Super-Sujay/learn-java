package com.learn.generics;

import java.util.List;
import java.util.ArrayList;

/**
 * This class gives us the use cases of Java Generics.
 * 
 * @author Sujay
 *
 */
public class GenericMethods {

	/**
	 * This method will print any type of variable.
	 * 
	 * @param t
	 */
	static <T> void print(T t) {
		System.out.println("The information to print is: " + t);
	}

	/**
	 * This method will print any type of List.
	 * 
	 * @param list
	 */
	static <T> void printList(List<T> list) {
		for (T t : list) {
			System.out.println(t.getClass().getSimpleName() + " " + t + " ");
		}
	}

	/**
	 * This method will print any type of List that extends the Number class.
	 * 
	 * @param list
	 */
	static void printNumberList(List<? extends Number> list) {
		for (Number number : list) {
			System.out.println(number.getClass().getSimpleName() + " " + number + " ");
		}
	}

	/**
	 * This method will compare any data type values and find the maximum from
	 * it.
	 * 
	 * @param t1
	 * @param t2
	 * @param t3
	 * @return
	 */
	static <T extends Comparable<T>> T maximum(T t1, T t2, T t3) {
		T max = t1;
		if (t2.compareTo(max) > 0)
			max = t2;
		if (t3.compareTo(max) > 0)
			max = t3;
		return max;
	}

	public static void main(String[] args) {

		print("Sujay");
		print('A');
		print(20);
		print(5.9f);
		print(20.595);

		List<String> strList = new ArrayList<String>();
		strList.add("Sujay");
		strList.add("Neha");
		strList.add("Vilas");
		strList.add("Supriya");

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(11);
		intList.add(1111);
		intList.add(11111);
		intList.add(111111);

		printList(strList);
		printNumberList(intList);

		System.out.println("Maximum of 1, 2 and 3 is: " + maximum(1, 2, 3));
		System.out.println("Maximum of 8.8, 6.6 and 7.7 is: " + maximum(8.8, 6.6, 7.7));
		System.out.println("Maximum of G, Z and $ is: " + maximum('G', 'Z', '$'));
		System.out.println("Maximum of Aaa, Bbb and Ccc is: " + maximum("Aaa", "Bbb", "Ccc"));
	}

}