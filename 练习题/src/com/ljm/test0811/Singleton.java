package com.ljm.test0811;

public class Singleton {
	//定义一个静态的引用变量来存储当前类的对象
	private static Singleton instance;
	//让当前类不能实例化
	private Singleton(){
		
	}
	//定义一个静态方法来给外部提供当前的实例对象
	public static Singleton getInstance(){
		/*
		 * 当第一次调用本类该方法的时候instance为null，就会进入if去创建一个实例，
		 * 当之后调用该方法的时候，instance就不会为null，所以不管调多少次都是同一个实例
		 */
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}

}
