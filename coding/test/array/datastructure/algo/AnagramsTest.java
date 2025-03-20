package test.array.datastructure.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Both String length is equal and same content.
class Anagram{
	
	public static boolean isAnagrams(String s1,String s2) {
		boolean isAnagrams=false;
		if(s1.length()==s2.length()) { 
	        //s1.chars()=IntStream,integer value of each character 
	    	 String sortedString1=s1.chars().sorted().mapToObj(i->(char)i).map(String::valueOf).collect(Collectors.joining());
	    	 String sortedString2=s1.chars().sorted().mapToObj(i->(char)i).map(String::valueOf).collect(Collectors.joining());
	    	if(sortedString1.equals(sortedString2)) {
	    		isAnagrams=true;
	    	}
		}
	    	
		 return isAnagrams;
	}
	
	
}

public class AnagramsTest {
	public static void main(String arags[]) {
	String s1="listen";
	String s2="silent";
	boolean b=Anagram.isAnagrams( s1, s2);
	System.out.println("is Anagrams::"+b);
	}

}
