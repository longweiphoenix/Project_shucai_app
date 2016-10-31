package com.ljm.test0809;

public class TestStatic {

	public static void main(String[] args) {
		//定义一个静态属性，然后创建一个测试类，在测试里面，分别用类名直接打印属性的值和通过对象打印属性的值
		System.out.println(Static.name+"(通过类名打印属性的值)");
		Static s = new Static();
		System.out.println(s.name+"(通过对象打印属性的值)");
		
		System.out.println("---------------------------");
		//静态方法调用非静态方法
		Static.testX();
		
		System.out.println("-----------------------");
		//写一个静态方法，然后在测试类里面，分别用类名调用方法和通过对象调用方法
		Static.testA();
		Static s1 = new Static();
		s1.testA();
		
		System.out.println("-----------------------------");
		//重新定义一个静态方法，然后分别在方法里面调用直接调用静态成员变量和静态方法，通过类的对象来调用非静态成员属性和非静态方法
		Static.test();
		
		System.out.println("------------------------------");
		//在定义一个非静态方法，分别直接调用非静态属性和非静态方法(此时，不能直接调用没有被static修饰的方法)
		Static s2 = new Static();
		s2.testZ();
	
	}

}
