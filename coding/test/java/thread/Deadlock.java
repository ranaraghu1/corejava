package test.java.thread;

import java.util.Random;

public class Deadlock {

	public static void main(String[] args) {
		Intersection intersection=new Intersection();
		Thread trainAthread=new Thread(new TrainA(intersection) );
		Thread trainBthread=new Thread(new TrainB(intersection) );
		trainAthread.start();
		trainBthread.start();

	}

	public static class TrainA implements Runnable{

		Intersection intersection;
		private Random random=new Random();
		
		public TrainA(Intersection intersection) {
			this.intersection=intersection;
		}
		
		@Override
		public void run() {
			while(true) {
				long sleepingTime=random.nextLong(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				intersection.takeRoadA();
			}
			
		}
		
	}
	
	public static class TrainB implements Runnable{

		Intersection intersection;
		private Random random=new Random();
		
		public TrainB(Intersection intersection) {
			this.intersection=intersection;
		}
		
		@Override
		public void run() {
			while(true) {
				long sleepingTime=random.nextLong(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				intersection.takeRoadB();
			}
			
		}
		
	}
	
	
	
	public static class Intersection {
		private Object roadA = new Object();
		private Object roadB = new Object();

		public void takeRoadA() {
			synchronized (roadA) {
				System.out.println("Road A is locked by thread:" + Thread.currentThread().getName());

				synchronized (roadB) {
					System.out.println("Train is passing through Road A");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}
		
		
		public void takeRoadB() {
			synchronized (roadB) {//synchronized (roadA)- To avoid deadlock
				System.out.println("Road B is locked by thread:" + Thread.currentThread().getName());

				synchronized (roadA) {//synchronized (roadB)- To avoid deadlock
					System.out.println("Train is passing through Road B");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}
	}

}
