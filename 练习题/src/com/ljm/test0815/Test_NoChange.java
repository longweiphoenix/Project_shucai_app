package com.ljm.test0815;

public class Test_NoChange {
	//定义一个常量来标识数组的长度
	private static final int ARRAY_SIZE = 100;
	//定义一个数组存储1到100的整数
	private static Test_NoChange[] array = new Test_NoChange[ARRAY_SIZE];
	//定义存储数位置的变量
	private static int pos = 0;
	//缓存的数
	private int number;
	//构造方法
	Test_NoChange(int number){
		this.number = number;
	}
	public int getNumber(){
		return this.number;
	}
	static{
		for(int i = 1; i <= ARRAY_SIZE; i++){
			array[i-1] = new Test_NoChange(i);
		}
	}
	public Test_NoChange valueof (int number){
		//遍历数组查看是否有已经缓存了的对象
		for(int i = 0; i < ARRAY_SIZE; i++){
			//如果有已经缓存了的，就返回
			if(number>=1 && number<=100){
				return array[i];
			}
		}
		//判断数组是否已经存满了
		if(pos == ARRAY_SIZE){
			//如果数组已经缓存满了，就把第一个元素给覆盖了
			array[0] = new Test_NoChange(number);
		}else{
			//如果没满，就重新创建一个对象并放入数组
			array[pos++] = new Test_NoChange(number);
		}
		//返回刚刚存储的对象
		return array[pos-1];
	}
	//打印缓存的对象
	public static void print(){
		for(Test_NoChange nc: array){
			System.out.print(nc.number+"~");
		}
	}
}
