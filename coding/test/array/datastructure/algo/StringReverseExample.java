package test.array.datastructure.algo;

public class StringReverseExample {
	String str1="raghu";
char[] str=str1.toCharArray();

int start;
char temp;
int end=str.length-1;

int counter;
public void calculateReverse(){
	System.out.println("length of String: "+end);
	for(start=0;start<end;start++,end--) {
		temp=str[start]; 
		str[start]=str[end]; 
		str[end]=temp;
		 
	
		
	}
	
	System.out.println(str);
}

	public static void main(String arags[]) {
		
		StringReverseExample example=new StringReverseExample();
		example.calculateReverse();
	}
}
