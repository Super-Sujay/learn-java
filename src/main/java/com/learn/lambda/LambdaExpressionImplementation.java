package com.learn.lambda;

/**
 * This class has use cases of Lambda Expressions
 * 
 * @author Sujay
 *
 */
public class LambdaExpressionImplementation {

	public static void main(String[] args) {
		
		//Lambda Expression in its basic form
		MathOperation addition = (int a, int b) -> a + b;
		
		//No need to define variable type
		MathOperation subtraction = (a, b) -> a - b;
		
		//Can provide more than one line of code by using { }
		MathOperation multiplication = (a, b) -> {
			return a * b;
		};

		//Normal lambda expression
		MathOperation division = (a, b) -> a / b;
		
		System.out.println("10 + 5 = " + operation(10, 5, addition));
		System.out.println("10 - 5 = " + operation(10, 5, subtraction));
		System.out.println("10 * 5 = " + operation(10, 5, multiplication));
		System.out.println("10 / 5 = " + operation(10, 5, division));
		
		//Lambda Expression for GreetingMessage
		GreetingMessage gm = t -> System.out.println("name: " + t);
		gm.message("Sujay");
		gm.message("Neha");

	}

	/**
	 * This is a Functional Interface of MathOperation
	 * 
	 * @author Sujay
	 *
	 */
	@FunctionalInterface
	interface MathOperation {
		int operation(int a, int b);
	}

	/**
	 * This is a Functional Interface of GreetingMessage
	 * 
	 * @author Sujay
	 *
	 */
	@FunctionalInterface
	interface GreetingMessage {
		void message(String name);
	}

	/**
	 * This method is used to perform necessary operations
	 * 
	 * @param a number
	 * @param b number
	 * @param mo MathOperation
	 * @return result
	 */
	private static int operation(int a, int b, MathOperation mo) {
		return mo.operation(a, b);
	}

}
