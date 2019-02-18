package gr.hua.dit.erasmus.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gr.hua.dit.erasmus.date.DateUtils;

@Entity
@Table(name = "application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "date_of_submission")
	@Temporal(TemporalType.DATE)
	private Date dateOfSubmission;
	@Column(name = "current_semester")
	private String currentSemester;
	@Column(name = "department")
	private String department;
	@Column(name = "name_of_faculty")
	private String nameOfFaculty;
	@Column(name = "language_certification")
	private String languageCertification;
	@Column(name = "status")
	private String status;
/*	@Column(name = "student_id")
	private int studentId;
	@Column(name = "faculty_id")
	private int facultyId;
*/
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "faculty_id")
	@JsonIgnore
	private Faculty faculty;

	public Application() {

	}

	public Application(Date dateOfSubmission, String currentSemester, String department, String nameOfFaculty,
		String languageCertification, String status) {
	super();
	this.dateOfSubmission = dateOfSubmission;
	this.currentSemester = currentSemester;
	this.department = department;
	this.nameOfFaculty = nameOfFaculty;
	this.languageCertification = languageCertification;
	this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfSubmission() {
		return dateOfSubmission;
	}

	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public String getCurrentSemester() {
		return currentSemester;
	}

	public void setCurrentSemester(String currentSemester) {
		this.currentSemester = currentSemester;
	}

	public String getNameOfFaculty() {
		return nameOfFaculty;
	}

	public void setNameOfFaculty(String nameOfFaculty) {
		this.nameOfFaculty = nameOfFaculty;
	}

	public String getLanguageCertification() {
		return languageCertification;
	}

	public void setLanguageCertification(String languageCertification) {
		this.languageCertification = languageCertification;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", dateOfSubmission=" + dateOfSubmission + ", currentSemester="
				+ currentSemester + ", department=" + department + ", nameOfFaculty=" + nameOfFaculty
				+ ", languageCertification=" + languageCertification + ", status=" + status + ", student=" + student + ", faculty=" + faculty
				+ "]";
	}

}

