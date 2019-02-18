package gr.hua.dit.erasmus.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.erasmus.entity.Application;
import gr.hua.dit.erasmus.entity.Student;
import gr.hua.dit.erasmus.service.ApplicationService;
import gr.hua.dit.erasmus.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	// 200 OK
	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Student getStudent(@PathVariable("studentId") int studentId) {
		Student student = studentService.getStudent(studentId);
		System.out.println("student :" + student);
		return student;
	}
	
	
	
}
