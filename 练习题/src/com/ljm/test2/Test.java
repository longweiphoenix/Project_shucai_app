package com.ljm.test2;

import java.util.Scanner;

/**
 * ��ĳ�Ա�������붨����콻ͨ����Vehicle���࣬�����У�
 * ����   �ٶȣ�speed��  �����size���ȵ�
 * ����   �ƶ���move������  �����ٶȣ�setSpeed��int speed���� ���� speedUp����������speedDown�����ȵ�.
 * ����ڲ�����Vehicle�е�main������ʵ����һ����ͨ���߶��󣬲�ͨ������������ʼ��speed��size��ֵ������ͨ��
 * ��ӡ���������⣬�����ٶȣ����ٵķ������ٶȽ��иı䡣
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�����뽻ͨ����");
		String car = scan.next();
		v.setSpeed(80);
		v.speedDown(20);
		v.speedUp(800);
		v.move(car);
		
	}

}
