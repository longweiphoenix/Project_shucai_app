package com.ljm.test2;

import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {
		TestStudentSystem[] tssArray = new TestStudentSystem[10];
		int i = 0;
		while(i < 10){
		System.out.println("������¼���ѧ������");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println("������ѧ��ѧ��");
		int stuId = scan.nextInt();
		
		System.out.println("������ѧ���Ա�");
		String sex = scan.next();
		char stusex = sex.charAt(0);
		
		System.out.println("������ѧ������");
		int age = scan.nextInt();
		
		TestStudentSystem tss = new TestStudentSystem(name,stuId,stusex,age);
		//���ñ��淽��
		tss.saveStudent(tss, tssArray);
		//���ô�ӡ����ķ���
		tss.searchStudent(tssArray);
		i++;
		if(i == 10){
			System.out.println("���洢��ѧ���Ѵ�����");
			break;
		}
	}}

}
