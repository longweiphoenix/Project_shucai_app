package AccessModifiers;

public class AccessModifiers {
	/**
	 * public(������)  �������ʿ��Ʒ������������࣬��Ա���������������췽��
	 */
	//���ʿ��Ʒ�public���γ�Ա���� 
	public String name;
	//public���ι��췽��
//	public AccessModifiers(){
//		System.out.println("����һ����public���εĹ��췽��");
//	}
	//public���η���
	public void testAccess(){
		System.out.println("����һ����public���εķ���");
	}
	/**
	 * protected(�ܱ�����) ����������η����������Σ��������γ�Ա���������������췽��������������
	 */
	//protected���γ�Ա����
	protected int age;
	//��protected���εĹ��췽��
	protected AccessModifiers(int age){
		System.out.println("����һ����protected���εĹ��췽��");
	}
	protected void testAccessA(){
		System.out.println("����һ����protected���εķ���");
	}
	/**
	 * defult(Ĭ�ϵ����η�) Ҳ���ǲ�д���ʿ��Ʒ������Ա������������������ʣ�Ҳ���Ա������е�������Ա���ʣ�����������
	 * �࣬��Ա���������������췽��
	 */
	//��Ĭ�����η������γ�Ա����
	char sex;
	//Ĭ�����η����ι��췽��
	AccessModifiers(){
		System.out.println("����һ����Ĭ�����η����εĹ��췽��");
	}
	
	void testAccessB(){
		new AccessModifiers(15,25);
		testAccessC();
		System.out.println("����һ����Ĭ�����η����εķ���");
	}
	
	
	/**
	 * private(��ǰ�෽�����Ʒ�) private�������γ�Ա���������������췽������ʾֻ�ܱ���ǰ���������Աʹ��
	 */
	//private���γ�Ա����
	private int height;
	//private���η���
	private void testAccessC(){
		System.out.println("����һ����private���εķ���");
	}
	//private���ι��췽��
	private AccessModifiers(int height,int age){
		System.out.println("����һ����private���εĹ��췽��");
	}
	/**
	 * this����ǰ���󣬿���ͨ��this.���ԣ�������õ�ǰ������ԡ�����ͨ��this.����������ǰ��ķ���
	 */
	public void testThis(){
		//this.����  ��ʵ������������this����ؼ��ֵģ�ֻ�Ǳ�ʡ����
		System.out.println(this.name);
		//this.����  ��ʵ������������this����ؼ��ֵģ�ֻ�Ǳ�ʡ����
		this.testAccessB();
	}
	//���췽�������õ���this
	public AccessModifiers(String name,char sex,int age,int height){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
	}

}
