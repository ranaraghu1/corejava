package test.java.cert;

import java.util.ArrayList;
import java.util.List;

public class RemoveListTest {


	public static void main(String[] args) {
		List<String> l=new ArrayList<>();
        l.add("A");
        l.add("B");
        l.add("A");
        l.add("D");
        
        l.remove("A");
        System.out.println(l);//[B, A, D]


	}

}
