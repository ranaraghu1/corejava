package test.java.cert;

public class ForLoopTest {

	public static void main(String[] args) {
		int i = 0;
		for (System.out.println("Hello"); i < 3; i++) {
			System.out.println("Hi");
		}
		
		
		
		for (System.out.println("Hello"); ; i++) {
			System.out.println("Hi"); // Hello Hi Hi Hi..............
		}

	}

}
