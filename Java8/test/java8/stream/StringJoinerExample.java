package test.java8.stream;
import java.util.StringJoiner; 
public class StringJoinerExample {
public static void main(String args[]) {
	StringJoiner joinName=new StringJoiner(",");
	joinName.add("raghu");
	joinName.add("Raju");
	joinName.add("Saanvi");
	System.out.println(joinName);
	
	
}
}
