package com.ljm.test0818;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		//c.setLenient(true);
		//c.set(Calendar.YEAR, 2020);
		//c.set(Calendar.MONTH, 12);
		//c.set(Calendar.DAY_OF_MONTH, 12);
		
		//先用add方法对月份操作
		//c.add(Calendar.MONTH, 1);
		//System.out.println(c.get(Calendar.YEAR));
		//System.out.println(c.get(Calendar.MONTH));
		
		//roll方法的用法
		//c.roll(Calendar.MONTH, 7);
		System.out.println(c.get(Calendar.YEAR));
		//System.out.println(c.get(Calendar.MONTH));
		
		//系统的月份是从0开始就算的
		System.out.println(c.get(Calendar.MONTH)+1);
		//星期是从1开始算的，即日一二三四五六这要顺序计算
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		//SimpleDateFormat 时间处理
		/**
		 * 1.y 年份
		 * 2.M 月份
		 * 3.d 日
		 * 4.h 十二小时制
		 * 5.H 二十四小时制
		 * 6.m 分钟
		 * 7.s 秒
		 */
		//通过simpledateformat类里面的构造函数转显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
		//这里是把要转换的时间通过format方法转换并返回字符串
		String time = sdf.format(c.getTime());
		
		System.out.println(time);
	}
}
