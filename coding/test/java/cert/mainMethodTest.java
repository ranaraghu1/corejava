package test.java.cert;

public class mainMethodTest {

	public static void main(String[] args) {
		System.out.println("In main----");
		main(new String[] {"abc","def"});//This call main method over and over. StackOverflowError will happens.

	}

}
