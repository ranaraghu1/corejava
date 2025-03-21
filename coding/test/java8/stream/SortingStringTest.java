package test.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingStringTest {

	public static void main(String[] args) {
		List<String> strings=Arrays.asList("apple","banana","cherry","date");
		List<String> outputString=strings.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList());
		
		System.out.println(outputString);

	}

}
