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

import gr.hua.dit.erasmus.entity.Application;
import gr.hua.dit.erasmus.entity.Faculty;
import gr.hua.dit.erasmus.entity.Student;
import gr.hua.dit.erasmus.service.ApplicationService;
import gr.hua.dit.erasmus.service.FacultyService;
import gr.hua.dit.erasmus.service.StudentService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private StudentService studentService;

	
	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/list")
	public String listFaculties(Model model) {

		List<Faculty> faculties = facultyService.getFaculties();
		// add the faculties to the model
		model.addAttribute("faculties", faculties);
		// add page title
		model.addAttribute("pageTitle", "Συνεργαζόμενα Τμήματα");
		return "list-faculties";
	}

	@GetMapping("/list/Informatics")
	public String listInformaticsFaculties(Model model) {

		List<Faculty> informaticsFaculties = facultyService.getInformaticsFaculties();
		// add the faculties to the model
		model.addAttribute("faculties", informaticsFaculties);
		// add page title
		model.addAttribute("pageTitle", "Συνεργαζόμενα Τμήματα Πληροφορικής και Τηλεματικής");
		return "list-faculties";
	}

	@GetMapping("/list/HomeEconomics")
	public String listHomeEconomicsFaculties(Model model) {

		List<Faculty> homeEconomicsFaculties = facultyService.getHomeEconomicsFaculties();
		// add the faculties to the model
		model.addAttribute("faculties", homeEconomicsFaculties);
		// add page title
		model.addAttribute("pageTitle", "Συνεργαζόμενα Τμήματα Οικιακής Οικονομίας & Οικολογίας");
		return "list-faculties";
	}

	@GetMapping("/list/HealthScience")
	public String listHealthScienceFaculties(Model model) {

		List<Faculty> healthScienceFaculties = facultyService.getHealthScienceFaculties();
		// add the faculties to the model
		model.addAttribute("faculties", healthScienceFaculties);
		// add page title
		model.addAttribute("pageTitle", "Συνεργαζόμενα Τμήματα Επιστήμης Διαιτολογίας - Διατροφής");
		return "list-faculties";
	}

	@GetMapping("/list/Geography")
	public String listGeographyFaculties(Model model) {

		List<Faculty> geographyFaculties = facultyService.getGeographyFaculties();
		// add the faculties to the model
		model.addAttribute("faculties", geographyFaculties);
		// add page title
		model.addAttribute("pageTitle", "Συνεργαζόμενα Τμήματα Γεωγραφίας");
		return "list-faculties";
	}

	@GetMapping("/{id}")
	public String getFaculty(Model model, @PathVariable("id") int id) {
		
		// get the faculty
		Faculty faculty = facultyService.getFaculty(id);
		model.addAttribute("faculty", faculty);
		return "faculty-form";
	}

	@GetMapping("/addFaculty")
	public String addFaculty(Model model) {

		// create model attribute to get form data
		Faculty faculty = new Faculty();
		model.addAttribute("faculty", faculty);
		model.addAttribute("pageTitle", "Καταχώρηση τμήματος");
		return "faculty-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteFaculty(Model model, @PathVariable("id") int id) {

		facultyService.deleteFaculty(id);
		return "redirect:/faculty/list";
	}

	@PostMapping("/saveFaculty")
	public String saveFaculty(@ModelAttribute("faculty") Faculty faculty) {

		facultyService.saveFaculty(faculty);
		return "redirect:/faculty/list";
	}
	
	
	@GetMapping("/{id}/applications/approved")
	public String getFacultyApprovedApprications(Model model, @PathVariable("id") int id) {
		
		List<Application> approvedApplications = applicationService.getFacultyApprovedApplications(id);
		model.addAttribute("applications", approvedApplications);
		model.addAttribute("pageTitle", "Λίστα κατάταξης συνεργαζόμενου τμήματος");
		return "list-applications";
	}
	
}
