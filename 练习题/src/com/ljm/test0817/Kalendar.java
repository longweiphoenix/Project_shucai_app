package com.ljm.test0817;
import java.util.Scanner;

public class Kalendar {
	public static void main(String[] args) {
		
		
		
		
		//�ٶȵ� ���е�����
//		int sum = 0;//������������
//		@SuppressWarnings("resource")
//		Scanner n = new Scanner(System.in);//�ӿ���̨����
//		System.out.println("������ݣ�");
//		int year = n.nextInt();
//		System.out.println("�������·ݣ�");
//		int month = n.nextInt();
//		//�����1900�꿪ʼ��year������������year-1900����Щ��֮�����е�����
//		for(int i = 1900; i < year; i++){
//			if(i%4==0 && i%100!=0 || i%400==0){
//				sum +=366;//����ʱ366��
//			}else{
//				sum += 365;//ƽ����365��
//			}
//		}
//		//����year�ӵ�һ���µ�month�µ�����������һ����month��֮ǰ���е�����
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
//		//����month�ж�����
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
//		//��������
//		int weekday = sum%7;//weekday���Ƕ�Ӧ������
//		System.out.println("��\tһ\t��\t��\t��\t��\t��");
//		
//		for(int i = 0; i <= weekday; i++){
//			System.out.print("\t");
//		}
//		//����������Ӧ������
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
