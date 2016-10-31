package com.ljm.collection;
/**
 * 使用了泛型
 * @author Administrator
 *
 * @param <T>
 */
public class Genericity<T> {
	private T ob;//定义泛型成员变量
	
	public Genericity(T ob){
		this.ob = ob;
	}
	//封装
	public T getOb(){
		return ob;
	}
	public void setOb(T ob){
		this.ob = ob;
	}
	public void showType(){
		System.out.println("T的实际类型是："+ob.getClass().getName());
	}
}
