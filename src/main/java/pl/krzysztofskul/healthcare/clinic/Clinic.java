package pl.krzysztofskul.healthcare.clinic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.healthcare.department.Department;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;

@Entity
public class Clinic extends Healthcare<Clinic> {

	@OneToMany(mappedBy = "healthcareCompany")
	private Set<Department> departments = new HashSet<Department>();
	
	public Clinic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clinic(List employeeList) {
		super(employeeList);
		// TODO Auto-generated constructor stub
	}

	public Clinic(String name, String country, String postalCode, String city, String street, List userList,
			List employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public Clinic(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public Clinic(User user, JobTitleEnum jobTitleEnum) {
		super(user, jobTitleEnum);
		// TODO Auto-generated constructor stub
	}

	public Clinic(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
	
	/**
	 * methods and functions
	 */
	
	public void addDepartment(Department department) {
		this.departments.add(department);
		department.setHealthcareCompany(this);
	}
	
}
