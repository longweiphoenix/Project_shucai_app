package com.ljm.collection;

public class TestGenericity {
	public static void main(String[] args) {
		//���巺����Genericity��һ��Integer�汾
		Genericity<Integer> intOb = new Genericity<Integer>(88);
		intOb.showType();
		int i = intOb.getOb();
		System.out.println("value="+i);
		System.out.println("-------------------");
		//���巺�����һ��String�汾
		Genericity<String> strOb = new Genericity<String>("Hello");
		strOb.showType();
		String str = strOb.getOb();
		System.out.println("value="+str);
		
		System.out.println("****************************************");
		//������Genericity1��һ��Integer�汾
		Genericity1 g = new Genericity1(new Integer(88));
		g.showType();
		int in = (Integer)g.getOb();
		System.out.println("value="+in);
		System.out.println("----------------");
		//������Genericity1��һ��String�汾
		Genericity1 s = new Genericity1("���");
		s.showType();
		String st = (String)s.getOb();
		System.out.println("value="+st);
	}
}
