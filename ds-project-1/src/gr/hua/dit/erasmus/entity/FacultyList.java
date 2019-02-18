package gr.hua.dit.erasmus.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

@XmlRootElement(name="FacultyList")
@Component
public class FacultyList {
	
	List<Faculty> facultyList;

	public List<Faculty> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(List<Faculty> facultyList) {
		this.facultyList = facultyList;
	}

}
