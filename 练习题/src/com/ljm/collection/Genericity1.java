package com.ljm.collection;
/**
 * 没有使用泛型
 * @author Administrator
 */
public class Genericity1 {
	private Object ob;//定义一个通用类型
	
	public Genericity1(Object ob){
		this.ob = ob;
	}
	
	public Object getOb(){
		return ob;
	}
	public void setOb(Object ob){
		this.ob = ob;
	}
	
	public void showType(){
		System.out.println("T的实际类型是："+ob.getClass().getName());
	}
}
