package test.java.thread;

import java.util.Random;

public class CaseStudyThreadExample {
 public static final int MAX_PASSWORD=9999;
	public static void main(String[] args) {
		//Random random=new Random();
		Vault vault=new Vault(5);
		AscendingHackerThread ascendingHackerThread=new AscendingHackerThread(vault);
		ascendingHackerThread.start();
	}
	
	 private static class Vault{
		 private int password;
		 
		 Vault(int password){
			 this.password=password;
		 }
		 
		 public boolean isGuessCorrect(int guessPassword) {
			 try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return this.password==guessPassword;
		 }
		
	}
	 
	 private static abstract class HackerThread extends Thread{
		 protected Vault vault;
		 public HackerThread(Vault vault) {
			 this.vault=vault;
			 this.setName(this.getClass().getSimpleName());
			 this.setPriority(Thread.MAX_PRIORITY);
		 }
		 
		 @Override
		 public void start() {
			 System.out.println("Starting thread::"+this.getName());
			 super.start();
		 }
		 
		 
	 }

	 private static class AscendingHackerThread extends HackerThread{
		 public AscendingHackerThread(Vault vault) {
			super(vault);
	
		}

		@Override
		 public void run() {
			 for(int guess=0;guess<MAX_PASSWORD;guess++) {
				 if(vault.isGuessCorrect(guess)) {
					 System.out.println("Guess password is:"+guess);
					 System.out.println("Exit programme");
					 System.exit(0);
				 }
			 }
		 }
		 
	 }
}


