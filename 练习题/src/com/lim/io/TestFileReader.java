package com.lim.io;

//import java.io.FileReader;
import java.io.IOException;

/*
 * java.io.Reader
 * 	java.io.InputStreamReader//转换流（字节输入流转换成字符输入流）
 * 		java.io.FileReader//文件字符输入流
 */
public class TestFileReader {

	public static void main(String[] args) {
		INOUTdemo it = new INOUTdemo();
		
		try {
			it.copyFile("E:/练习题/src/com/lim/io/INOUTdemo.java", "E:/INOUT.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//			it.testOut("E:/OUT.txt");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			it.teatA("E:/练习题/src/com/lim/io/INOUTdemo.java");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
		
//		FileReader fr = null;
//		try {
//			//创建文件字符输入流
//			fr = new FileReader("E:/练习题/src/com/lim/io/TestFileReader.java");
//			//开始读
//			char[] ch = new char[512];//1KB
//			int temp = 0;
//			while ((temp=fr.read(ch)) != -1) {
//				System.out.println(new String(ch,0,temp));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (fr != null) {
//				try {
//					fr.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
