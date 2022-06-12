package test.java8.stream;
interface LambdaExpression{
	public void draw(String colors);
}
public class LambdaExpressionExampleNoParameter {
	public static void main(String args[]) {
		LambdaExpression lmbd=(colors)->{
			System.out.println("Draw a colors:"+colors);
		};
		lmbd.draw("Red");
		
		//Omit the functional parenthesis
		LambdaExpression lmbd1=colors->{
			System.out.println("Draw a colors:"+colors);
		};
		lmbd1.draw("Blue");
		
		
		//{};is not mandatoty
				LambdaExpression lmbd2=changeColor->
					System.out.println("Draw a colors:"+changeColor);
				
				lmbd2.draw("Yellow");
		
	}
	
	
}
