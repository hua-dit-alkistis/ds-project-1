package gr.hua.dit.erasmus.service;

import java.util.List;

import gr.hua.dit.erasmus.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student student);
	
	public Student getStudent(int id);

	public void deleteStudent(int id);
	
}
