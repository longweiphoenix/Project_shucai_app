package com.ljm.test0815;

public class NoChangeClass {
	//���峣��
	private final String name;
	private final int age;
	
	//��ʼ��
	public NoChangeClass(String name,int age){
		this.name = name;
		this.age = age;
	}
	//��ȡֵ
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
