package test.java.basics;
 interface TestInterface{
	 default void show()
	    {
	        System.out.println("Default TestInterface");
	    } 
 }
public class TestInterface1 implements TestInterface {
	
	public void show()
    {
        System.out.println("Default TestInterface1");
    }
	
	public static void main(String[] args) {
		
		TestInterface test= new TestInterface1();
		test.show();
	}
}


package com.apple.ist.ets.comms.envoy.server.bean.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
    private int empNum;
    private String empName;
    private Double sal;
    private String department;
    private Date doj;
    private String gender;
    private int age;

    public Employee(int empNum, String empName, Double sal, String department, Date doj, String gender,int age) {
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
        List<Employee> employeeList=new ArrayList<>();
        Date date = fmt.parse("2013-05-06");

        Employee employee1=new Employee(101,"John",20000.00,"IT",fmt.parse("01-05-02-2025"),"Male",20);
        Employee employee2=new Employee(102,"Ramesh",30000.00,"HR",fmt.parse("01-06-2024"),"Male",24);
        Employee employee3=new Employee(103,"Rupali",50000.00,"HR",fmt.parse("01-07-2024"),"Female",30);
        Employee employee4=new Employee(104,"Raju",35000.00,"IT",fmt.parse("01-05-2018"),"Male",35);
        Employee employee5=new Employee(105,"Debanshi",25000.00,"Marketing",fmt.parse("05-05-2019"),"Female",23);
        Employee employee6=new Employee(107,"Depali",6000.00,"HR",fmt.parse("01-07-2024"),"Female",22);

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
        List<Employee> empHighestSal=employeeList.stream().sorted(Comparator.comparing(Employee::getSal).reversed()).limit(1).toList();
        System.out.println("empHighestSal-"+empHighestSal.toString());

        Optional<Employee> optional=employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSal)));
        if(optional.isPresent()){
            System.out.println("empHighestSal-"+optional.get());
        }

        //Find lowest salary of an employee
        List<Employee> empLowesttSal=employeeList.stream().sorted(Comparator.comparing(Employee::getSal)).limit(1).toList();
        System.out.println("empLowesttSal-"+empLowesttSal.toString());

        Optional<Employee> optionalMin=employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getSal)));
        if(optionalMin.isPresent()){
            System.out.println("empLowesttSal-"+optionalMin.get());
        }

        //find average slary of each department
        Map avgSalary=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSal)));
        System.out.println("avgSal-"+avgSalary);

        //Find the employee whose department is IT
        System.out.println("Employee in IT dept----------");
        employeeList.stream().filter(a->a.getDepartment().equals("IT")).forEach( System.out::println);

        //Find list of employee whose joining date is before current date
        System.out.println("Joining date is before current date----------");
        employeeList.stream().filter(a->a.getDoj().before(new Date())).forEach(System.out::println);

        //Find youngest employee of HR department
        System.out.println("Youngest employee in HR department----------");
        List<String> youngestEmployee=employeeList.stream().filter(a->a.getDepartment().equals("HR")).sorted(Comparator.comparing(Employee::getAge)).limit(1).toList().stream().map(Employee::getEmpName).toList();
        System.out.println("Youngest employee in HR department"+youngestEmployee);

        List<String> youngestEmployee1=employeeList.stream().filter(a->a.getDepartment().equals("HR")).min(Comparator.comparing(Employee::getAge)).stream().map(Employee::getEmpName).toList();
        System.out.println("Youngest employee in HR department"+youngestEmployee1);

        //How many Male and Female employees in HR Department.
        Map<String,Long> countGender=employeeList.stream().filter(a->a.getDepartment().equals("HR")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println("male and Female employees in HR Department"+countGender);

        //Summerize the employee salary by doubling for HR Department
        Double summerizingSal=employeeList.stream().filter(e->e.getDepartment().equals("HR")).map(a->a.getSal()*2).reduce(0.0,Double::sum);
        System.out.println("Summarizing salary "+summerizingSal);

        //find out the employee list whose salary greater than or equal to 35000.00
        List<Employee> goodSalEmp=employeeList.stream().takeWhile(e->e.getSal().intValue()>=10000).toList();
        List<String> goodSalEmp1=goodSalEmp.stream().map(a->a.getEmpName()).toList();
        System.out.println("Good salaried employees "+goodSalEmp1);
    }
}

	


//ConcurrentHashMapTest


package com.apple.ist.ets.comms.envoy.server.bean.admin;

