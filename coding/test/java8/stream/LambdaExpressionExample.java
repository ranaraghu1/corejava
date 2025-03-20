package test.java8.stream;

@FunctionalInterface // optional
interface LambdaInterfaceTest {
	int add(int a, int b);

}

public class LambdaExpressionExample {
	public static void main(String args[]) {
		// with return keyword
		LambdaInterfaceTest lmb = (a, b) -> {
			return (a + b);

		};// return statement means {} required.
		System.out.println(lmb.add(10, 20));

       //without return
		LambdaInterfaceTest lmb1 = (a, b) -> (a + b); //{} not required, no return statement. 
		System.out.println(lmb1.add(50, 20));

	}

}
