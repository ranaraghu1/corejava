package test.java.cert;

public class SuperKeyWordTest {

	{
		System.out.println(this.hashCode());//1554547125,This calls super class hahCode,Object class.
	}
	
	{
		System.out.println(this.hashCode());//1554547125,This calls current class hashCode,as we are not writing any hashCode here, it is overridden from Object class. 
	}
	
	public static void main(String[] args) {
	 SuperKeyWordTest superKeyWordTest=new SuperKeyWordTest();
     System.out.println("In main");

	}

}
