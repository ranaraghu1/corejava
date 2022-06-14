package test.array.datastructure.algo;

import java.util.Arrays;

public class LargestSmallestNumber {

	
	public static void main(String[] args) {
		int[] a=new int[] {1,1,2,2,3,4,5};
		//int[] a=new int[] {5,6660,1,2,2,3,4,5};
		int largest = Integer.MIN_VALUE; 
		int smallest = Integer.MAX_VALUE;
		System.out.println("Largest number in array is : " + largest); 
		System.out.println("Smallest number in array is : " + smallest);
		
		for (int number : a) {
			if (number > largest) { 
				//System.out.println("if block"); 
				largest = number;
			} else if (number < smallest) {
				//System.out.println("else if block"); 
				smallest = number; 
				}
		 }
		System.out.println("Given integer array : " + Arrays.toString(a)); 
		System.out.println("Largest number in array is : " + largest); 
		System.out.println("Smallest number in array is : " + smallest);

		}

}
