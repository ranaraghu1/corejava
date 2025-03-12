package test.java8.stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest {
    private int empNum;
    private String empName;
    private Double sal;
    private String department;
    private Date doj;
    private String gender;
    private int age;

    public EmployeeTest(int empNum, String empName, Double sal, String department, Date doj, String gender,int age) {
        this.empNum = empNum;
        this.empName = empName;
        this.sal = sal;
        this.department = department;
        this.doj = doj;
        this.gender = gender;
        this.age=age;
    }

    public int getEmpNum() {
        return empNum;
    }

    public void setEmpNum(int empNum) {
        this.empNum = empNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNum=" + empNum +
                ", empName='" + empName + '\'' +
                ", sal=" + sal +
                ", department='" + department + '\'' +
                ", doj=" + doj +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}


class Test{
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
        List<EmployeeTest> employeeList=new ArrayList<>();
       // Date date = fmt.parse("2013-05-06");

        EmployeeTest employee1=new EmployeeTest(101,"John",20000.00,"IT",fmt.parse("01-05-02-2025"),"Male",20);
        EmployeeTest employee2=new EmployeeTest(102,"Ramesh",30000.00,"HR",fmt.parse("01-06-2024"),"Male",24);
        EmployeeTest employee3=new EmployeeTest(103,"Rupali",50000.00,"HR",fmt.parse("01-07-2024"),"Female",30);
        EmployeeTest employee4=new EmployeeTest(104,"Raju",35000.00,"IT",fmt.parse("01-05-2018"),"Male",35);
        EmployeeTest employee5=new EmployeeTest(105,"Debanshi",25000.00,"Marketing",fmt.parse("05-05-2019"),"Female",23);
        EmployeeTest employee6=new EmployeeTest(107,"Depali",6000.00,"HR",fmt.parse("01-07-2024"),"Female",22);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);

        //Find department names.
        List<String> departments=employeeList.stream().map(e->e.getDepartment()).distinct().toList();
        System.out.println("Department-"+departments);

        //Find highest salary of employee
        List<EmployeeTest> empHighestSal=employeeList.stream().sorted(Comparator.comparing(EmployeeTest::getSal).reversed()).limit(1).toList();
        System.out.println("empHighestSal-"+empHighestSal.toString());

        Optional<EmployeeTest> optional=employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(EmployeeTest::getSal)));
        if(optional.isPresent()){
            System.out.println("empHighestSal-"+optional.get());
        }

        //Find lowest salary of an employee
        List<EmployeeTest> empLowesttSal=employeeList.stream().sorted(Comparator.comparing(EmployeeTest::getSal)).limit(1).toList();
        System.out.println("empLowesttSal-"+empLowesttSal.toString());

        Optional<EmployeeTest> optionalMin=employeeList.stream().collect(Collectors.minBy(Comparator.comparing(EmployeeTest::getSal)));
        if(optionalMin.isPresent()){
            System.out.println("empLowesttSal-"+optionalMin.get());
        }

        //find average slary of each department
        Map avgSalary=employeeList.stream().collect(Collectors.groupingBy(EmployeeTest::getDepartment,Collectors.averagingDouble(EmployeeTest::getSal)));
        System.out.println("avgSal-"+avgSalary);

        //Find the employee whose department is IT
        System.out.println("Employee in IT dept----------");
        employeeList.stream().filter(a->a.getDepartment().equals("IT")).forEach( System.out::println);

        //Find list of employee whose joining date is before current date
        System.out.println("Joining date is before current date----------");
        employeeList.stream().filter(a->a.getDoj().before(new Date())).forEach(System.out::println);

        //Find youngest employee of HR department
        System.out.println("Youngest employee in HR department----------");
        List<String> youngestEmployee=employeeList.stream().filter(a->a.getDepartment().equals("HR")).sorted(Comparator.comparing(EmployeeTest::getAge)).limit(1).toList().stream().map(EmployeeTest::getEmpName).toList();
        System.out.println("Youngest employee in HR department"+youngestEmployee);

        List<String> youngestEmployee1=employeeList.stream().filter(a->a.getDepartment().equals("HR")).min(Comparator.comparing(EmployeeTest::getAge)).stream().map(EmployeeTest::getEmpName).toList();
        System.out.println("Youngest employee in HR department"+youngestEmployee1);

        //How many Male and Female employees in HR Department.
        Map<String,Long> countGender=employeeList.stream().filter(a->a.getDepartment().equals("HR")).collect(Collectors.groupingBy(EmployeeTest::getGender,Collectors.counting()));
        System.out.println("male and Female employees in HR Department"+countGender);

        //Summerize the employee salary by doubling for HR Department
        Double summerizingSal=employeeList.stream().filter(e->e.getDepartment().equals("HR")).map(a->a.getSal()*2).reduce(0.0,Double::sum);
        System.out.println("Summarizing salary "+summerizingSal);

        //find out the employee list whose salary greater than or equal to 35000.00
        List<EmployeeTest> goodSalEmp=employeeList.stream().takeWhile(e->e.getSal().intValue()>=10000).toList();
        List<String> goodSalEmp1=goodSalEmp.stream().map(a->a.getEmpName()).toList();
        System.out.println("Good salaried employees "+goodSalEmp1);
    }
}
