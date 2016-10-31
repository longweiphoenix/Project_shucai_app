package com.lim.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamClass {

	public void testOut(File fil) throws IOException{
		FileOutputStream fos  = new FileOutputStream(fil);
		
		fos.write('d');
		int a = 97;//int ռ�ĸ��ֽ�
		fos.write(a>>>24);
		fos.write(a>>>16);
		fos.write(a>>>8);
		fos.write(a>>>0);
		
		String str = "����������������";
		fos.write(str.getBytes());	
		
		fos.close();
		
	}
	//copy�ļ�
	public void copyFile(File file,File file1) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file1);
		
		while (fis.available()>0) {
			fos.write(fis.read());
		}
		fis.close();
		fos.close();
	}
}
