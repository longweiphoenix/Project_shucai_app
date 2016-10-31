package Calculator;

public class Test {
	public static void main(String[] args) {
		Number num = new Number(1,2);
		
		System.out.println(num.getN1()+" "+num.getN2());
		
		int sum1 = Number.addition(5, 6);
		System.out.println(sum1);
		
		int sum2 = Number.multiplication(5, 6);
		System.out.println(sum2);
		
		int sum3 = Number.subtration(5, 6);
		System.out.println(sum3);
		
		double sum4 = Number.division(6, 5);
		System.out.println(sum4);
	}

}

