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
@Table(name = "faculty")
public class Faculty {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "university")
	private String university;
	@Column(name = "department")
	private String department;
	@Column(name = "country")
	private String country;
	@Column(name = "city")
	private String city;
	@Column(name = "language")
	private String language;
	@Column(name = "total_number_of_spots")
	private int totalNumberOfSpots;
	@Column(name = "number_of_spots_available")
	private int numberOfSpotsAvailable;
	@Column(name = "contact_info")
	private String contactInfo;
	
	//mappedBy = "faculty"
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "faculty_id")
	private List<Application> applications;

	public Faculty() {

	}
	
	public Faculty(String name, String university, String department, String country, String city, String language,
			int totalNumberOfSpots, int numberOfSpotsAvailable, String contactInfo) {
		super();
		this.name = name;
		this.university = university;
		this.department = department;
		this.country = country;
		this.city = city;
		this.language = language;
		this.totalNumberOfSpots = totalNumberOfSpots;
		this.numberOfSpotsAvailable = numberOfSpotsAvailable;
		this.contactInfo = contactInfo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getTotalNumberOfSpots() {
		return totalNumberOfSpots;
	}
	public void setTotalNumberOfSpots(int totalNumberOfSpots) {
		this.totalNumberOfSpots = totalNumberOfSpots;
	}
	public int getNumberOfSpotsAvailable() {
		return numberOfSpotsAvailable;
	}
	public void setNumberOfSpotsAvailable(int numberOfSpotsAvailable) {
		this.numberOfSpotsAvailable = numberOfSpotsAvailable;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
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
			applications = new ArrayList<>();
		}
		applications.add(anApplication);
		anApplication.setFaculty(this);
	}

	
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", university=" + university + ", department=" + department
				+ ", country=" + country + ", city=" + city + ", language=" + language + ", totalNumberOfSpots="
				+ totalNumberOfSpots + ", numberOfSpotsAvailable=" + numberOfSpotsAvailable + ", contactInfo="
				+ contactInfo + "]";
	}

	
}

