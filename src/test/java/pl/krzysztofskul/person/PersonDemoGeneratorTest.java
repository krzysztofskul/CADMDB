package pl.krzysztofskul.person;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.company.CompanyDemoGenerator;
import pl.krzysztofskul.person.employment.Employment;
import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDemoGeneratorTest<T> {

	@Test
	public void test01_GetPersonGenerator() {
		PersonDemoGenerator.getPersonGenerator();
		assertTrue(PersonDemoGenerator.personDemoGenerator != null);
	}
	
	@Test
	public void test02_SetDemoUsers() {
		
	}
	
	@Test
	public void test03_GetDemoUsers() {
		assertTrue(PersonDemoGenerator.getPersonGenerator().getDemoUsers() != null);
		assertTrue(PersonDemoGenerator.getPersonGenerator().getDemoUsers().size() > 0);
		System.out.println("---------- DEMO USERS -------------");
		
		Set<User<T>> users = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : users) {
			System.out.println(
					"-------------\n" +
					user.getNameFirst()+" "+user.getNameLast()+
					"\n\t"+user.getNickname()+
					"\n\t"+user.getUserRole().getCode()+
					"\n\t company: "+user.getEmployment().getCompany()+
					"\n\t job title: "+user.getEmployment().getJobTitle()
				);	
		}
	}
	
	@Test
	public void test04_givenDemoUsersAndDemoInvestor_whenCreateDemoCompanies_shouldCompanyBeConnectedWithDemoUser() {
		PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		CompanyDemoGenerator.getCompanyDemoGenerator().getDemoCompanies();
		Set<User<T>> users = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		//users.removeIf(u -> u.getUserRole() != UserRole.USER_DEMO);
		System.out.println("---------- DEMO USERS CONNECTED WITH COMPANIES -------------");
		for (User<T> user : users) {
			if (user.getUserRole() == UserRole.USER_DEMO & user.getEmployment().getCompany() != null) {
				System.out.println(
					"-------------\n" 
					+user.getNameFirst()+" "+user.getNameLast()
					+"\n "+user.getNickname()
					+"\n "+user.getEmail()
					+"\n "+user.getUserRole().getCode()
					+"\n\t Comapny name: "+((Company<T>) user.getEmployment().getCompany()).getName()
					+"\n\t Job title: "+user.getEmployment().getJobTitle()
				);	
				assertTrue(user.getEmployment().getCompany() != null);				
			}

		}
	}
	
}
