package pl.krzysztofskul.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.designingoffice.DesigningOffice;
import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.healthcare.clinic.Clinic;
import pl.krzysztofskul.healthcare.department.Department;
import pl.krzysztofskul.healthcare.department.DepartmentNameStandarizedEnum;
import pl.krzysztofskul.healthcare.department.room.Room;
import pl.krzysztofskul.healthcare.department.room.RoomNameStandarizedEnum;
import pl.krzysztofskul.healthcare.hospital.Hospital;
import pl.krzysztofskul.investmentcompany.InvestmentCompany;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.person.PersonDemoGenerator;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;
import pl.krzysztofskul.person.user.UserRole;
import pl.krzysztofskul.subcontractor.Subcontractor;

public class CompanyDemoGenerator<T, E> {

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
		setDemoClinics();
		setDemoDesigningOffices();
		setDemoSubcontractors();
	}
	
	/*
	 * methods and functions.
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
			hospital.setArea(new Random().nextInt(500)+500);
			hospital.setElectricalPowerConnectionValue(						
						new Random().nextInt(500000)+5000
					);
			hospital = (Hospital<T>) getCompanyDemoAddressDetails(hospital);
			setDemoDepartments(hospital);
			demoCompanies.add(hospital);
			break;
			}
		}
	}
	
	private void setDemoClinics() {
		Set<User<T>> usersAsUserDemoRole = PersonDemoGenerator.getPersonGenerator().getDemoUsers();
		
		for (User<T> user : usersAsUserDemoRole) {
			if (user.getUserRole() == UserRole.USER_DEMO & null == user.getEmployment().getCompany()) {
			Clinic<T> clinic= new Clinic(user, JobTitleEnum.MANAGER_IN_CLINIC);
			clinic.setArea(new Random().nextInt(250)+250);
			clinic.setElectricalPowerConnectionValue(						
						new Random().nextInt(100000)+1000
					);
			clinic = (Clinic<T>) getCompanyDemoAddressDetails(clinic);
			setDemoDepartments(clinic);
			demoCompanies.add(clinic);
			break;
			}
		}
	}
	
	private void setDemoDepartments(Healthcare healthcare) {
		DepartmentNameStandarizedEnum[] departmentsToAdd = new DepartmentNameStandarizedEnum[1];
		
		if (healthcare.getClass().getName().contains("Hospital")) {
			departmentsToAdd = DepartmentNameStandarizedEnum.values();	
			Hospital healthcareHospital = (Hospital) healthcare;
			for (DepartmentNameStandarizedEnum departmentNameStandarizedEnum : departmentsToAdd) {	
					healthcareHospital.addDepartment(new Department(departmentNameStandarizedEnum));
					
			}
			Set<Department> departments = healthcareHospital.getDepartments();
			for (Department department : departments) {
				for (RoomNameStandarizedEnum roomNameStandarizedEnum : RoomNameStandarizedEnum.values()) {
					department.addRoom(new Room(roomNameStandarizedEnum));
				}
			} 
			healthcare = healthcareHospital;
		} 
		
		
		if (healthcare.getClass().getName().contains("Clinic")) {
			departmentsToAdd[0] = DepartmentNameStandarizedEnum.DEMO_DEPARTMENT;
			
			Clinic healthcareClinic = (Clinic) healthcare;
			for (DepartmentNameStandarizedEnum departmentNameStandarizedEnum : departmentsToAdd) {	
					healthcareClinic.addDepartment(new Department(departmentNameStandarizedEnum));
					
			}
			Set<Department> departments = healthcareClinic.getDepartments();
			for (Department department : departments) {
				for (RoomNameStandarizedEnum roomNameStandarizedEnum : RoomNameStandarizedEnum.values()) {
					department.addRoom(new Room(roomNameStandarizedEnum));
				}
			} 
			healthcare = healthcareClinic; 
			
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

	private void addDemoDepartmentToHealthcare(T healthcare, Department department) {
		if (healthcare.getClass().getName().contains("Hospital")) {
			Hospital hospital = (Hospital) healthcare;
			hospital.addDepartment(department);
		}
		if (healthcare.getClass().getName().contains("Clinic")) {
			Clinic clinic = (Clinic) healthcare;
			clinic.addDepartment(department);
		}
	}
	
}
