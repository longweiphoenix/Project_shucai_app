package com.lim.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {

	public static void main(String[] args) throws IOException {
		//文件输入流
		FileInputStream fil = new FileInputStream("E:\\练习题\\src\\com\\lim\\io\\FileInputStreamClass.java");
		//文件输出流
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.txt");
		
		
		byte[] b = new byte[1024];
		int temp = 0;
		while ((temp = fil.read(b,0,b.length)) != -1) {
			fos.write(b,0,temp);
			
		}
		//刷新
		fos.flush();
		//关闭
		fil.close();
		fos.close();
	}
}
