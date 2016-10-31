package com.ljm.test0816;

public class OutClass {
	String name;
	static int age;
	
	public void test(){
		@SuppressWarnings("unused")
		char sex;
		//外部类里面的成员可以通过实例化内部类来使用
		InClass ic = new InClass();
		ic.InTest();
		System.out.println(ic.inname);
		//外部类里面的成员不能直接使用内部类里面的成员
		//System.out.println(inname);
		InStaticClass isc = new InStaticClass();
		isc.intest2();
	}

	public static void test2(){
		@SuppressWarnings("unused")
		String name;
		//方法里面可以使用外部类里面的其他成员
		System.out.println(age);
	}
	/**
	 * 非静态内部类
	 */
	public class InClass{
		//非静态内部类不允许定义静态成员
		String inname;
		
		public void InTest(){
			System.out.println("我是非静态内部类里面的方法");
			//非静态内部类可以使用外部类里面的其他成员
			System.out.println(OutClass.age);
			//调用外部类里面的其他方法
			test();
		}
	}
	/**
	 * 静态内部类
	 */
	static public class InStaticClass{
		//静态内部类里面不允许访问外部类里面的非静态成员
		static String inname;
		int inage;
		
		public static void intest(){
			//静态内部类不允许访问外部类里面的非静态成员
			//test();
			//但是可以访问外部类里面的静态成员
			test2();
			System.out.println(age);
		}
		//静态内部类里面的非静态成员
		public void intest2(){
			//即使是非静态成员也不能访问外部类的非静态成员
			//test();
		}
		
		//外部类里面的成员同样不能直接访问静态内部类的成员
	}
}
