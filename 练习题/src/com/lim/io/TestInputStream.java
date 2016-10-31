package com.lim.io;

import java.io.File;
import java.io.IOException;

public class TestInputStream {

	public static void main(String[] args) throws IOException {
//		File f1 = new File("D:/Documents/Pictures/6c85e6408517c3e2da8dd9e7498a22f1.jpg");
//		FileInputStreamClass fil = new FileInputStreamClass();
//		try {
//			fil.test(f);
//		} catch (Exception e) {
//			e.printStackTrace();
//			}
		
		
//		File f2 = new File("D:/6c85e6408517c3e2da8dd9e7498a22f1.txt");
//		
//		FileOutputStreamClass fil = new FileOutputStreamClass();
//		//fil.copyFile(f1, f2);
//		fil.testOut(f2);
		
		File f = new File("D:/1.txt");
		DataInputStreamClass dis = new DataInputStreamClass();
		try {
			dis.test(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
