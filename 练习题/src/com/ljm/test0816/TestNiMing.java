package com.ljm.test0816;

public class TestNiMing {
	public static void main(String[] args) {
		/**
		 * 匿名内部类
		 */
		InsterfaceTest ift = new InsterfaceTest(){//创建一个匿名内部类 

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("已经懵了");
			}
			
		};
		ift.eat();
		//创建对象ClassA
		ClassA c = new ClassA(new InsterfaceTest(){

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("yunle");
			}
			
		});
		c.eat();
		
		new InsterfaceTest(){

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("111111111");
			}}.eat();
	}
}
