package pl.krzysztofskul.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.designingoffice.DesigningOffice;
import pl.krzysztofskul.healthcare.hospital.Hospital;
import pl.krzysztofskul.investmentcompany.InvestmentCompany;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.person.PersonDemoGenerator;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;
import pl.krzysztofskul.subcontractor.Subcontractor;

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
		setDemoManufacturers();
		setDemoInvestmentCompanies();
		setDemoHospitals();
		setDemoDesigningOffices();
		setDemoSubcontractors();
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
	
	private void setDemoInvestmentCompanies() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & null == user.getEmployment().getCompany()) {
				InvestmentCompany<T> investmentCompany = new InvestmentCompany(user, JobTitleEnum.MANAGER_IN_INVESTMENT_COMPANY);
				investmentCompany = (InvestmentCompany<T>) getCompanyDemoAddressDetails(investmentCompany);
				demoCompanies.add(investmentCompany);
				break;
			}
		}
	}
	
	private void setDemoManufacturers() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & null == user.getEmployment().getCompany()) {
				Manufacturer manufacturer = new Manufacturer(user, JobTitleEnum.MANAGER_IN_MANUFACTURER);
				manufacturer = (Manufacturer) getCompanyDemoAddressDetails(manufacturer);
				demoCompanies.add(manufacturer);
				break;
			}
		}
	}
	private void setDemoDesigningOffices() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & null == user.getEmployment().getCompany()) {
				DesigningOffice designingOffice = new DesigningOffice(user, JobTitleEnum.MANAGER_IN_DESIGNINIG_OFFICE);
				designingOffice = (DesigningOffice) getCompanyDemoAddressDetails(designingOffice);
				demoCompanies.add(designingOffice);
				break;
			}
		}
	}
	private void setDemoSubcontractors() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & null == user.getEmployment().getCompany()) {
				Subcontractor subcontractor = new Subcontractor(user, JobTitleEnum.MANAGER_IN_SUBCONTRACTOR);
				subcontractor = (Subcontractor) getCompanyDemoAddressDetails(subcontractor);
				demoCompanies.add(subcontractor);
				break;
			}
		}
	}
	
	private void setDemoHospitals() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & null == user.getEmployment().getCompany()) {
			Hospital<T> hospital = new Hospital(user, JobTitleEnum.MANAGER_IN_HOSPITAL);
			hospital = (Hospital<T>) getCompanyDemoAddressDetails(hospital);
			demoCompanies.add(hospital);
			break;
			}
		}
	}
	
	private Company getCompanyDemoAddressDetails(Company company) {
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
