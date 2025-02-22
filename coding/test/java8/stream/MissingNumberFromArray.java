package test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//boxed()- return type Stream<Integer>
public class MissingNumberFromArray {

	public static void main(String[] args) {
		int[] arr= {2,3,4,5};// output=1
		
		List<Integer> list=Arrays.stream(arr).filter(i->i>0).sorted().distinct().boxed().collect(Collectors.toList());
		int missingNum=IntStream.rangeClosed(1, list.size()+1).filter(i->list.contains(i)).findFirst().orElse(1);
		System.out.println("Missing number is::"+missingNum);

	}

}
