package com.ljm.test2;

public class Vehicle {
	//����
	double speed;
	double size;
	// �ƶ�move����
	public void  move(String car){
		System.out.println(car+"�����ƶ�"+"���ڵ��ٶ�Ϊ��"+speed);
	}
	//�����ٶ�
	public void setSpeed(int speed){
		this.speed=speed;
		
	}
	//����
	public void speedUp(int speed){
		this.speed += speed;
		
	}
	//����
	public void speedDown(int speed){
		this.speed -= speed;
		
	}

}
