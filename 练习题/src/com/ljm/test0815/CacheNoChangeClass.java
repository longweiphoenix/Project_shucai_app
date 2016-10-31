package com.ljm.test0815;

public class CacheNoChangeClass {
	//定义一个常量来标识数组的大小
	private static final int ARRAY_SIZE = 3;
	//创建一个数组来缓存不可变类
	private static CacheNoChangeClass[] array= new CacheNoChangeClass[ARRAY_SIZE];
	//记录存储位置的变量
	private static int pos = 0;
	
	//缓存的字符串属性
	private String name;
	//私有化的构造函数
	private CacheNoChangeClass(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static CacheNoChangeClass valueof(String name){
		//遍历数组里面是否有已经缓存了的对象
		for(int i = 0; i < ARRAY_SIZE; i++){
			//如果有已经缓存了的就返回
			if(array[i] != null && array[i].equals(name)){
				//返回对象
				return array[i];
			}
		}
		//判断数组是否已经缓存满了
		if(pos == ARRAY_SIZE){
			//数组缓存满了，就把第一给元素给覆盖了
			array[0] = new CacheNoChangeClass(name);
			pos = 1;
		}else{
			//如果缓存没满就重新创建一个对象并放入数组
			array[pos++] = new CacheNoChangeClass(name);
		}
		//返回刚才存的对象
		return array[pos-1];
	}
	
	//打印输出
	public static void printArray(){
		for(CacheNoChangeClass c: array){
			System.out.println(c.getName());
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){//当比较当前类里面的代码和传进来的类对象的代码是否相等
			return false;
		}
		CacheNoChangeClass other = (CacheNoChangeClass)obj;
		if(name == null){
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name)){
			return false;
		}
		return true;
	}

}
