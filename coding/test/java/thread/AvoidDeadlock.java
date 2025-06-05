package test.java.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class AvoidDeadlock {

	public static void main(String[] args) {
		Intersection intersection = new Intersection();
		Thread trainAthread = new Thread(new TrainA(intersection));
		Thread trainBthread = new Thread(new TrainB(intersection));
		trainAthread.start();
		trainBthread.start();

	}

	public static class TrainA implements Runnable {

		Intersection intersection;
		private Random random = new Random();

		public TrainA(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				try {
					intersection.getLockObject().lock();

					try {
						long sleepingTime = random.nextLong(5);
						Thread.sleep(sleepingTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					intersection.takeRoadA();
				} finally {
					intersection.getLockObject().unlock();
				}
				long sleepingTime = random.nextLong(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	public static class TrainB extends Thread {

		Intersection intersection;
		private Random random = new Random();

		public TrainB(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				try {
					intersection.getLockObject().lock();
					long sleepingTime = random.nextLong(5);
					try {
						Thread.sleep(sleepingTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					intersection.takeRoadB();
				}

				finally {
					intersection.getLockObject().unlock();
				}

				long sleepingTime = random.nextLong(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
}

class Intersection {

	private ReentrantLock lockObject = new ReentrantLock();

	public ReentrantLock getLockObject() {
		return lockObject;
	}

	public void setLockObject(ReentrantLock lockObject) {
		this.lockObject = lockObject;
	}

	public void takeRoadA() {

		System.out.println("Train is passing through Road A");

	}

	public void takeRoadB() {
		System.out.println("Train is passing through Road B");

	}

}