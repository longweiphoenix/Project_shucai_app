package com.ljm.test0817;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//强制来回收
		System.gc();
		Runtime.getRuntime().gc();
		//以毫秒为单位
		long time = System.currentTimeMillis();
		System.out.println(time);
		//以纳秒为单位
		long time1 = System.nanoTime();
		System.out.println(time1);
		
		Scanner scan = new Scanner(System.in);
		//String str = scan.next();
		//int numb = scan.nextInt();
		
		//String长度不可变
		String str1 = "aaaaa";
		String str2 = str1+"bbb";
		String str3 = new String("abcd");//同str1
		
		StringBuffer strb = new StringBuffer("aaaa");
		//System.out.println(strb.append("b"));与下面一句话同一个效果
		//System.out.println(strb.insert(strb.length(), "b"));
		//追加到字符串序列的后面
		strb.append("bbb");
		System.out.println(strb);
		strb.replace(3, 4, "cc");
		System.out.println(strb);
		//删除当前序列里面的一个字符
		strb.delete(2, 3);
		System.out.println(strb);//删除的是第二个字符
		
		//Math
		//比较两个数值大小
		System.out.println(Math.max(15.0, 15.2));
		//随机产生和四舍五入
		System.out.println(Math.random()*100);
		//用一个类的额时候，一般看三点：1.方法到底是静态还是非静态。2.看参数。3.看返回值类型
		System.out.println((int)Math.pow(5, 3));
		
		//随机产生类
		Random rand = new Random();
		//产生整数
		int number = rand.nextInt();
		System.out.println(number);
		//产生boolean类型
		boolean bool = rand.nextBoolean();
		System.out.println(bool);
		
		System.out.println(0.01+0.05);
//		System.out.println(1.0-0.42);
//		//通过Bigdecimal
//		//通过String类型参数的构造函数来，可以解决精度缺失
//		BigDecimal bd = new BigDecimal("0.01");
//		BigDecimal bd1 = new BigDecimal("0.05");
//		//System.out.println(bd.add(bd1));
//		//double类型参数的构造函数不能解决京都却好似，所以不推荐使用此构造函数
//		BigDecimal bd2 = new BigDecimal("1.0");
//		BigDecimal bd3 = new BigDecimal("0.42");
//		
//		//非要使用double类型的参数的话，就是用BigDecimal里面的静态方法valueof来使用
//		BigDecimal bd4 = BigDecimal.valueOf(0.01);
//		BigDecimal bd5 = BigDecimal.valueOf(0.05);
//		
//		BigDecimal bd6 = BigDecimal.valueOf(4.015);
//		BigDecimal bd7 = BigDecimal.valueOf(100);
//		
//		BigDecimal bd8 = BigDecimal.valueOf(123.3);
//		BigDecimal bd9 = BigDecimal.valueOf(100);
//		
//		//加法运算
//		System.out.println(bd4.add(bd5));//add加法
//		//减法运算
//		System.out.println(bd2.subtract(bd3));//subtract减法
//		//乘法运算
//		System.out.println(bd6.multiply(bd7));//multiply乘法
//		//除法运算
//		System.out.println(bd8.divide(bd9));//divide除法
		System.out.println(UnitClass.add(12.2, 15.6));
		System.out.println(UnitClass.subtract(5.3, 3.0));
		System.out.println(UnitClass.multipliy(3.56, 2.8));
		System.out.println(UnitClass.divide(15.5, 3.26));
	}

}
