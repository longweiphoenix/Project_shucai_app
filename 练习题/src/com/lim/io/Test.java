package com.lim.io;

import java.io.File;
//import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		FileRW frw = new FileRW();
		
		try {
			frw.testFRW("E:/��ϰ��/src/com/lim/io/INOUTdemo.java", "D:/INOUTdemo12.java");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			frw.testCopy("E:/��ϰ��/src/com/lim/io/INOUTdemo.java", "D:/INOUTdemo.java");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			frw.testFR("E:/��ϰ��/src/com/lim/io/INOUTdemo.java");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//File f = new File("D:");
		//test(f);
	}
	public static void test(File str){
		File[] fil = str.listFiles();
		if (fil != null && fil.length>0) {
			//����
			for (File f: fil) {
				if (f.isDirectory()) {
					test(f);
				}else {
					System.out.println(f);
				}
			}
			
		}
	}
}
