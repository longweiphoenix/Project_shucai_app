package com.ljm.collection;
/**
 * ʹ���˷���
 * @author Administrator
 *
 * @param <T>
 */
public class Genericity<T> {
	private T ob;//���巺�ͳ�Ա����
	
	public Genericity(T ob){
		this.ob = ob;
	}
	//��װ
	public T getOb(){
		return ob;
	}
	public void setOb(T ob){
		this.ob = ob;
	}
	public void showType(){
		System.out.println("T��ʵ�������ǣ�"+ob.getClass().getName());
	}
}
