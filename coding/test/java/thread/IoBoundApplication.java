package test.java.thread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//create no of thread per request. Thread per task thread model.
public class IoBoundApplication {
	private static final int NUMBER_OF_TASKS = 1000;

	public static void main(String[] args) {
		// Scanner s = new Scanner(System.in);
		// System.out.println("Press enter to start");
		// s.next();
		System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);
		long startTime = System.currentTimeMillis();
		performTasks();
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Task took %dms to complete\n", endTime - startTime));
	}

	private static void performTasks() {

		ExecutorService executorService = Executors.newCachedThreadPool();// Create Dynamic thread pool.Create no of thread per request.
		for (int i = 0; i < NUMBER_OF_TASKS; i++) {
			executorService.submit(new Runnable() {

				@Override
				public void run() {
					blockingIoOperation();

				}
			});

		}

	}

	private static void blockingIoOperation() {
		System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
		try {
			Thread.sleep(1000);// Suppose some IO operation taking 1 second time.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
