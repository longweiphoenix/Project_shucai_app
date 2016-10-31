package com.ljm.thread;

import java.util.Random;

public class Card implements Runnable{

	int money = 10000;
	int z = 500;
	int f = 200;
	@Override
	public void run(){
		while (money>=200) {
			boolean b = new Random().nextBoolean();
			if(b == true){
				if ((money-z)<0) {
					break;
				}
				zhu();
			}else {
				if ((money-f)<0) {
					break;
				}
				fu();
			}
		}
		
	}
	
	public void zhu(){
		money -= z;
		System.out.println("主卡取了"+z+"元钱");
		System.out.println("剩余"+money);
	}
	public void fu(){
		money -= f;
		System.out.println("副卡取了"+f+"元钱");
		System.out.println("剩余"+money);
	}
	
}
