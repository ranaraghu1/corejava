package test.java8.stream;
import java.util.Arrays;

public class ParallelArraySortingExample {

	public static void main(String args[]) {
		 int[] arr = {5,2,1,0,-3};  
		 int[] arr1 = {5,2,1,0,-3};    
		 Arrays.parallelSort(arr);
		 for(int i:arr) {
			 System.out.println(i);
		 }
		 System.out.println("Sorting with index");
		 Arrays.parallelSort(arr1, 0, 3);
		 for(int i:arr1) {
			 System.out.println(i);
		 }
	}
}
