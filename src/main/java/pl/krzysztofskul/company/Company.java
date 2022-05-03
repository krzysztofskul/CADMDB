package pl.krzysztofskul.company;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;


import pl.krzysztofskul.person.employment.Employment;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;

//@MappedSuperclass
//@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Company<T> {

	/*
	 * param.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	// todo: create @OneToOne AddressDeitails.class
	private String country;
	private String postalCode;
	private String city;
	private String street;
	private String streetNo;

	// todo: create @OneToOne ContactDeitails.class
	private String www;
	private String email;
	private String phoneNo;

	@OneToMany(mappedBy="company")
	private List<User<T>> userList = new ArrayList<User<T>>();
	
	@OneToMany(mappedBy="company")
	private List<Employment<T>> employeeList = new ArrayList<Employment<T>>();

	/*
	 * constr.
	 */
	
	public Company() {
		super();
	}
	
	public <T> Company(User user) {
		super();
	}
	
	public <T> Company(User user, JobTitleEnum jobTitleEnum) {
		super();
		this.addUser(user, jobTitleEnum);
		
	}
	
	public Company(List<Employment<T>> employeeList) {
		super();
		this.employeeList = employeeList;
	}

	public Company(String name, String country, String postalCode, String city, String street, String streetNo) {
		super();
		this.name = name;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.street = street;
		this.streetNo = streetNo;
	}



	public Company(String name, String country, String postalCode, String city, String street, List<User<T>> userList,
			List<Employment<T>> employeeList) {
		super();
		this.name = name;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.street = street;
		this.employeeList = employeeList;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getWww() {
		return www;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<User<T>> getUserList() {
		return userList;
	}

	public void setUserList(List<User<T>> userList) {
		this.userList = userList;
	}

	public List<Employment<T>> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employment<T>> employeeList) {
		this.employeeList = employeeList;
	}
	
	/*
	 * func.
	 */
	
	public void addUser(User<T> user, JobTitleEnum jobTitleEnum) {
		user.getEmployment().setCompany(this);
		user.getEmployment().setJobTitle(jobTitleEnum);;
		this.userList.add(user);
		user.getEmployment().setCompany(this);
	}
	
	
}
