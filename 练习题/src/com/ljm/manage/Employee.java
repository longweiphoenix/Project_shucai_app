package com.ljm.manage;
/**
 *  �򵥵�ְ������ϵͳ
 * 1.����������ţ��������Ա𡢳������¡��������¡�ѧ����ְ��סַ���绰�����ʡ�
 * 2.�Ե�λ��ְ�����й����������롢������ְ��ɾ�������������������ҡ������ݹ��ʣ�����ȹ��ܡ�
 */

public class Employee {
	private String name;//����
	private String jobNum;//����
	private String sex;//�Ա�
	private String birthDay;//��������
	private String jobDay;//��������
	private String education;//ѧ��
	private String post;//ְ��
	private String address;//סַ
	private String phone;//�绰
	private String money;//����
	
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
