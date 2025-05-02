package test.java.cert;
class P{
	public static void m1() {
		System.out.println("Parent class");
	}
}
class C extends P{
	public static void m1() {
		System.out.println("Child class");
	}
}
public class MethodHidingTest {

	public static void main(String[] args) {
		P p=new P();
		p.m1();//Parent class,because parent class reference is here.
		P p1=new C();
		p1.m1();//Parent class,because parent class reference.
		C c1=new C();
		c1.m1();//child class
		
	}

}
