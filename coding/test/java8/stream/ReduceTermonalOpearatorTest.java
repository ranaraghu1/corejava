package test.java8.stream;

import java.util.Arrays;

public class ReduceTermonalOpearatorTest {

	public static void main(String[] args) {
		int[] list= {10,20,30};
		int sum=Arrays.stream(list).reduce(0,(x,y)->x+y);
		System.out.println(sum);
		
		//multiply each element by 2
		Arrays.stream(list).map(a->a*2).forEach(a->System.out.println(a));
		

	}

}