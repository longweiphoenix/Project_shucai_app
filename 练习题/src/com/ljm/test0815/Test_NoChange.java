package com.ljm.test0815;

public class Test_NoChange {
	//����һ����������ʶ����ĳ���
	private static final int ARRAY_SIZE = 100;
	//����һ������洢1��100������
	private static Test_NoChange[] array = new Test_NoChange[ARRAY_SIZE];
	//����洢��λ�õı���
	private static int pos = 0;
	//�������
	private int number;
	//���췽��
	Test_NoChange(int number){
		this.number = number;
	}
	public int getNumber(){
		return this.number;
	}
	static{
		for(int i = 1; i <= ARRAY_SIZE; i++){
			array[i-1] = new Test_NoChange(i);
		}
	}
	public Test_NoChange valueof (int number){
		//��������鿴�Ƿ����Ѿ������˵Ķ���
		for(int i = 0; i < ARRAY_SIZE; i++){
			//������Ѿ������˵ģ��ͷ���
			if(number>=1 && number<=100){
				return array[i];
			}
		}
		//�ж������Ƿ��Ѿ�������
		if(pos == ARRAY_SIZE){
			//��������Ѿ��������ˣ��Ͱѵ�һ��Ԫ�ظ�������
			array[0] = new Test_NoChange(number);
		}else{
			//���û���������´���һ�����󲢷�������
			array[pos++] = new Test_NoChange(number);
		}
		//���ظոմ洢�Ķ���
		return array[pos-1];
	}
	//��ӡ����Ķ���
	public static void print(){
		for(Test_NoChange nc: array){
			System.out.print(nc.number+"~");
		}
	}
}
