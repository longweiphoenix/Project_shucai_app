package com.ljm.test0816;

public class TestNiMing {
	public static void main(String[] args) {
		/**
		 * �����ڲ���
		 */
		InsterfaceTest ift = new InsterfaceTest(){//����һ�������ڲ��� 

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("�Ѿ�����");
			}
			
		};
		ift.eat();
		//��������ClassA
		ClassA c = new ClassA(new InsterfaceTest(){

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("yunle");
			}
			
		});
		c.eat();
		
		new InsterfaceTest(){

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("111111111");
			}}.eat();
	}
}
