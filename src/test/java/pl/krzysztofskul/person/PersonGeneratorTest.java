package pl.krzysztofskul.person;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pl.krzysztofskul.person.user.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonGeneratorTest {

	@Test
	public void test01_GetPersonGenerator() {
		assertTrue(PersonGenerator.personGenerator == null);
		PersonGenerator.getPersonGenerator();
		assertTrue(PersonGenerator.personGenerator != null);
	}
	
	@Test
	public void test02_SetDemoUsers() {
		
	}
	
	@Test
	public void test03_GetDemoUsers() {
		assertTrue(PersonGenerator.getPersonGenerator().getDemoUsers() != null);
		assertTrue(PersonGenerator.getPersonGenerator().getDemoUsers().size() > 0);
		System.out.println("---------- DEMO USERS -------------");
		for (User user : PersonGenerator.getPersonGenerator().getDemoUsers()) {
			System.out.println(
					"-------------\n" +
					user.getNameFirst()+" "+user.getNameLast()+" \n "+user.getNickname()+" \n "+user.getUserRole().getUserRoleToStringPL()+" \n "+user.getUserRole().getUserRoleToStringEN()+" \n Employee object: "+user.getEmploeyee());	
		}
		
	}



}
