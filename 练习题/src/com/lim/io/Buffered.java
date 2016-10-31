package com.lim.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Buffered {

	public void testA(String str) throws IOException{
		//���������ֽ�������
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(str)));
		InputStreamReader isr = new InputStreamReader(bis);
		int temp = 0;
		char[] ch = new char[512];
		long l = System.currentTimeMillis();
		
		while ((temp=isr.read(ch)) != -1) {
			System.out.println(new String(ch,0,temp));
		}
		
//		while (bis.available() > 0) {
//			System.out.print(bis.read()+"\t");
//			if (temp++%10 == 0) {
//				System.out.println();
//			}
//		}
		System.out.println("ִ��ʱ�䣺"+(System.currentTimeMillis()-l));
		bis.close();
	}
	//����
	public void testB(String str1,String str2) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(str1)));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(str2)));
		//һ�߶�һ��д
		long l = System.currentTimeMillis();
		while (bis.available()>0) {
			bos.write(bis.read());
			
		}
		System.out.println("ִ��ʱ�䣺"+(System.currentTimeMillis()-l));
		//ˢ��
		bos.flush();
		//�ر�
		bis.close();
		bos.close();
	}
}
