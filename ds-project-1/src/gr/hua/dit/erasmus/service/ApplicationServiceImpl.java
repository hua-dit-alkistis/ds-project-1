package gr.hua.dit.erasmus.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.erasmus.dao.ApplicationDAO;
import gr.hua.dit.erasmus.entity.Application;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationDAO applicationDAO;

	@Override
	@Transactional
	public List<Application> getApplications() {
		return applicationDAO.getApplications();
	}

	@Override
	@Transactional
	public void saveApplication(Application application) {
		applicationDAO.saveApplication(application);
	}

	@Override
	@Transactional
	public Application getApplication(int id) {
		return applicationDAO.getApplication(id);
	}

	@Override
	@Transactional
	public void deleteApplication(int id) {
		applicationDAO.deleteApplication(id);

	}

	@Override
	@Transactional
	public List<Application> getApprovedApplications() {
		return applicationDAO.getApprovedApplications();
	}

	@Override
	@Transactional
	public List<Application> getDisapprovedApplications() {
		return applicationDAO.getDisapprovedApplications();
	}

	@Override
	@Transactional
	public List<Application> getUncheckedApplications() {
		return applicationDAO.getUncheckedApplications();
	}
	
	@Override
	@Transactional
	public List<Application> getFacultyApplications(int facultyId) {
		return applicationDAO.getFacultyApplications(facultyId);
	}

	@Override
	@Transactional
	public List<Application> getFacultyApprovedApplications(int facultyId) {
		return applicationDAO.getFacultyApprovedApplications(facultyId);
	}

	@Override
	@Transactional
	public List<Application> getStudentApplications(int studentId) {
		return applicationDAO.getStudentApplications(studentId);
	}
		
}
