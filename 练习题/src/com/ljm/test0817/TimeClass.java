package com.ljm.test0817;

import java.util.Calendar;
import java.util.Date;

public class TimeClass {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//��ȡʱ������ַ�ʽ   Date  Calendar
		
		//Date�࣬����ʱ�����
		Date d = new Date();
		//ֱ�Ӵ�ӡ��������ǵ�ǰʱ��
		System.out.println(d);
		//��ȡ����
		System.out.println(d.getTime()+"����");
		System.out.println(System.currentTimeMillis()+"����");
		//��ȡ���
		System.out.println(d.getYear()+1900+"��");//��1900�꿪ʼ����
		//��ȡ�·�
		System.out.println(d.getMonth()+1+"��");//��0�¿�ʼ�����
		//��ȡ����
		System.out.println(d.getDate()+"��");
		//��ȡʱ
		System.out.println(d.getHours()+"ʱ");
		//��ȡ��
		System.out.println(d.getMinutes()+"��");
		//��ȡ��
		System.out.println(d.getSeconds()+"��");
		//��ȡ����
		System.out.println(d.getDay()+"����");
		
		//�������
		d.setYear(2020);
		System.out.println(d.getYear()+"��");
		//�����·�
		d.setMonth(13);
		System.out.println(d.getMonth()+"��");
		
		System.out.println("***************���Ӻ���*****************");
		
		//Calendar ͨ��getInstance��ȡʵ��
		Calendar c = Calendar.getInstance();
		//System.out.println(c);//������ǵ�ַ
		//��ȡ����
		System.out.println(c.getTimeInMillis()+"����");
		//��ȡ���
		System.out.println(c.get(Calendar.YEAR)+"��");
		//��ȡ�·�
		System.out.println(c.get(Calendar.MONTH)+1+"��");//�·��Ǵӵ�����¿�ʼ�����
		//��ȡ����
		System.out.println(c.get(Calendar.DAY_OF_MONTH)+"��");
		//��ȡ����
		System.out.println(c.get(Calendar.WEEK_OF_MONTH)+"����");
		//��ȡʱ(12Сʱ��)
		System.out.println(c.get(Calendar.HOUR)+"ʱ");
		//��ȡʱ(24Сʱ��)
		System.out.println(c.get(Calendar.HOUR_OF_DAY)+"ʱ");
		//��ȡ��
		System.out.println(c.get(Calendar.MINUTE)+"��");
		//��ȡ��
		System.out.println(c.get(Calendar.SECOND)+"��");
		
		//����
		//�������
		c.set(Calendar.YEAR, 2020);
		System.out.println(c.get(Calendar.YEAR)+"��");
		//�����·�
		c.set(Calendar.MONTH, 13);
		System.out.println(c.get(Calendar.MONTH)+"��");
		
	}
}
