package com.ljm.test0817;
import java.math.BigDecimal;
/**
 * ��������
 * @author Administrator
 */
public class UnitClass {
	
	private final static int SEVERY = 2;
	//��
	public static double add(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		
		return bd.add(bd1).doubleValue();
	}
	//��
	public static double subtract(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		
		return bd.subtract(bd1).doubleValue();
	}
	//�˷�
	public static double multipliy(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		
		return bd.multiply(bd1).doubleValue();
	}
	//����
	public static double divide(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		//ȡ����������С���㣬ȡ�ϣ�����һλ
		return bd.divide(bd1,SEVERY,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
