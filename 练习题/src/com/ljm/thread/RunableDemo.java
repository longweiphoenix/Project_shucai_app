package com.ljm.thread;

public class RunableDemo implements Runnable{

	int num = 30;
	@Override
	public void run() {
		
		
		while (true) {
			synchronized (this) {//synchronized  ��
				if (num>0) {
					System.out.println(Thread.currentThread().getName()+"���ڳ�Ʊ:"+num);
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
//			System.out.println("��ǰ�ǵ�"+num+"��");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

	
}
