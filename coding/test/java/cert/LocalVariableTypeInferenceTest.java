package test.java.cert;

import java.util.ArrayList;

public class LocalVariableTypeInferenceTest {

	public static void main(String[] args) {
		var array=new int[] {10,20,30};
		//var array1=new Integer[] {10,20,30}; //valid
		for(int element:array) {
			System.out.println(element);
			
		}
		
		var str="raghu";
		System.out.println(str.length());
		
		var list=new ArrayList<Integer>();
		list.add(234);
		System.out.println(list.size());
		var var=10;//valid
		System.out.println(var);
		
		int _x=10;
		System.out.println(_x);
		int __x=100;
		System.out.println(__x);
		
		System.out.println(10.0/0);//Infinity
		//System.out.println(0/0);//ArithmeticException
		//System.out.println(10/0);  //ArithmeticException
		System.out.println(0.0/0); //NaN
		System.out.println(10+'a'); //107
		System.out.println(10.0+'a');//107.0
		

	}

}

