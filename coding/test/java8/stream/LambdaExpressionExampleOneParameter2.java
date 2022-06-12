package test.java8.stream;
interface LambdaExpressionTest{
	public void draw(String colors);
}
public class LambdaExpressionExampleOneParameter2 {
	public static void main(String args[]) {
		LambdaExpressionTest lmbd=(colors)->{
			System.out.println("Draw a colors:"+colors);
		};
		lmbd.draw("Red");
		
		//Omit the functional parenthesis
		LambdaExpressionTest lmbd1=colors->{
			System.out.println("Draw a colors:"+colors);
		};
		lmbd1.draw("Blue");
		
		
		//{};is not mandatoty
				LambdaExpressionTest lmbd2=changeColor->
					System.out.println("Draw a colors:"+changeColor);
				
				lmbd2.draw("Yellow");
		
	}
	
	
}
