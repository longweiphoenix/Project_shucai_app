package com.ljm.test3;

public class People {
	//��������
	private String name;
	private String sex;
	private int age;
	//���췽��
	People(){
		System.out.println("�޲ι��췽��");
	}
	
	People(String n){
		name = n;
		System.out.println(n);
	}
	
	public void Message(){
		System.out.println("�޲�");
	}
	
	public void Message(String neme){
		System.out.println("�в�");
	}
	
	public void Message(String name,String sex){
		System.out.println("ͬ�Σ���ͬ����");
	}
	
	public void Message(String neme,int age){
		System.out.println("��ͬ�Σ�ͬ����");
	}
	
	
	public void display(){
		
		System.out.println("����:"+name);
		System.out.println("����:"+age);
	}

}
