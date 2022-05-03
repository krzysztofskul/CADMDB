package pl.krzysztofskul.company;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pl.krzysztofskul.person.PersonDemoGenerator;
import pl.krzysztofskul.person.employment.Employment;
import pl.krzysztofskul.person.user.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyDemoGeneratorTest {

	@Test
	public void test01_givenComapanyDemoGenerator_whenGetCompanyDemoGenerator_shouldCreateDemoCompanies() {
		PersonDemoGenerator.getPersonGenerator();
		Set<Company> demoCompanies = CompanyDemoGenerator.getCompanyDemoGenerator().getDemoCompanies();
		System.out.println("-------------- DEMO COMPANIES -------------");		
		for (Company company : demoCompanies) {
			assertTrue(company.getName() != null);
			System.out.println("Company name: "+company.getName());
			System.out.println("\tCompany type: "+company.getClass().getName());
			List<User> users = company.getUserList();
			assertTrue(users.size() > 0);
			for (User user : users) {
				System.out.println("\tuser: "+user.getNameFirst()+" "+user.getNameLast());
				System.out.println("\tuser role: "+user.getUserRole().getUserRoleToStringPL());
			}
		} 
		
	}

}
