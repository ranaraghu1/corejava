package test.java.cert;

public class GenaricClassTest<T> {
	
	public <T> T m1(T ob) {
		 return (T) "Welcome!!!";	
		
	}

	public static void main(String[] args) {
		GenaricClassTest genClassTest=new GenaricClassTest();
		 String result = (String) genClassTest.m1("Hello");
		 System.out.println(result);
	}

}
