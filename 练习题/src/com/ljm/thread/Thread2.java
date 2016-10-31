package com.ljm.thread;
/**
 * 继承Thread
 * @author Administrator
 */
public class Thread2 extends Thread{

	/**
	 * 如果咩有重写run调用的是父类的run方法
	 */
	@Override
	public void run() {
		int num = 10;
		while (--num > 0) {
			System.out.println("线程------"+getName()+"\t正在执行"+num);
			
		}
	}	
}
