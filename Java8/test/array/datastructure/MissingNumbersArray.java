package test.array.datastructure;

import java.util.Arrays;
import java.util.BitSet;

//Missing numbers from 1 to 10.
public class MissingNumbersArray {

	public static void main(String[] args) {
		//Find single missing number
		int[] a =new int[] {1,2,3,4,5,6,7,9,10};
		int sumOfAll = (10*(10+1))/2;
	      int sumOfArray = 0;
	      for(int i=0; i<=10-2; i++) {
	         sumOfArray = sumOfArray+a[i];
	      }
	      int missingNumber = sumOfAll-sumOfArray;
	      System.out.println("Missing number is: "+missingNumber);
		
       //Multiple Numbers 
	    int[] b =new int[] {1,2,4,5,6,7,9,10};
	  	int count=10;
	  	int missingCount = count - b.length; 
	  	BitSet bitSet = new BitSet(count); 
	  	for (int number : b) { 
	  		bitSet.set(number - 1);
	  		} 
	  	 int lastMissingIndex =0; 
	  	for (int i = 0; i < missingCount; i++) { 
	  		lastMissingIndex = bitSet.nextClearBit(lastMissingIndex); 
	  		System.out.println(++lastMissingIndex);
	  		}

 }
			  

	
}
