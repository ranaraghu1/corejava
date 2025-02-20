package test.reflection;

public class Student {
	private int studentId;
	public String studentName;
	
	public Student() {
		super();
	}

	
	public Student(String studentName) {
		super(); this.studentName = studentName;
	  }
	 
	public int getStudentId() {
		System.out.println("student id : "+studentId);
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
		System.out.println("student id: "+studentId);
	}
	public String getStudentName() {
		System.out.println("student name: "+studentName);
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
		
	}
	
	

}
