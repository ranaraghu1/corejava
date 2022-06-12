package test.java8.stream;
interface LambdaExpressionTest2{
	public void draw(String colors);
}
public class LambdaExpressionExampleOneParameter {
	public static void main(String args[]) {
		LambdaExpressionTest2 lmbd=(colors)->{
			System.out.println("Draw a colors:"+colors);
		};
		lmbd.draw("Red");
		
		//Omit the functional parenthesis
		LambdaExpressionTest2 lmbd1=colors->{
			System.out.println("Draw a colors:"+colors);
		};
		lmbd1.draw("Blue");
		
		
		//{};is not mandatoty
		LambdaExpressionTest2 lmbd2=changeColor->
					System.out.println("Draw a colors:"+changeColor);
				
				lmbd2.draw("Yellow");
		
	}
	
	
}
