package com.learn.arrays;

import java.util.Arrays;

public class RemoveNullValues {

	public static void main(String[] args) {
		String[] names = { "Sujay", null, "Anurag", null, "Prashant" };
		System.out.println("Before: " + Arrays.toString(names));
		// List<String> list = new ArrayList<String>(Arrays.asList(names));
		// list.removeIf(o -> o == null);
		// list.removeAll(Collections.singleton(null));
		// System.out.println(list);
		// List<String> list = Arrays.stream(names).filter(name -> name !=
		// null).collect(Collectors.toList());
		// names = list.toArray(new String[list.size()]);
		names = Arrays.stream(names).filter(name -> name != null).toArray(String[]::new);
		System.out.println("After: " + Arrays.toString(names));
		Arrays.sort(names);
		System.out.println("After sorting: " + Arrays.toString(names));
	}
	
	public static void main1(String[] args) {
		Integer[] arr = { 0, null, 1, null, 2, null, 3, null, 4, null, 5 };
		System.out.println(Arrays.toString(arr));
		arr = Arrays.stream(arr).filter(i -> i != null).toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main3(String[] args) {
		Integer[] arr = { 0, null, 1, null, 2, null, 3, null, 4, null, 5 };
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null)
				arr[count++] = arr[i];
		}
		arr = Arrays.copyOf(arr, count);
		System.out.println(Arrays.toString(arr));
	}
	
}
