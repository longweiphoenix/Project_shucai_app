package com.ljm.test0809;

public class Static {
	//static  ���γ�Ա����������ֻ�ã�����.�������������ã�Ҳ���������ã�������.��������
	//��̬����
	static String name;
	//�Ǿ�̬����
	int age = 10;
	
	//��̬����
	static void testA(){
		System.out.println("��̬����");
	}
	
	//�Ǿ�̬����
	void testB(){
		System.out.println("�Ǿ�̬����");
	}
	
	//����һ���Ǿ�̬��Ա���Ժ�һ���Ǿ�̬�������Լ��������ھ�̬������ֱ�ӵ��÷Ǿ�̬���ԺͷǾ�̬����
	static void testX(){
//		testB();
//		System.out.println(age);
		Static s1 = new Static();
		s1.testB();
		System.out.println(s1.age);
	}     //�ھ�̬�����У�����ֱ�ӵ��÷Ǿ�̬���ԺͷǾ�̬����
	
	//���¶���һ����̬������Ȼ��ֱ��ڷ����������ֱ�ӵ��þ�̬��Ա�����;�̬������ͨ����Ķ��������÷Ǿ�̬��Ա���ԺͷǾ�̬����
	static void test(){
		System.out.println(name);//���þ�̬����
		testA();//���þ�̬����
		Static s = new Static();//ʵ����Static�����ģ�����һ������s
		System.out.println(s.age);//���÷Ǿ�̬��Ա����
		s.testB();//���÷Ǿ�̬����
//		Static.name="zhangsan";//�����
//		s.name="lisi";//�������	
	}
	
	//�ڶ���һ���Ǿ�̬�������ֱ�ֱ�ӵ��÷Ǿ�̬���ԺͷǾ�̬����
	void testZ(){
		System.out.println(age);//���÷Ǿ�̬����
		testB();//���÷Ǿ�̬����
	}
	
	//дһ������������ӡһ�仰���鿴�������ʲôʱ��ִ��
	//ÿ��������һ�Σ������ִ��һ��
	{
		System.out.println("�����");
	}
	//��̬��:ִֻ��һ�����ڳ�������ʱ����ִ��
	static{
		System.out.println("��̬��");
	}

}
