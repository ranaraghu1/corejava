package test.java.basics;

public class AutoboxingAndUnboxing {
	public static void m1(Integer a,Integer b) {
		System.out.println("Integer:"+(a+b));
	}

	
	public static void m1(long a,long b) {
		System.out.println("Long:"+(a+b));
	}
	
	public static void main(String[] args) {
		short a=2,b=5;
		AutoboxingAndUnboxing.m1(a, b);//promotion-  Long:7
		
		int c=5,d=6;
		AutoboxingAndUnboxing.m1(c, d);//promotion-  Long:11
		
		
		Integer e=5,f=7;
		AutoboxingAndUnboxing.m1(e, f);//Integer:12
		

	}

}
