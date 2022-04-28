package pl.krzysztofskul.person;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pl.krzysztofskul.person.user.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDemoGeneratorTest<T> {

	@Test
	public void test01_GetPersonGenerator() {
		assertTrue(PersonDemoGenerator.personDemoGenerator == null);
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
					user.getNameFirst()+" "+user.getNameLast()+" \n "+user.getNickname()+" \n "+user.getUserRole().getUserRoleToStringPL()+" \n "+user.getUserRole().getUserRoleToStringEN()+" \n Employee object: "+user.getEmploeyee());	
		}
		
	}



}
