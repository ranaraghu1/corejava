package test.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

class Student{
	
	private int rollNum;
	private String name;
	private List<Address> address;
	private List<Mobiles> mobiles;
	
	public Student() {
		super();
		
	}
	
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Mobiles> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<Mobiles> mobiles) {
		this.mobiles = mobiles;
	}

	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", name=" + name + "]";
	}

	
	
	
}

class Address{
	private int zip;

	public Address() {
		super();
		
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
}
class Mobiles{
	private String mobNum;

	public Mobiles() {
		super();
		
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
}

public class StringOpertionExample {

	public static void main(String[] args) {
		List<Student> studentList=new ArrayList<>();
		
		List<Address> addressList=new ArrayList<>();
		List<Mobiles> mobilesList=new ArrayList<>();
		
		List<Address> addressList1=new ArrayList<>();
		List<Mobiles> mobilesList1=new ArrayList<>();
		
	//student 1 details	
	  Address add= new Address();
	  add.setZip(111);
	  Address add1= new Address();
	  add1.setZip(222);
	  addressList.add(add);
	  addressList.add(add1);
	  
	  
	  Mobiles mob= new Mobiles();
	  mob.setMobNum("111111");
	  Mobiles mob1= new Mobiles();
	  mob.setMobNum("222222");
	  mobilesList.add(mob);
	  mobilesList.add(mob1);
	  
	  Student st= new Student();
	  st.setName("Rajesh");
	  st.setRollNum(1);
	  st.setAddress(addressList);
	  st.setMobiles(mobilesList);
	  
	 

	//student 2 details	
	  
	  Address add2= new Address();
	  add.setZip(333);
	  Address add3= new Address();
	  add1.setZip(444);
	  addressList1.add(add2);
	  addressList1.add(add3);
	  
	  
	  Mobiles mob2= new Mobiles();
	  mob.setMobNum("333333");
	  Mobiles mob3= new Mobiles();
	  mob.setMobNum("444444");
	  mobilesList1.add(mob2);
	  mobilesList1.add(mob3);
	  
	  Student st1= new Student();
	  st.setName("Saroj");
	  st.setRollNum(2);
	  st.setAddress(addressList1);
	  st.setMobiles(mobilesList1);
	  
	 // studentList.add(mobilesList1);
	  
	  
System.out.println("printing");
System.out.println(studentList);
	  


	}

}
