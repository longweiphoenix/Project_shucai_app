package com.lim.io;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamClass {

	//дһ����ͨ�������Ұ�File���󴫹���
	public void  test(File file) throws Exception{
		
		FileInputStream fil = new FileInputStream(file);
		
		//������������������õ�
		int i = 0;
		//��Ϊ���ֽ�����ȡ���ݵ�ʱ����һ��һ���ֽڶ�ȡ����������while��ѭ����ȡ����
		/*while(fil.read() != -1){
			//�����ӡ����ʮ�������͵�����
			//toBinaryString  ��������ʾ��ʽ
			//toHexString ʮ��������ʾ��ʽ
			//toOctalString �˽�����ʾ��ʽ
			System.out.print(Integer.toOctalString(fil.read())+"\t");
			//���滻��
			if ((i++%10) == 0) {
				System.out.println();
			}
		}*/
		//��������ʱ��
		long l = System.currentTimeMillis();
		System.out.println(l);
		/*
		 * ͨ��byte[]���������棬�ڷ��ظ�����
		 */
		byte[] b = new byte[1024*512];
		//����һ��int���͵ı���������
//		int temp = fil.read(b);
//		//���������ȡ���ݷ��ص�intֵ������ĳ��ȴ������ݵĳ��ȣ���ȡ�ͻ��пյ�ֵ
//		for (int j = 0; j < temp; j++) {
//			System.out.print(b[j]+"\t");
//			if (i++%10 == 0) {
//				System.out.println();
//			}
//		}
		
		int temp = 0;
		while ((temp = fil.read(b,0,b.length)) != -1) {
			for (int j = 0; j < temp; j++) {
				System.out.print(b[j]+"\t");
				if (i++%10 == 0) {
					System.out.println();
				}
			}
			
		}
		fil.close();
		//ִ��ʱ��
		System.out.println("ִ��ʱ��:"+(System.currentTimeMillis()-l));
	
	}
}
