package com.ljm.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TestCollections {
	
	public static void main(String[] args) {
		//��װ����
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(45);
		l.add(15);
		l.add(32);
		l.add(56);
		System.out.println("--------����ǰ-------------");
		for (Integer i: l) {
			System.out.println(i);
		}
		//�Ե���������������
		Collections.sort(l);
		
		System.out.println("---------�����----------------");
		for(Integer i: l){
			System.out.println(i);
		}
		/*
		 * ���ַ������ͼ��������ַ��������ʱ�����ȿ���һ���ַ��Ұ���0~9<A~Z<a~z��˳������
		 * �����һ���ַ���һ���ģ��ͻῴ�ڶ����ַ�
		 */
		List<String> str = new ArrayList<String>();
		str.add("ran");
		str.add("Xu");
		str.add("Xx");
		str.add("bai");
		str.add("li");
		str.add("Zhang");
		str.add("1x");
		str.add("lI");
		System.out.println("------------����ǰ--------------");
		Iterator<String> a = str.iterator();
		while(a.hasNext()){
			String s = a.next();
			System.out.println(s);
		}
		System.out.println("------------�����---------------");
		Collections.sort(str);
		for(String s: str){
			System.out.println(s);
		}
		/*
		 * �����Ҫ�Լ�������Ķ�������������ʱ�������ַ�ʽ��
		 * ��һ�֡����������Ҫȥʵ��Comparable�ӿ�
		 * �ڶ��֡�ֱ�Ӵ�һ��ʵ���࣬�����ʵ����Comparator�ӿ�
		 */
		
		TestCourse tc = new TestCourse();
		Course c = new Course(1,"����");
		tc.addCourse(c);
		tc.addCourse(new Course(5,"��ѧ"));
		tc.addCourse(new Course(2,"Ӣ��"));
		tc.addCourse(new Course(7,"����"));
		tc.addCourse(new Course(2,"��ѧ"));
		System.out.println("--------------����ǰ---------------");
		tc.searchAll();
		
		//ͨ��ʵ��Comparator�ӿڽ�������,
		Collections.sort(tc.getCourseAllList(), new Comparator<Course>(){

			@Override
			public int compare(Course arg0, Course arg1) {
				
				return arg0.getName().compareTo(arg1.getName());
			}
		});
		//Iterator id = tc.getCourseAllList().iterator();
		
		System.out.println("---------------�����name��--------------------");
		tc.searchAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
