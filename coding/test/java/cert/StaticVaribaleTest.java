package test.java.cert;

public class StaticVaribaleTest {
	
	static int result=100;
	public static int calculate() {
		for(int i=0;i<3;i++) {
			result+=i;
		}
		return result;
	}

	public static void main(String[] args) {
		int result=calculate();
		calculate();
		result=calculate();
		System.out.println(result);//109

	}

}
