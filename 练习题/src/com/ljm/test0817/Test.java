package com.ljm.test0817;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//ǿ��������
		System.gc();
		Runtime.getRuntime().gc();
		//�Ժ���Ϊ��λ
		long time = System.currentTimeMillis();
		System.out.println(time);
		//������Ϊ��λ
		long time1 = System.nanoTime();
		System.out.println(time1);
		
		Scanner scan = new Scanner(System.in);
		//String str = scan.next();
		//int numb = scan.nextInt();
		
		//String���Ȳ��ɱ�
		String str1 = "aaaaa";
		String str2 = str1+"bbb";
		String str3 = new String("abcd");//ͬstr1
		
		StringBuffer strb = new StringBuffer("aaaa");
		//System.out.println(strb.append("b"));������һ�仰ͬһ��Ч��
		//System.out.println(strb.insert(strb.length(), "b"));
		//׷�ӵ��ַ������еĺ���
		strb.append("bbb");
		System.out.println(strb);
		strb.replace(3, 4, "cc");
		System.out.println(strb);
		//ɾ����ǰ���������һ���ַ�
		strb.delete(2, 3);
		System.out.println(strb);//ɾ�����ǵڶ����ַ�
		
		//Math
		//�Ƚ�������ֵ��С
		System.out.println(Math.max(15.0, 15.2));
		//�����������������
		System.out.println(Math.random()*100);
		//��һ����Ķ�ʱ��һ�㿴���㣺1.���������Ǿ�̬���ǷǾ�̬��2.��������3.������ֵ����
		System.out.println((int)Math.pow(5, 3));
		
		//���������
		Random rand = new Random();
		//��������
		int number = rand.nextInt();
		System.out.println(number);
		//����boolean����
		boolean bool = rand.nextBoolean();
		System.out.println(bool);
		
		System.out.println(0.01+0.05);
//		System.out.println(1.0-0.42);
//		//ͨ��Bigdecimal
//		//ͨ��String���Ͳ����Ĺ��캯���������Խ������ȱʧ
//		BigDecimal bd = new BigDecimal("0.01");
//		BigDecimal bd1 = new BigDecimal("0.05");
//		//System.out.println(bd.add(bd1));
//		//double���Ͳ����Ĺ��캯�����ܽ������ȴ���ƣ����Բ��Ƽ�ʹ�ô˹��캯��
//		BigDecimal bd2 = new BigDecimal("1.0");
//		BigDecimal bd3 = new BigDecimal("0.42");
//		
//		//��Ҫʹ��double���͵Ĳ����Ļ���������BigDecimal����ľ�̬����valueof��ʹ��
//		BigDecimal bd4 = BigDecimal.valueOf(0.01);
//		BigDecimal bd5 = BigDecimal.valueOf(0.05);
//		
//		BigDecimal bd6 = BigDecimal.valueOf(4.015);
//		BigDecimal bd7 = BigDecimal.valueOf(100);
//		
//		BigDecimal bd8 = BigDecimal.valueOf(123.3);
//		BigDecimal bd9 = BigDecimal.valueOf(100);
//		
//		//�ӷ�����
//		System.out.println(bd4.add(bd5));//add�ӷ�
//		//��������
//		System.out.println(bd2.subtract(bd3));//subtract����
//		//�˷�����
//		System.out.println(bd6.multiply(bd7));//multiply�˷�
//		//��������
//		System.out.println(bd8.divide(bd9));//divide����
		System.out.println(UnitClass.add(12.2, 15.6));
		System.out.println(UnitClass.subtract(5.3, 3.0));
		System.out.println(UnitClass.multipliy(3.56, 2.8));
		System.out.println(UnitClass.divide(15.5, 3.26));
	}

}
