package Calculator;

public class Number {
	private static int n1;
	private static int n2;
	
	//���췽��
	Number(int n1,int n2){
		this.n1=n1;
		this.n2=n2;
		
	}
	public static int getN1() {
		return n1;
	}
	public static int getN2() {
		return n2;
	}
	//�ӷ�
	static int addition(int n1,int n2){
		return n1+n2;
	}
	//����
	static int subtration(int n1,int n2){
		return n1-n2;
	}
	//�˷�
	static int multiplication(int n1,int n2){
		return n1*n2;
	}
	//����
	static double division(double n1,double n2){
		return n1/n2;
	}

}
