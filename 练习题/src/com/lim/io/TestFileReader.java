package com.lim.io;

//import java.io.FileReader;
import java.io.IOException;

/*
 * java.io.Reader
 * 	java.io.InputStreamReader//ת�������ֽ�������ת�����ַ���������
 * 		java.io.FileReader//�ļ��ַ�������
 */
public class TestFileReader {

	public static void main(String[] args) {
		INOUTdemo it = new INOUTdemo();
		
		try {
			it.copyFile("E:/��ϰ��/src/com/lim/io/INOUTdemo.java", "E:/INOUT.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//			it.testOut("E:/OUT.txt");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			it.teatA("E:/��ϰ��/src/com/lim/io/INOUTdemo.java");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
		
//		FileReader fr = null;
//		try {
//			//�����ļ��ַ�������
//			fr = new FileReader("E:/��ϰ��/src/com/lim/io/TestFileReader.java");
//			//��ʼ��
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
