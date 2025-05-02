package test.java.cert;

 class ParentTest {

	public static void main(String[] args) {
		System.out.println("Parent main");

	}
	
	public class Test1 extends Parent{
		public static void main(String[] args) {
			System.out.println("Child main");

		}
	}

}
