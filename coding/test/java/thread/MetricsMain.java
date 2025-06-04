package test.java.thread;

import java.util.Random;

public class MetricsMain {

	public static void main(String[] args) {

		Metrics metrics= new Metrics();
		BusinessLogicThread businessLogicThread1= new BusinessLogicThread(metrics);
		BusinessLogicThread businessLogicThread2= new BusinessLogicThread(metrics);
		
		MetricsPrinterThread metricsPrinterThread=new MetricsPrinterThread(metrics);
	
		
		businessLogicThread1.start();
		businessLogicThread2.start();
		metricsPrinterThread.start();		
		
	}
	
	public static class  MetricsPrinterThread extends Thread{
		Metrics metrics;
		
		public MetricsPrinterThread(Metrics metrics) {
			this.metrics=metrics;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double currentAverage=metrics.getAverage();
				System.out.println("Current Average is ::"+currentAverage);
			}
		}
		
	}

	public static class BusinessLogicThread extends Thread {
		Metrics metrics;
		private Random randon = new Random();

		public BusinessLogicThread(Metrics metrics) {
			this.metrics = metrics;
		}

		@Override
		public void run() {

			while (true) {
				long startTime = System.currentTimeMillis();
				try {
				
					Thread.sleep(randon.nextInt(10));// sleep from 0-10 random number

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long endTime = System.currentTimeMillis();
				metrics.addSample(endTime - startTime);
			}
		}
	}

	public static class Metrics {
		private long count = 0;
		private volatile double average = 0.0;// double is not atomic

		public synchronized void addSample(long sample) {// Many Thread can access this method
			double currentSum = average * count;
			count++;// adding a new sample, so count will be +1
			average = (currentSum + sample) / count;
		}

		public double getAverage() {
			return average;
		}
	}

}
