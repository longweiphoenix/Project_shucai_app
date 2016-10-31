package com.ljm.test3;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Calculate1 cal = new Calculate1();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入两个整数");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		cal.a = a;
		cal.b = b;
		cal.s();
		cal.c();
		cal.j();
	
		
		

	}

}
