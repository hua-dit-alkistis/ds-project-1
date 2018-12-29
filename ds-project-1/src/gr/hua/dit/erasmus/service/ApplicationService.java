package gr.hua.dit.erasmus.service;

import java.util.List;

import gr.hua.dit.erasmus.entity.Application;

public interface ApplicationService {
	
	public List<Application> getApplications();

	public void saveApplication(Application application);
	
	public Application getApplication(int id);

	public void deleteApplication(int id);
	
	public List<Application> getApprovedApplications();
	
	public List<Application> getDisapprovedApplications();
	
	public List<Application> getUncheckedApplications();
	
	public List<Application> getFacultyApplications(int facultyId);
	
	public List<Application> getFacultyApprovedApplications(int facultyId);

	public List<Application> getStudentApplications(int studentId);
	
}
