package test.java8.stream;


interface Drawable{
	public abstract void darw();
}

public class AnonymousClassTest {

	public static void main(String[] args) {

		Drawable drawable= new Drawable(){
			public void darw() {
				System.out.println("Anonymous: Drawing");
				
			}

		};
		drawable.darw();
		
		Drawable d2=()->{
			    System.out.println("Lambda expression");
				System.out.println("Drawing");
		};
		d2.darw();
		
		Drawable d3=()->System.out.println("Lambda expression: Drawing");//single statement {}not required
		d3.darw();
	

	}

}
