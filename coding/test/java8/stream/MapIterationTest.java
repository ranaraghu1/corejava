package test.java8.stream;

import java.util.Map;

public class MapIterationTest {

	public static void main(String[] args) {
		Map<String,Integer> items=Map.of("Apple", 100, "Banana", 80, "Cherry", 120);
		
		items.forEach((key, value) -> {
		    System.out.println( key + " " + value);
		});

	}

}
