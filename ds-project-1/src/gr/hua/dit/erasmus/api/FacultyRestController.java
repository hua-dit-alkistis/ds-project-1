package gr.hua.dit.erasmus.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import gr.hua.dit.erasmus.entity.Faculty;
import gr.hua.dit.erasmus.entity.FacultyList;
import gr.hua.dit.erasmus.service.FacultyService;

@RestController
@RequestMapping("/api/faculty")
public class FacultyRestController {
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyList facultyList;
	
	// 200 OK
	@RequestMapping(value = "/{facultyId}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Faculty getFaculty(@PathVariable("facultyId") int facultyId) {
		Faculty faculty = facultyService.getFaculty(facultyId);
		return faculty;
	}

	// 200 OK but list is null
	@RequestMapping(value = "/list/{department}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public FacultyList getDepartmentFaculties(@PathVariable("department") String department) {
		if (department == "Informatics") {
			List<Faculty> faculties = facultyService.getInformaticsFaculties();
			System.out.println("Informatics faculties" + faculties);
			this.facultyList.setFacultyList(faculties);
		} 
		else if (department == "HomeEconomics") {
			List<Faculty> faculties = facultyService.getHomeEconomicsFaculties();
			System.out.println("Home Economics faculties" + faculties);
			this.facultyList.setFacultyList(faculties);
		}
		else if (department == "HealthScience") {
			List<Faculty> faculties = facultyService.getHealthScienceFaculties();
			System.out.println("Health Science faculties" + faculties);
			this.facultyList.setFacultyList(faculties);
		}
		else if (department == "Geaography") {
			List<Faculty> faculties = facultyService.getGeographyFaculties();
			System.out.println("Geography faculties" + faculties);
			this.facultyList.setFacultyList(faculties);
		}
		return this.facultyList;
	}

}
