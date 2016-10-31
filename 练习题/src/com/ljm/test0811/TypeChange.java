package com.ljm.test0811;

public class TypeChange {
	public static void main(String[] args) {
		//基本类型转换成包装类
		int int1 = 10;
		Integer int2 = new Integer(int1);//把int类型转换成Integer类型
		System.out.println(int2);
		char ch1 = 'a';
		Character ch2 = new Character(ch1);
		boolean bool1 = true;
		Boolean bool2 = new Boolean(bool1);
		double dou1 = 15.8;
		Double dou2 = new Double(dou1);
		byte by1 = 12;
		Byte by2 = new Byte(by1);
		short sh1 = 45;
		Short sh2 = new Short(sh1);
		float flo1 = 56.2f;
		Float flo2 = new Float(flo1);
		long lo1 = 132456789;
		Long lo2 = new Long(lo1);
		//字符串转换成包装类
		String str1 = "10";//字符串转换成包装类，需要看字符串的值是什么，进行对应的转换
		Integer int3 = new Integer(str1);
		String str2 = "a";
		Character ch3 =new Character('a');
		//包装类转换成基本类型
		char ch4 = ch2.charValue();//ch2是包装类
		int int4 = int2.intValue();//int2是包装类
		byte by3 = by2.byteValue();
		
		long lo3 = lo2;//自动拆箱
		Long lo4 = lo3;//自动装箱
		//字符串类型转换成基本数据类型(需要把字符串先转换成包装类，然后在转换成基本数据类型)
		int int5 = new Integer(str1);//str1是字符串
		int int6 = new Integer("34");
		System.out.println(int5+"\t"+int6);
		double dou3 = new Double("46.45");
		System.out.println(dou3);
		
		boolean bool3 = new Boolean("false");
		System.out.println(bool3);
		
		//基本数据类型转换成字符串
		String str3 = String.valueOf(bool3);
		System.out.println(str3);
		String str4 = lo4.toString();
		System.out.println(str4);
		String str5 = dou3+"";
		System.out.println(str5);
		
		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		System.out.println(s.equals(s1));
	}

}
