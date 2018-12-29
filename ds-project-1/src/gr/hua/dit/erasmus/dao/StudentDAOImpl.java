package gr.hua.dit.erasmus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.erasmus.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> query = currentSession.createQuery("from Student", Student.class);
		List<Student> students = (List<Student>) query.getResultList();
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		if (student.getId() != 0) {
			// update the student
			currentSession.update(student);			
		} else {
			// save the student
			currentSession.save(student);
		}
	}

	@Override
	public Student getStudent(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	@Override
	public void deleteStudent(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		// find the student
		Student student = currentSession.get(Student.class, id);
		// delete student
		currentSession.delete(student);
	}

}
