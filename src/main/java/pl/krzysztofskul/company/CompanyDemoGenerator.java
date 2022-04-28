package pl.krzysztofskul.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.person.user.User;

public class CompanyDemoGenerator {

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
	
	public static Set<Company> getDemoCompanies() {
		return demoCompanies;
	}

	private static void setDemoCompanies(Set<Company> demoCompanies) {
		setDemoInvestors(2);
		setDemoHospitals();
	}
	
	/*
	 * func.
	 */
	
    public static String getRandomCompanyType() {
    	List<String> companyTypes = new ArrayList<String>();
    	for (CompanyTypeEnum comapnyType : CompanyTypeEnum.values()) {
			companyTypes.add(comapnyType.toString());
		}

    	return companyTypes.get(new Random().nextInt(companyTypes.size()+1));
    }
	
	private static void setDemoInvestors(int number) {
		for (int i = 0; i < number; i++) {
			Investor investor = new Investor();
			investor.setName(LoremIpsum.getInstance().getTitle(1) + " " + getRandomCompanyType());
			investor.setCountry(LoremIpsum.getInstance().getCountry());
			investor.setPostalCode(LoremIpsum.getInstance().getZipCode());
			investor.setCity(LoremIpsum.getInstance().getCity());
			investor.setStreet(LoremIpsum.getInstance().getName()+" street");
			investor.setStreetNo("no. " + new Random().nextInt(200)+1);
			investor.setWww(LoremIpsum.getInstance().getUrl());
			investor.setWww(LoremIpsum.getInstance().getEmail());
			investor.setWww(LoremIpsum.getInstance().getPhone());
		}
	}
	
	private static void companyAddUser(Company company, User user) {
		// todo
	}

	private static void setDemoHospitals() {
		// todo
	}
	
}
