package com.ljm.test0810;

import com.ljm.testclass0810.Airplane;
import com.ljm.testclass0810.Car;
import com.ljm.testclass0810.Vehicle;

public class TestVehicle {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();//父类的引用指向本类对象
		Vehicle vc = new Car();//父类的引用指向子类对象
		Vehicle va = new Airplane();
		//Car c = new Vehicle();//子类的引用不能指向父类的对象
		v.color();//调用本类方法
		v.type();
		//父类不能调用子类独有的方法
		//vc.road();报错
		Car c =(Car)vc;//父类强制转换成子类
		c.road();
		Airplane a = (Airplane)va;
		if(c instanceof Car){
			System.out.println("可以转换");
		}else{
			System.out.println("不能转换");
		}
		
		if(vc instanceof Airplane){
			System.out.println("可以转换");
		}else{
			System.out.println("不可以转换");
		}
	}
}
