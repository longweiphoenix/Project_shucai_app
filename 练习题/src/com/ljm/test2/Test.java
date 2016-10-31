package com.ljm.test2;

import java.util.Scanner;

/**
 * 类的成员变量：请定义各异交通工具Vehicle的类，其中有：
 * 属性   速度（speed）  体积（size）等等
 * 方法   移动（move（））  设置速度（setSpeed（int speed）） 加速 speedUp（），减速speedDown（）等等.
 * 最后在测试类Vehicle中的main（）中实例化一个交通工具对象，并通过方法给它初始化speed，size的值，并且通过
 * 打印出来。另外，调用速度，减速的方法对速度进行改变。
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入交通工具");
		String car = scan.next();
		v.setSpeed(80);
		v.speedDown(20);
		v.speedUp(800);
		v.move(car);
		
	}

}
