package com.ljm.thread;
/**
 * 继承Thread类
 */
public class Thread1 extends Thread{
	private String name;
	public Thread1(String name){
		this.name = name;
	}
	@Override
	public void run() {
		int num = 10;
		while(--num > 0){
			System.out.println("线程--------"+name+"\t正在执行："+num);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
