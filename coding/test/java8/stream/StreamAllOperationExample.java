package test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAllOperationExample {

	public static void main(String[] args) {
		List<String> listA=Arrays.asList("a","d","z","p");
		
		List<String> listB=listA.parallelStream().sorted((String a, String b)->b.compareTo(a)). collect(Collectors.toList());
		listB.stream().forEach(System.out::println);

	}

}
