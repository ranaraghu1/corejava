package test.creational.designpattern;

class User{
	private int userId;
	private String userName;
	private String email;
	
	private User(EmployeeBuilder builder) {
		this.userId=builder.userId;
		this.userName=builder.userName;
		this.email=builder.email;
	}


	
	
	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}




	static class EmployeeBuilder{
		private int userId;
		private String userName;
		private String email;
		
		
		public EmployeeBuilder() {
			
		}
		
		public EmployeeBuilder setUserId(int userId) {
			this.userId = userId;
			return this;
		}
		public EmployeeBuilder setUserName(String userName) {
			this.userName = userName;
			return this;
		}
		public EmployeeBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public User build() {
			User e=new User(this);
			return e;
		}
		
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + "]";
	}

	//toString of Employee class
	
	
	
}



public class BuilderDesignPatternTest {
	public static void main(String args[]) {
	User e= new User.EmployeeBuilder().setEmail("rana@gmail.com").setUserId(101).build();
	System.out.println(e.toString());
	}

}
