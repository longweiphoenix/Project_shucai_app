package AccessModifiers;

public class Test {

	public static void main(String[] args) {
	/*	 //调用被public修饰的成员变量，构造方法和方法
		 AccessModifiers am = new AccessModifiers();//AccessModifiers此时被调用
		 String name = am.name;
		 System.out.println(name);//本包中可被调用
		 am.testAccess();//调用 AccessModifiers类中的方法，被public修饰，可被调用
	*/	 
		 //调用被protected修饰的成员变量，构造方法和方法
	/*	 AccessModifiers am = new AccessModifiers(15);
		 int age = am.age;
		 System.out.println(age);
		 am.testAccessA();
	*/
		//调用被默认修饰符修饰的成员变量，构造方法和方法
		AccessModifiers am = new AccessModifiers("白",'女',24,168);
		char sex = am.sex;
		System.out.println("性别："+sex);
		am.testAccessB();
		am.testThis();
	
	}

}
