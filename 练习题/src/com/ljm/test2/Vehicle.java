package com.ljm.test2;

public class Vehicle {
	//属性
	double speed;
	double size;
	// 移动move（）
	public void  move(String car){
		System.out.println(car+"正在移动"+"现在的速度为："+speed);
	}
	//设置速度
	public void setSpeed(int speed){
		this.speed=speed;
		
	}
	//加速
	public void speedUp(int speed){
		this.speed += speed;
		
	}
	//减速
	public void speedDown(int speed){
		this.speed -= speed;
		
	}

}
