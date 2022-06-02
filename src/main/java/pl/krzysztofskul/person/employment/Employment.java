package pl.krzysztofskul.person.employment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.person.Person;
import pl.krzysztofskul.person.PersonDemoGenerator;
import pl.krzysztofskul.person.user.User;

@Entity
public class Employment<T> {

	/*
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = Healthcare.class)
	private T company;
	
	private JobTitleEnum jobTitle;
	
	@OneToOne(mappedBy = "employment")
	private User user;

	/*
	 * constr.
	 */
	
	public Employment() {
		super();
	}
	
	public Employment(User user) {
		super();
		this.user = user;
	}

	public Employment(T company, JobTitleEnum jobTitle, User user) {
		super();
		this.company = company;
		this.jobTitle = jobTitle;
		this.user = user;
	}

	/*
	 * getters and setters
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public T getCompany() {
		return company;
	}

	public void setCompany(T company) {
		this.company = company;
	}

	public JobTitleEnum getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitleEnum jobTitle) {
		this.jobTitle = jobTitle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
