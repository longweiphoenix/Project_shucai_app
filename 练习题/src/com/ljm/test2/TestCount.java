package com.ljm.test2;

public class TestCount {
	//��������
	 int a;
	 int b;
	
	//�޲ι����a��ֵ
//	public TestCount(){
//		a = 1;
//	}
	
	//�����вη���
	public TestCount(int na,int nb){//na��nb�ǵ���������ֵ

		a = na;
		b = nb;
	}
	
	public void testCount(){
		int count = 0;//����һ������������ѭ������
		for(int i = 1; i > 0; i++){
			a++;//aÿ������1
			b = b - 2*a;
			count++;
			if(a >= b){//��a>=b��ʱ��ѭ������
				System.out.println("a = "+a+";b = "+b);
				break;
			}
		}
		System.out.println("ѭ��"+count+"��");
	}
	
}
