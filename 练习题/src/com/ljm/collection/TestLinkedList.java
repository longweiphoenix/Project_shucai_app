package com.ljm.collection;

import java.util.Iterator;
import java.util.LinkedList;



public abstract class TestLinkedList {
	/**
	 *LinkedListͬ���������ҿ����ظ��� 									
	 */
	static LinkedList<Course> l = new LinkedList<Course>();
	
	public static void main(String[] args){
		//���
		l.add(new Course(1,"��ѧ"));
		//���
		l.push(new Course(2,"����"));
		//ʹ��addFirst���������
		l.addFirst(new Course(3,"Ӣ��"));
		//l.add(new Course(1,"����"));
		//l.push(new Course(1,"����"));
		l.addFirst(new Course(4,"����"));
		boolean b = l.offer(new Course(5,"����"));
		//Course c = l.getFirst();
		System.out.println(b);
		//System.out.println(c.getId()+"\t"+c.getName());
		//��ӡ�洢�ڼ����е����� Iterator
		
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
		 * ��ȡ��һ��Ԫ�ص���ɾ�����������Ԫ��
		 */
		Course c = l.peek();
		System.out.println(c.getId()+" "+c.getName());
		System.out.println("_____________________________");
		/*
		 * ��ȡ��������ĵ�һ��Ԫ�ز����Ƴ����������Ԫ��
		 */
		Course c1 = l.poll();
		System.out.println(c1.getId()+" "+c1.getName());
		
		System.out.println("*****************************");
		for(Course c2: l){
			System.out.println(c2.getId()+" "+c2.getName());
		}
	}
}
