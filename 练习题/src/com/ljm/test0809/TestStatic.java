package com.ljm.test0809;

public class TestStatic {

	public static void main(String[] args) {
		//����һ����̬���ԣ�Ȼ�󴴽�һ�������࣬�ڲ������棬�ֱ�������ֱ�Ӵ�ӡ���Ե�ֵ��ͨ�������ӡ���Ե�ֵ
		System.out.println(Static.name+"(ͨ��������ӡ���Ե�ֵ)");
		Static s = new Static();
		System.out.println(s.name+"(ͨ�������ӡ���Ե�ֵ)");
		
		System.out.println("---------------------------");
		//��̬�������÷Ǿ�̬����
		Static.testX();
		
		System.out.println("-----------------------");
		//дһ����̬������Ȼ���ڲ��������棬�ֱ����������÷�����ͨ��������÷���
		Static.testA();
		Static s1 = new Static();
		s1.testA();
		
		System.out.println("-----------------------------");
		//���¶���һ����̬������Ȼ��ֱ��ڷ����������ֱ�ӵ��þ�̬��Ա�����;�̬������ͨ����Ķ��������÷Ǿ�̬��Ա���ԺͷǾ�̬����
		Static.test();
		
		System.out.println("------------------------------");
		//�ڶ���һ���Ǿ�̬�������ֱ�ֱ�ӵ��÷Ǿ�̬���ԺͷǾ�̬����(��ʱ������ֱ�ӵ���û�б�static���εķ���)
		Static s2 = new Static();
		s2.testZ();
	
	}

}
