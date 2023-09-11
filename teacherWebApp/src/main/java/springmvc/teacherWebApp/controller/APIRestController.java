package springmvc.teacherWebApp.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.teacherWebApp.model.Student;
import springmvc.teacherWebApp.service.TeacherService;

@RestController
@RequestMapping("/student")
public class APIRestController {
	@Autowired
	TeacherService teacherService;
	
	//---Get one student---//
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
		System.out.println("Getting student: "+id);
		Student student = teacherService.getStudent(id);
		if(student == null) {
			System.out.println("student not found.");
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		System.out.println("student found!");
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	//---Get all students---//
	@RequestMapping(value = "/student/", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = teacherService.getAllStudents();
		if(students.isEmpty()) {
			System.out.println("No students in the class.");
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		System.out.println("retrieved student list!");
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	//---Create one student---//
	@RequestMapping(value = "/student/", method = RequestMethod.POST)
	public ResponseEntity<Void> createStudent(@RequestBody Student student, UriComponentsBuilder UcBuilder){
		if(teacherService.studentInThisClass(student)) {
			System.out.println("A student with this ID already exists.");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		teacherService.addStudent(student);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(UcBuilder.path("/student/{id}").buildAndExpand(student.getId()).toUri()); 
		System.out.println("requesting student creation");
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	//---Edit one student---//
	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Student> editStudent(@PathVariable("id") int id, @RequestBody Student student){
		System.out.println("Editing student "+id);
		Student existingStudent = teacherService.getStudent(id);
		if(existingStudent == null) {
			System.out.println("no such user to edit");
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		// add other fields to update
		teacherService.editStudent(existingStudent);
		return new ResponseEntity<Student>(existingStudent, HttpStatus.OK);
	}
	//---Delete one student---//
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
		System.out.println("Deleting student with id: "+id);
		Student student = teacherService.getStudent(id);
		if(student == null) {
			System.out.println("No student with matching id to delete");
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		teacherService.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	//---Delete all students---//
    @RequestMapping(value = "/student/", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllStudents(){
		System.out.println("Deleting all student records");
		teacherService.deleteAllStudents();
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
    
}
