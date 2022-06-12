package test.java8.stream;
import java.util.stream.Stream;

public class IterateNtimes {
	public static void main(String args[]) {
		Stream.iterate(1,element-> element+1)
		.filter(element->element%2==0)
		.limit(4)
		.forEach(System.out::println);
		
	}

}
