package com.ljm.test2;

public class TestStudentSystem {
	String name;
	int stuId;
	char sex;
	int age;
	//�����вη���
	public TestStudentSystem(String newname,int newstuId,char newsex,int newage){
		name = newname;
		stuId = newstuId;
		sex = newsex;
		age = newage;
	}
	
	//����Ϣ����������Ҫ����������
	public TestStudentSystem[] saveStudent(TestStudentSystem tss,TestStudentSystem[] tssArray){
		for(int i = 0; i < tssArray.length; i++){//�Ѵӿ���̨�����ѧ����Ϣ�洢��
			if(tssArray[i] == null){             //����tssArray�еĿ�λ��
				tssArray[i] = tss;
				break;//�洢��Ϣ������ѭ��
			}
		}
		return tssArray;//����TestStudentSystem[]��������
	}
	
	//��ѯϵͳ��Ϣ
	public void searchStudent(TestStudentSystem[] tssArray){
		for(int i = 0; i < tssArray.length; i++){
			if(tssArray[i] != null){
				System.out.println("������"+tssArray[i].name+"\nѧ�ţ�"+tssArray[i].stuId+"\n�Ա�"+tssArray[i].sex+"\n���䣺"+tssArray[i].age);
				
			}
		}
	}

}
