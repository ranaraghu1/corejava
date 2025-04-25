package test.java.cert;
interface A{
	
}

class B{
	
}

public class InstanceofTest {

	public static void main(String[] args) {
		Thread t=new Thread();
		System.out.println(t instanceof Runnable);//true
		System.out.println(t instanceof Left);//false
		//System.out.println(t instanceof B);//CE:Incompatible

	}

}
