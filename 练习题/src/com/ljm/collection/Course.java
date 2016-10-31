package com.ljm.collection;

public class Course {
	private int id;
	private String cname;
	
	public Course(int id,String cname){
		this.id = id;
		this.cname = cname;
	}
	//·â×°
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.cname = name;
	}
	public String getName(){
		return cname;
	}
	@Override
	public String toString() {
		return "Course [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
	
	
	
}
