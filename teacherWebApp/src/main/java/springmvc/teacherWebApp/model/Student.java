package springmvc.teacherWebApp.model;

public class Student {
	private String firstName, lastName, fullName;
	private int id;
	private String email;
	private Long gpa;
	
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		if(fullName == null) {
			fullName = firstName + " " + lastName;
		}
		return fullName;
	}
	public void setFullName(String first, String last) {
		this.fullName = first + " " + last;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String teacher) {
		this.email = teacher;
	}
	public Long getGpa() {
		return gpa;
	}
	public void setGpa(Long gpa) {
		this.gpa = gpa;
	}

	
}
