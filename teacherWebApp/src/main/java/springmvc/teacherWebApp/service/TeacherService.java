package springmvc.teacherWebApp.service;

import java.util.List;
import springmvc.teacherWebApp.model.Student;

public interface TeacherService {
	Student getStudent(int id);
	List<Student> getAllStudents();
	void addStudent(Student student);
	void editStudent(Student student);
	void deleteStudent(int id);
	void deleteAllStudents();
	public boolean studentInThisClass(Student student);
}
