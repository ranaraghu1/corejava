package test.java.cert;

class MyThread implements Runnable{
	public void run() {
		System.out.println("Inside Run");
	}
}

public class MyThreadTest{

	public static void main(String[] args) {
		MyThread t1=new MyThread();
		Thread t2=new Thread(t1);
		t2.start();

	}

}
