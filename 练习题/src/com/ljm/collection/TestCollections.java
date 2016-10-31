package com.ljm.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TestCollections {
	
	public static void main(String[] args) {
		//组装数据
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(45);
		l.add(15);
		l.add(32);
		l.add(56);
		System.out.println("--------排序前-------------");
		for (Integer i: l) {
			System.out.println(i);
		}
		//对单个整数进行排序
		Collections.sort(l);
		
		System.out.println("---------排序后----------------");
		for(Integer i: l){
			System.out.println(i);
		}
		/*
		 * 对字符串类型集合排序，字符串排序的时候，首先看第一个字符且按照0~9<A~Z<a~z的顺序排序，
		 * 如果第一个字符是一样的，就会看第二个字符
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
		System.out.println("------------排序前--------------");
		Iterator<String> a = str.iterator();
		while(a.hasNext()){
			String s = a.next();
			System.out.println(s);
		}
		System.out.println("------------排序后---------------");
		Collections.sort(str);
		for(String s: str){
			System.out.println(s);
		}
		/*
		 * 如果需要对集合里面的对象进行排序，这个时候有两种方式：
		 * 第一种、对象的类需要去实现Comparable接口
		 * 第二种、直接传一个实现类，这个类实现了Comparator接口
		 */
		
		TestCourse tc = new TestCourse();
		Course c = new Course(1,"语文");
		tc.addCourse(c);
		tc.addCourse(new Course(5,"数学"));
		tc.addCourse(new Course(2,"英语"));
		tc.addCourse(new Course(7,"物理"));
		tc.addCourse(new Course(2,"化学"));
		System.out.println("--------------排序前---------------");
		tc.searchAll();
		
		//通过实现Comparator接口进行排序,
		Collections.sort(tc.getCourseAllList(), new Comparator<Course>(){

			@Override
			public int compare(Course arg0, Course arg1) {
				
				return arg0.getName().compareTo(arg1.getName());
			}
		});
		//Iterator id = tc.getCourseAllList().iterator();
		
		System.out.println("---------------排序后（name）--------------------");
		tc.searchAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
