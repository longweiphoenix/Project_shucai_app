package com.ljm.manage;
/**
 *  简单的职工管理系统
 * 1.对象包括工号，姓名、性别、出生年月、工作年月、学历、职务、住址、电话，工资。
 * 2.对单位的职工进行管理，包括插入、（根据职务）删除、（根据姓名）查找、（根据工资）排序等功能。
 */

public class Employee {
	private String name;//姓名
	private String jobNum;//工号
	private String sex;//性别
	private String birthDay;//出生年月
	private String jobDay;//工作年月
	private String education;//学历
	private String post;//职务
	private String address;//住址
	private String phone;//电话
	private String money;//工资
	
	Employee(String name,String jubNum,String sex,String birthday,String jobDay,String education,String post,String address,String phone,String money, String jobNum){
		this.name = name;
		this.jobNum = jobNum;
		this.sex = sex;
		this.birthDay = birthday;
		this.jobDay = jobDay;
		this.education = education;
		this.post = post;
		this.address = address;
		this.phone = phone;
		this.money = money;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getJobDay() {
		return jobDay;
	}

	public void setJobDay(String jobDay) {
		this.jobDay = jobDay;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
}
