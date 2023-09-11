package springmvc.teacherWebApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.springframework.stereotype.Service;
import springmvc.teacherWebApp.model.Student;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	private static List<Student> myClass;
	static {
		myClass = new ArrayList<Student>();
		myClass.add(new Student("Helen","C",1));
	    myClass.add(new Student("Julie","A",2));
	    myClass.add(new Student("Nate","G",3));
	    myClass.add(new Student("Will","H",4));
	    myClass.add(new Student("Bill","E",5));
    }
	private static int counter = myClass.size();

	
	@Override
	public Student getStudent(int id) {
		for(Student student : myClass) {
			if(student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return myClass;
	}

	@Override
	public void addStudent(Student student) {
		student.setId(counter+1);
		counter+=1;
		myClass.add(student);
	}

	@Override
	public void editStudent(Student student) {
		int index = myClass.indexOf(student);
		myClass.set(index, student);
	}

	@Override
	public void deleteStudent(int id) {
		for(Iterator<Student> iterator = myClass.iterator(); iterator.hasNext();) {
			Student student = iterator.next();
			if(student.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteAllStudents() {
		myClass.clear();
	}

	@Override
	public boolean studentInThisClass(Student student) {
		return getStudent(student.getId()) != null;
	}

}
