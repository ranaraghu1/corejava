package test.java.cert;
interface Intrf2{
	public static void m3() {
		System.out.println("Inside interface");
	}
}

class Test2 implements Intrf2{
	public static void m3() {
		System.out.println("Inside Test class");
	}
}

public class functionalIntrf1 {

	public static void main(String[] args) {
		Intrf2 intrf= new Test2();
		//intrf.m3(); // Invalid. This is not overriding or method hiding. This is treated as simple method of interface and class
		Intrf2.m3();
		Test2.m3();
		


	}

}
