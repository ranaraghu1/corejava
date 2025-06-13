package test.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceCountDownLatchExample {

	  public static void main(String[] args) throws InterruptedException {
	        int numberOfTasks = 3;
	        CountDownLatch latch = new CountDownLatch(numberOfTasks);
	        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

	        for (int i = 0; i < numberOfTasks; i++) {
	            executor.submit(() -> {
	                try {
	                    // Simulate some work
	                    System.out.println("Thread " + Thread.currentThread().getName() + " is working.");
	                    Thread.sleep(2000);
	                } catch (InterruptedException e) {
	                    Thread.currentThread().interrupt();
	                } finally {
	                    latch.countDown(); // Decrement the latch count
	                    System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
	                }
	            });
	        }

	        latch.await(); // Wait for all tasks to complete
	        System.out.println("All tasks completed. Main thread continues.");
	        executor.shutdown();
	    }
}
