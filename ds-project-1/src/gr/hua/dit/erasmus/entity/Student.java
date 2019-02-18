package gr.hua.dit.erasmus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "department")
	private String department;
	@Column(name = "name_of_father")
	private String nameOfFather;
	@Column(name = "year_of_registration")
	private String yearOfRegistration;
	@Column(name = "year_of_birth")
	private String yearOfBirth;
	@Column(name = "number_of_remaining_classes")
	private int numberOfRemainingClasses;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<Application> applications;

	public Student() {

	}

	public Student(String lastName, String firstName, String username, String email, String department,
			String nameOfFather, String yearOfRegistration, String yearOfBirth, int numberOfRemainingClasses) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.email = email;
		this.department = department;
		this.nameOfFather = nameOfFather;
		this.yearOfRegistration = yearOfRegistration;
		this.yearOfBirth = yearOfBirth;
		this.numberOfRemainingClasses = numberOfRemainingClasses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNameOfFather() {
		return nameOfFather;
	}

	public void setNameOfFather(String nameOfFather) {
		this.nameOfFather = nameOfFather;
	}

	public String getYearOfRegistration() {
		return yearOfRegistration;
	}

	public void setYearOfRegistration(String yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getNumberOfRemainingClasses() {
		return numberOfRemainingClasses;
	}

	public void setNumberOfRemainingClasses(int numberOfRemainingClasses) {
		this.numberOfRemainingClasses = numberOfRemainingClasses;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	// add convenience methods for bi-directional relation
	public void add(Application anApplication) {
		if (applications == null) {
			applications = new ArrayList<>(3);
		}
		applications.add(anApplication);
		anApplication.setStudent(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", username=" + username
				+ ", email=" + email + ", department=" + department + ", nameOfFather=" + nameOfFather
				+ ", yearOfRegistration=" + yearOfRegistration + ", yearOfBirth=" + yearOfBirth
				+ ", numberOfRemainingClasses=" + numberOfRemainingClasses + "]";
	}

}

