package com.ljm.test0817;
import java.math.BigDecimal;
/**
 * 算数运算
 * @author Administrator
 */
public class UnitClass {
	
	private final static int SEVERY = 2;
	//加
	public static double add(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		
		return bd.add(bd1).doubleValue();
	}
	//减
	public static double subtract(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		
		return bd.subtract(bd1).doubleValue();
	}
	//乘法
	public static double multipliy(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		
		return bd.multiply(bd1).doubleValue();
	}
	//除法
	public static double divide(double dou1,double dou2){
		BigDecimal bd = BigDecimal.valueOf(dou1);
		BigDecimal bd1 = BigDecimal.valueOf(dou2);
		//取其结果是两个小数点，取上：即进一位
		return bd.divide(bd1,SEVERY,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
