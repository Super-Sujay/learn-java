package com.learn.generics;

interface Car {
	
	String name = "Car";
	
	public void topSpeed();
	
	public void acceleration();
	
	public void handling();
	
}

class Audi implements Car {

	@Override
	public void topSpeed() {
		System.out.println("Top Speed: 260 KM/Hr");
	}

	@Override
	public void acceleration() {
		System.out.println("Acceleration: 14m/s2");
	}

	@Override
	public void handling() {
		System.out.println("Handling: 191 torque");
	}
	
}

class Bmw implements Car {

	@Override
	public void topSpeed() {
		System.out.println("Top Speed: 389 KM/Hr");
	}

	@Override
	public void acceleration() {
		System.out.println("Acceleration: 28m/s2");
	}

	@Override
	public void handling() {
		System.out.println("Handling: 221 torque");
	}
	
}


public class ClassTest {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Car c1 = new Audi();
		Car c2 = new Bmw();
		
		Class<? extends Car> c = c1.getClass();
	}

	
}