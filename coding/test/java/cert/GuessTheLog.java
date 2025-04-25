package test.java.cert;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
public class GuessTheLog {

	public static void main(String[] args) {
		 Animal animal = new Dog("Dog");
	        Dog dog = new Animal("Generic Animal");
	        System.out.println("Animal name: " + animal.getName());
	        animal.makeSound();//Generaic animal sound
	        System.out.println("Animal name: " + dog.getName());
	        dog.makeSound();//error

	}
}
