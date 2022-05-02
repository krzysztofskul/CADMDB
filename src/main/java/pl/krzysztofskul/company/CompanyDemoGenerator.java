package pl.krzysztofskul.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.healthcareUnit.hospital.Hospital;
import pl.krzysztofskul.investmentcompany.InvestmentCompany;
import pl.krzysztofskul.person.PersonDemoGenerator;
import pl.krzysztofskul.person.employee.JobTitleEnum;
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
		setDemoInvestmentCompanys();
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

    	return companyTypes.get(new Random().nextInt(companyTypes.size()));
    }
	
	private void setDemoInvestmentCompanys() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & user.getEmploeyee().getJobTitle() == JobTitleEnum.MANAGER_IN_INVESTMENT_COMPANY) {
				InvestmentCompany<T> investmentCompany = new InvestmentCompany(user);
				investmentCompany = (InvestmentCompany<T>) setCompanyDemoAddressDetails(investmentCompany);
				demoCompanies.add(investmentCompany);
			}
		}
	}
	
	private void setDemoHospitals() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & user.getEmploeyee().getJobTitle() == JobTitleEnum.MANAGER_IN_HOSPITAL) {
			Hospital<T> hospital = new Hospital(user);
			hospital = (Hospital<T>) setCompanyDemoAddressDetails(hospital);
			demoCompanies.add(hospital);
			}
		}
	}
	
	private Company setCompanyDemoAddressDetails(Company company) {
		company.setName(LoremIpsum.getInstance().getTitle(1) + " " + getRandomCompanyType());
		company.setCountry(LoremIpsum.getInstance().getCountry());
		company.setPostalCode(LoremIpsum.getInstance().getZipCode());
		company.setCity(LoremIpsum.getInstance().getCity());
		company.setStreet(LoremIpsum.getInstance().getName()+" street");
		company.setStreetNo("no. " + new Random().nextInt(200)+1);
		company.setWww(LoremIpsum.getInstance().getUrl());
		company.setEmail(LoremIpsum.getInstance().getEmail());
		company.setPhoneNo(LoremIpsum.getInstance().getPhone());
		return company;
	}


	
}
