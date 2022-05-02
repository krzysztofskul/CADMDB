package pl.krzysztofskul.person;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pl.krzysztofskul.company.CompanyDemoGenerator;
import pl.krzysztofskul.person.employee.Employee;
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
					" \n "+user.getNickname()+
					" \n "+user.getUserRole().getUserRoleToStringPL()+
					" \n "+user.getUserRole().getUserRoleToStringEN()+
					" \n Employee object: "+user.getEmploeyee()+
					" \n Employee details: "+user.getEmploeyee().getJobTitle().getNamePL()+
					" \n Employee details: "+user.getEmploeyee().getCompany()
				);	
		}
	}

	@Test
	public void test04_GetDemoEmployees() {
		System.out.println("---------- DEMO EMPLOYEES -------------");
		Set<Employee<T>> employees = PersonDemoGenerator.getPersonGenerator().getDemoEmployees();
		for (Employee<T> employee : employees) {
			System.out.println(
					"-------------\n" +
					"name and surname: "+employee.getNameFirst()+" "+employee.getNameLast()+"\n"+
					"connectesd with user: "+employee.getUser()+"\n"+
					"job title EN: "+employee.getJobTitle().getNameEN()+"\n"+
					"job title PL: "+employee.getJobTitle().getNamePL()+"\n"+
					"company: "+employee.getCompany()
			);	
		}
	}
	
	@Test
	public void test05_givenDemoUsersAndDemoInvestor_whenCreateDemoCompanies_shouldCompanyBeConnectedWithDemoUser() {
		PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		CompanyDemoGenerator.getCompanyDemoGenerator().getDemoCompanies();
		Set<User<T>> users = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		//users.removeIf(u -> u.getUserRole() != UserRole.USER_DEMO);
		System.out.println("---------- USER DEMO CONNECTED WITH COMPANY-------------");
		for (User<T> user : users) {
			if (user.getUserRole() == UserRole.USER_DEMO & user.getCompany() != null) {
				System.out.println(
						"-------------\n" +
						user.getNameFirst()+" "
								+user.getNameLast()
								+" \n "+user.getNickname()
								+" \n "+user.getEmail()
								+" \n "+user.getUserRole().getUserRoleToStringPL()
								+" \n "+user.getUserRole().getUserRoleToStringEN()
								+" \n Employee (object): "+user.getEmploeyee()
								+" \n Comapny (object): "+user.getCompany().getName()+ " / " + user.getCompany().getClass().toString()
							);	
				assertTrue(user.getCompany() != null);				
			}

		}
	}

}
