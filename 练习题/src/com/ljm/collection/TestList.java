package com.ljm.collection;

import java.util.Arrays;
import java.util.Scanner;

public class TestList {
	public static void main(String[] args) {
		//��һ������һ������
		TestCourse tc = new TestCourse();
		
		Course c = new Course(1,"��ѧ");
		tc.addCourse(c);
		tc.addCourse(c);
		//tc.searchAll();
		c = new Course(2,"����");
		tc.addCourse(c);
		c = new Course(3,"Ӣ��");
		tc.addCourse(2,c);
		//tc.searchAll();
		
		Course[] cou = {new Course(4,"��ѧ"),new Course(5,"����")};
		//������ת���ɼ��ϴ���ȥ
		tc.addAllCourse(Arrays.asList(cou));
		//tc.searchAll();
		
		Course[] coul = {new Course(6,"����"),new Course(7,"��ʷ")};
		tc.addAllCourse(3,Arrays.asList(coul));
		//tc.searchAll();
		
		//tc.removeCourse(3);
		tc.searchAll();
		tc.searchIterator();
		tc.srarchForeach();
		System.out.println("**************************");
		//tc.removeCourse();
		tc.remove(1);
		
		System.out.println("--------------�������ѡ��------------------");
		Student s = new Student(1,"����");
		int count = 0;
		//isEmpty�жϼ��������ǲ�����Ԫ��
		if(s.getCourseLisr().isEmpty()){
			System.out.println("����Ϊ��");
		}
		
		while(true){
			System.out.println("��ѡ�������еĿγ̣�");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int id = scan.nextInt();
			//��ѯ������ѡ��Ŀγ�
			Course chooseCourse = tc.getChooseCourse(id);
			//���ѡ��Ŀγ�
			if(chooseCourse != null){
				s.studentChooseCourse(chooseCourse);
			}
			//��ӡ��ѡ�Ŀγ�
			count++;
			if(count == 2){
				break;
			}
		}
		s.searchChooseCourse();
		if(!s.getCourseLisr().isEmpty()){
			System.out.println("���ϲ�Ϊ��");
		}
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("��ѡ����Ҫ�޸ĵĿγ�id");
		int id1 = scan.nextInt();
		Course c1 = new Course(100,"��ѧӢ��");
		//�޸�ѧ��ѡ��Ŀγ�
		s.updateChooseCourse(id1, c1);
		//�ٴδ�ӡ
		s.searchChooseCourse();
	
	
	
	}
}
