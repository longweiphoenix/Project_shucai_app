package com.lim.io;

import java.io.IOException;

public class TestBuffered {

	public static void main(String[] args) {
		Buffered b = new Buffered();
		try {
			b.testA("C:\\Users\\Administrator\\Desktop\\1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		try {
//			b.testB("C:\\Users\\Administrator\\Desktop\\����.pptx", "C:\\Users\\Administrator\\Desktop\\���˸���.pptx");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
