package com.lim.Excepition0825;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		/**
		 * File������ļ�Ŀ¼
		 */
		File f = new File("C:\\");
//		int i = f.compareTo(f);//����ĸ˳��Ƚ���������·����
//		System.out.println(i);
		//System.out.println(f.canWrite());//�ܷ��޸�·������ʾ���ļ�
		/*try {
			//�����յ��ļ�
			f.createNewFile();
		} catch (IOException e){
			// TODO: handle exception
			e.printStackTrace();
		}*/
		//�鿴�Ƿ���һ���ļ�
/*		if (f.isFile()) {
			//ɾ����ǰ·�����ļ�
			f.delete();
		}
*/		//�жϵ�ǰ·����Ŀ¼�����ļ��Ƿ����
//		if (!f.exists()) {
//			//�����ǰ�ļ������ھʹ���
//			f.mkdir();

		//f.mkdirs();//ʹ��mkdirs();����·�������в����ڵ�Ŀ¼���ļ�
//		}else{
//			f.delete();
//		}
/*		if (f.isDirectory()) {
			System.out.println("��Ŀ¼");
		}else{
			System.out.println("����Ŀ¼");
		}
*/		
/*		System.out.println(f);
		//��ȡ����·��
		System.out.println(f.getAbsolutePath());
		//��ȡ��ǰĿ¼������
		System.out.println(f.getName());
		//���ص�ǰ·������������ļ���Ŀ¼
		File[] f1 = f.listFiles();
		for (File f2: f1) {
			System.out.println(f2);
		}
*/		
		
		
		
//		 printfile(f);
//	}
//	public static void printfile(File file)
//	{
//		if(!file.exists())
//		{
//			System.out.println("���ļ�������");
//		}
//	   File[] pf=file.listFiles();
//	   for(File i:pf)
//	   {
//		   if(i.isFile())
//		   {
//			   System.out.println(i);
//		   }
//		   else if(i.isDirectory())
//		   {
//			   printfile(i);
//		   }
//	   }
//		
	 print(f);
	}
	//��ӡ���ĳ��·���������ļ�
	public static void print(File f){
		File[] f1 = f.listFiles();
		//�жϵ�ǰfile���������Ƿ���Ԫ��
		if (f1 != null && f1.length>0) {
			//��foreach����
			for(File f2: f1){
				if (f2.isDirectory()) {
					print(f2);
				}else{
					System.out.println(f2);
				}
			}
		}
	}

}
