package com.learn.collections;

import static java.util.Comparator.naturalOrder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		// Queue implementation using PriorityQueue returns binary tree
		// representation with the comparator logic provided
		Queue<Integer> pQueue = new PriorityQueue<Integer>(20, naturalOrder());
		for (int i = 19; i > 0; i--)
			pQueue.offer(i);
		System.out.println(pQueue);

		// Queue implementation using LinkedList return a normal queue following
		// FIFO mechanism
		pQueue = new LinkedList<Integer>();
		for (int i = 19; i > 0; i--)
			pQueue.offer(i);
		System.out.println(pQueue);

		// Deque is double ended queue which follows FIFO mechanism
		Deque<Integer> numbers = new LinkedList<Integer>();
		for (int i = 19; i > 0; i--)
			numbers.offer(i);
		System.out.println(numbers);

	}

}
