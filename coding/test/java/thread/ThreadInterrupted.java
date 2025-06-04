package test.java.thread;

public class ThreadInterrupted {

	public static void main(String[] args) {
		Thread thread=new Thread(new BlockingThread());
		thread.start();
		//thread.interrupt();// This method will interrupted the BlockingThrad. If this will be disable, The Blocking Thread wait long period to complete.

	}
	
	private static class BlockingThread implements Runnable{

		@Override
		public void run() {
			System.out.println("start run method:::");
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				System.out.println("Exiting Blocking Thread");
			
			}
			System.out.println("End run method:::");
		}
		
	}

}
