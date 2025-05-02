package test.java.cert;

public class OverloadingGuess {
	
	public void m1(Object obj) {
		System.out.println("Object version");
	}
	public void m1(String ster) {
		System.out.println("String version");
		
	}

	public static void main(String[] args) {
		OverloadingGuess test=new OverloadingGuess();
		test.m1(null);

	}

}
