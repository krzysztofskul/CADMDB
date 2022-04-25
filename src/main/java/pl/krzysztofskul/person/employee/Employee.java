package pl.krzysztofskul.person.employee;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import pl.krzysztofskul.person.Person;
import pl.krzysztofskul.person.user.User;

@Entity
public class Employee extends Person {

	// todo: change for Company.class
	//@ManyToOne
	private String company;
	
	// todo: change for JobTitle.enum
	private String jobTitle;
	
	@OneToOne(mappedBy = "employee")
	private User user;

	public Employee() {
		super();
	}

	public Employee(String company, String jobTitle, User user) {
		super();
		this.company = company;
		this.jobTitle = jobTitle;
		this.user = user;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
