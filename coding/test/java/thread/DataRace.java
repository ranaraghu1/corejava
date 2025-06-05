package test.java.thread;

public class DataRace {

	public static void main(String[] args) throws InterruptedException {
		Shared shared = new Shared();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				shared.increment();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				shared.checkDataRace();
			}
		});

		thread1.start();
		thread2.start();

	}

	public static class Shared {
		private int a = 0;
		private int b = 0;

		public  void increment() {
			a++;
			b++;
		}

		public void checkDataRace() {
			if (a> b) {
				System.out.println("Data Race is detected");
			}
		}
	}

}
