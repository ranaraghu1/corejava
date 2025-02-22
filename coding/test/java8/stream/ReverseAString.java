package test.java8.stream;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Reverse{
	public static String revereseString(String str) {
		AtomicInteger count=new AtomicInteger(str.length()-1);
		StringBuffer sb=new StringBuffer();
		IntStream.range(0,str.length()-1)
		.forEach(i->{
			if(i<str.length()-1) {
				sb.append(String.valueOf(str.charAt(count.get())));
				count.decrementAndGet();
			}
					
		});
		
		sb.append(String.valueOf(str.charAt(0)));
		return sb.toString();
	}
	

}

public class ReverseAString {
	public static void main(String arags[]) {
		String str="java";
		String result=Reverse.revereseString(str);
		System.out.println("result::"+result);
	}
	
}
