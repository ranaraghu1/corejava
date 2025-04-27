package test.java.cert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Employee{
	private int empId;
	private String empName;
	
	
	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
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

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empName, other.empName);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
}
public class EmployeeTest {
	
	public static void main(String args[]) {
	
	Employee e1=new Employee(101, "Raghu");
	Employee e2=new Employee(102, "Ramesh");
	Employee e3=new Employee(101, "Raghu");
	
	Map<Employee,String> map=new HashMap<>();
	map.put(e1,"Developer");
	map.put(e2,"Tester");
	map.put(e3,"Manager");
	System.out.println(map.size());
	System.out.println(map);
	
	}
	
	

}
