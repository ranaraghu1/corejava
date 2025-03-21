package test.java8.stream;

@FunctionalInterface
interface Calculator{
	
	public abstract int calculate(int a, int b);
	
}
public class ClaculateTest {

	public static void main(String[] args) {
		Calculator add=(a,b)-> {
			return a+b;
		};
		
		System.out.println("Addition of 10,5= "+add.calculate(10,5));
		
		Calculator substarct=(a,b)-> {
			return a-b;
		};
		
		System.out.println("Substarction of 10,5= "+substarct.calculate(10,5));
		
		Calculator multiply=(a,b)-> {
			return a*b;
		};
		
		System.out.println("Multiplication of 10,5= "+multiply.calculate(10,5));
		
		
		Calculator divide=(a,b)-> {
			return a/b;
		};
		
		System.out.println("Division of 10,5= "+divide.calculate(10,5));
		

	}

}
