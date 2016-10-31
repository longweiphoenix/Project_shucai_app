package com.ljm.test0811;

public class Compare {
	private int age;
	private String name;
	
	public Compare(){
		
	}
	
	public Compare(int age,String name){
		this.age = age;
		this.name =name;
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		/**
		 * getClass()(�����)������������Ĵ���
		 * ��Ķ��������������������Ե���Ϣ
		 */
		if(obj != null && this.getClass() == obj.getClass()){
			//��objǿ��ת����Compare�Ķ���
			Compare c = (Compare)obj;
			//�Ƚ������������������ֵ�Ƿ����
			if(this.getAge() == c.getAge() && this.getName().equals(c.getName())){
				return true;
			}
				
		}
		return false;
	}
	
/*	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Compare other = (Compare)obj;
		if(age != other.age)
			return false;
		if(name == null){
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name))
			return false;
		return true;
	}*/
	
	/**
	 * ����equals����
	 */

	/*public boolean equals(Object obj){
		//��==���Ƚϣ���������������ö���͵�ǰ�����ַ��ͬ��˵����ͬһ���������Է���true��
		if(this == obj){
			return true;
		}
		/**
		 * getClass()(�����)������������Ĵ���
		 * ��Ķ��������������������Ե���Ϣ
		 */
		/*if(obj != null && this.getClass() == obj.getClass()){
			//��objǿ��ת����Compare�Ķ���
			Compare c = (Compare)obj;
			//�Ƚ������������������ֵ�Ƿ����
			if(this.getAge() == c.getAge() && this.getName().equals(c.getName())){
				return true;
			}
				
		}
		return false;
	}*/
}
