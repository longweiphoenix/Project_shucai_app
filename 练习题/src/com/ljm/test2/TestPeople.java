package com.ljm.test2;

public class TestPeople {

	public static void main(String[] args) {
		People[] array = {new People(),
				new People("��˼",81,'Ů',20),
				new People("����",89,'��',21),
				new People("����",90,'��',15),
				new People("����",50,'��',14)};
		
		//�����е�����
		People[] arrays = new People[5];
		
		//Ϊ�˵���������ķ�������ǰ��һ���ϵ��û�У�ֻ��Ϊ�˵��÷���
		People arrayss = new People();
		
		for(int i = 0; i < array.length; i++){
			//��Ϊarrayss.sex(arrat[i])������һ��People����
			People p = arrayss.sex(array[i]);
			//�жϷ��صĶ����Ƿ�Ϊnull
			if(p != null){
				//��Ϊ�յ�ʱ����ӵ��µ���������
				arrays[i] = p;
			}else{
				arrays[i] = null;
			}
				
		}
		//�����µ�����
		for(People pp: arrays){
			if(pp != null){
				System.out.println(pp.name);
			}
		}

	}

}
