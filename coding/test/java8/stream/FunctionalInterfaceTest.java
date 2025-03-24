package test.java8.stream;
 interface TestInterface{
	 default void show()
	    {
	        System.out.println("Default TestInterface");
	    } 
 }
public class FunctionalInterfaceTest implements TestInterface {
	
	public void show()
    {
        System.out.println("Default TestInterface1");
    }
	
	public static void main(String[] args) {
		
		TestInterface test= new FunctionalInterfaceTest();
		test.show();
	}
}

