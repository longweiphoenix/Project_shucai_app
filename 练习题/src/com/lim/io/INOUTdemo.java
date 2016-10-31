package com.lim.io;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * inputStreamReader/outputStreamWriter
 * @author Administrator
 */
public class INOUTdemo {
	
	public void teatA(String str) throws IOException{
		InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(str)),"gbk");
		//读
		/*int temp = 0;
		while ((temp=isr.read()) != -1) {
			System.out.print((char)temp);	
		}*/
		
		char[] ch = new char[1024];
		int a = 0;
		while ((a = isr.read(ch,0,ch.length)) != -1) {
			for (int i = 0; i < a; i++) {
				System.out.print(ch[i]);
			}
			
		}
		isr.close();
	}
	
	public void testOut(String str) throws IOException{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(str)));
		osw.write(97);
		osw.write("张文在自拍");
		osw.write("冉司机是个小胖子",1,3);
		
		osw.flush();
		osw.close();
	}
	
	//copy
	public void copyFile(String str1,String str2) throws IOException{
		InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(str1)));
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(str2)));
		
		/**
		 * 不能用以下方法来遍历
		 */
		/*while (isr.read() != -1) {
			osw.write(isr.read());
			osw.flush();
		}*/
		long l = System.currentTimeMillis();
		char[] ch = new char[1024];
		int a = 0;
		while ((a=isr.read(ch,0,ch.length)) != -1) {
			String str = new String(ch,0,a);
			osw.write(str);
			osw.flush();
		}
		System.out.println("执行时间："+(System.currentTimeMillis()-l));
		
		isr.close();
		osw.close();
	}
}
