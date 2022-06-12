package test.array.datastructure.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class StringReverse{
	public String reverseWord(String sentence) {
		List< String> words = Arrays.asList(sentence.split("\\s"));

		StringBuilder sb = new StringBuilder(sentence.length()); 
		for (int i = words.size() - 1; i >= 0; i--) {
			sb.append(words.get(i));
			sb.append(' ');
			} 
		return sb.toString().trim();

		
	}
	
	public String StringCollectionsReverse(String sentence){
	
       List< String> words = Arrays.asList(sentence.split("\\s"));
			Collections.reverse(words);
			StringBuilder sb = new StringBuilder(sentence.length()); 
			for (int i = 0;i<words.size();i++) {
				sb.append(words.get(i));
				sb.append(' ');
				} 
			return sb.toString().trim();
		}
			
		
	
	public  String reverseString(String line) { 
		if (line.trim().isEmpty()) {
			return line; 
			} 
		StringBuilder reverse = new StringBuilder();
		String[] sa = line.trim().split("\\s"); 
	
		for (int i = sa.length - 1; i >= 0; i--) {
			reverse.append(sa[i]); 
			reverse.append(' '); 
			}
		return reverse.toString().trim();
		}


}
public class ReverseSentenceWord {

	public static void main(String[] args) {
		String sentence="String is an immutable";
		StringReverse srev= new StringReverse();
		System.out.println(srev.reverseWord(sentence));
		System.out.println(srev.reverseString(sentence));
		System.out.println(srev.StringCollectionsReverse(sentence));

	}

}
