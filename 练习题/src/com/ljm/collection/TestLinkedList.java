package com.ljm.collection;

import java.util.Iterator;
import java.util.LinkedList;



public abstract class TestLinkedList {
	/**
	 *LinkedList同样是有序并且可以重复的 									
	 */
	static LinkedList<Course> l = new LinkedList<Course>();
	
	public static void main(String[] args){
		//添加
		l.add(new Course(1,"数学"));
		//添加
		l.push(new Course(2,"语文"));
		//使用addFirst方法来添加
		l.addFirst(new Course(3,"英语"));
		//l.add(new Course(1,"物理"));
		//l.push(new Course(1,"地理"));
		l.addFirst(new Course(4,"物理"));
		boolean b = l.offer(new Course(5,"物理"));
		//Course c = l.getFirst();
		System.out.println(b);
		//System.out.println(c.getId()+"\t"+c.getName());
		//打印存储在集合中的数据 Iterator
		
	for (Iterator<Course> a = l.iterator();a.hasNext(); ) {
		//Course c1 = (Course)a.next();
		System.out.println((Course)a.next());
	}	
//		while(a.hasNext()){
//			Course c1 = (Course) a.next();
//			System.out.println(c1.getId()+" "+c1.getName());
//		}
		//foreach
//		for (Course c1: l) {
//			//if(c1!=null)
//			System.out.println(c1.getId()+" "+c1.getName());
//		}
		System.out.println("------------------------------");
		/*
		 * 获取第一个元素但不删除集合里面的元素
		 */
		Course c = l.peek();
		System.out.println(c.getId()+" "+c.getName());
		System.out.println("_____________________________");
		/*
		 * 获取集合里面的第一个元素并且移除集合里面的元素
		 */
		Course c1 = l.poll();
		System.out.println(c1.getId()+" "+c1.getName());
		
		System.out.println("*****************************");
		for(Course c2: l){
			System.out.println(c2.getId()+" "+c2.getName());
		}
	}
}
