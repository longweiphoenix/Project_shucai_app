package com.lim.Excepition0825;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		/**
		 * File类操作文件目录
		 */
		File f = new File("C:\\");
//		int i = f.compareTo(f);//按字母顺序比较两个抽象路径名
//		System.out.println(i);
		//System.out.println(f.canWrite());//能否修改路径名表示的文件
		/*try {
			//创建空的文件
			f.createNewFile();
		} catch (IOException e){
			// TODO: handle exception
			e.printStackTrace();
		}*/
		//查看是否是一个文件
/*		if (f.isFile()) {
			//删除当前路径的文件
			f.delete();
		}
*/		//判断当前路径的目录或者文件是否存在
//		if (!f.exists()) {
//			//如果当前文件不存在就创建
//			f.mkdir();

		//f.mkdirs();//使用mkdirs();创建路径中所有不存在的目录或文件
//		}else{
//			f.delete();
//		}
/*		if (f.isDirectory()) {
			System.out.println("是目录");
		}else{
			System.out.println("不是目录");
		}
*/		
/*		System.out.println(f);
		//获取绝对路径
		System.out.println(f.getAbsolutePath());
		//获取当前目录的名字
		System.out.println(f.getName());
		//返回当前路径下面的所有文件和目录
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
//			System.out.println("该文件不存在");
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
	//打印输出某个路径的所有文件
	public static void print(File f){
		File[] f1 = f.listFiles();
		//判断当前file类型数组是否有元素
		if (f1 != null && f1.length>0) {
			//用foreach遍历
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
