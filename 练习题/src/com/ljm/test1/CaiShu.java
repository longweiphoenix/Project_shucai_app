package com.ljm.test1;

import java.util.Scanner;

public class CaiShu{
	public int num(int a){
	ChuShiHua c = new ChuShiHua();
	
	if(a > c.v){
		System.out.println("�����������V");
	}else if(a == c.v){
		System.out.println("�����������V");
	}else{
		System.out.println("�������С��V");
	}
	return a;
	}

	
}
