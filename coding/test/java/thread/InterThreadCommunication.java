package test.java.thread;

class CalculateServiceThread extends Thread {
	double sum = 0.00;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				sum = sum + i;
			}

			notify();
		}
	}
	


}

public class InterThreadCommunication {

	public static void main(String[] args) {
		CalculateServiceThread calServiceThread = new CalculateServiceThread();
		calServiceThread.start();

		synchronized (calServiceThread) {
			try {
				//The main thread(current thread) wait to CalculateServiceThread complete its task.
				calServiceThread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(calServiceThread.sum);

	}

}
