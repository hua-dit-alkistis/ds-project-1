package gr.hua.dit.erasmus.dao;

import java.util.List;
import gr.hua.dit.erasmus.entity.Faculty;

public interface FacultyDAO {

	public List<Faculty> getFaculties();

	public void saveFaculty(Faculty faculty);
	
	public Faculty getFaculty(int id);

	public void deleteFaculty(int id);
	
	public List<Faculty> getHomeEconomicsFaculties();

	public List<Faculty> getHealthScienceFaculties();

	public List<Faculty> getInformaticsFaculties();

	public List<Faculty> getGeographyFaculties();

}
