package com.lim.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputStreamClass {

	public void test(File fil) throws Exception{
		//输入数据后，通过DataOutputStream可以将数据的类型输出
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(fil));
		
		dos.writeInt(98);
		dos.writeBoolean(false);
		dos.writeUTF("冉司机");
		dos.writeFloat(23.6f);
		
		DataInputStream dis = new DataInputStream(new FileInputStream(fil));
		
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readUTF());
		System.out.println(dis.readFloat());
		
		dos.close();
		dis.close();
		
	}
}
