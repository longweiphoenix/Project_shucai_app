package com.ljm.test2;

public class TestCount {
	//创建属性
	 int a;
	 int b;
	
	//无参构造给a赋值
//	public TestCount(){
//		a = 1;
//	}
	
	//构造有参方法
	public TestCount(int na,int nb){//na，nb是导进来的数值

		a = na;
		b = nb;
	}
	
	public void testCount(){
		int count = 0;//定义一个变量来计算循环次数
		for(int i = 1; i > 0; i++){
			a++;//a每次增加1
			b = b - 2*a;
			count++;
			if(a >= b){//当a>=b的时候，循环打破
				System.out.println("a = "+a+";b = "+b);
				break;
			}
		}
		System.out.println("循环"+count+"次");
	}
	
}
