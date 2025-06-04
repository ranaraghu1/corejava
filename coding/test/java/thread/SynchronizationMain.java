package test.java.thread;

public class SynchronizationMain {
	public static void main(String [] args) throws InterruptedException {
		 SharedClass sharedObject1 = new SharedClass();
	        SharedClass sharedObject2 = new SharedClass();
	 
	        Thread thread1 = new Thread(() -> {
	            while (true) {
	                sharedObject1.increment();
	            }
	        });
	 
	        Thread thread2 = new Thread(() -> {
	            while (true) {
	                sharedObject2.increment();
	            }
	        });
	 
	        thread1.start();
	        thread2.start();
	    }
	 
	    static class SharedClass {
	        private int counter = 0;
	 
	        public synchronized void increment() {
	            this.counter++;
	        }
	    }
}
