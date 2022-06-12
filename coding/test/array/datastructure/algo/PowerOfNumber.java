package test.array.datastructure.algo;

public class PowerOfNumber {

	public static void powerOfNumber(int base,int exponent) {
		int result=1;
		for(int i=exponent;i!=0;i--) {
			result=result*base;
		}
	    
		System.out.println(base+" exponent "+exponent+":"+result);
		
	}
	    public static void main(String args[]){
	    	PowerOfNumber.powerOfNumber(2,5);
	    	
	    }

	}




