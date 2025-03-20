package test.array.datastructure.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindNthLargestNumberFromArray {

	public static void main(String[] args) {
		int[] arr= {4,8,1,3};//find second highest wil be 4.
		
		List<Integer> list=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		int a=list.get(1);//n-1
		System.out.println(a);
		
	}

}
