package test.array.datastructure.algo;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWordsInStringTest {

	public static void main(String[] args) {
		String sentence="java is a robust language";
		
		Pattern pattern=Pattern.compile(" +");
		Stream<String> list= pattern.splitAsStream(sentence.trim());
				
		String outputString=list.map(word->new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
		
		System.out.println(outputString);

	}

}
