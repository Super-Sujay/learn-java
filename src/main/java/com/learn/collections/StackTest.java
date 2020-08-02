package com.learn.collections;

import java.util.Stack;

public class StackTest {

	private static void stack_push(Stack<Integer> stack) {
		for (int i = 0; i < 5; i++)
			System.out.println("Push: " + stack.push(i));
	}
	
	private static void stack_pop(Stack<Integer> stack) {
		for (int i = 0; i < 5; i++)
			System.out.println("Pop: " + stack.pop());
	}
	
	private static void stack_peek(Stack<Integer> stack) {
		System.out.println("Element on stack top: " + stack.peek());
	}
	
	private static void stack_search(Stack<Integer> stack, int element) {
		int pos = stack.search(element);
		if(pos == -1)
			System.out.println("Element " + element + " not found");
		else
			System.out.println("Element " + element + " is found at position: " + pos);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack_push(stack);
		System.out.println(stack);
		stack_pop(stack);
		System.out.println(stack);
		stack_push(stack);
		System.out.println(stack);
		stack_peek(stack);
		stack_search(stack, 2);
		stack_search(stack, 6);
	}

}
