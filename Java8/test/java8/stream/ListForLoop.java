package test.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListForLoop {
public static void main(String args[])
{
	List list=new ArrayList();
	list.add("Saanvi");
	list.add("Raghu");
	
	list.forEach((n)->
	System.out.println(n));
	System.out.println("----Reversing----");
	Collections.sort(list);
	list.forEach(n->
	System.out.println(n));
	
}
}