import com.sun.tools.javac.Main;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest extends Thread{

    static ConcurrentHashMap<Integer,String> chm=new ConcurrentHashMap<>();
    public void run(){
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }

        System.out.println("Child Thread updating Map");
        chm.put(101,"A");
    }

    public static void main(String args[]) throws InterruptedException {
        //Adding elements to object created of Map";
        chm.put(102, "B");
        chm.put(103, "C");

        // Creating thread inside main() method
        ConcurrentHashMapTest t = new ConcurrentHashMapTest();

       //Start Thread
        t.start();

        Set<Integer> s1 = chm.keySet();
        Iterator<Integer> itr = s1.iterator();

        while (itr.hasNext()) {
            Integer I1 = itr.next();
            System.out.println(
                    "Main Thread Iterating Map and Current Entry is:"
                            + I1 + "..." + chm.get(I1));

            // Making thread to sleep for 3 seconds
            Thread.sleep(3000);
        }

        // Display elements of map objects
        System.out.println(chm);
    }


}



//JPA  and Hibernate


The main components of JPA include:
- Entity: A lightweight, persistent domain object which represents a table in relational database.

- EntityManagerFactory: Factory for creating `EntityManager` instances. This is Thread safe. So it is costly to use. So it should create one EntityManagerFactory per application and reused.

- EntityManager: Manages lifecycle operations on entities.This is not thread safe. So It should be used per transaction or per request.
  It create EntityTransaction and Query. 
  
- Persistence Unit (persistence.xml): Defines all entity classes managed by an `EntityManager`.Defined entity classes and their configuration. 

- EntityTransaction: Manages transaction boundaries.It lives short period. It removed when data base commit or rollback.
  It allows you to begin, commit, and rollback transactions to ensure data consistency and integrity.

- Query: Interface for executing database queries.


Defined primary Key 

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

GenerationType.AUTO- Lets Persistence generates appropriate strategy. It depends on database dialect and provider settings.

GenerationType.IDENTITY`- It relies on the database to automatically generate the primary key values using an identity column.
This strategy is common in databases like MySQL, PostgreSQL, etc.


GenerationType.SEQUENCE`- It uses a database sequence to generate unique primary key values.
This strategy is commonly used in databases that support sequences, like Oracle, PostgreSQL, etc


