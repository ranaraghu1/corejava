package test.java.cert;
interface IntrfDefault{
	default void m1() {
		System.out.println("Default impl");
	}
}

class Impl implements IntrfDefault{
	public void m1() {
		System.out.println("Implementation");
	}
}
public class functionalIntrf{

	public static void main(String[] args) {
		
		IntrfDefault intrf=new Impl();
		intrf.m1();
	}

}
