package test.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AssignmentsTest {

	public static void main(String[] args) {
		Random random=new Random();
		List<Integer> list=new ArrayList<>();
		 int min=1;int max=1000;
		IntStream.range(0, 50)
				.forEach(a->{
					if(list.size()<50) {
						list.add(random.nextInt(max - min));
					}
					
				});
		
		System.out.println("list Size::"+list.size());
		list.stream().forEach(a->System.out.println(a));
		
		List<Integer> primeNumber=list.stream().filter(a->a%2!=0 || a==2).collect(Collectors.toList());
		System.out.println("Prime Number::"+primeNumber);
		
		//Sum of all even number
		int sumOfEvenNums=list.stream().filter(a->a%2==0).reduce(0,(x,y)->x+y);
		System.out.println("Sum of even Number:"+sumOfEvenNums);
		
		//find 5 largest number
		List<Integer> largestelement=list.stream().sorted(Comparator.reverseOrder()).limit(5).toList();
		System.out.println(largestelement);
		
		//Find smallest number greater than 500
		List<Integer> smallestElementGreaterThan500=list.stream().filter(a->a>500).sorted().limit(1).toList();
		System.out.println(smallestElementGreaterThan500);
		  
	       

	}

}
