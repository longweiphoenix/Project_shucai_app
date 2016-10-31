package com.ljm.test0811;

public class Singleton {
	//����һ����̬�����ñ������洢��ǰ��Ķ���
	private static Singleton instance;
	//�õ�ǰ�಻��ʵ����
	private Singleton(){
		
	}
	//����һ����̬���������ⲿ�ṩ��ǰ��ʵ������
	public static Singleton getInstance(){
		/*
		 * ����һ�ε��ñ���÷�����ʱ��instanceΪnull���ͻ����ifȥ����һ��ʵ����
		 * ��֮����ø÷�����ʱ��instance�Ͳ���Ϊnull�����Բ��ܵ����ٴζ���ͬһ��ʵ��
		 */
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}

}
