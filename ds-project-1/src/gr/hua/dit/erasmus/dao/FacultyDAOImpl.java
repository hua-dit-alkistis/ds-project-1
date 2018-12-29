package gr.hua.dit.erasmus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.erasmus.entity.Faculty;

@Repository
public class FacultyDAOImpl implements FacultyDAO {
	
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Faculty> getFaculties() {
		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();      
        // create a query
        Query<Faculty> query = currentSession.createQuery("from Faculty", Faculty.class);    
        // execute the query and get the results list
        List<Faculty> faculties = (List<Faculty>) query.getResultList();                       
        //return the results
        return faculties;   	
	}
	
	@Override
	public List<Faculty> getInformaticsFaculties() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Faculty> query = currentSession.createQuery("from Faculty where department='Informatics'", Faculty.class);
        List<Faculty> informaticsFaculties = (List<Faculty>) query.getResultList();
        return informaticsFaculties;   	
	}
	
	@Override
	public List<Faculty> getHomeEconomicsFaculties() {
		
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Faculty> query = currentSession.createQuery("from Faculty where department='Home Economics'", Faculty.class);
        List<Faculty> homeEconomicsFaculties = (List<Faculty>) query.getResultList();
        return homeEconomicsFaculties;   
	}
	
	@Override
	public List<Faculty> getHealthScienceFaculties() {
		
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Faculty> query = currentSession.createQuery("from Faculty where department='Health Science'", Faculty.class);
        List<Faculty> healthScienceFaculties = (List<Faculty>) query.getResultList();
        return healthScienceFaculties;   
	}
	
	@Override
	public List<Faculty> getGeographyFaculties() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Faculty> query = currentSession.createQuery("from Faculty where department='Geography'", Faculty.class);
        List<Faculty> geographyFaculties = (List<Faculty>) query.getResultList();
        return geographyFaculties;   
	}
	
	@Override
	public void saveFaculty(Faculty faculty) {

   		Session currentSession = sessionFactory.getCurrentSession();
		if (faculty.getId() != 0) {			
			currentSession.update(faculty);			
		} else {			
			currentSession.save(faculty);
		}
	}

	@Override
	public Faculty getFaculty(int id) {
		
   		Session currentSession = sessionFactory.getCurrentSession();   		 		
   		Faculty faculty = currentSession.get(Faculty.class, id);
    	return faculty;
	}

	@Override
	public void deleteFaculty(int id) {
		
   		Session currentSession = sessionFactory.getCurrentSession();
   		Faculty faculty = currentSession.get(Faculty.class, id);
   		currentSession.delete(faculty);
	}

	@Override
	public List<Faculty> getStudentFaculties(String department) {
		
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Faculty> query = currentSession.createQuery("from Faculty where department= " +department, Faculty.class);
        List<Faculty> faculties = (List<Faculty>) query.getResultList();
        return faculties; 
	}
	
}
