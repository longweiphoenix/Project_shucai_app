package com.lim.io;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamClass {

	//写一个普通方法并且把File对象传过来
	public void  test(File file) throws Exception{
		
		FileInputStream fil = new FileInputStream(file);
		
		//这个变量是用来换行用的
		int i = 0;
		//因为用字节流读取数据的时候是一个一个字节读取所以我们用while来循环读取数据
		/*while(fil.read() != -1){
			//这里打印的是十进制类型的数据
			//toBinaryString  二进制显示方式
			//toHexString 十六进制显示方式
			//toOctalString 八进制显示方式
			System.out.print(Integer.toOctalString(fil.read())+"\t");
			//下面换行
			if ((i++%10) == 0) {
				System.out.println();
			}
		}*/
		//计算运行时间
		long l = System.currentTimeMillis();
		System.out.println(l);
		/*
		 * 通过byte[]数组来缓存，在返回给程序
		 */
		byte[] b = new byte[1024*512];
		//定义一个int类型的变量来接受
//		int temp = fil.read(b);
//		//长度是你读取数据返回的int值，数组的长度大于数据的长度，读取就会有空的值
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
		//执行时间
		System.out.println("执行时间:"+(System.currentTimeMillis()-l));
	
	}
}
