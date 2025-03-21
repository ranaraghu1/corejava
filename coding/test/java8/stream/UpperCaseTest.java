package test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseTest {
	public static void main(String args[]) {
		
		List<String> names=Arrays.asList("Alice","Bob","Charlie");
		List<String> namesUpperCase =names.stream().map(a->a.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(namesUpperCase);
	}
	

}
