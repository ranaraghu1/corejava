package test.java.thread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinThread {

	public static void main(String[] args) throws InterruptedException {
		List<Long> inputNumbers = Arrays.asList(2566545L, 3L, 5L);
		List<FactorialThread> factorialThreads = new ArrayList<FactorialThread>();
		for (Long val : inputNumbers) {
			FactorialThread thread = new FactorialThread(val);
			factorialThreads.add(thread);
		}

		for (FactorialThread thread : factorialThreads) {
			thread.setDaemon(true);
			thread.start();
		}

		for (FactorialThread thread : factorialThreads) {
			thread.join(2000);
		}

		for (int i = 0; i < inputNumbers.size(); i++) {
			FactorialThread factorialThread = factorialThreads.get(i);
			if (factorialThread.isFinished()) {
				System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
			} else {
				System.out.println("Calculate of number " + inputNumbers.get(i) + " is in progress");
			}
		}

	}

	private static class FactorialThread extends Thread {
		private Long inputNumber;
		private BigInteger result =BigInteger.valueOf(10L);
		private boolean isFinished = false;

		public FactorialThread(Long inputNumber) {
			super();
			this.inputNumber = inputNumber;
		}

		@Override
		public void run() {
			this.result = factorial(inputNumber);
			this.isFinished = true;

		}

		public BigInteger factorial(long n) {
			BigInteger tempResult = BigInteger.ONE;
			for (long i = n; i > 0; i--) {
				tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));

			}
			return tempResult;

		}

		public boolean isFinished() {
			return isFinished;
		}

		public BigInteger getResult() {
			return result;
		}

	}

}
