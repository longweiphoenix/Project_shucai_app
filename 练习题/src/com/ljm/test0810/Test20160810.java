package com.ljm.test0810;

import com.ljm.testclass0810.Animal;
import com.ljm.testclass0810.Monkey;
import com.ljm.testclass0810.Tiger;
public class Test20160810 {
	public static void main(String[] args) {
		//引用对象指向本类
		Animal a = new Animal();
		//引用对象指向子类
		Animal m = new Monkey();//向上类型转换（自动类型转换）
		//自动类型转换
		//向下类型转换(强制类型转换)
		//Monkey newMonkey = (Monkey)m;//把Animal类型转换层Monkey类型
		//如果引用类型指向的是子类，并没有重写父类的方法，调用的方法是父类的方法
		Animal t = new Tiger();
		t.shin();
		//两个不相关的类型互相转换
		Tiger t1 =(Tiger)m;
		Tiger ti = (Tiger)t;
		//通过instanceof判断两个类型能否转换
		if(m instanceof Monkey){
			System.out.println("m能转换成Monkey类型");
		}else{
			System.out.println("m不能转换成Monkey类型");
		}
		
		if(m instanceof Tiger){
			System.out.println("m能转换成Tiger类型");
		}else{
			System.out.println("不能转换成Tiger类型");
		}
		
		//不能直接用一个子类的引用类型指向父类
		//Monkey mo = new Animal();不能转换
		//创建本来的引用，调用的方法是本类的
		a.eat();
		//引用类型值得是子类的，那么调用的方法是重写的也是子类的
		m.eat();
		//子类没有重写方法，调用的是就是父类继承过来的方法
		t.eat();
		//不能用父类的引用，调用子类独有的引用
		//t.test();
	}
}
