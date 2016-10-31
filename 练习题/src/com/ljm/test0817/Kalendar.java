package com.ljm.test0817;
import java.util.Scanner;

public class Kalendar {
	public static void main(String[] args) {
		
		
		
		
		//百度的 ，有点问题
//		int sum = 0;//用来计算天数
//		@SuppressWarnings("resource")
//		Scanner n = new Scanner(System.in);//从控制台输入
//		System.out.println("输入年份：");
//		int year = n.nextInt();
//		System.out.println("请输入月份：");
//		int month = n.nextInt();
//		//计算从1900年开始到year的天数，即（year-1900）这些年之间所有的天数
//		for(int i = 1900; i < year; i++){
//			if(i%4==0 && i%100!=0 || i%400==0){
//				sum +=366;//润年时366天
//			}else{
//				sum += 365;//平年是365天
//			}
//		}
//		//计算year从第一个月到month月的天数，即这一年中month月之前所有的天数
//		for(int i = 0; i < month; i++){
//			if(i == 2){
//				if(year%4==0 && year%100!=0 || year%400==0){
//					sum += 29;
//				}else{
//					sum += 28;
//				}
//			}else{
//				if(i==4 || i== 6 || i==9 || i==11){
//					sum += 30;
//				}else{
//					sum += 31;
//				}
//			} 
//		}
//		//计算month有多少天
//		int days = 0;
//		if(month == 2){
//			if(year%4==0 && year%100!=0 || year%400==0){
//				days = 29;
//			}else{
//				days = 28;
//			}
//		}else if(month==4 || month==6 || month==9 || month==11){
//			days = 30;
//		}else{
//			days = 31;
//		}
//		//计算星期
//		int weekday = sum%7;//weekday就是对应的星期
//		System.out.println("日\t一\t二\t三\t四\t五\t六");
//		
//		for(int i = 0; i <= weekday; i++){
//			System.out.print("\t");
//		}
//		//计算日历对应的星期
//		for(int i = 1; i <= days; i++){
//			if(sum%7 == 6){
//				System.out.print(i+"\n");
//			}else{
//				System.out.print(i+"\t");
//			}
//			sum += 1;
//		}
	}
}
