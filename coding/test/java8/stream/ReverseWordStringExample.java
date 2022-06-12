package test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWordStringExample {
	private static final Pattern pattern = Pattern.compile(" +");


	public static void main(String[] args) {
		String sentence="Java is a robust language";
		Stream<String> stream = pattern.splitAsStream(sentence);
		String output=stream.map(word-> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
	
		System.out.println(output);

		
		
	}

}
