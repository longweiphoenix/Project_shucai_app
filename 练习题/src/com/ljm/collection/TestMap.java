package com.ljm.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {
	
	/**
	 * map keyֵ�����ظ�
	 * key����Ϊnull������ֻ�ܳ���һ��
	 * key�ǿ��Զ���Ϊ��������
	 */
	
	public static void main(String[] args) {
		Map<Integer,Student> m = new HashMap<Integer,Student>();
		//�������
		m.put(1, new Student(1001,"��"));
		m.put(2, new Student(1002,"Ƚ"));
		m.put(3, new Student(1003,"��"));
		
		//entryʵ����
		Set<Map.Entry<Integer, Student>> me = m.entrySet();
		
		for(Map.Entry<Integer, Student> entry: me){
			int i = entry.getKey();
			Student s = entry.getValue();
			System.out.println("key��ֵ:"+i+"value������:"+s.getName());
		}
		
		//��ȡkeyֵ��set����
		Set<Integer> seti = m.keySet();
		for(Integer intl: seti){
			//��ӡkey�� ֵ
			System.out.println(intl);
			//��ӡvalue������
			Student stu = m.get(intl);
			System.out.println("value������:"+stu.getName());
		}
		//ɾ��map�������������
		m.remove(2);
		
		System.out.println("----------------------------------");
		//ͨ��Iterator������
		//��һ�����������Inteator
		Iterator<Map.Entry<Integer, Student>> i = m.entrySet().iterator();
		//����
		while(i.hasNext()){
			//ͨ����������ȡentryʵ��
			Map.Entry<Integer, Student> mentry = i.next();
			//��ȡkey��ֵ
			int key = mentry.getKey();
			//��ȡvalue
			Student s = mentry.getValue();
			System.out.println("keyֵ��"+key+"\tvalueֵ"+s.getName());
		}
		
	}
}
