package com.ljm.collection;
/**
 * û��ʹ�÷���
 * @author Administrator
 */
public class Genericity1 {
	private Object ob;//����һ��ͨ������
	
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
		System.out.println("T��ʵ�������ǣ�"+ob.getClass().getName());
	}
}
