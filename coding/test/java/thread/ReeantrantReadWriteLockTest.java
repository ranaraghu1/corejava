package test.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReeantrantReadWriteLockTest {

	public static final int HIGHEST_PRICE = 1000;

	public static void main(String[] args) {
		InventoryDataBase inventoryDataBase = new InventoryDataBase();
		Random random = new Random();
		for (int i = 0; i < 100000; i++) {
			inventoryDataBase.addItems(random.nextInt(HIGHEST_PRICE));
		}

		Thread writer = new Thread(() -> {
			while (true) {
				inventoryDataBase.addItems(random.nextInt(HIGHEST_PRICE));
				inventoryDataBase.removeItems(random.nextInt(HIGHEST_PRICE));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		writer.setDaemon(true);
		writer.start();

		int NumberOfReaderThreads = 7;
		List<Thread> readers = new ArrayList<>();
		for (int readerIndex = 0; readerIndex < NumberOfReaderThreads; readerIndex++) {

			Thread reader = new Thread(() -> {
				for (int i = 0; i < 100000; i++) {
					int upperBoundPrice = random.nextInt(HIGHEST_PRICE);
					int lowerBoundPrice = upperBoundPrice > 0 ? random.nextInt(upperBoundPrice) : 0;
					inventoryDataBase.getNumberOfItemsInPriceRange(lowerBoundPrice, upperBoundPrice);
				}

			});
			reader.setDaemon(true);
			readers.add(reader);

		}

		long startReadingTime = System.currentTimeMillis();
		for (Thread reader : readers) {
			reader.start();
		}

		for (Thread reader : readers) {
			try {
				reader.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endReadingTime = System.currentTimeMillis();

		System.out.println(String.format("Reading took %d ms", endReadingTime - startReadingTime));

	}

	public static class InventoryDataBase {
		private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();
		//private ReentrantLock lock=new ReentrantLock();
		private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
		private Lock readLock = reentrantReadWriteLock.readLock();
		private Lock writeLock = reentrantReadWriteLock.writeLock();

		public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {
			readLock.lock();
			//lock.lock();
			try {
				Integer fromKey = priceToCountMap.ceilingKey(lowerBound);
				Integer toKey = priceToCountMap.floorKey(upperBound);

				if (fromKey == null || toKey == null) {
					return 0;
				}

				NavigableMap<Integer, Integer> rangeOfPrice = priceToCountMap.subMap(fromKey, true, toKey, true);

				int sum = 0;
				for (int NumberOfItemsForPrice : rangeOfPrice.values()) {
					sum += NumberOfItemsForPrice;
				}
				return sum;
			} finally {
				readLock.unlock();
				//lock.unlock();
			}
		}

		public void addItems(int price) {
			writeLock.lock();
			//lock.lock();
			try {
				Integer numberOfItemsForPrice = priceToCountMap.get(price);

				if (numberOfItemsForPrice == null) {
					priceToCountMap.put(price, 1);
				} else {
					priceToCountMap.put(price, numberOfItemsForPrice + 1);
				}
			} finally {
				writeLock.unlock();
				//lock.unlock();
			}
		}

		public void removeItems(int price) {
			writeLock.lock();
			//lock.lock();
			try {
				Integer numberOfItemsForPrice = priceToCountMap.get(price);

				if (numberOfItemsForPrice == null || numberOfItemsForPrice == 1) {
					priceToCountMap.remove(price);
				} else {
					priceToCountMap.put(price, numberOfItemsForPrice - 1);
				}
			} finally {
				writeLock.unlock();
				//lock.unlock();
			}
		}

	}

}
