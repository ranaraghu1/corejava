package test.java.cert;

public class FinalVariableTest {

	//final int x=10;
	final int x;
	{
	x=10;	
	}
	
	public static void main(String[] args) {
		FinalVariableTest fTest=new FinalVariableTest();
		System.out.println(fTest.x);

	}

}
