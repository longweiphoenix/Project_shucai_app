package com.ljm.test2;

public class People {
	public String name;
	public int score;
	public char sex;
	public int age;
	//�޲ι��췽��
	public People(){
		name = "����";
		score = 80;
		age = 18;
		sex = '��';
	}
	//�вι��췽��
	public People(String newname,int newscore,char newsex,int newage){
		name = newname;
		score = newscore;
		sex = newsex;
		age = newage;
	}
	
	//ɸѡ����
	public People sex(People student){
		if(student.sex == '��'){
			return student;
		}else{
			return null;
		}
	}
	
	//ɸѡѧ������
	public boolean score(int score){
		if(score > 80){
			return true;
		}else{
			return false;
		}
	}
}
