package test.java.basics;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Employee{
	int empID;
	String empName;
	

	public Employee(int empID, String empName) {
		super();
		this.empID = empID;
		this.empName = empName;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public int hashCode() {
		System.out.println("hashcode method is called");
		return Objects.hash(empID, empName);
		
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals method is called");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empID == other.empID && Objects.equals(empName, other.empName);
	}
}

public class HashMapExampleCaching {

public static void main(String args[]) {
	
	Map<Employee,Integer> hm=new HashMap<>();
	Employee e1= new Employee(101,"Raghu");
	Employee e2= new Employee(101,"Raghu1");
	System.out.println(e1.hashCode());
	System.out.println(e2.hashCode());
	hm.put(e1,1);
	hm.put(e2,2);
	hm.put(null,2);
	
	System.out.println(hm.get(e1));
	
}
}