GenerationType.TABLE`-It uses a database table to generate unique primary key values. 
This strategy supported with any database. 
it can be slower compared to other strategies.


JPQL-Query language for JPA. Writing query using an object-oriented syntax not SQL syntax.

EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
EntityManager em = emf.createEntityManager();
TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.price > :price", Product.class);


Criteria API

It is just an alternative method for defining JPA queries.
The main purpose behind this is to provide a type-safe way to express a query.
JPQL- sometimes the parameters, logic, and String concatenation makes less readable code.Criteria API likes java code with a builder syntax

EntityManager em = emf.createEntityManager();  
CriteriaBuilder cb=em.getCriteriaBuilder();  
CriteriaQuery<StudentEntity> cq=cb.createQuery(StudentEntity.class);  
CriteriaQuery<StudentEntity> select = cq.select(stud);  


Hibernate
---------
ORM tools simplifies data creation, data manipulation and data access using java API.
Light weight and open source.
Reduce code length and remove boilerplate code. Code is more cleaner and readable.
It facilitates to generate independent data base/native query for underlying data base( based on dialect).
It supports associations,Collections and inheritances.
HQL-Closure to java and more object oriented.
Migration and integration is more flexible.

Persistent
When a POJO instance is in session scope is called persistent .Hibernate detects if any changes made to that object then it synchronised with database.

Session
Represents a single unit of work with the data base.
It is lightweight, non-thread-safe object(that should not be shared across multiple threads).Session is created per request.
It is used to perform CRUD operations on persistent objects. 

SessionFactory
Heavy weight and thread safe.
used to crete and manage multiple session across application.
It is costly.So one SessionFactory per application is recommended.
It is also configuring and managing the underlying connection pooling and caching mechanisms.


First-level cache and second-level cache.

The first-level cache is associated with a Session and stores the current loaded object in memory.
It is local to Session object and can not be shared between multiple sessions.
This cache is enable by default.
The first-level cache scope is session's scope and it is destroyed once session is closed.


The second-level cache is associated with a Session Factory and holds/shares objects across multiple sessions, thereby reducing the number of database queries needed. 
This session  is disabled by default and we can enabled through configuration.
The second-level cache scope is application’s life cycle scope, it is only destroyed and recreated when an application is restarted.


Hibernate Configuration File(hibernate.cfg.xml)

It is used to configure the basic settings of Hibernate, such as the database URL, username, password, and dialect. 
It also contains the mapping information of the persistent classes and the resources required for connection pooling. 

<property name="hibernate.connection.provider_class">
org.hibernate.connection.C3P0ConnectionProvider
</property>
<property name="hibernate.c3p0.min_size">7</property>
<property name="hibernate.c3p0.max_size">53</property>
<property name="hibernate.c3p0.timeout">100</property>
<property name="hibernate.c3p0.max_statements">50</property>
<property name="hibernate.c3p0.idle_test_period">1000</property>
<property name="hibernate.c3p0.validate">true</property>

Connection Pooling

In order improve the application performance we will use connection pooling and will avoid every time connection object creation and destruction.

Default Connection Pooling- allow maximum 20 connections.

<session-factory>
    <property name="connection.pool_size">10</property>
  </session-factory>
  
Third Party Vendors provided- C3P0

Application Servers Provided
Servlet Containers (like Tomcat) provides a connection pooling mechanism by default.
Thus, your application don't have to worry about the details about it. 

There are only two cases where you need to worry about connection pooling.

You are dealing with a standalone application (which doesn't run inside a container).
You are really expert in connection pooling and none of the existing suits your needs.


Hibernate Inheritance Mapping

Hibernate Inheritance Mapping represents the inheritance relationships between classes in a relational database. 
It allows the developer to map a single table to multiple classes using table per class hierarchy, table per subclass, and table per concrete class. 

Is hibernate prone to SQL injection attacks?
How to prevent SQL Injection with JPA and Hibernate?-  Always use bind parameters instead of concatenate the parameter String.

Without parameter binding, you have to concatenate the parameter String like this (bad code).

String hql = "from Stock s where s.stockCode = '" + stockCode + "'";
List result = session.createQuery(hql).list();

Pass an unchecked value from user input to the database will raise security concern, because it can easy get hack by SQL injection. 
You have to avoid the above bad code and using parameter binding instead.

String hql = "from Stock s where s.stockCode = :stockCode";
List result = session.createQuery(hql)
.setParameter("stockCode", "7277")
.list();


@EmbeddedId- indicates it is a composite primary key of the bean entity.


getCurrentSession and openSession methods?

getCurrentSession()
returns the session bound to the context.
This session object gets closed once the session factory is closed.
This method is faster than openSession()


openSession()
Always opens a new session.
It's the developer’s responsibility to close this object once all the database operations are done.


save() and saveOrUpdate()

Both the methods save records to the table in the database in case there are no records with the primary key in the table.

save()

save() generates a new identifier and INSERT record into a database
The insertion fails if the primary key already exists in the table.
The return type is Serializable which is the newly generated identifier id value as a Serializable object.
This method is used to bring only a transient object to a persistent state.


saveOrUpdate()

Session.saveOrUpdate() can either INSERT or UPDATE based upon existence of a record.
In case the primary key already exists, then the record is updated.
The return type of the saveOrUpdate() method is void.
This method can bring both transient (new) and detached (existing) objects into a persistent state.

 saveOrUpdate() is more flexible in terms of use but it involves extra processing to find out whether a record already exists in the table or not.

get() and load()

load
Only use load() method if you are sure that the object exists. It is used for LAZY loading of entities.
load() method will throw an exception if the unique id is not found in the database.
load() just returns a proxy by default and database won't be hit until the proxy is first invoked.

get
If you are not sure that the object exist.
get() method will return null if the unique id is not found in the database.
get() will hit the database immediately.

If load() can’t find the object in the cache or database, an exception is thrown. The load() method never returns null. 
The get() method returns null if the object can’t be found.

Merge() method can be used for updating existing values.

What happens when the no-args constructor is absent in the Entity bean?

Hibernate framework internally uses Reflection API for creating entity bean instances when get() or load() methods are called. The method Class.newInstance() which requires a no-args constructor to be present. 
So if we don't have this constructor in the entity beans, then hibernate fails to instantiate the bean and hence it throws HibernateException.

Entity class final?

No, we should not define the entity class final because hibernate uses proxy classes and objects for lazy loading of data and hits the database only when it is absolutely needed.


When entity state is Detached?

session.close();
session.clear();
session.detach(record);

Explain Query Cache ?

The query cache is useful for those queries which are most frequently called with the same parameters.
This increases the speed of the data retrieval and greatly improves performance for commonly repetitive queries.

<property name="hibernate.cache.use_query_cache">true</property>

In the code, we need to do the below changes for the query object:
Query query = session.createQuery("from InterviewBitEmployee");


N+1 SELECT problem in Hibernate?
This is due to the result of using lazy loading and on-demand fetching strategy.
If you have an N items list and each item from the list has a dependency on a collection of another object, say bid.
In order to find the highest bid for each item while using the lazy loading strategy, hibernate has to first fire 1 query to load all items and then subsequently fire N queries to load big of each item. Hence, hibernate actually ends up executing N+1 queries.

Solution
Pre-fetch the records in batches which helps us to reduce the problem of N+1 to (N/K) + 1 where K refers to the size of the batch.

concurrency strategies available in hibernate?
Concurrency strategies are the mediators responsible for storing and retrieving items from the cache.
While enabling second-level cache, it is the responsibility of the developer to provide what strategy.

Transactional: If you need a fully transactional cache. Only suitable in a JTA environment.
Read-Only: If your application needs to read, but not modify, instances of a persistent class, a read-only cache can be used.
Read-Write:If the application needs to update data, a read-write cache might be appropriate.
Non-strict-Read-Write: If the application only occasionally needs to update data.


query.setCacheable(true);
query.setCacheRegion("IB_EMP");

session.evict(record);

