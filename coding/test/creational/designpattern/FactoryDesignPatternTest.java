package test.creational.designpattern;

interface Employee{
	public String getEmployeePriviledge();
	
}

class PermanentEmployee implements Employee{

	@Override
	public String getEmployeePriviledge() {
		return "Full access priviledge";
	}
}

class ContractualEmployee implements Employee{

	@Override
	public String getEmployeePriviledge() {
		return "Limited access priviledge";
	}
	
}

class FactoryDesignPattern{
	Employee instance;
	public Employee getInstance(String type) {
		if(type.equals("permanent")) {
			instance=new PermanentEmployee();
		}
		if(type.equals("contractual")) {
			instance=new ContractualEmployee();
		}
		return instance;
	}

}

public class FactoryDesignPatternTest {
	public static void main(String args[]) {
		
		FactoryDesignPattern factory=new FactoryDesignPattern();
		Employee employee=factory.getInstance("permanent");
		//Employee employee=factory.getInstance("contractual");
		
		System.out.println(employee.getEmployeePriviledge());
		
		
	}
	
}
