package com.ljm.test0810;

import com.ljm.testclass0810.Animal;
import com.ljm.testclass0810.Monkey;
import com.ljm.testclass0810.Tiger;
public class Test20160810 {
	public static void main(String[] args) {
		//���ö���ָ����
		Animal a = new Animal();
		//���ö���ָ������
		Animal m = new Monkey();//��������ת�����Զ�����ת����
		//�Զ�����ת��
		//��������ת��(ǿ������ת��)
		//Monkey newMonkey = (Monkey)m;//��Animal����ת����Monkey����
		//�����������ָ��������࣬��û����д����ķ��������õķ����Ǹ���ķ���
		Animal t = new Tiger();
		t.shin();
		//��������ص����ͻ���ת��
		Tiger t1 =(Tiger)m;
		Tiger ti = (Tiger)t;
		//ͨ��instanceof�ж����������ܷ�ת��
		if(m instanceof Monkey){
			System.out.println("m��ת����Monkey����");
		}else{
			System.out.println("m����ת����Monkey����");
		}
		
		if(m instanceof Tiger){
			System.out.println("m��ת����Tiger����");
		}else{
			System.out.println("����ת����Tiger����");
		}
		
		//����ֱ����һ���������������ָ����
		//Monkey mo = new Animal();����ת��
		//�������������ã����õķ����Ǳ����
		a.eat();
		//��������ֵ��������ģ���ô���õķ�������д��Ҳ�������
		m.eat();
		//����û����д���������õ��Ǿ��Ǹ���̳й����ķ���
		t.eat();
		//�����ø�������ã�����������е�����
		//t.test();
	}
}
