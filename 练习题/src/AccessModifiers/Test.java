package AccessModifiers;

public class Test {

	public static void main(String[] args) {
	/*	 //���ñ�public���εĳ�Ա���������췽���ͷ���
		 AccessModifiers am = new AccessModifiers();//AccessModifiers��ʱ������
		 String name = am.name;
		 System.out.println(name);//�����пɱ�����
		 am.testAccess();//���� AccessModifiers���еķ�������public���Σ��ɱ�����
	*/	 
		 //���ñ�protected���εĳ�Ա���������췽���ͷ���
	/*	 AccessModifiers am = new AccessModifiers(15);
		 int age = am.age;
		 System.out.println(age);
		 am.testAccessA();
	*/
		//���ñ�Ĭ�����η����εĳ�Ա���������췽���ͷ���
		AccessModifiers am = new AccessModifiers("��",'Ů',24,168);
		char sex = am.sex;
		System.out.println("�Ա�"+sex);
		am.testAccessB();
		am.testThis();
	
	}

}
