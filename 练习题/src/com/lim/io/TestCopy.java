package com.lim.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {

	public static void main(String[] args) throws IOException {
		//�ļ�������
		FileInputStream fil = new FileInputStream("E:\\��ϰ��\\src\\com\\lim\\io\\FileInputStreamClass.java");
		//�ļ������
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.txt");
		
		
		byte[] b = new byte[1024];
		int temp = 0;
		while ((temp = fil.read(b,0,b.length)) != -1) {
			fos.write(b,0,temp);
			
		}
		//ˢ��
		fos.flush();
		//�ر�
		fil.close();
		fos.close();
	}
}
