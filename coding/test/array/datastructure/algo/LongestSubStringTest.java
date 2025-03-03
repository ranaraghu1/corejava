package test.array.datastructure.algo;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
//sliding window
public class LongestSubStringTest {

	public static void main(String[] args) {
		String s="abadcbkabb";//a,ab,abd,abdc,b,bd,bdc,dc,dcb,dcba,c,cb,cba=4
		
		//String s="abad";//3
		//String s="a";//1
		

		AtomicInteger count=new AtomicInteger(0);
		 int i=0;
		 int j=0;
		 HashMap<Character,Integer> map=new HashMap<>();
		 while(i<=j && j<s.length()) {
			
			 if(map.get(s.charAt(j))!=null) {
				 i++;
				 j=i+1;
				
			 }
			 else {
				 map.put(s.charAt(j), i);
				 j++;
				 count.incrementAndGet();
				
			 }
			 
			 
		 }
		 
		 System.out.println(count.get());
		

	}

}
