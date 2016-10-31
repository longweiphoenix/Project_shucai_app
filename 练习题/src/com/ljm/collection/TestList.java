package com.ljm.collection;

import java.util.Arrays;
import java.util.Scanner;

public class TestList {
	public static void main(String[] args) {
		//第一步创建一个对象
		TestCourse tc = new TestCourse();
		
		Course c = new Course(1,"数学");
		tc.addCourse(c);
		tc.addCourse(c);
		//tc.searchAll();
		c = new Course(2,"语文");
		tc.addCourse(c);
		c = new Course(3,"英语");
		tc.addCourse(2,c);
		//tc.searchAll();
		
		Course[] cou = {new Course(4,"化学"),new Course(5,"物理")};
		//把数组转换成集合传过去
		tc.addAllCourse(Arrays.asList(cou));
		//tc.searchAll();
		
		Course[] coul = {new Course(6,"地理"),new Course(7,"历史")};
		tc.addAllCourse(3,Arrays.asList(coul));
		//tc.searchAll();
		
		//tc.removeCourse(3);
		tc.searchAll();
		tc.searchIterator();
		tc.srarchForeach();
		System.out.println("**************************");
		//tc.removeCourse();
		tc.remove(1);
		
		System.out.println("--------------下面进行选课------------------");
		Student s = new Student(1,"张三");
		int count = 0;
		//isEmpty判断集合里面是不是有元素
		if(s.getCourseLisr().isEmpty()){
			System.out.println("集合为空");
		}
		
		while(true){
			System.out.println("请选择以上有的课程：");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int id = scan.nextInt();
			//查询并返回选择的课程
			Course chooseCourse = tc.getChooseCourse(id);
			//添加选择的课程
			if(chooseCourse != null){
				s.studentChooseCourse(chooseCourse);
			}
			//打印所选的课程
			count++;
			if(count == 2){
				break;
			}
		}
		s.searchChooseCourse();
		if(!s.getCourseLisr().isEmpty()){
			System.out.println("集合不为空");
		}
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("请选择你要修改的课程id");
		int id1 = scan.nextInt();
		Course c1 = new Course(100,"大学英语");
		//修改学生选择的课程
		s.updateChooseCourse(id1, c1);
		//再次打印
		s.searchChooseCourse();
	
	
	
	}
}
