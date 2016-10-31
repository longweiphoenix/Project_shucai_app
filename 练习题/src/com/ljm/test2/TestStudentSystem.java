package com.ljm.test2;

public class TestStudentSystem {
	String name;
	int stuId;
	char sex;
	int age;
	//构造有参方法
	public TestStudentSystem(String newname,int newstuId,char newsex,int newage){
		name = newname;
		stuId = newstuId;
		sex = newsex;
		age = newage;
	}
	
	//存信息，传入对象和要操作的数组
	public TestStudentSystem[] saveStudent(TestStudentSystem tss,TestStudentSystem[] tssArray){
		for(int i = 0; i < tssArray.length; i++){//把从控制台输入的学生信息存储到
			if(tssArray[i] == null){             //数组tssArray中的空位置
				tssArray[i] = tss;
				break;//存储信息后跳出循环
			}
		}
		return tssArray;//返回TestStudentSystem[]数据类型
	}
	
	//查询系统信息
	public void searchStudent(TestStudentSystem[] tssArray){
		for(int i = 0; i < tssArray.length; i++){
			if(tssArray[i] != null){
				System.out.println("姓名："+tssArray[i].name+"\n学号："+tssArray[i].stuId+"\n性别："+tssArray[i].sex+"\n年龄："+tssArray[i].age);
				
			}
		}
	}

}
