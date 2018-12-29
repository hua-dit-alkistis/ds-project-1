package gr.hua.dit.erasmus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.erasmus.entity.Secretary;

@Repository
public class SecretaryDAOImpl implements SecretaryDAO {
	
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Secretary> getMembers() {
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Secretary> query = currentSession.createQuery("from Secretary", Secretary.class);
      
        // execute the query and get the results list
        List<Secretary> members = (List<Secretary>) query.getResultList();
                        
        //return the results
        return members;   	
	}

	@Override
	public void saveMember(Secretary member) {
		// get current hibernate session
   		Session currentSession = sessionFactory.getCurrentSession();
   		
		if (member.getId() != 0) {
			// update the member
			currentSession.update(member);			
		} else {
			// save the member
			currentSession.save(member);
		}
	}

	@Override
	public Secretary getMember(int id) {
		// get current hibernate session
   		Session currentSession = sessionFactory.getCurrentSession();
    		
   		Secretary member = currentSession.get(Secretary.class, id);
    	return member;
	}

	@Override
	public void deleteMember(int id) {
		// get current hibernate session
   		Session currentSession = sessionFactory.getCurrentSession();

   		Secretary member = currentSession.get(Secretary.class, id);

   		currentSession.delete(member);
	}

}
