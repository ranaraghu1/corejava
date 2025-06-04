package test.java.thread;

import java.util.ArrayList;
import java.util.List;

//In this exercise we are going to implement a  MultiExecutor .

//The client of this class will create a list of Runnable tasks and provide that list into MultiExecutor's constructor.

//When the client runs the . executeAll(),  the MultiExecutor,  will execute all the given tasks.

//To take full advantage of our multicore CPU, we would like the MultiExecutor to execute all the tasks in parallel, by passing each task to a different thread.

public class MultiExecutor {

	List<Runnable> tasks = new ArrayList<Runnable>();

	public MultiExecutor(List<Runnable> tasks) {
		this.tasks = tasks;
	}

	/**
	 * Starts and executes all the tasks concurrently
	 */
	public void executeAll() {
		List<Thread> threads = new ArrayList<>(tasks.size());

		for (Runnable task : tasks) {
			Thread thread = new Thread(task);
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.start();
		}

	}

	private static class MultiExecutorTask implements Runnable {
		@Override
		public void run() {
			System.out.println("Executing:::" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new MultiExecutorTask());
		Thread thread2 = new Thread(new MultiExecutorTask());
		Thread thread3 = new Thread(new MultiExecutorTask());
		Thread thread4 = new Thread(new MultiExecutorTask());
		List<Runnable> tasks = new ArrayList<Runnable>();
		tasks.add(thread1);
		tasks.add(thread2);
		tasks.add(thread3);
		tasks.add(thread4);

		MultiExecutor multiExecutor = new MultiExecutor(tasks);

		multiExecutor.executeAll();

	}

}
