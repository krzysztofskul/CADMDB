package pl.krzysztofskul.company;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.healthcare.clinic.Clinic;
import pl.krzysztofskul.healthcare.department.Department;
import pl.krzysztofskul.healthcare.department.room.Room;
import pl.krzysztofskul.healthcare.hospital.Hospital;
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
			if (company.getClass().getName().contains("Hospital")) {
				Hospital companyHospital = (Hospital) company;
				System.out.println("\t Area: "+companyHospital.getArea() + " m2");
				System.out.println("\t Electrical power connection value: "+companyHospital.getElectricalPowerConnectionValue() + " VA");
				printDepartments(companyHospital);
			}
			if (company.getClass().getName().contains("Clinic")) {
				Clinic companyClinic = (Clinic) company;
				System.out.println("\t Area: "+companyClinic.getArea() + " m2");
				System.out.println("\t Electrical power connection value: "+companyClinic.getElectricalPowerConnectionValue() + " VA");
				printDepartments(companyClinic);
			}
			List<User> users = company.getUserList();
			assertTrue(users.size() > 0);
			for (User user : users) {
				System.out.println("\tuser: "+user.getNameFirst()+" "+user.getNameLast());
				System.out.println("\tuser role: "+user.getUserRole().getUserRoleToStringPL());
			}
		} 
		
	}

	private void printDepartments(Healthcare healthcare) {
		
		Set<Department> departments = null;
		
		if (healthcare.getClass().getName().contains("Hospital")) {
			Hospital h = (Hospital) healthcare;
			departments = h.getDepartments();
		}
		if (healthcare.getClass().getName().contains("Clinic")) {
			Clinic c = (Clinic) healthcare;
			departments = c.getDepartments();
		}		
		
		if (departments != null & departments.size() > 0) {
			System.out.println("\t  Departments:");
			for (Department department : departments) {
				System.out.println("\t\t "+department.getNameStandarized().getNameEN());
				if (department.getRooms() != null & department.getRooms().size() > 0) {
					System.out.println("\t\t\t Rooms:");
					Set<Room> rooms = department.getRooms();
					for (Room room : rooms) {
						System.out.println("\t\t\t\t "+room.getNameStandarized());
					}
				} 
			}
		}
	}

}
