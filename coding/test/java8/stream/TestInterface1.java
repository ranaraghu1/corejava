package test.java8.stream;
 interface TestInterface{
	 default void show()
	    {
	        System.out.println("Default TestInterface");
	    } 
 }
public class TestInterface1 implements TestInterface {
	
	public void show()
    {
        System.out.println("Default TestInterface1");
    }
	
	public static void main(String[] args) {
		
		TestInterface test= new TestInterface1();
		test.show();
	}
}

