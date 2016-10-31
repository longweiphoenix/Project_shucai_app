package com.ljm.test0816;

public class TestBoss {

	public static void main(String[] args) {
//		Boss b = new One();
//		b.money();
		One o = new One();
		o.money();
		
		Factory f = new Factory();
		Boss a = f.getNew("Two");
		a.money();
		
		//反射机制调用
//		Factory f = new Factory();
//		Boss a = f.getNew("com.ljm.test0816.Two");
//		a.money();
	}

}
