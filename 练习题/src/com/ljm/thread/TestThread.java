package com.ljm.thread;

import com.lim.io.BandCard;

//import java.lang.management.ThreadMXBean;

public class TestThread {

	public static void main(String[] args) {
	//	Thread1 td1 = new Thread1("A");
	/*	Thread2 td2 = new Thread2();
		Thread2 td3 = new Thread2();
		Thread2 td4 = new Thread2();
		
		td2.setName("�߳�>>>1******");
		td2.setPriority(Thread.MAX_PRIORITY);
		td3.setName("�߳�>>>2======");
		td3.setPriority(Thread.MIN_PRIORITY);
		td4.setName("�߳�>>>3++++++");
		td4.setPriority(Thread.NORM_PRIORITY);
		
//		td1.start();
//		td2.start();
		
		td2.start();
		td3.start();
		td4.start();
		*/
		
	/*	ShareRunnable sr = new ShareRunnable();
		
		Thread tr1 = new Thread(sr,"����A:");
		Thread tr2 = new Thread(sr,"����B:");
		Thread tr3 = new Thread(sr,"����C:");
		
		tr1.start();
		tr2.start();
		tr3.start();
		
		try {
			tr1.join();
			tr2.join();
			tr3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
//		RunableDemo rd = new RunableDemo();
//		Thread td = new Thread(rd);
//		td.start();
	/*	Thread td = new Thread(rd);
		Thread td1 = new Thread(rd);
		Thread td2 = new Thread(rd);
		td.setName("����A:");
		td1.setName("����B:");
		td2.setName("����C:");
		td.start();
		td1.start();
		td2.start();
		
		try {
			td.join();
			td1.join();
			td2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
//		Card c = new Card();
//		Thread td = new Thread(c);
//		
//		td.start();
//		
//		try {
//			td.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BandCard bc = new BandCard();
		Thread td1 = new Thread(bc);
		Thread td2 = new Thread(bc);
		
		td1.setName("����");
		td2.setName("����");
		
		td1.start();
		td2.start();
		
		try {
			td1.join();
			td2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
