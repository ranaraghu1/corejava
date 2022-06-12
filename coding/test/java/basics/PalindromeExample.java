package test.java.basics;
import java.util.stream.IntStream;

public class PalindromeExample {
	
	public static  boolean  intPalidrum(int number) {
		 return number == IntStream.iterate(number, i -> i / 10)
			        .map(n -> n % 10)
			        .limit(String.valueOf(number).length())
			        .reduce(0, (a, b) -> a = a * 10 + b);
	}
	
	public static  boolean  stringPalidrum(String original) {
		
		String temp=original.replaceAll("\\s+", "");
		 
		 return IntStream.range(0, temp.length() / 2) .noneMatch(i -> temp.charAt(i)
		 != temp.charAt(temp.length() - i - 1));
	}

	public static void main(String[] args) {
		 String s="  a ssa ";
		 int number=12321;
		boolean isPalindrum= PalindromeExample.intPalidrum(number);
		if(isPalindrum)
		 System.out.println(number+" is palindrum");
		else
		 System.out.println(number+" is not palindrum");
		
		boolean isPalindrumString= PalindromeExample.stringPalidrum(s);
	
		if(isPalindrumString)
			 System.out.println(s+" is palindrum");
			else
			 System.out.println(s+" is not palindrum");
	}

}
