package test.java.thread;

import java.math.BigInteger;

/*
 * Where each calculation in (..) is calculated on a different thread and add result from each thread.
 */


public class ComplexCalculation {

	public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
		BigInteger result;

	
		PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
		PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		result = thread1.getResult().add(thread2.getResult());
		return result;

	}

	private static class PowerCalculatingThread extends Thread {
		private BigInteger result;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {	
			  int exp= power.intValue();
			  result= base.pow(exp);
		}

		public BigInteger getResult() {
			return result;
		}

		public static void main(String args[]) {
			BigInteger base1 = BigInteger.valueOf(10L);
			BigInteger power1 = BigInteger.valueOf(2L);
			BigInteger base2 = BigInteger.valueOf(5L);
			BigInteger power2 = BigInteger.valueOf(2L);
			BigInteger result=ComplexCalculation.calculateResult(base1, power1, base2, power2);
		    System.out.println(result);
		}
	}

}
