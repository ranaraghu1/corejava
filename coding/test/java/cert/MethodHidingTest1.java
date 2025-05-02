package test.java.cert;
/*
 * This is overloading.We can't create object of 
 */
class ParentClass{
	public void m1(int i) {
		System.out.println("Normal method");
	}
}
class ChildClass extends ParentClass{
	public void m1(int... i) {
		System.out.println("Var arg method");
	}
}
public class MethodHidingTest1 {

	public static void main(String[] args) {
		ParentClass p1=new ParentClass();
		p1.m1(1);//parent class reference.Normal method.
		ParentClass p2=new ChildClass();
		p2.m1(1);//parent class reference.Normal method.
		ChildClass c1=new ChildClass();
		c1.m1(1);//Normal method.Because in child class both m1(int i) and  m1(int... i) available, So it call exact match.
		ChildClass c2=new ChildClass();
		c2.m1(1,2);//Var arg method.
	

	}

}
