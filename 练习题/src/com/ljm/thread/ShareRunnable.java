package com.ljm.thread;

public class ShareRunnable implements Runnable{

	//票的总数
	private int tickets = 200;
	
	//定义一个int类型的值，表示出票数量
	private int num = 1;

	@Override
	public void run() {
		
		while (tickets>0) {
			tickets -= num;
			//因为实现的是Runnable接口，所以只能通过Thread的静态方法currentThread()获取实例，在获取当前执行run的线程名字
			System.out.println(Thread.currentThread().getName()+"正在执行操作"+tickets);
		
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("剩余票数:"+tickets);
			if (tickets == 0) {
				break;
			}
			
		}
		
	}
	
}
