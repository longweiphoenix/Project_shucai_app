package com.ljm.collection;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * ���ͣ�
 * @author Administrator
 *
 */

public class TestCourse {
	//����һ��װ��������ļ���
	private List<Course> courseAllList;
	
	public TestCourse(){
		//��ʼ������
		courseAllList = new ArrayList<Course>();
	}
	
	/*
	 *����������������� 
	 */
	public void addCourse(Course course){
		//��add������ӵ�������
		courseAllList.add(course);
	}
	
	/*
	 * ��һ����ӷ���
	 */
	public void addCourse(int position,Course course){
		//ͨ��add������������ӵ�ָ��λ��
		System.out.println(courseAllList.size());
		if(position>=0 && position<=courseAllList.size()){
			courseAllList.add(position,course);
		}else{
			System.out.println("��������±�Խ��");
		}
	}
	
	/*
	 * �Ѽ������������������ӵ���һ����������
	 */
	public void addAllCourse(List<Course> list){
		//ͨ��addAll�������������������Ԫ����ӵ���ǰ����
		courseAllList.addAll(list);
	}
	
	/*
	 *�Ѽ������������������ӵ���һ�����ϵ�ָ��λ��ȥ 
	 */
	public void addAllCourse(int position,List<Course> list){
		//ͨ��add������������ӵ�ָ��λ��
		//�ж�ָ��λ��Խ��û��
		if (position>=0 && position<=courseAllList.size()) {
			courseAllList.addAll(position, list);
		}else{
			System.out.println("�±�Խ��");
		}
	}
	
	/*
	 * ��ѯ�������������
	 */
	public void searchAll(){
		for (int i = 0; i < courseAllList.size(); i++) {
			//ͨ��for��������ԭʼ���ص���object����
			Course c = (Course)courseAllList.get(i);
			System.out.println("�γ�id��"+c.getId()+"\t�γ�����"+c.getName());
		}
	}
	
	/*
	 * ͨ��������Iterator������
	 */
	public void searchIterator(){
		System.out.println("-------������ͨ��������Iteratorѭ��������------------");
		//ͨ�����������iterator������������ȡIterator�Ķ���
		Iterator<Course> i = courseAllList.iterator();
		//ͨ��hasNext���ж��Ƿ���Ԫ��
		while(i.hasNext()){
			//ͨ��Iterator�����next������������ȡ��������Ķ���
			Course c = (Course)i.next();
			//��ӡ
			System.out.println("�γ�id��"+c.getId()+"\t�γ�����"+c.getName());
		}
	}
	
	/*
	 * for eachѭ������
	 */
	public void srarchForeach(){
		System.out.println("--------������ͨ��foreach������ѭ��������-----------");
		for(Course obj: courseAllList){
			Course c = obj;
			System.out.println("�γ�id��"+c.getId()+"\t�γ�����"+c.getName());

		}
	}
	
	/*
	 * ��ȡ���������ĳһ��Ԫ��
	 */
	public void searchOne(int position){
		Course c = courseAllList.get(position);
		System.out.println("�γ�id��"+c.getId()+"\t�γ�����"+c.getName());

	}
	
	
	/*
	 * ɾ���������������
	 */
//	public void remove(int position){
//		Course c = courseAllList.get(position);
//		System.out.println("�γ�id��"+c.getId()+"\t�γ�����"+c.getName());
//		courseAllList.remove(position);
//		System.out.println("ɾ���ɹ�");
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
//		System.out.println("�γ̣�"+c.getId()+"."+c.getName());
//		courseAllList.remove(c);
//		//courseAllList.removeAll(Arrays.asList(courses));
//		System.out.println("�ɹ�ɾ��");
//		searchAll();
//	}
	/**
	 * ����Ŀγ�
	 */
	/*
	 * ����remove������ɾ�����������Ԫ��
	 */
	public void remove(int position){
		courseAllList.remove(position);
	}
	/*
	 * ����remove�����ط����Ƴ��������״γ��ֵ�Ԫ��
	 */
	public void remove(Object o){
		courseAllList.remove(o);
	}
	/*
	 * �޸ļ��������ĳһ��Ԫ��
	 */
	public void set(int position,Course c){
		courseAllList.set(position, c);
	}
	/*
	 * ��ռ���
	 */
	public void clearList(){
		courseAllList.clear();
	}
	/*
	 * ���ݿγ�id�����ؿγ̶���
	 */
	public Course getChooseCourse(int id){
		//������ѯ�γ̼��������Ƿ���ѡ��γ�
		for(Course c: courseAllList){
			if(id == c.getId()){
				//��ѯ���ͷ���
				return c;
			}
		}
		//���û���ҵ��ͷ���һ��null
		return null;
	}

	public List<Course> getCourseAllList() {
		return courseAllList;
	}

	public void setCourseAllList(List<Course> courseAllList) {
		this.courseAllList = courseAllList;
	}

}
