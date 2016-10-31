package com.ljm.test3;

public class TestPeople {

	public static void main(String[] args) {
		People p = new People();
		People p1 = new People("冉司机");
		//p.display();
		p.Message();
		p.Message("老司机");
		p.Message("老司机", "男");
		p.Message("老司机", 18);

	}

}
