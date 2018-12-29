package gr.hua.dit.erasmus.dao;

import java.util.List;

import gr.hua.dit.erasmus.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	public void saveStudent(Student student);
	
	public Student getStudent(int id);

	public void deleteStudent(int id);

}

