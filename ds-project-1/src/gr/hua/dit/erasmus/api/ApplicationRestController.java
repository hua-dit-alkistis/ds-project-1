package gr.hua.dit.erasmus.api;

import java.util.Date;

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
@RequestMapping("/api/application")
public class ApplicationRestController {

	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	StudentService studentService;

	// 400 Bad Request 
	@RequestMapping(value = "/submit", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Application submitApplication(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("studentId") int studentId,
			@RequestParam("email") String email, @RequestParam("currentSemester") String currentSemester, @RequestParam("department") String department,
			@RequestParam("nameOfFaculty") String nameOfFaculty, @RequestParam("languageCertification") String languageCertification) {
        Student student = studentService.getStudent(studentId);
		Application application = new Application(null, currentSemester, department, nameOfFaculty, languageCertification, "unchecked");
		if (student.getLastName() == "lastName" && student.getFirstName() == "firstName" && student.getEmail() == "email" && student.getNumberOfRemainingClasses() <= 5) {
			application.setStudent(student);

		} else {
			application.setStatus("disapproved");
		} 
		applicationService.saveApplication(application);
		return application;
	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Application createApplicationfromJson(@RequestBody Application application) {
		applicationService.saveApplication(application);
		return application;
	}

}
