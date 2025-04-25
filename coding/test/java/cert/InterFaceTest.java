package test.java.cert;

interface Intrf{
		void m1();
		
}

class ServiceProvider implements Intrf{

	public void m1() {
		System.out.println("In m1");
		
	}
	
}
public class InterFaceTest {

	public static void main(String[] args) {
		System.out.println("In main");

	}

}
