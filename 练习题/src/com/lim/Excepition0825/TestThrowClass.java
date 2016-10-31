package com.lim.Excepition0825;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestThrowClass {

	/**
	 * 1.异常的处理机制的概念
	 * 2.try....catch....
	 * 3.系统常用的异常类
	 * 4.什么时候使用finally
	 * 5.throw 和 throws
	 * 6.自定义异常
	 */
	/**
	 * ArithmeticException  运算异常
	 * IndexOutOfBoundsException 数组下标越界异常
	 * NullPointerException 空指针异常
	 * ClassCastException 类型转换出错异常
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 1.概念：编写程序的时候，无法保证用户或者程序本身能完整运行，导致程序不能完整运行的原因称为异常
		 * 2.当我们无法预测程序是否能正常执行的时候，我们就用try...catch...来保证程序正常运行
		 */
		//testDivi();
		//testFinally();
		
		try {
			testThrow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	//throw 和throws
	@SuppressWarnings({ "resource", "unused" })
	public static void testThrow() throws IOException{
		FileInputStream fil =null;
		
		fil = new FileInputStream(new File(""));
		//通过throw抛出一个异常
		try {
			throw new ZidingException("这是一个io流异常");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	
	
	
	
	//finally用法
	public static void testFinally(){
		FileInputStream fil = null;
		try {
			fil = new FileInputStream(new File(""));
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}finally {
			//关闭资源（回收资源）
			
			//try...catch...嵌套
			try {
				fil.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
//		System.out.println("**************************");
//		System.out.println("看这句话能不能打印出来");
	}
	
	//除数为0的异常
	public static  void testDivi(){
		//Scanner scan = new Scanner(System.in);
		int num1 = 10;
		int num2 = 0;
		try {
			System.out.println(num1/num2);
		} catch (ArithmeticException air) {
			// TODO: handle exception
			//这是打印出抛出的异常
			air.printStackTrace();
		}
		System.out.println("--------------------");
		System.out.println("看这句话能不能运行出来");
		
	}
}