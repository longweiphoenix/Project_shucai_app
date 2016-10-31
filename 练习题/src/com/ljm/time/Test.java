package com.ljm.time;

public class Test {
	public static void main(String[] args) {
		//赋值时间
		Mytime m = new Mytime(16,7,7);
		System.out.println(m.getHour()+"时"+m.getMinute()+"分"+m.getSecond()+"秒");
		//时加
		Mytime.addHour(11);
		System.out.println(m.getHour()+"时"+m.getMinute()+"分"+m.getSecond()+"秒");
		//分加
		Mytime.addMinute(26);
		System.out.println(m.getHour()+"时"+m.getMinute()+"分"+m.getSecond()+"秒");
		//秒加
		Mytime.addSecond(38);
		System.out.println(m.getHour()+"时"+m.getMinute()+"分"+m.getSecond()+"秒");
		//时减
		Mytime.subHour(11);
		System.out.println(m.getHour()+"时"+m.getMinute()+"分"+m.getSecond()+"秒");
		//分减
		Mytime.subMinute(26);
		System.out.println(m.getHour()+"时"+m.getMinute()+"分"+m.getSecond()+"秒");
		//秒减
		Mytime.subSecond(38);
		System.out.println(m.getHour()+"时"+m.getMinute()+"分"+m.getSecond()+"秒");

		
	}

}
