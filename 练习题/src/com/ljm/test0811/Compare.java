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
		 * getClass()(类对象)描述的类里面的代码
		 * 类的对象：描述的是类里面属性的信息
		 */
		if(obj != null && this.getClass() == obj.getClass()){
			//把obj强制转换成Compare的对象
			Compare c = (Compare)obj;
			//比较连个对象里面的属性值是否相等
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
	 * 重新equals方法
	 */

	/*public boolean equals(Object obj){
		//用==来比较，如果传进来的引用对象和当前对象地址相同，说明是同一个对象，所以返回true。
		if(this == obj){
			return true;
		}
		/**
		 * getClass()(类对象)描述的类里面的代码
		 * 类的对象：描述的是类里面属性的信息
		 */
		/*if(obj != null && this.getClass() == obj.getClass()){
			//把obj强制转换成Compare的对象
			Compare c = (Compare)obj;
			//比较连个对象里面的属性值是否相等
			if(this.getAge() == c.getAge() && this.getName().equals(c.getName())){
				return true;
			}
				
		}
		return false;
	}*/
}
