package test.java.cert;

public class ForEachLoopTest {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("-------------");
		for(int a:arr) {//Not possible to print in reverse order.
			System.out.println(a);
		}
		
		System.out.println("-------------");
		for(int i=arr.length-1;i>=0;i--) {
			System.out.println(arr[i]);
		}
		

	}

}
