package com.ljm.test2;

public class People {
	public String name;
	public int score;
	public char sex;
	public int age;
	//无参构造方法
	public People(){
		name = "张三";
		score = 80;
		age = 18;
		sex = '男';
	}
	//有参构造方法
	public People(String newname,int newscore,char newsex,int newage){
		name = newname;
		score = newscore;
		sex = newsex;
		age = newage;
	}
	
	//筛选男生
	public People sex(People student){
		if(student.sex == '男'){
			return student;
		}else{
			return null;
		}
	}
	
	//筛选学生分数
	public boolean score(int score){
		if(score > 80){
			return true;
		}else{
			return false;
		}
	}
}
