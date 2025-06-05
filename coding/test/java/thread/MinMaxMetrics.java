package test.java.thread;

import java.util.Random;

public class MinMaxMetrics {
	private volatile long minValue;
	private volatile long maxValue;

	/**
	 * Initializes all member variables
	 */
	public MinMaxMetrics() {
		this.maxValue = Long.MAX_VALUE;
		this.minValue = Long.MIN_VALUE;
	}

	/**
	 * Adds a new sample to our metrics.
	 */
	public void addSample(long newSample) {
		synchronized (this) {
		
				this.minValue = newSample;
				this.maxValue = Math.max(newSample, this.maxValue);
			
		}
	}

	/**
	 * Returns the smallest sample we've seen so far.
	 */
	public long getMin() {
		return this.minValue;
	}

	/**
	 * Returns the biggest sample we've seen so far.
	 */
	public long getMax() {
		return this.maxValue;
	}

	private static class MinMaxMetricsThread extends Thread {
		MinMaxMetrics minMaxMetrics;
		private Random random=new Random();

		public MinMaxMetricsThread(MinMaxMetrics minMaxMetrics) {
			this.minMaxMetrics = minMaxMetrics;
		}

		@Override
		public void run() {
			
			minMaxMetrics.addSample(random.nextInt(10));
		}

	}

	public static void main(String[] args) {
		MinMaxMetrics minMaxMetrics = new MinMaxMetrics();

		MinMaxMetricsThread therad1 = new MinMaxMetricsThread(minMaxMetrics);
		MinMaxMetricsThread therad2 = new MinMaxMetricsThread(minMaxMetrics);

		therad1.start();
		therad2.start();
		System.out.println("Min val::" + minMaxMetrics.getMin());
		System.out.println("Max val::" + minMaxMetrics.getMax());

	}

}
