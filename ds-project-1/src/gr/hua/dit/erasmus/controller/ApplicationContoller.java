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
import gr.hua.dit.erasmus.service.ApplicationService;
import gr.hua.dit.erasmus.service.StudentService;

@Controller
@RequestMapping("/application")
public class ApplicationContoller {

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private StudentService studentService;
	

	@GetMapping("/list")
	public String listApplications(Model model) {

		List<Application> applications = applicationService.getApplications();
		// add the applications to the model
		model.addAttribute("applications", applications);
		// add page title
		model.addAttribute("pageTitle", "Λίστα Δηλώσεων");
		return "list-applications";
	}

	@GetMapping("/list/approved")
	public String listApprovedApplications(Model model) {

		List<Application> approvedApplications = applicationService.getApprovedApplications();
		model.addAttribute("applications", approvedApplications);
		model.addAttribute("pageTitle", "Εγκεκριμένες Δηλώσεις");
		return "list-applications";
	}

	@GetMapping("/list/disapproved")
	public String listDisapprovedApplications(Model model) {

		List<Application> disapprovedApplications = applicationService.getDisapprovedApplications();
		model.addAttribute("applications", disapprovedApplications);
		model.addAttribute("pageTitle", "Μη εγκεκριμένες Δηλώσεις");
		return "list-applications";
	}

	@GetMapping("/list/unchecked")
	public String listUncheckedApplications(Model model) {
		
		List<Application> uncheckedApplications = applicationService.getUncheckedApplications();
		model.addAttribute("applications", uncheckedApplications);
		model.addAttribute("pageTitle", "Υπό έλεγχο");
		return "list-applications";
	}

	@GetMapping("/{id}")
	public String getApplication(Model model, @PathVariable("id") int id) {

		Application application = applicationService.getApplication(id);
		model.addAttribute("application", application);
		return "application-form";
	}
	
	@GetMapping("/student/{id}/list")
	public String listStudentApplications(Model model, @PathVariable("id") int id) {

		List<Application> applications = applicationService.getStudentApplications(id);
		model.addAttribute("applications", applications);
		model.addAttribute("pageTitle", "Δηλώσεις Φοιτητή");
		return "list-applications";
	}
	
	@GetMapping("/faculty/{id}/list")
	public String listFacultyApplications(Model model, @PathVariable("id") int id) {

		List<Application> applications = applicationService.getFacultyApplications(id);
		model.addAttribute("applications", applications);
		model.addAttribute("pageTitle", "Δηλώσεις τμήματος");
		return "list-applications";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteApplication(Model model, @PathVariable("id") int id) {
		
		applicationService.deleteApplication(id);
		return "redirect:/application/list";
	}
	
/*	@GetMapping("/submitApplication/")
	public String submitApplication(Model model) {
		
		Application application = new Application();
		model.addAttribute("application", application);
		model.addAttribute("pageTitle", "Υποβολή Δήλωσης");
		return "application-form";
	}

	@PostMapping("/saveApplication")
	public String saveApplication(@ModelAttribute("application") Application application) {

		applicationService.saveApplication(application);
		return "redirect:/application/list";
	}
*/

}
