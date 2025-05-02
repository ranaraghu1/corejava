package test.java.cert;
class Parent{
	protected void m1() {
		System.out.println("In Parent");
	}
}

class Child1 extends Parent{
	public void m1() {
		System.out.println("In Child");
	}
	
}
public class OveriddingTest {

	public static void main(String[] args) {
		Parent p=new Child1();
		p.m1();

	}

}
