package gr.hua.dit.erasmus.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.erasmus.dao.FacultyDAO;
import gr.hua.dit.erasmus.entity.Faculty;

@Service
public class FacultyServiceImpl implements FacultyService {
	
	@Autowired
	private FacultyDAO facultyDAO;

	@Override
	@Transactional
	public List<Faculty> getFaculties() {
		return facultyDAO.getFaculties();
	}

	@Override
	@Transactional
	public void saveFaculty(Faculty faculty) {
		facultyDAO.saveFaculty(faculty);

	}

	@Override
	@Transactional
	public Faculty getFaculty(int id) {
		return facultyDAO.getFaculty(id);
	}

	@Override
	@Transactional
	public void deleteFaculty(int id) {
		facultyDAO.deleteFaculty(id);
	}

	@Override
	@Transactional
	public List<Faculty> getHomeEconomicsFaculties() {
		return facultyDAO.getHomeEconomicsFaculties();
	}

	@Override
	@Transactional
	public List<Faculty> getHealthScienceFaculties() {
		return facultyDAO.getHealthScienceFaculties();
	}

	@Override
	@Transactional
	public List<Faculty> getInformaticsFaculties() {
		return facultyDAO.getInformaticsFaculties();
	}

	@Override
	@Transactional
	public List<Faculty> getGeographyFaculties() {
		return facultyDAO.getGeographyFaculties();
	}

	@Override
	@Transactional
	public List<Faculty> getStudentFaculties(String department) {
		return facultyDAO.getStudentFaculties(department);
	}
	
}
