package com.ljm.test0815;

public class Cat extends Animal implements Pet{
	
	

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("I want to eat some fish");
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("This is a cat");
	}
}
