package com.ljm.test1;
/**
 * ��������Ϸ��һ����A��һ����Ա����v,��һ����ֵ100.����һ���࣬��A��ĳ�Ա����v���в¡����
 * ��������ʾ���ˣ�С������ʾС�ˡ���������ʾ�²�ɹ���
 */

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("������һ��һǧ���ڵ�������");
		int a = scan.nextInt();
		CaiShu cs = new CaiShu();
		cs.num(a);
	}

}
