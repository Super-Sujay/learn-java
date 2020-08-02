package com.learn.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetToArray {

	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>(Arrays.asList(1, 3, 2, 4, 8, 9, 0));

//		Integer[] boxedIntSet = hashSet.toArray(new Integer[hashSet.size()]);
		Integer[] boxedIntSet = hashSet.stream().toArray(Integer[]::new);
		System.out.println("Integer[] boxedIntSet contents: " + Arrays.toString(boxedIntSet));

		int[] intSet = hashSet.stream().mapToInt(Integer::valueOf).toArray();
		System.out.println("int[] intSet contents: " + Arrays.toString(intSet));
	}

}
