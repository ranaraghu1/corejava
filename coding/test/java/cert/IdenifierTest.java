package test.java.cert;

import javax.annotation.processing.SupportedSourceVersion;

public class IdenifierTest {

	public static void main(String[] args) {
		//int int =10;// not possible
		int Int=20;// possible
		System.out.println(Int); 
		String string="";// Valid
		
		//pre-definded class name and interface name can be used identifier name
		String String=""; // Valid(Not recomended)
		int Runnable=105; //valid
		//int #count=10; // invalid
		int _count=10; //valid
		//class class=IdenifierTest.class;//invalid
		//int 1abc=10;  //Invalid
		
	
	
	}

}
