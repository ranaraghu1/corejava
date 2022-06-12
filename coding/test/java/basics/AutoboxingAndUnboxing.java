package test.java.basics;

public class AutoboxingAndUnboxing {
	public static void m1(Integer a,Integer b) {
		System.out.println(a+b);
	}

	
	public static void m1(long a,long b) {
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {
		short a=2,b=5;
		AutoboxingAndUnboxing.m1(a, b);

	}

}
