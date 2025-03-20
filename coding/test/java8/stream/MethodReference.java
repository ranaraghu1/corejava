package test.java8.stream;

import java.util.Optional;

@FunctionalInterface// optional
 interface FunctionalInterfaceMethodRef {
	void add(int a,int b);

}
public class MethodReference {
	public static void add(int a, int b) {
		int total=a+b;
		System.out.println("Add more Items:"+total);
	}

	public static void main(String[] args) {
		FunctionalInterfaceMethodRef  add=MethodReference::add;
		add.add(8,10);
		
		//Optional class- used to deal with NPE.
		String s = null;
		Optional<String> checkIfNull=Optional.ofNullable(s);
		if(checkIfNull.isPresent()) 
			System.out.println("Elements are present");
		
		else
			System.out.println("No element present");
		
	}
}
