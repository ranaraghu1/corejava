package test.array.datastructure.algo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharactersInString {
	
	public static void main(String args[]) {
		String str="raghunath";
		Map<Character,Long> map=str.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(e->e,Collectors.counting()));
		List<Character> charList=map.entrySet().stream().filter(a->a.getValue()>1).map(e->e.getKey()).toList();
			
		charList.forEach(e->System.out.println("Duplicate characters  "+e));
		
	}

}


