package test.java.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class PriceContainer {

	private ReentrantLock lockObject = new ReentrantLock();
	private double bitcoinPrice;
	private double etherprice;
	private double litcoinPrice;
	private double bitcoinCashPrice;
	private double rippleprice;

	public ReentrantLock getLockObject() {
		return lockObject;
	}

	public void setLockObject(ReentrantLock lockObject) {
		this.lockObject = lockObject;
	}

	public double getBitcoinPrice() {
		return bitcoinPrice;
	}

	public void setBitcoinPrice(double bitcoinPrice) {
		this.bitcoinPrice = bitcoinPrice;
	}

	public double getEtherprice() {
		return etherprice;
	}

	public void setEtherprice(double etherprice) {
		this.etherprice = etherprice;
	}

	public double getLitcoinPrice() {
		return litcoinPrice;
	}

	public void setLitcoinPrice(double litcoinPrice) {
		this.litcoinPrice = litcoinPrice;
	}

	public double getBitcoinCashPrice() {
		return bitcoinCashPrice;
	}

	public void setBitcoinCashPrice(double bitcoinCashPrice) {
		this.bitcoinCashPrice = bitcoinCashPrice;
	}

	public double getRippleprice() {
		return rippleprice;
	}

	public void setRippleprice(double rippleprice) {
		this.rippleprice = rippleprice;
	}
}

class PriceUpdate extends Thread {
	private PriceContainer priceContainer;
	private Random random = new Random();

	public PriceUpdate(PriceContainer priceContainer) {
		this.priceContainer = priceContainer;
	}

	@Override
	public void run() {
		while (true) {

			try {
				priceContainer.getLockObject().lock();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				priceContainer.setBitcoinPrice(random.nextInt(1000));
				priceContainer.setBitcoinCashPrice(random.nextInt(500));
				priceContainer.setEtherprice(random.nextInt(50));
				priceContainer.setLitcoinPrice(random.nextInt(300));
				priceContainer.setRippleprice(random.nextInt(200));
			} finally {
				priceContainer.getLockObject().unlock();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
