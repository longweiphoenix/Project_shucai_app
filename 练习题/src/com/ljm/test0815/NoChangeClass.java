package com.ljm.test0815;

public class NoChangeClass {
	//定义常量
	private final String name;
	private final int age;
	
	//初始化
	public NoChangeClass(String name,int age){
		this.name = name;
		this.age = age;
	}
	//获取值
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	
	public String str(){
		return name;
	}
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj != null && obj.getClass() == this.getClass()){
			NoChangeClass nc = (NoChangeClass)obj;
			if(nc.getName().equals(this.name)&& nc.getAge() == this.getAge()){
				return true;
			}
		}
		return false;
	}

}
