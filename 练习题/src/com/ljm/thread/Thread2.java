package com.ljm.thread;
/**
 * �̳�Thread
 * @author Administrator
 */
public class Thread2 extends Thread{

	/**
	 * ���������дrun���õ��Ǹ����run����
	 */
	@Override
	public void run() {
		int num = 10;
		while (--num > 0) {
			System.out.println("�߳�------"+getName()+"\t����ִ��"+num);
			
		}
	}	
}
