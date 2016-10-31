package com.ljm.time;

public class Mytime {
	//�����Ա����
	private static int hour;
	private static int minute;
	private static int second;
	
	//���ʱ��ļӼ�����
	Mytime(int hour,int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	//���
	public static int addSecond(int sec){
		second += sec;
		if(second > 60){
			second = second - 60;
			minute++;
		}
		return sec;	
	}
	//�ּ�
	public static int addMinute(int min){
		minute += min;
		if(minute > 60){
			minute = minute - 60;
			hour++;
		}
		return min;
	}
	//ʱ��
	public static int addHour(int hou){
		hour += hou;
		if(hour > 24){
			hour = hour - 24;
		}
		return hou;
	}
	//���
	public static int subSecond(int sec){
		second -= sec;
		if(second < 0){
			second = 60 + second;
			minute--;
		}
		return sec;	
	}
	//�ּ�
	public static int subMinute(int min){
		minute -= min;
		if(minute < 0){
			minute = 60 + minute;
			hour--;
		}
		return min;
	}
	//ʱ��
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

