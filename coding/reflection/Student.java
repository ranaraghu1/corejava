package reflection;

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
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	

}
