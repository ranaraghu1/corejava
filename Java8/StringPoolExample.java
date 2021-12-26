
public class StringPoolExample {

	public static void main(String[] args) {
		String s1=new String("raghu");
		String s2=new String("raghu");
		String s3="raghu";
		String s4="raghu";
		String s5=new String("raghu").intern();
		
		System.out.println(s1==s2);//false
		
		System.out.println(s1==s3);//false
		
		System.out.println(s3==s4);//true
		
		System.out.println(s4==s5);//true
		
		
		String s8="ABC";
		
		String s9=s8+"D";
		 System.gc();
		System.out.println(s9==s8);
		System.out.println(s8);
		
		

	}

}
