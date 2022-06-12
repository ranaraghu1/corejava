package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

	//Class<?> c=Class.forName("reflection.Student");
	 Class<?> c=Student.class;
	 

	 Constructor<?> constructor = c.getConstructor();
	 System.out.println("constructor: "
             + constructor.getName());
	 
	 //Constructor<?> constructor1 = c.getConstructor(int.class);
	 Object obj = constructor.newInstance();
	 

	 Method[] methods = c.getMethods();

     for (Method method : methods) {
         System.out.println(method.getName());
     }

     
     Method methodcall
     = c.getDeclaredMethod("getStudentId",null);
    // Invoking the method at runtime
     System.out.println(methodcall.invoke(obj,null));
	
	}

}