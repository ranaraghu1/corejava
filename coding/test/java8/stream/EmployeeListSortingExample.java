package test.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee{


	private Integer empID;
	private String empName;
	private Integer eSal;
	
	public Employee(Integer empID, String enmName, int eSal) {
		super();
		this.empID = empID;
		this.empName = enmName;
		this.eSal = eSal;
	}



	
	

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String enmName) {
		this.empName = enmName;
	}

	public Integer geteSal() {
		return eSal;
	}

	public void seteSal(Integer eSal) {
		this.eSal = eSal;
	}

	
	
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", enmName=" + empName + ", eSal=" + eSal + "]";
	}
	
}
public class EmployeeListSortingExample {

	public static void main(String[] args) {
		List<Employee> empList=new ArrayList<>();

		empList.add(new Employee(102, "Rajesh", 50000));
		empList.add(new Employee(98, "Satish", 65000));
		empList.add(new Employee(155, "Asish", 79000));
		
		empList.sort(Comparator.comparing(Employee::getEmpName));
		empList.forEach(e->System.out.println(e));
		System.out.println("-----------------------"); 
		empList.sort(Comparator.comparing(Employee::getEmpID));
		empList.forEach(e->System.out.println(e));
		
		System.out.println("-----------------------"); 
		empList.sort(Comparator.comparing(e->e.geteSal()));
		empList.forEach(e->System.out.println(e));
		
		System.out.println("---------Reverse--------------"); 
		empList.sort((Employee e1, Employee e2)->e2.getEmpName().compareTo(e1.getEmpName()));
		empList.forEach(e->System.out.println(e));
		
		System.out.println("----------Multiple Conditions  ???-------------");
		empList.sort(Comparator.comparing(Employee::getEmpName).thenComparing(Employee::geteSal));
		empList.forEach(e->System.out.println(e));
	
		
	}

}
