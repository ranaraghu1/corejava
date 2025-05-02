package test.java.cert;

public interface InterfaceMain {
	
	public static void main(String args[]) {
		System.out.println("Interface main method");
	}
	
	private static void m1() {
		System.out.println("In java 1.9v-private static method");
	}
	
	private void m2() {
		System.out.println("In java 1.9v-private instance method");
	}
}
