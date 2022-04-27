package pl.krzysztofskul.person;

import java.util.HashSet;
import java.util.Set;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.healthcareUnit.company.Company;
import pl.krzysztofskul.person.employee.Employee;
import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;

public class PersonGenerator<T> {

	/*
	 * param.
	 */
	
	public static PersonGenerator personGenerator;
	
	private Set<User<T>> demoUsers = new HashSet<User<T>>();
	private Set<Employee> demoEmployees = new HashSet<Employee>();
	private Set<Company<T>> demoCompanies = new HashSet<Company<T>>();

	/*
	 * constr.
	 */
	
	private PersonGenerator() {
		super();
		this.setDemoUsers();
		this.setDemoEmployees();
	}
	
	/*
	 * methods
	 */
	
	public static PersonGenerator getPersonGenerator() {
		if (null == personGenerator) {
			personGenerator = new PersonGenerator();
		}
		return personGenerator;}

	/*
	 * getters and setters and other methods
	 */
	
	public Set<User<T>> getDemoUsers() {
		return demoUsers;
	}
	
	private void setDemoUsers() {
		for (UserRole userRole : UserRole.values()) {
			this.demoUsers.add(new User<T>(
					LoremIpsum.getInstance().getFirstName(),
					LoremIpsum.getInstance().getLastName(),
					LoremIpsum.getInstance().getWords(1),
					LoremIpsum.getInstance().getEmail(),
					LoremIpsum.getInstance().getWords(1),
					userRole,
					null
				)
			);			
		}

	}

	public Set<Employee> getDemoEmployees() {
		return demoEmployees;
	}

	private void setDemoEmployees() {
		// todo
	
	}
	
	
	
	
}
