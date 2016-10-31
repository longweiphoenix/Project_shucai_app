package com.ljm.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Student {
	private int id;
	private String name;
	
	//set集合里面的元素是无序并且不可重复的
	private Set<Course> courseSet;
	
	//构造方法
	public Student(int id,String name){
		this.id = id;
		this.name = name;
		//初始化集合，指向实现类
		courseSet = new HashSet<Course>();
	}
	
	//封装
	public Set<Course> getCourseLisr(){
		return courseSet;
	}
	public void setCourseList(Set<Course> courseList){
		this.courseSet = courseList;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * set集合的一些用法
	 */
	
	/*
	 * 添加元素
	 */
	public void studentChooseCourse(Course c){
		courseSet.add(c);
	}
	/*
	 * set集合只能通过两种迭代器来遍历（Iterator，foreach）
	 */
	public void searchChooseCourse(){
		Iterator<Course> i = courseSet.iterator();
		//查找是否还有元素
		while(i.hasNext()){
			Course c = i.next();
			System.out.println("---------下面是你选的课程---------------");
			System.out.println("课程id："+c.getId()+"\t课程名称："+c.getName());
		}
	}
	/*
	 * 删除set集合里面的元素
	 */
	public void deleteChooseCourse(Course c){
		courseSet.remove(c);
	}
	/*
	 * 伪修改set集合
	 */
	public void updateChooseCourse(int id,Course c){
		//Iterator<Course> i = courseSet.iterator();
		Course c1 = null;
		//查询是否还有元素
		//查询到我们要修改的课程时就退出循环
		/**
		 * 尽量不要用迭代器遍历的时候去修改
		 */
		/*while(i.hasNext()){
			c1 = i.next();
			
			if (id == c1.getId()) {
				c1 = c;
				break;
			}
		}*/
		
		//用foreach修改，也不能修改
		for(Course c2: courseSet){
			if(id == c2.getId()){
				c1 = c2;
				break;
			}
		}
		//删除要需改的课程
		deleteChooseCourse(c1);
		//添加修改后的课程
		studentChooseCourse(c);
	}
	
	
	
	
	
}
