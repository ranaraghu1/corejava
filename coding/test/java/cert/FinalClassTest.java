package test.java.cert;
final class ABC{
	
	final void m1() {
		System.out.println("In A class");
	}
	
}
public class FinalClassTest{

	public static void main(String[] args) {
		System.out.println(ABC.class.getName());
	}

}
