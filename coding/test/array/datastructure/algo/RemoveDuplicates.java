package test.array.datastructure.algo;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] a=new int[] {1,1,2,2,3,4,5};
		//int[] b=new int[] {1,2,1,3,1,4,5};
		
		//Arrays.sort(a);
		
		int size=a.length;
		int[] c=new int[size];
		int prev=a[0];
		c[0]=prev;
		for(int i=1;i<size;i++) {
			int ch=a[i];
			if(prev!=ch) {
				c[i]=ch;
			}
			prev=ch;
		}
   System.out.println( "New Array::"+Arrays.toString(c));//[1, 0, 0, 2, 3, 4, 5]
   
   
   
 //proper solution-find number of duplicate elements
   
 	int numberOfDuplicates=0;
 	int prevNum=a[0];
 	for(int i=1;i<a.length;i++) {
 		int ch=a[i];
 		if(prevNum==ch) {
 			numberOfDuplicates++;
 		}
 		prevNum=ch;
 	}
 	System.out.println("number of duplicates:"+numberOfDuplicates);
 	
 	
	int[] d=new int[a.length-numberOfDuplicates];
	int arrayIndex=0;
	int prevVal=a[0];
	d[0]=prevVal;
	for(int i=1;i<a.length;i++) {
		
		int ch=a[i];
		if(prevVal!=ch) {
			arrayIndex++;
			d[arrayIndex]=ch;
			
		}
		prevVal=ch;
	}
System.out.println( "New Array with 0 remove::"+Arrays.toString(d));//[1, 2, 3, 4, 5]

 	
 	
 	
	}

	
	
}
