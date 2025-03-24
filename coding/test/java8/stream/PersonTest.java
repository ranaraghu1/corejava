package test.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class PersonTest {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 35));

		List<String> peoplOrderingByAge = people.stream().sorted(Comparator.comparingInt(Person::getAge))
				.map(a -> a.getName()).collect(Collectors.toList());
		System.out.println(peoplOrderingByAge);

	}

}
