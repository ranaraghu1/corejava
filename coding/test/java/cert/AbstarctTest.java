package test.java.cert;

public abstract class AbstarctTest {
	
	public abstract void m1() ;	
	
	public static void main(String[] args) {
		System.out.println("Parenet class");
		AbstarctTest abstarctTest=new Child2();
		abstarctTest.m1();
		
	}

}

abstract class Child extends AbstarctTest{
	
}

class Child2 extends Child{

	@Override
	public void m1() {
		System.out.println("m1 implementation");
		
	}
	
	
	
}
