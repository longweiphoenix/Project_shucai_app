package com.lim.io;

import java.util.Random;

public class BandCard implements Runnable{

	private int moneyAll = 10000;
	private int[] num = {300,500};
	
	@Override
	public synchronized void run() {
		
		while (true) {
			Random rd = new Random();
			int i = num[rd.nextInt(2)];
			if ((moneyAll-i)>0) {
				moneyAll -= i;
				System.out.println(Thread.currentThread().getName()+"ȡ��"+i+"\t��ʣ"+moneyAll);
			}else {
				break;
			}
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notify();//���ѵȴ����߳�
		}
	}

}
