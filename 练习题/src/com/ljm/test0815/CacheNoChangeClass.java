package com.ljm.test0815;

public class CacheNoChangeClass {
	//����һ����������ʶ����Ĵ�С
	private static final int ARRAY_SIZE = 3;
	//����һ�����������治�ɱ���
	private static CacheNoChangeClass[] array= new CacheNoChangeClass[ARRAY_SIZE];
	//��¼�洢λ�õı���
	private static int pos = 0;
	
	//������ַ�������
	private String name;
	//˽�л��Ĺ��캯��
	private CacheNoChangeClass(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static CacheNoChangeClass valueof(String name){
		//�������������Ƿ����Ѿ������˵Ķ���
		for(int i = 0; i < ARRAY_SIZE; i++){
			//������Ѿ������˵ľͷ���
			if(array[i] != null && array[i].equals(name)){
				//���ض���
				return array[i];
			}
		}
		//�ж������Ƿ��Ѿ���������
		if(pos == ARRAY_SIZE){
			//���黺�����ˣ��Ͱѵ�һ��Ԫ�ظ�������
			array[0] = new CacheNoChangeClass(name);
			pos = 1;
		}else{
			//�������û�������´���һ�����󲢷�������
			array[pos++] = new CacheNoChangeClass(name);
		}
		//���ظղŴ�Ķ���
		return array[pos-1];
	}
	
	//��ӡ���
	public static void printArray(){
		for(CacheNoChangeClass c: array){
			System.out.println(c.getName());
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){//���Ƚϵ�ǰ������Ĵ���ʹ������������Ĵ����Ƿ����
			return false;
		}
		CacheNoChangeClass other = (CacheNoChangeClass)obj;
		if(name == null){
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name)){
			return false;
		}
		return true;
	}

}
