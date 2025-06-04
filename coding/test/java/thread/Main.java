package test.java.thread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
			System.out.println("I am running in Thread:"+Thread.currentThread().getName());
			System.out.println("Thread priority:"+Thread.currentThread().getPriority());
				
			}
			
		});
		
		t1.setName("Worker Thread");
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Before start:"+Thread.currentThread().getName());
		t1.start();
		Thread.sleep(1000);
		System.out.println("After start:"+Thread.currentThread().getName());
	

	}

}


/*
 * Before start:main 
 * I am running in Thread:Worker Thread 
 * After start:main
 */