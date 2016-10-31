package com.lim.Excepition0825;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestThrowClass {

	/**
	 * 1.�쳣�Ĵ�����Ƶĸ���
	 * 2.try....catch....
	 * 3.ϵͳ���õ��쳣��
	 * 4.ʲôʱ��ʹ��finally
	 * 5.throw �� throws
	 * 6.�Զ����쳣
	 */
	/**
	 * ArithmeticException  �����쳣
	 * IndexOutOfBoundsException �����±�Խ���쳣
	 * NullPointerException ��ָ���쳣
	 * ClassCastException ����ת�������쳣
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 1.�����д�����ʱ���޷���֤�û����߳��������������У����³������������е�ԭ���Ϊ�쳣
		 * 2.�������޷�Ԥ������Ƿ�������ִ�е�ʱ�����Ǿ���try...catch...����֤������������
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
	//throw ��throws
	@SuppressWarnings({ "resource", "unused" })
	public static void testThrow() throws IOException{
		FileInputStream fil =null;
		
		fil = new FileInputStream(new File(""));
		//ͨ��throw�׳�һ���쳣
		try {
			throw new ZidingException("����һ��io���쳣");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	
	
	
	
	//finally�÷�
	public static void testFinally(){
		FileInputStream fil = null;
		try {
			fil = new FileInputStream(new File(""));
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}finally {
			//�ر���Դ��������Դ��
			
			//try...catch...Ƕ��
			try {
				fil.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
//		System.out.println("**************************");
//		System.out.println("����仰�ܲ��ܴ�ӡ����");
	}
	
	//����Ϊ0���쳣
	public static  void testDivi(){
		//Scanner scan = new Scanner(System.in);
		int num1 = 10;
		int num2 = 0;
		try {
			System.out.println(num1/num2);
		} catch (ArithmeticException air) {
			// TODO: handle exception
			//���Ǵ�ӡ���׳����쳣
			air.printStackTrace();
		}
		System.out.println("--------------------");
		System.out.println("����仰�ܲ������г���");
		
	}
}