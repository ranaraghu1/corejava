package test.java.cert;

public class StringTest1 {

	public static void main(String[] args) {
		String s=new String("Raghu");
		s.concat("Nath");
		s=s.concat("Rana");
		System.out.println(s);//RaghuRana
		
		StringBuilder sb=new StringBuilder("Raghu");
		sb.append("Nath");
	    sb=sb.append("Rana");
		System.out.println(sb);//RaghuNathRana
		
		System.out.println(s.equals(sb));
	
	}

}
