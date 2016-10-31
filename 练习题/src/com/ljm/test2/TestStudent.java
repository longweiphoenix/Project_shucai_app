package com.ljm.test2;

import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {
		TestStudentSystem[] tssArray = new TestStudentSystem[10];
		int i = 0;
		while(i < 10){
		System.out.println("请输入录入的学生姓名");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println("请输入学生学号");
		int stuId = scan.nextInt();
		
		System.out.println("请输入学生性别");
		String sex = scan.next();
		char stusex = sex.charAt(0);
		
		System.out.println("请输入学生年龄");
		int age = scan.nextInt();
		
		TestStudentSystem tss = new TestStudentSystem(name,stuId,stusex,age);
		//调用保存方法
		tss.saveStudent(tss, tssArray);
		//调用打印数组的方法
		tss.searchStudent(tssArray);
		i++;
		if(i == 10){
			System.out.println("您存储的学生已达上限");
			break;
		}
	}}

}
