package pl.krzysztofskul.person;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.person.employee.Employee;
import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;

public class PersonDemoGenerator<T> {

	/*
	 * param.
	 */
	
	public static PersonDemoGenerator personDemoGenerator;
	
	private Set<User<T>> demoUsers = new HashSet<User<T>>();
	private Set<Employee> demoEmployees = new HashSet<Employee>();

	/*
	 * constr.
	 */
	
	private PersonDemoGenerator() {
		super();
		this.setDemoUsers();
		this.setDemoEmployees();
	}
	
	/*
	 * methods
	 */
	
	public static PersonDemoGenerator getPersonGenerator() {
		if (null == personDemoGenerator) {
			personDemoGenerator = new PersonDemoGenerator();
		}
		return personDemoGenerator;}

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
