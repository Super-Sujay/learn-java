package com.learn.collections;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<String> queue = Stream.of("Zebra", "Monkey", "Cat", "Apple").collect(PriorityQueue::new, Queue::offer, Queue::addAll);
		System.out.println("Queue: " + queue);
		System.out.println("Queue head(removed): " + queue.poll());
		System.out.println("Queue: " + queue);
		
		queue = Stream.of("Zebra", "Monkey", "Cat", "Apple").collect(() -> new PriorityQueue<String>(comparing(String::length).reversed()), Queue::offer, Queue::addAll);
		System.out.println("New Queue: " + queue);
	}

	public static void main3(String[] args) {

		// Creating an empty Queue
		Queue<String> queue = new LinkedList<String>();

		// Adding elements to the Queue
		queue.offer("C");
		queue.offer("C++");
		queue.offer("Java");
		queue.offer("Python");
		System.out.println(queue);

		// Printing the most priority value
		System.out.println(queue.peek());

		// Printing all the elements of the Queue
		System.out.println("All elements of the Priority Queue: " + queue);

		// Removing the top priority element
		queue.poll();
		System.out.println("All elements after removing the top priority element: " + queue);

		// Removing using remove method
		System.out.println("Removing using remove method");
		queue.remove("Java");
		System.out.println("All elements after removing Java: " + queue);

		// Check if the element is present
		boolean b = queue.contains("C");
		System.out.println("Is C present? " + b);

		// Getting objects from Queue to Array
		Object[] data = queue.toArray();
		System.out.println("Contents of the object: " + Arrays.toString(data));
		queue.add("C");
		queue.add("Java");

		// String[] strings = queue.toArray(new String[queue.size()]);
		String[] strings = queue.stream().toArray(String[]::new);
		System.out.println("Contents of the string: " + Arrays.toString(strings));
	}

	public static void main2(String[] args) {
		Queue<Integer> pQueue = new PriorityQueue<Integer>(naturalOrder());
		for (int i = 19; i > 0; i--)
			pQueue.offer(i);
		System.out.println(pQueue);
	}

}
