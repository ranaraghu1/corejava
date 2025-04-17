package test.java.cert;

public class TwoDimentionalArray {

	public static void main(String[] args) {

		String[][] s= {{"A","B"},{"C","D"}};
		for(int i=s.length-1;i>=0;i--) {
			for(int j=0;j<s[i].length;j++) {
				System.out.println(s[i][j]);
			}
			
		}
		
		System.out.println("------------------");

		for(int i=s.length-1;i>=0;i--) {
			for(int j=s[i].length-1;j>=0;j--) {
				System.out.println(s[i][j]);
			}
			
		}
	}

}
