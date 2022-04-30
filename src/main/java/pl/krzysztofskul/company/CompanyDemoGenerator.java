package pl.krzysztofskul.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.person.PersonDemoGenerator;
import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;

public class CompanyDemoGenerator<T> {

	private static CompanyDemoGenerator companyDemoGenerator;
	
	private static Set<Company> demoCompanies = new HashSet<Company>();

	/*
	 * constr.
	 */
	
	private CompanyDemoGenerator() {
		setDemoCompanies(demoCompanies);
	}
	
	public static CompanyDemoGenerator getCompanyDemoGenerator() {
		if (companyDemoGenerator == null) {
			companyDemoGenerator = new CompanyDemoGenerator();
		}
		return companyDemoGenerator;
	}

	/*
	 * getters and setters
	 */
	
	public Set<Company> getDemoCompanies() {
		return demoCompanies;
	}

	private void setDemoCompanies(Set<Company> demoCompanies) {
		setDemoInvestors();
		setDemoHospitals();
	}
	
	/*
	 * func.
	 */
	
    public String getRandomCompanyType() {
    	List<String> companyTypes = new ArrayList<String>();
    	for (CompanyTypeEnum comapnyType : CompanyTypeEnum.values()) {
			companyTypes.add(comapnyType.getName());
		}

    	return companyTypes.get(new Random().nextInt(companyTypes.size()+1));
    }
	
	private void setDemoInvestors() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		usersAsUserDemoRole.removeIf(u -> u.getUserRole() != UserRole.USER_DEMO);
		
		for (User<T> user : usersAsUserDemoRole) {
			Investor<T> investor = new Investor(user);
			investor.setName(LoremIpsum.getInstance().getTitle(1) + " " + getRandomCompanyType());
			investor.setCountry(LoremIpsum.getInstance().getCountry());
			investor.setPostalCode(LoremIpsum.getInstance().getZipCode());
			investor.setCity(LoremIpsum.getInstance().getCity());
			investor.setStreet(LoremIpsum.getInstance().getName()+" street");
			investor.setStreetNo("no. " + new Random().nextInt(200)+1);
			investor.setWww(LoremIpsum.getInstance().getUrl());
			investor.setEmail(LoremIpsum.getInstance().getEmail());
			investor.setPhoneNo(LoremIpsum.getInstance().getPhone());
		}
	}

	private void setDemoHospitals() {
		// todo
	}
	
}
