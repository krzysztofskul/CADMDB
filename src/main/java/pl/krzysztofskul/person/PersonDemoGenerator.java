package pl.krzysztofskul.person;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.person.employment.Employment;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;

public class PersonDemoGenerator<T> {

	/*
	 * param.
	 */
	
	public static PersonDemoGenerator personDemoGenerator;
	private static Set<User<Company>> demoUsers = new HashSet<User<Company>>();

	/*
	 * constr.
	 */
	
	private PersonDemoGenerator() {
		super();
		this.setDemoUsers();
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
	
	public Set<User<Company>> getDemoUsers() {
		return demoUsers;
	}
	
	private void setDemoUsers() {
		for (UserRole userRole : UserRole.values()) {
			
			switch (userRole.getCode()) {
				case "ADMIN-DEMO": {
					createAdminDemo(userRole);
					break;				
				}
				case "USER-DEMO": {
					createUserDemo(userRole);
					break;				
				}
						
				default:
					break;
			}
		}

	}
		private void createUserDemo(UserRole userRole) {
		for (JobTitleEnum jobTitleEnum : JobTitleEnum.values()) {
			User user = new User<T>(
					LoremIpsum.getInstance().getFirstName(),
					LoremIpsum.getInstance().getLastName(),
					LoremIpsum.getInstance().getWords(1),
					LoremIpsum.getInstance().getEmail(),
					LoremIpsum.getInstance().getWords(1),
					userRole
			);
			this.demoUsers.add(user);	
		}
	}

	private void createAdminDemo(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}	
	
}
