package com.ljm.test2;

public class TestPeople {

	public static void main(String[] args) {
		People[] array = {new People(),
				new People("张思",81,'女',20),
				new People("张五",89,'男',21),
				new People("张六",90,'男',15),
				new People("张柒",50,'男',14)};
		
		//定义行的数组
		People[] arrays = new People[5];
		
		//为了调用类里面的方法，跟前面一点关系都没有，只是为了调用方法
		People arrayss = new People();
		
		for(int i = 0; i < array.length; i++){
			//因为arrayss.sex(arrat[i])返回了一个People对象
			People p = arrayss.sex(array[i]);
			//判断返回的对象是否为null
			if(p != null){
				//不为空的时候添加到新的数组里面
				arrays[i] = p;
			}else{
				arrays[i] = null;
			}
				
		}
		//遍历新的数组
		for(People pp: arrays){
			if(pp != null){
				System.out.println(pp.name);
			}
		}

	}

}
