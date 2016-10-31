package com.ljm.test1;

import java.util.Scanner;

public class CaiShu{
	public int num(int a){
	ChuShiHua c = new ChuShiHua();
	
	if(a > c.v){
		System.out.println("输入的数大于V");
	}else if(a == c.v){
		System.out.println("输入的数等于V");
	}else{
		System.out.println("输入的数小于V");
	}
	return a;
	}

	
}
