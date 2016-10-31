package com.lim.io;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileRW {
	//文件输入流
	public void testFR(String str) throws IOException{
		FileReader fr = new FileReader(str);
		
		char[] ch = new char[1024];
		int n = 0;
		while ((n=fr.read(ch,0,ch.length)) != -1) {
			String s = new String(ch,0,n);
			System.out.print(s);
		}
		fr.close();
	}
	//copy文件
	public void testCopy(String str1,String str2) throws IOException{
		FileReader fr = new FileReader(str1);
		FileWriter fw = new FileWriter(str2);
		
		char[] ch = new char[1024];
		int temp = 0;
		while ((temp = fr.read(ch,0,ch.length)) != -1) {
			fw.write(ch,0,temp);
			fw.flush();
		}
		fr.close();
		fw.close();
	}
	//copy
	public void testFRW(String str1,String str2) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(str1)));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2)));
		//上一句可以写为
		PrintWriter pw = new PrintWriter(str2);
		
		String str;
		while ((str=br.readLine()) != null) {
//			bw.write(str);
//			bw.newLine();//换行
//			bw.flush();
			pw.println(str);
			pw.flush();
		}
		br.close();
		//bw.close();
		pw.close();
	}
}
