package com.ljm.time;

public class Test {
	public static void main(String[] args) {
		//��ֵʱ��
		Mytime m = new Mytime(16,7,7);
		System.out.println(m.getHour()+"ʱ"+m.getMinute()+"��"+m.getSecond()+"��");
		//ʱ��
		Mytime.addHour(11);
		System.out.println(m.getHour()+"ʱ"+m.getMinute()+"��"+m.getSecond()+"��");
		//�ּ�
		Mytime.addMinute(26);
		System.out.println(m.getHour()+"ʱ"+m.getMinute()+"��"+m.getSecond()+"��");
		//���
		Mytime.addSecond(38);
		System.out.println(m.getHour()+"ʱ"+m.getMinute()+"��"+m.getSecond()+"��");
		//ʱ��
		Mytime.subHour(11);
		System.out.println(m.getHour()+"ʱ"+m.getMinute()+"��"+m.getSecond()+"��");
		//�ּ�
		Mytime.subMinute(26);
		System.out.println(m.getHour()+"ʱ"+m.getMinute()+"��"+m.getSecond()+"��");
		//���
		Mytime.subSecond(38);
		System.out.println(m.getHour()+"ʱ"+m.getMinute()+"��"+m.getSecond()+"��");

		
	}

}
