package test.java.thread;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest extends Thread{

    static ConcurrentHashMap<Integer,String> chm=new ConcurrentHashMap<>();
    public void run(){
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }

        System.out.println("Child Thread updating Map");
        chm.put(101,"A");
    }

    public static void main(String args[]) {
        //Adding elements to object created of Map";
        chm.put(102, "B");
        chm.put(103, "C");

        // Creating thread inside main() method
        ConcurrentHashMapTest t = new ConcurrentHashMapTest();

       //Start Thread
        t.start();

        Set<Integer> s1 = chm.keySet();
        Iterator<Integer> itr = s1.iterator();

        while (itr.hasNext()) {
            Integer I1 = itr.next();
            System.out.println(
                    "Main Thread Iterating Map and Current Entry is:"
                            + I1 + "..." + chm.get(I1));

            // Making thread to sleep for 3 seconds
            try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        // Display elements of map objects
        System.out.println(chm);
    }


}