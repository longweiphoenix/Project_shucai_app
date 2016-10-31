package com.ljm.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {
	
	/**
	 * map key值不能重复
	 * key可以为null，但是只能出现一个
	 * key是可以定义为任意类型
	 */
	
	public static void main(String[] args) {
		Map<Integer,Student> m = new HashMap<Integer,Student>();
		//添加数据
		m.put(1, new Student(1001,"李"));
		m.put(2, new Student(1002,"冉"));
		m.put(3, new Student(1003,"张"));
		
		//entry实体类
		Set<Map.Entry<Integer, Student>> me = m.entrySet();
		
		for(Map.Entry<Integer, Student> entry: me){
			int i = entry.getKey();
			Student s = entry.getValue();
			System.out.println("key的值:"+i+"value的名字:"+s.getName());
		}
		
		//获取key值的set集合
		Set<Integer> seti = m.keySet();
		for(Integer intl: seti){
			//打印key的 值
			System.out.println(intl);
			//打印value的名字
			Student stu = m.get(intl);
			System.out.println("value的名字:"+stu.getName());
		}
		//删除map集合里面的数据
		m.remove(2);
		
		System.out.println("----------------------------------");
		//通过Iterator来遍历
		//第一步定义迭代器Inteator
		Iterator<Map.Entry<Integer, Student>> i = m.entrySet().iterator();
		//遍历
		while(i.hasNext()){
			//通过迭代器获取entry实例
			Map.Entry<Integer, Student> mentry = i.next();
			//获取key的值
			int key = mentry.getKey();
			//获取value
			Student s = mentry.getValue();
			System.out.println("key值："+key+"\tvalue值"+s.getName());
		}
		
	}
}
