package AccessModifiers;

public class AccessModifiers {
	/**
	 * public(公开的)  公共访问控制符，可以修饰类，成员变量，方法，构造方法
	 */
	//访问控制符public修饰成员变量 
	public String name;
	//public修饰构造方法
//	public AccessModifiers(){
//		System.out.println("这是一个被public修饰的构造方法");
//	}
	//public修饰方法
	public void testAccess(){
		System.out.println("这是一个被public修饰的方法");
	}
	/**
	 * protected(受保护的) 子类访问修饰符，可以修饰，可以修饰成员变量，方法，构造方法，不可修饰类
	 */
	//protected修饰成员变量
	protected int age;
	//被protected修饰的构造方法
	protected AccessModifiers(int age){
		System.out.println("这是一个被protected修饰的构造方法");
	}
	protected void testAccessA(){
		System.out.println("这是一个被protected修饰的方法");
	}
	/**
	 * defult(默认的修饰符) 也就是不写访问控制符，可以被本包下面的其他类访问，也可以被本类中的其他成员访问，它可以修饰
	 * 类，成员变量，方法，构造方法
	 */
	//（默认修饰符）修饰成员变量
	char sex;
	//默认修饰符修饰构造方法
	AccessModifiers(){
		System.out.println("这是一个被默认修饰符修饰的构造方法");
	}
	
	void testAccessB(){
		new AccessModifiers(15,25);
		testAccessC();
		System.out.println("这是一个被默认修饰符修饰的方法");
	}
	
	
	/**
	 * private(当前类方法控制符) private可以修饰成员变量，方法，构造方法，表示只能被当前类的其他成员使用
	 */
	//private修饰成员变量
	private int height;
	//private修饰方法
	private void testAccessC(){
		System.out.println("这是一个被private修饰的方法");
	}
	//private修饰构造方法
	private AccessModifiers(int height,int age){
		System.out.println("这是一个被private修饰的构造方法");
	}
	/**
	 * this代表当前对象，可以通过this.属性：代表调用当前类的属性。可以通过this.方法：代表当前类的方法
	 */
	public void testThis(){
		//this.属性  其实程序里面是有this这个关键字的，只是被省略了
		System.out.println(this.name);
		//this.方法  其实程序里面是有this这个关键字的，只是被省略了
		this.testAccessB();
	}
	//构造方法里面用到的this
	public AccessModifiers(String name,char sex,int age,int height){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
	}

}
