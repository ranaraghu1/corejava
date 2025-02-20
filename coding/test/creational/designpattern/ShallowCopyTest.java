package test.creational.designpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GovtEmployee implements Cloneable{
	
	private int empId;
	private String empName;
	private List<String> address=new ArrayList();
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	
	public void loadAddress() {
		address.add("1111");
		address.add("2222");
	}
	
	//sallow copy
	/*
	 * @Override protected Object clone() throws CloneNotSupportedException {
	 * 
	 * return super.clone(); }
	 */
	
	//deep copy
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		GovtEmployee employee=new GovtEmployee();
		employee.setEmpId(this.empId);
		employee.setEmpName(this.empName);
		for(String addr:address) {
			employee.getAddress().add(addr);
		}
		
		return employee;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}
	
	
		
	
}

public class ShallowCopyTest {
	public static void main(String args[]) throws CloneNotSupportedException {
	
		 GovtEmployee employee=new GovtEmployee();
		 employee.setEmpId(1);
		 employee.setEmpName("Raghu");
		 employee.loadAddress();
		 
		GovtEmployee employee1=(GovtEmployee) employee.clone();
		System.out.println("Employee object::"+employee);
		System.out.println("Employee cloned object::"+employee1);
		
	   //changing in clone object, it will reflect in original object as well as address is object here which hold reference
		
		employee1.getAddress().add("4444");
		System.out.println("Employee object::"+employee);
		System.out.println("Employee cloned object::"+employee1);
		
		//This problems solved in deep copy-  //see deep copy comment section
		
		
	}

}
