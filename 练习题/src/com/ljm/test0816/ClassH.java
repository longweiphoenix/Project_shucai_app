package com.ljm.test0816;

public class ClassH implements InterfaceClass{
	public void testC(){
		ClassD d = new ClassD();
		d.testB(ClassH.this);
	}

	@Override
	public void testA(int num) {
		// TODO Auto-generated method stub
		System.out.println("È½Ë¾»ú"+num);
	}

}
