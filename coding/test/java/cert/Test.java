package test.java.cert;

public class Test {

	int x=10;
	static int y=20;
	public static void main(String[] args) {
		Test obj1=new Test();
		obj1.x=777;
		obj1.y=999;
		
		Test obj2=new Test();
		System.out.println(obj1.x+"---"+obj1.y); //777  999
		System.out.println(obj2.x+"---"+obj2.y); //10  999
		
		//int j;
		//System.out.println(j);// invalid
		
		int j=10;
		j=++j;
		int i=--j;
		System.out.println(i+"  "+j);  //10 10 
		
		int n=11;
		n=n++;
		int m=n--;
		System.out.println(m+"  "+n);
		
		
		
		
			
		
		

	}

}
