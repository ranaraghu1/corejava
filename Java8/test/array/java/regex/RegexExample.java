package test.array.java.regex;

import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {
		System.out.println(Pattern.matches(".s", "ast"));//false- more than 3 characters
		System.out.println(Pattern.matches(".s", "as"));// true- 2nd ch. is s.
		System.out.println(Pattern.matches(".s", "asas"));// false
		
		
		//Metacharacters
		System.out.println("Metacharacters");
		System.out.println(Pattern.matches("\\d", "1"));//true
		System.out.println(Pattern.matches("\\d", "123"));//false- comes more than 1
		System.out.println(Pattern.matches("\\d", "a"));//false
		
		System.out.println(Pattern.matches("[a-zA-Z0-9]{4}", "Ragu"));//true
		System.out.println(Pattern.matches("[a-zA-Z0-9]{4}", "ragu"));//true
		System.out.println(Pattern.matches("[a-zA-Z0-9]{4}", "Rag1"));//true
		System.out.println(Pattern.matches("[a-zA-Z0-9]{4}", "Rag$"));//false -$ is not match
		
		//starting with 7 or 8 or 9 and [0-9]9 digits=10 digits- [789]{1}[0-9]{9} or [789]{1}\\d{9}
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true  
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "5953038949"));//false- start with 5.
		
		System.out.println(Pattern.matches("[789]{1}\\d{9}", "9953038949"));//true  
		
		
		
		
		
	}

}
