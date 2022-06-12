package test.array.datastructure.algo;

class StringOperation{
	StringBuilder sb=null;
	char[] ch= {};
	public String reverseStringIteration(String str) {
		 sb=new StringBuilder();
		ch=str.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			if(ch.length<2) {
				return str;
			}
			sb.append(ch[i]);
		}
		return sb.toString();
	}
	public String reverseSringRecursive(String str) {
		if(ch.length<2) {
			return str;
		}
	
		return reverseSringRecursive(str.substring(1))+str.charAt(0);
	}
}
public class ReverseString {

	public static void main(String[] args) {
		String str="raghu";
		StringOperation sop=new StringOperation();
		String reverseString=sop.reverseStringIteration(str);
		System.out.println("The origina String is :"+str);
		System.out.println("Reverse with iteration:"+reverseString);
		
		String revString=sop.reverseSringRecursive(str);
		
		System.out.println("Reverse with recursion:"+revString);
		

	}

}
