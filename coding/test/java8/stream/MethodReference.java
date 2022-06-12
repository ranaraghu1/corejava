package test.java8.stream;

import java.util.Optional;

@FunctionalInterface// optional
 interface FunctionalInterfaceMethodRef {
	void add(int a,int b);

}
public class MethodReference {
	public static void addMore(int a, int b) {
		int total=a+b;
		System.out.println("Add more Items:"+total);
	}

	public static void main(String[] args) {
		FunctionalInterfaceMethodRef  add=MethodReference::addMore;
		add.add(8,10);
		
		//Optional class- used to deal with NPE.
		String s = null;
		Optional<String> checkNull=Optional.ofNullable(s);
		if(checkNull.isPresent()) 
			System.out.println("Null is not there");
		
		else
			System.out.println("s has no elements present");
		
	}
}
