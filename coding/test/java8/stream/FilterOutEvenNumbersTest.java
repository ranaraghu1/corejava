package test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOutEvenNumbersTest {

	public static void main(String[] args) {
		List<Integer> nums=Arrays.asList(4,3,8,10,25);
		List<Integer> oddNums=nums.stream().filter(a->a%2!=0).collect(Collectors.toList());
		System.out.println(oddNums);

	}

}
