package com.ljm.test0818;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		//c.setLenient(true);
		//c.set(Calendar.YEAR, 2020);
		//c.set(Calendar.MONTH, 12);
		//c.set(Calendar.DAY_OF_MONTH, 12);
		
		//����add�������·ݲ���
		//c.add(Calendar.MONTH, 1);
		//System.out.println(c.get(Calendar.YEAR));
		//System.out.println(c.get(Calendar.MONTH));
		
		//roll�������÷�
		//c.roll(Calendar.MONTH, 7);
		System.out.println(c.get(Calendar.YEAR));
		//System.out.println(c.get(Calendar.MONTH));
		
		//ϵͳ���·��Ǵ�0��ʼ�����
		System.out.println(c.get(Calendar.MONTH)+1);
		//�����Ǵ�1��ʼ��ģ�����һ������������Ҫ˳�����
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		//SimpleDateFormat ʱ�䴦��
		/**
		 * 1.y ���
		 * 2.M �·�
		 * 3.d ��
		 * 4.h ʮ��Сʱ��
		 * 5.H ��ʮ��Сʱ��
		 * 6.m ����
		 * 7.s ��
		 */
		//ͨ��simpledateformat������Ĺ��캯��ת��ʾ��ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HHʱmm��ss��");
		//�����ǰ�Ҫת����ʱ��ͨ��format����ת���������ַ���
		String time = sdf.format(c.getTime());
		
		System.out.println(time);
	}
}
