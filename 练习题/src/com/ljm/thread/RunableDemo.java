package com.ljm.thread;

public class RunableDemo implements Runnable{

	int num = 30;
	@Override
	public void run() {
		
		
		while (true) {
			synchronized (this) {//synchronized  锁
				if (num>0) {
					System.out.println(Thread.currentThread().getName()+"正在出票:"+num);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					num--;
				}else {
					break;
				}
			}
			
			
	}
		
//		while (--num > 0) {
//			System.out.println("当前是第"+num+"秒");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

	
}
