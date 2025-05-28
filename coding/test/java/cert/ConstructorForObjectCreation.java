package test.java.cert;

public class ConstructorForObjectCreation {
	private String name;
	private int id;


	public ConstructorForObjectCreation() {
		super();
	}
	
	public ConstructorForObjectCreation(String name) {
		super();
		this.name = name;
	}

	public ConstructorForObjectCreation(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

    static int count;
	{
		count++;
	}

	public static void main(String[] args) {
		ConstructorForObjectCreation obj1=new ConstructorForObjectCreation();
		ConstructorForObjectCreation obj2=new ConstructorForObjectCreation("Ragbhunath");
		ConstructorForObjectCreation obj3=new ConstructorForObjectCreation("Rana", 1);
		System.out.println("Number of object creation:"+count);
		
		

	}

}
