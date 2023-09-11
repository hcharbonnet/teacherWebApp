package springmvc.teacherWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.teacherWebApp.model.Student;

@Controller
@RequestMapping("/registration") // maps to form.jsp
public class StudentController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String studentResult(Model model, Student student) {
		
		System.out.println("Student Name: " + student.getFullName());
		System.out.println("Student ID: " + student.getId());
		System.out.println("Student Email: " + student.getEmail());
		System.out.println("Student GPA: " + student.getGpa());

		model.addAttribute(student); // sending student to UI
		
		return "showRegistration"; // jsp page in view
	}
}
