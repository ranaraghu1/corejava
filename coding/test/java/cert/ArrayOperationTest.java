package test.java.cert;

public class ArrayOperationTest {

	public static void main(String[] args) {

		/*
		 *  array operation
		 */
		
		int[] arr=new int[5];
		//arr[5]=10; //java.lang.ArrayIndexOutOfBoundsException
		//arr[-2]=45; //java.lang.ArrayIndexOutOfBoundsException
		
		
		int j=3;
		double[] array=new double[3];
		for(int i=0;i>j;i++) {
			array[0]=i;
		}
		
		for(double val :array) {
			System.out.println(val);//0.0  0.0  0.0
			
		}
		
		int element=4;
		int[] annoArr=new int[] {element};
		for(int arrElement:annoArr) {
			System.out.println(arrElement);
		}
		

	}

}
