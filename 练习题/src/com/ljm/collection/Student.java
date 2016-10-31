package com.ljm.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Student {
	private int id;
	private String name;
	
	//set���������Ԫ���������Ҳ����ظ���
	private Set<Course> courseSet;
	
	//���췽��
	public Student(int id,String name){
		this.id = id;
		this.name = name;
		//��ʼ�����ϣ�ָ��ʵ����
		courseSet = new HashSet<Course>();
	}
	
	//��װ
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
	 * set���ϵ�һЩ�÷�
	 */
	
	/*
	 * ���Ԫ��
	 */
	public void studentChooseCourse(Course c){
		courseSet.add(c);
	}
	/*
	 * set����ֻ��ͨ�����ֵ�������������Iterator��foreach��
	 */
	public void searchChooseCourse(){
		Iterator<Course> i = courseSet.iterator();
		//�����Ƿ���Ԫ��
		while(i.hasNext()){
			Course c = i.next();
			System.out.println("---------��������ѡ�Ŀγ�---------------");
			System.out.println("�γ�id��"+c.getId()+"\t�γ����ƣ�"+c.getName());
		}
	}
	/*
	 * ɾ��set���������Ԫ��
	 */
	public void deleteChooseCourse(Course c){
		courseSet.remove(c);
	}
	/*
	 * α�޸�set����
	 */
	public void updateChooseCourse(int id,Course c){
		//Iterator<Course> i = courseSet.iterator();
		Course c1 = null;
		//��ѯ�Ƿ���Ԫ��
		//��ѯ������Ҫ�޸ĵĿγ�ʱ���˳�ѭ��
		/**
		 * ������Ҫ�õ�����������ʱ��ȥ�޸�
		 */
		/*while(i.hasNext()){
			c1 = i.next();
			
			if (id == c1.getId()) {
				c1 = c;
				break;
			}
		}*/
		
		//��foreach�޸ģ�Ҳ�����޸�
		for(Course c2: courseSet){
			if(id == c2.getId()){
				c1 = c2;
				break;
			}
		}
		//ɾ��Ҫ��ĵĿγ�
		deleteChooseCourse(c1);
		//����޸ĺ�Ŀγ�
		studentChooseCourse(c);
	}
	
	
	
	
	
}
