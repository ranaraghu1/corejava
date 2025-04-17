package test.java.cert;

public class FinalStaticTest {
	final static int x;
	static {
		x = 10;
	}

	public static void main(String[] args) {
		FinalStaticTest fTest=new FinalStaticTest();
		//System.out.println(fTest.x);

	}

}
