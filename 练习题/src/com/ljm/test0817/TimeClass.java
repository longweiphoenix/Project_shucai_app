package com.ljm.test0817;

import java.util.Calendar;
import java.util.Date;

public class TimeClass {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//获取时间的两种方式   Date  Calendar
		
		//Date类，创建时间对象
		Date d = new Date();
		//直接打印，输出的是当前时间
		System.out.println(d);
		//获取毫秒
		System.out.println(d.getTime()+"毫秒");
		System.out.println(System.currentTimeMillis()+"毫秒");
		//获取年份
		System.out.println(d.getYear()+1900+"年");//从1900年开始算起
		//获取月份
		System.out.println(d.getMonth()+1+"月");//从0月开始算起的
		//获取天数
		System.out.println(d.getDate()+"日");
		//获取时
		System.out.println(d.getHours()+"时");
		//获取分
		System.out.println(d.getMinutes()+"分");
		//获取秒
		System.out.println(d.getSeconds()+"秒");
		//获取星期
		System.out.println(d.getDay()+"星期");
		
		//设置年份
		d.setYear(2020);
		System.out.println(d.getYear()+"年");
		//设置月份
		d.setMonth(13);
		System.out.println(d.getMonth()+"月");
		
		System.out.println("***************楚河汉界*****************");
		
		//Calendar 通过getInstance获取实例
		Calendar c = Calendar.getInstance();
		//System.out.println(c);//输出的是地址
		//获取毫秒
		System.out.println(c.getTimeInMillis()+"毫秒");
		//获取年份
		System.out.println(c.get(Calendar.YEAR)+"年");
		//获取月份
		System.out.println(c.get(Calendar.MONTH)+1+"月");//月份是从第零个月开始就算的
		//获取天数
		System.out.println(c.get(Calendar.DAY_OF_MONTH)+"日");
		//获取星期
		System.out.println(c.get(Calendar.WEEK_OF_MONTH)+"星期");
		//获取时(12小时制)
		System.out.println(c.get(Calendar.HOUR)+"时");
		//获取时(24小时制)
		System.out.println(c.get(Calendar.HOUR_OF_DAY)+"时");
		//获取分
		System.out.println(c.get(Calendar.MINUTE)+"分");
		//获取秒
		System.out.println(c.get(Calendar.SECOND)+"秒");
		
		//设置
		//设置年份
		c.set(Calendar.YEAR, 2020);
		System.out.println(c.get(Calendar.YEAR)+"年");
		//设置月份
		c.set(Calendar.MONTH, 13);
		System.out.println(c.get(Calendar.MONTH)+"月");
		
	}
}
