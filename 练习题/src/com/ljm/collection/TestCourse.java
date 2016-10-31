package com.ljm.collection;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * 泛型：
 * @author Administrator
 *
 */

public class TestCourse {
	//定义一个装所有数组的集合
	private List<Course> courseAllList;
	
	public TestCourse(){
		//初始化集合
		courseAllList = new ArrayList<Course>();
	}
	
	/*
	 *给这个集合增加数据 
	 */
	public void addCourse(Course course){
		//用add方法添加单个数据
		courseAllList.add(course);
	}
	
	/*
	 * 另一种添加方法
	 */
	public void addCourse(int position,Course course){
		//通过add方法的重载添加到指定位置
		System.out.println(courseAllList.size());
		if(position>=0 && position<=courseAllList.size()){
			courseAllList.add(position,course);
		}else{
			System.out.println("您输入的下标越界");
		}
	}
	
	/*
	 * 把集合里面的所有数据添加到另一个集合里面
	 */
	public void addAllCourse(List<Course> list){
		//通过addAll方法把其他集合里面的元素添加到当前集合
		courseAllList.addAll(list);
	}
	
	/*
	 *把集合里面的所有数据添加到另一个集合的指定位置去 
	 */
	public void addAllCourse(int position,List<Course> list){
		//通过add方法的重载添加到指定位置
		//判断指定位置越界没有
		if (position>=0 && position<=courseAllList.size()) {
			courseAllList.addAll(position, list);
		}else{
			System.out.println("下标越界");
		}
	}
	
	/*
	 * 查询集合里面的数据
	 */
	public void searchAll(){
		for (int i = 0; i < courseAllList.size(); i++) {
			//通过for遍历集合原始返回的是object对象
			Course c = (Course)courseAllList.get(i);
			System.out.println("课程id："+c.getId()+"\t课程名："+c.getName());
		}
	}
	
	/*
	 * 通过迭代器Iterator来遍历
	 */
	public void searchIterator(){
		System.out.println("-------下面是通过迭代器Iterator循环遍历的------------");
		//通过集合里面的iterator（）方法来获取Iterator的对象
		Iterator<Course> i = courseAllList.iterator();
		//通过hasNext来判断是否还有元素
		while(i.hasNext()){
			//通过Iterator里面的next（）方法来获取集合里面的对象
			Course c = (Course)i.next();
			//打印
			System.out.println("课程id："+c.getId()+"\t课程名："+c.getName());
		}
	}
	
	/*
	 * for each循环遍历
	 */
	public void srarchForeach(){
		System.out.println("--------下面是通过foreach迭代器循环遍历的-----------");
		for(Course obj: courseAllList){
			Course c = obj;
			System.out.println("课程id："+c.getId()+"\t课程名："+c.getName());

		}
	}
	
	/*
	 * 获取集合里面的某一个元素
	 */
	public void searchOne(int position){
		Course c = courseAllList.get(position);
		System.out.println("课程id："+c.getId()+"\t课程名："+c.getName());

	}
	
	
	/*
	 * 删除集合里面的数据
	 */
//	public void remove(int position){
//		Course c = courseAllList.get(position);
//		System.out.println("课程id："+c.getId()+"\t课程名："+c.getName());
//		courseAllList.remove(position);
//		System.out.println("删除成功");
//		searchAll();
//		
//	}
//
//	public void removeCourse() {
//		// TODO Auto-generated method stub
//		
//	}
	
//	public void removeCourse(){
//		//Course[] courses = {courseAllList.get(4),courseAllList.get(5)};
//		Course c = (Course) courseAllList.get(3);
//		System.out.println("课程："+c.getId()+"."+c.getName());
//		courseAllList.remove(c);
//		//courseAllList.removeAll(Arrays.asList(courses));
//		System.out.println("成功删除");
//		searchAll();
//	}
	/**
	 * 今天的课程
	 */
	/*
	 * 利用remove方法来删除集合里面的元素
	 */
	public void remove(int position){
		courseAllList.remove(position);
	}
	/*
	 * 利用remove的重载方法移除集合中首次出现的元素
	 */
	public void remove(Object o){
		courseAllList.remove(o);
	}
	/*
	 * 修改集合里面的某一个元素
	 */
	public void set(int position,Course c){
		courseAllList.set(position, c);
	}
	/*
	 * 清空集合
	 */
	public void clearList(){
		courseAllList.clear();
	}
	/*
	 * 根据课程id来返回课程对象
	 */
	public Course getChooseCourse(int id){
		//遍历查询课程集合里面是否有选择课程
		for(Course c: courseAllList){
			if(id == c.getId()){
				//查询到就返回
				return c;
			}
		}
		//如果没有找到就返回一个null
		return null;
	}

	public List<Course> getCourseAllList() {
		return courseAllList;
	}

	public void setCourseAllList(List<Course> courseAllList) {
		this.courseAllList = courseAllList;
	}

}
