package test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonElelmentsFromTwoList {
	public static void main(String rags[]) {
		List<Integer> list1=Arrays.asList(2,3,6,8);
		List<Integer> list2=Arrays.asList(2,8,0,1);//2,8
		
		list1.stream().filter(list2::contains).collect(Collectors.toList()).forEach(a->{
			System.out.println(a);
		});
		
		int[] arr1= {2,3,6,8};
		int[] arr2= {2,8,0,1};
		List<Integer> list3=Arrays.stream(arr1).boxed().collect(Collectors.toList());
		List<Integer> list4=Arrays.stream(arr2).boxed().collect(Collectors.toList());
		
		list3.stream().filter(list4::contains).collect(Collectors.toList()).forEach(a->{
			System.out.println(a);
		});
	}

}
