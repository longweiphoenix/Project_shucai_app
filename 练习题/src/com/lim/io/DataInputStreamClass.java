package com.lim.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputStreamClass {

	public void test(File fil) throws Exception{
		//�������ݺ�ͨ��DataOutputStream���Խ����ݵ��������
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(fil));
		
		dos.writeInt(98);
		dos.writeBoolean(false);
		dos.writeUTF("Ƚ˾��");
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
