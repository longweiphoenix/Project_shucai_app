package com.ljm.time;

public class Mytime {
	//定义成员变量
	private static int hour;
	private static int minute;
	private static int second;
	
	//添加时间的加减方法
	Mytime(int hour,int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	//秒加
	public static int addSecond(int sec){
		second += sec;
		if(second > 60){
			second = second - 60;
			minute++;
		}
		return sec;	
	}
	//分加
	public static int addMinute(int min){
		minute += min;
		if(minute > 60){
			minute = minute - 60;
			hour++;
		}
		return min;
	}
	//时加
	public static int addHour(int hou){
		hour += hou;
		if(hour > 24){
			hour = hour - 24;
		}
		return hou;
	}
	//秒减
	public static int subSecond(int sec){
		second -= sec;
		if(second < 0){
			second = 60 + second;
			minute--;
		}
		return sec;	
	}
	//分减
	public static int subMinute(int min){
		minute -= min;
		if(minute < 0){
			minute = 60 + minute;
			hour--;
		}
		return min;
	}
	//时减
	public static int subHour(int hou){
		hour -= hou;
		if(hour < 0){
			hour = 24 + hour;
		}
		return hou;
	}
	
	
	
	public static int getHour() {
		return hour;
	}
	public static void setHour(int hour) {
		Mytime.hour = hour;
	}
	public static int getMinute() {
		return minute;
	}
	public static void setMinute(int minute) {
		Mytime.minute = minute;
	}
	public static int getSecond() {
		return second;
	}
	public static void setSecond(int second) {
	Mytime.second = second;
	}

}

