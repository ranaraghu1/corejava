package test.java.cert;

class Test1 implements Cloneable{
	
}

public class CloneTest implements Cloneable{

	public static void main(String[] args) throws CloneNotSupportedException {
		Test1 a= new Test1();
		//a.clone();//Not visible from Object class as clone method is protected.
		
		CloneTest cloneTest=new CloneTest();
		CloneTest cloneTes1=(CloneTest)cloneTest.clone();
		System.out.println(cloneTes1.getClass());

	}

}
