package pl.krzysztofskul.person;

import java.util.HashSet;
import java.util.Set;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;

public class PersonGenerator {

	private static PersonGenerator personGenerator;
	
	private Set<User> demoUsers = new HashSet<User>();

	private PersonGenerator() {
		super();
	}
	
	public PersonGenerator getPersonGenerator() {
		if (null == personGenerator) {
			personGenerator = new PersonGenerator();
		}
		return personGenerator;}

	public Set<User> getDemoUsers() {
		return demoUsers;
	}

	public void setDemoUsers() {
		for (UserRole userRole : UserRole.values()) {
			demoUsers.add(new User(
					LoremIpsum.getInstance().getName(),
					LoremIpsum.getInstance().getEmail(),
					LoremIpsum.getInstance().getWords(1),
					userRole
				)
			);			
		}

	}
	
	
	
}
