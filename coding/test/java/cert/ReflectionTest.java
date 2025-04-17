package test.java.cert;

import java.lang.reflect.Method;

public class ReflectionTest {
	public void m1() {
		System.out.println("m1");
	}
	
	public void m2() {
		System.out.println("m2");
	}

	public static void main(String[] args) {
		Method[] methods=ReflectionTest.class.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method.getName());//main,m1,m2
		}

	}

}
