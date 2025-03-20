package test.array.datastructure.algo;

import java.util.Arrays;

public class TwoArraysAreEqualOrNot {

	public static void main(String[] args) {
		int[] a= {1,3,6,5};
		int[] b= {3,1,5,6};
		
		boolean areEqual=false;
		
		if(a.length!=b.length) {
			areEqual=false;
		}
			
		if(Arrays.equals(Arrays.stream(a).sorted().toArray(), Arrays.stream(b).sorted().toArray())) {
			areEqual=true;	
		}
		
		System.out.println(areEqual);
		
	}

}
