package test.java.cert;

import java.io.IOException;

public interface Left {
 public Object m1()throws IOException;
}

 interface Right{
	public String m1()throws Exception;
}



class Test3 implements Left,Right{
	public String m1(){
	 return "";
		
	}
	
}
