package com.ljm.test0816;

public class OutClass {
	String name;
	static int age;
	
	public void test(){
		@SuppressWarnings("unused")
		char sex;
		//�ⲿ������ĳ�Ա����ͨ��ʵ�����ڲ�����ʹ��
		InClass ic = new InClass();
		ic.InTest();
		System.out.println(ic.inname);
		//�ⲿ������ĳ�Ա����ֱ��ʹ���ڲ�������ĳ�Ա
		//System.out.println(inname);
		InStaticClass isc = new InStaticClass();
		isc.intest2();
	}

	public static void test2(){
		@SuppressWarnings("unused")
		String name;
		//�����������ʹ���ⲿ�������������Ա
		System.out.println(age);
	}
	/**
	 * �Ǿ�̬�ڲ���
	 */
	public class InClass{
		//�Ǿ�̬�ڲ��಻�����徲̬��Ա
		String inname;
		
		public void InTest(){
			System.out.println("���ǷǾ�̬�ڲ�������ķ���");
			//�Ǿ�̬�ڲ������ʹ���ⲿ�������������Ա
			System.out.println(OutClass.age);
			//�����ⲿ���������������
			test();
		}
	}
	/**
	 * ��̬�ڲ���
	 */
	static public class InStaticClass{
		//��̬�ڲ������治��������ⲿ������ķǾ�̬��Ա
		static String inname;
		int inage;
		
		public static void intest(){
			//��̬�ڲ��಻��������ⲿ������ķǾ�̬��Ա
			//test();
			//���ǿ��Է����ⲿ������ľ�̬��Ա
			test2();
			System.out.println(age);
		}
		//��̬�ڲ�������ķǾ�̬��Ա
		public void intest2(){
			//��ʹ�ǷǾ�̬��ԱҲ���ܷ����ⲿ��ķǾ�̬��Ա
			//test();
		}
		
		//�ⲿ������ĳ�Աͬ������ֱ�ӷ��ʾ�̬�ڲ���ĳ�Ա
	}
}
