package gr.hua.dit.erasmus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.erasmus.entity.Application;
import gr.hua.dit.erasmus.entity.Faculty;
import gr.hua.dit.erasmus.entity.Student;
import gr.hua.dit.erasmus.service.ApplicationService;
import gr.hua.dit.erasmus.service.FacultyService;
import gr.hua.dit.erasmus.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String listStudents(Model model) {

		List<Student> students = studentService.getStudents();
		// add the students to the model
		model.addAttribute("students", students);
		// add page title
		model.addAttribute("pageTitle", "Λίστα φοιτητών");
		return "list-students";
	}

	@GetMapping("/{id}")
	public String getStudent(Model model, @PathVariable("id") int id) {
		
		Student student = studentService.getStudent(id);
		model.addAttribute("student", student);		
		return "student-form";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		
		// create model attribute to get form data
		Student student = new Student();		
		model.addAttribute("student", student);		
		// add page title
		model.addAttribute("pageTitle", "Καταχώρηση φοιτητή");		
		return "student-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(Model model, @PathVariable("id") int id) {
		
		studentService.deleteStudent(id);		
		return "redirect:/student/list";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);		
		return "redirect:/student/list";
	}

}