package com.ljm.test0810;

import com.ljm.testclass0810.Airplane;
import com.ljm.testclass0810.Car;
import com.ljm.testclass0810.Vehicle;

public class TestVehicle {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();//���������ָ�������
		Vehicle vc = new Car();//���������ָ���������
		Vehicle va = new Airplane();
		//Car c = new Vehicle();//��������ò���ָ����Ķ���
		v.color();//���ñ��෽��
		v.type();
		//���಻�ܵ���������еķ���
		//vc.road();����
		Car c =(Car)vc;//����ǿ��ת��������
		c.road();
		Airplane a = (Airplane)va;
		if(c instanceof Car){
			System.out.println("����ת��");
		}else{
			System.out.println("����ת��");
		}
		
		if(vc instanceof Airplane){
			System.out.println("����ת��");
		}else{
			System.out.println("������ת��");
		}
	}
}
