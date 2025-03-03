package test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PushAllZeroToEndOfArray {

	public static void main(String[] args) {
		
	int[] arr= {2,3,0,7,8,0,3};
	IntStream arrNonZeros=Arrays.stream(arr).filter(i->i!=0).sorted();
	long count =Arrays.stream(arr).filter(a->a==0).count();
	IntStream arrZeros=Arrays.stream(new int[(int) count]);
    List<Integer> output=IntStream.concat(arrNonZeros,arrZeros).boxed().collect(Collectors.toList());
    System.out.println(output);
   

	}

}
