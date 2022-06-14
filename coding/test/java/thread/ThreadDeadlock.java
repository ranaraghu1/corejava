package test.java.thread;

public class ThreadDeadlock {

	public static void main(String[] args) {
		final String resource1="hi";
		final String resource2="hello";
		//t1 tries to lock resource1 then resource2
		Thread t1=new Thread(){
			public void run() {
				synchronized(resource1) {
					System.out.println("Thread 1 locked resouce 1");
					try {
						Thread.sleep(100);
						
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				synchronized(resource2){
					System.out.println("Thread 1 locled resouce 2");
				}
			}
		};
		
		//t2 tries to lock resource2 then resource1
		Thread t2=new Thread() {
			public void run() {
				synchronized(resource2) {
					
					System.out.println("Thread 2 locked resouce 2");
					try {
						Thread.sleep(100);
						
					}catch(InterruptedException e) {
						
						e.printStackTrace();
					}
					
					
				}
				synchronized(resource1){
					
				}
			}
		};
    t1.start();
    t2.start();
	}

}
