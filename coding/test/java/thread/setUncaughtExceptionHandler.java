package test.java.thread;

public class setUncaughtExceptionHandler {

	public static void main(String[] args) {
		Thread thread=new Thread(()->{   //implement run method using lambda expression
			System.out.println("Inside Run method");
			throw new RuntimeException("Internal error");
		});
		thread.setName("Worker Thread");
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Cleaning operation::::");
				System.out.println("Critical error::"+t.getName()+"  error is:"+e.getMessage());
				
			}
		});
		
		thread.start();
		

	}

}
