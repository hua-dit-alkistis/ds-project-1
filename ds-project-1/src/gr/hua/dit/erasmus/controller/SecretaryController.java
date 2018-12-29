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

import gr.hua.dit.erasmus.entity.Secretary;
import gr.hua.dit.erasmus.service.SecretaryService;

@Controller
@RequestMapping("/secretary")
public class SecretaryController {

	@Autowired
	private SecretaryService secretaryService;

	@GetMapping("/list")
	public String listMembers(Model model) {

		List<Secretary> members = secretaryService.getMembers();
		// add the members to the model
		model.addAttribute("members", members);
		// add page title
		model.addAttribute("pageTitle", "Μέλη γραμματείας");
		return "list-members";
	}

	@GetMapping("/{id}")
	public String getMember(Model model, @PathVariable("id") int id) {
		
		Secretary member = secretaryService.getMember(id);
		model.addAttribute("member", member);
		return "secretary-form";
	}

	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		Secretary member = new Secretary();
		model.addAttribute("member", member);
		model.addAttribute("pageTitle", "Καταχώρηση μέλους γραμματείας");
		return "secretary-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteMember(Model model, @PathVariable("id") int id) {
		
		secretaryService.deleteMember(id);
		return "redirect:/secretary/list";
	}

	@PostMapping("/saveMember")
	public String saveMember(@ModelAttribute("member") Secretary member) {

		secretaryService.saveMember(member);
		return "redirect:/secretary/list";
	}
	
}
