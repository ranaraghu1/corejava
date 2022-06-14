package test.array.datastructure.algo;

public class ArrayZeroAppendFirstExample {
	static void moveZerosToEnd(int arr[], int n) {
	      
	    int count =0;
	    for (int i = 0; i < n; i++)
	        if (arr[i] != 0)
	        	arr[count++]=arr[i];
	  
	     
	    // Update all elements at index >=count with value 0
	    for (int i = count; i<n;i++)
	        arr[i]=0;
	}
	
	static void moveZerosToFirst(int arr[], int n) {
	      
	    int count =n-1;
	    for (int i = n-1; i>= 0; i--)
	        if (arr[i] != 0)
	        	arr[count--]=arr[i];
	  
	     
	    // Update all elements at index >=count with value 0
	    for (int i = count; count<0;i--)
	        arr[i]=0;
	    
	}
	
	// function to print the array elements
	static void printArray(int arr[], int n) {
	    for (int i = 0; i < n; i++)
	    System.out.print(arr[i] + " ");
	}
	
	public static void main(String args[]) {
	    int arr[] = {0, 1, 9, 8, 4, 0, 0, 2};
	    int arr1[] = {0, 1, 9, 8, 4, 0, 0, 2};
	    int n = arr.length;
	  
	    System.out.print("Original array: ");
	    printArray(arr, n);
	  
	    moveZerosToEnd(arr, n);
	  
	    System.out.print("\nModified array: ");
	    printArray(arr, n);
	    
	    moveZerosToFirst(arr1, n);
	    System.out.print("\n");
	    printArray(arr1, n);
	    
	}
}
