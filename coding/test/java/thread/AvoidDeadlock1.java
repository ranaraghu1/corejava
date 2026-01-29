package test.java.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class ThreadA implements Runnable{
	static ReentrantLock lock=new ReentrantLock();
	
	@Override
	public void run() {
		while(true) {
		lock.lock();
		try {
			Thread.sleep(new Random().nextLong(5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Train "+Thread.currentThread().getName()+" passing in Road A");
		lock.unlock();
		}
		
	}
	
}


class ThreadB implements Runnable{
	static ReentrantLock lock=new ReentrantLock();
	
	@Override
	public void run() {
		while(true) {
		lock.lock();
		try {
			Thread.sleep(new Random().nextLong(5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Train "+Thread.currentThread().getName()+" passing in Road B");
		lock.unlock();
		}
		
	}
	
}
public class AvoidDeadlock1 {
	static ReentrantLock lock=new ReentrantLock();
	public static void main(String[] args) {
		
	Thread threadA=new Thread(new ThreadA());
	Thread threadB=new Thread(new ThreadB());
	threadA.start();
	threadB.start();
	
	

}
}
