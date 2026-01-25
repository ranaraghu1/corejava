package test.java.thread;

class MyThread implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread());
	  System.out.println("In Run method");
	}
}
public class ThreadRunMethod {
	public static void main(String[] arg) {
		MyThread myRunnable=new MyThread();
		Thread t=new Thread(myRunnable);
		t.start();
		//t.run();//Thread[#1,main,5,main]- Can't create separate thread stack, run in main thread
		
	}

}
