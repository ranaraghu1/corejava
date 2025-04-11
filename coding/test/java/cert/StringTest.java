package test.java.cert;

public class StringTest {

	public static void main(String[] args) {
		System.out.println("---------------");
		String s1="abc";
		String s2="abc";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()==s2.hashCode());
		
		System.out.println("---------------");
		String s11=new String("abc");
		String s22=new String("abc");
		System.out.println(s11==s22);
		System.out.println(s11.equals(s22));
		System.out.println(s11.hashCode()==s22.hashCode());
		
		System.out.println("---------------");
		StringBuffer sb1=new StringBuffer("abc");
		StringBuffer sb2=new StringBuffer("abc");
		System.out.println(sb1==sb2);
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.hashCode()==sb2.hashCode());
		
		String s3=new String("raghu");
		StringBuilder sb3=new StringBuilder("abc");
		//System.out.println(s3==sb3);//compiletime error
		
		System.out.println("-----Bitwise operator----------");
		System.out.println(true & false);
		System.out.println(true | false);
		
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(true ^ true);
		System.out.println(false ^ false);
		System.out.println(~5);
		
		
		int x=10,y=15;
		if(++x<10 & ++y>15) {
			++x;
			
		}else {
			++y;
		}
		System.out.println(x+"   "+y);
		
		 int b,c,d;	
	     int a=b=c=d=10; //chained assignments.
	     System.out.println("a="+a+" b="+b+" c="+c);
	     
	     System.out.println(10);

	}

}
