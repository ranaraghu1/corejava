import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringTest {
	
	int div(int a,int b) {
		int c=a/b;
		return c;
	}

	public static void main(String[] args) {
		StringTest stringTest=new StringTest();
		Scanner sc= new Scanner(System.in);
		int input1=sc.nextInt();
		int input2=sc.nextInt();
		int resutl=stringTest.div(input1, input2);
		System.out.println(resutl);
	}
}
