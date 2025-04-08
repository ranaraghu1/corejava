package test.java.cert;

public class LocalVariableTest {

	final static synchronized strictfp public void main(String... args) {
		System.out.println("Inside main");

	}
	
	public void m1() {
		int x=10;
		final int y=20;
		//public z=30;// not vlid- Local variable can't be public protected private
		//private int z=20;// invalid
		//protected int z=20;// invalid
		
	}

}
