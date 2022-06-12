package test.java.basics;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		//{34,56,78,54,32} 
		
		//78,56,54,34,32
		
		//: 78 32 56 34 54
		Integer[] arr=new Integer[]{34,56,78,54,32};
		Integer[] arr1= new Integer[5];
		int temp;
		int max=0;
		int min=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]<arr[i+1]) {
				temp=arr[i+1];
				arr1[i+1]=arr[i];
				arr[i+1]=arr[i];
				arr[i]=temp;
				arr1[i]=temp;
				
			}
			else {
				i=i+1;
			}
		}
		
		for(int i=0;i<arr1.length-1;i++) {
			max=arr1[arr1.length-1];
			min=arr1[i];
		}
		System.out.println(max+" "+min);	
	}

	

}
