package test.array.datastructure.algo;

import java.util.HashSet;
import java.util.Set;

//print pair whose sum is 7.
public class PrintPairSum {

	public static void main(String[] args) {
		//this is complexity o(n*2)
		int a[]=new int[]{2,4,3,5,6,-2,4,7,8,9};
		for(int i=0;i<a.length;i++) {
			 int first=a[i];
			for(int j=i+1;j<a.length;j++) {
				int second=a[j];
				if((first+second)==7) {
					System.out.println(first+"  "+second);
				}
				
			}
		}
		
		
	//Using Hashtable/hashSet- add and contains is o(N)
		
		int sum=7;
		Set<Integer> set=new HashSet<>(a.length);
		 if(a.length < 2){
	            return;
	        }  
		
		for(int value:a) {
			int target=sum-value;
			if(!set.contains(target)) {
				set.add(target);
			}
			else {
				System.out.println("Set operation--"+value+" "+target);
			}
		}
System.out.println(set.toString());
	}

}
