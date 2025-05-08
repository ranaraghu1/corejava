package test.java.cert;

class ParentClass1{
	public void m1(int... a) {
		System.out.println("Parent class");
	}
}
class ChildClass1 extends ParentClass1{
	public void m1(int... a) {
		System.out.println("Child class");
	}
}

public class MethodHidingTest2 {
	public static void main(String args[]) {
	ParentClass1 p1=new ChildClass1();
	p1.m1(1,2);

	}
}
