package com.ljm.test1;
/**
 * 猜数字游戏，一个类A有一个成员变量v,有一个初值100.定义一个类，对A类的成员变量v进行猜。如果
 * 大了则提示大了，小了则提示小了。等于则提示猜测成功。
 */

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个一千以内的正整数");
		int a = scan.nextInt();
		CaiShu cs = new CaiShu();
		cs.num(a);
	}

}
