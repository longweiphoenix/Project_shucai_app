package com.ljm.thread;

public class ShareRunnable implements Runnable{

	//Ʊ������
	private int tickets = 200;
	
	//����һ��int���͵�ֵ����ʾ��Ʊ����
	private int num = 1;

	@Override
	public void run() {
		
		while (tickets>0) {
			tickets -= num;
			//��Ϊʵ�ֵ���Runnable�ӿڣ�����ֻ��ͨ��Thread�ľ�̬����currentThread()��ȡʵ�����ڻ�ȡ��ǰִ��run���߳�����
			System.out.println(Thread.currentThread().getName()+"����ִ�в���"+tickets);
		
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ʣ��Ʊ��:"+tickets);
			if (tickets == 0) {
				break;
			}
			
		}
		
	}
	
}
