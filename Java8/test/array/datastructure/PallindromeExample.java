package test.array.datastructure;

public class PallindromeExample {

	public static void main(String[] args) {
		String a="abcba";
	
		String reverse="";
		for(int i=a.length()-1;i>=0;i--)
		{
			reverse=reverse+a.charAt(i);
		}

		if(a.equalsIgnoreCase(reverse)) 
			System.out.println(a+" is a pallindrome");
		else
			System.out.println(a+" is not a pallindrome");
		
		//integer
		int n=121;
		int temp=n;
		int sum=0;
		int r;
		while(n>0) {
			r=n%10;
			sum=(sum*10)+r;
			n=n/10;
		}
		if(temp==sum) 
			System.out.println(temp+" is a pallindrome");
		else
			System.out.println(temp+" is not a pallindrome");
	}

	
	
	
}
