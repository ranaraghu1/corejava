package test.java.cert;

public class ConstructorOverLoadingTest {
	
	ConstructorOverLoadingTest(double d){
		this(10);
		System.out.println("double-arg");
	}
	ConstructorOverLoadingTest(int i){
		this();
		System.out.println("int-arg");
	}
	ConstructorOverLoadingTest(){
		System.out.println("no-arg");
	}

	public static void main(String[] args) {
		ConstructorOverLoadingTest consOverLoadingTest=new ConstructorOverLoadingTest(10.5);

		/*
		 * no-arg int-arg double-arg.
		 */
		
	}

}
