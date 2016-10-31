package com.ljm.test3;

public class People {
	//定义属性
	private String name;
	private String sex;
	private int age;
	//构造方法
	People(){
		System.out.println("无参构造方法");
	}
	
	People(String n){
		name = n;
		System.out.println(n);
	}
	
	public void Message(){
		System.out.println("无参");
	}
	
	public void Message(String neme){
		System.out.println("有参");
	}
	
	public void Message(String name,String sex){
		System.out.println("同参，不同个数");
	}
	
	public void Message(String neme,int age){
		System.out.println("不同参，同个数");
	}
	
	
	public void display(){
		
		System.out.println("姓名:"+name);
		System.out.println("年龄:"+age);
	}

}
