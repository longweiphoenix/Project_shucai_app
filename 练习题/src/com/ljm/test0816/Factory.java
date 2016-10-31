package com.ljm.test0816;

public class Factory {
	public Boss getNew(String key){
		if(key.equals("One")){
			return new One();
		}else if("Two".equals(key)){
			return new Two();
		}else if("»•À¿".equals(key)){
			return new Three();
		}
		return null;
		
		
		
		
		//∑¥…‰
//		try {
//			Boss b = (Boss)Class.forName(key).newInstance();//
//			return b;
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
		
	}
}
