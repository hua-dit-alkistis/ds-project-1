package gr.hua.dit.erasmus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	@GetMapping("/qualification")
	public String showQualification() {
		return "qualification";
	}
	@GetMapping("/departments")
	public String showDepartments() {
		return "departments";
	}
}