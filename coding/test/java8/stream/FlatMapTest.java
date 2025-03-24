package test.java8.stream;

import java.util.Arrays;
import java.util.List;

//Flattering purpose/Unpacking
public class FlatMapTest {

	public static void main(String[] args) {

      List<List<Integer>> list=Arrays.asList(Arrays.asList(2,4,5,10,45,2,6,8,99),Arrays.asList(7,8,9,5,8,9,9));
      
 
      list.parallelStream().flatMap(a->a.stream()).forEach(a->System.out.println(a));
      
      System.out.println("ParallelStream::::::::");
      list.parallelStream().flatMap(a->a.parallelStream()).forEach(a->System.out.println(a));

	}

}
