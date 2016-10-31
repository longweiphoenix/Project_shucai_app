package com.ljm.test0809;

public class Static {
	//static  修饰成员变量，可以只用（类名.属性名）来调用，也可以来调用（对象名.属性名）
	//静态属性
	static String name;
	//非静态属性
	int age = 10;
	
	//静态方法
	static void testA(){
		System.out.println("静态方法");
	}
	
	//非静态方法
	void testB(){
		System.out.println("非静态方法");
	}
	
	//定义一个非静态成员属性和一个非静态方法，自己尝试下在静态方法中直接调用非静态属性和非静态方法
	static void testX(){
//		testB();
//		System.out.println(age);
		Static s1 = new Static();
		s1.testB();
		System.out.println(s1.age);
	}     //在静态方法中，不能直接调用非静态属性和非静态方法
	
	//重新定义一个静态方法，然后分别在方法里面调用直接调用静态成员变量和静态方法，通过类的对象来调用非静态成员属性和非静态方法
	static void test(){
		System.out.println(name);//调用静态属性
		testA();//调用静态方法
		Static s = new Static();//实例化Static这个类的，创建一个对象s
		System.out.println(s.age);//调用非静态成员属性
		s.testB();//调用非静态方法
//		Static.name="zhangsan";//类调用
//		s.name="lisi";//对象调用	
	}
	
	//在定义一个非静态方法，分别直接调用非静态属性和非静态方法
	void testZ(){
		System.out.println(age);//调用非静态属性
		testB();//调用非静态方法
	}
	
	//写一个代码块里面打印一句话，查看代码块在什么时候执行
	//每创建对象一次，代码块执行一次
	{
		System.out.println("代码块");
	}
	//静态块:只执行一次且在程序运行时首先执行
	static{
		System.out.println("静态块");
	}

}
