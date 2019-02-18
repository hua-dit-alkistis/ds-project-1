package gr.hua.dit.erasmus.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.erasmus.entity.Application;
import gr.hua.dit.erasmus.entity.Faculty;
import gr.hua.dit.erasmus.entity.Student;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Application> getApplications() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Application> query = currentSession.createQuery("from Application", Application.class);
		List<Application> applications = (List<Application>) query.getResultList();
		return applications;
	}

	@Override
	public void saveApplication(Application application) {
		
		Session currentSession = sessionFactory.getCurrentSession();				
		currentSession.update(application);			
	}

	@Override
	public Application getApplication(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Application application = currentSession.get(Application.class, id);
		return application;
	}

	@Override
	public void deleteApplication(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(id);

	}

	@Override
	public List<Application> getApprovedApplications() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Application> query = currentSession.createQuery("from Application where status='approved'",
				Application.class);
		List<Application> approvedApplications = (List<Application>) query.getResultList();
		return approvedApplications;
	}

	@Override
	public List<Application> getDisapprovedApplications() {
	
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Application> query = currentSession.createQuery("from Application where status='disapproved'",
				Application.class);
		List<Application> disapprovedApplications = (List<Application>) query.getResultList();
		return disapprovedApplications;
	}

	@Override
	public List<Application> getUncheckedApplications() {
	
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Application> query = currentSession.createQuery("from Application where status='unchecked'",
				Application.class);
		List<Application> uncheckedApplications = (List<Application>) query.getResultList();
		return uncheckedApplications;
	}

	@Override
	public List<Application> getStudentApplications(int studentId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Student student = (Student) currentSession.createQuery("from  Student where id = " +studentId).getSingleResult();
		System.out.println(student.getApplications());
		return student.getApplications();
	}
	
	@Override
	public List<Application> getFacultyApplications(int facultyId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Faculty faculty = (Faculty) currentSession.createQuery("from  Faculty where id = " +facultyId).getSingleResult();
		System.out.println(faculty.getApplications());
		return faculty.getApplications();
	}

	@Override
	public List<Application> getFacultyApprovedApplications(int facultyId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Faculty faculty = (Faculty) currentSession.createQuery("from  Faculty where id = " +facultyId).getSingleResult();
		List<Application> applications = faculty.getApprovedApplications();
		return applications;
	} 
}

