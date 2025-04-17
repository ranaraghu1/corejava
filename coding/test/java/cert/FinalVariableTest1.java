package test.java.cert;

public class FinalVariableTest1 {
	final int x;
	
	FinalVariableTest1(){
		x=10;
	}

	public static void main(String[] args) {
		
		FinalVariableTest1 fTest=new FinalVariableTest1();
		System.out.println(fTest.x);
	}

}
