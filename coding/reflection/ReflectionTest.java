package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

	//Class<?> c=Class.forName("reflection.Student");
	 Class<?> c=Student.class;
	 
	 Constructor<?> constructor = c.getConstructor();
	 System.out.println("constructor: "
             + constructor.getName());
	
	 
	 Method[] methods = c.getMethods();

     for (Method method : methods) {
         System.out.println(method.getName());
     }
     
     Student s=(Student)c.newInstance();  
     
     Method methodcall=c.getDeclaredMethod("setStudentId", int.class);

     // Invoking the method at runtime
     methodcall.invoke(s,10);
     
     Field field = c.getDeclaredField("studentName");
     field.set(s, "Raghu");
     
     Method methodcall1
     = c.getDeclaredMethod("getStudentName");

      methodcall1.invoke(s);
      
     //Reflection breaks the encapsulation as we can access private members.
     Field field1 = c.getDeclaredField("studentId"); 
     field1.setAccessible(true);
	 field1.set(s, 101);
	 
	 Method methodcall2=c.getDeclaredMethod("getStudentId");
	 methodcall2.invoke(s);

	}

}