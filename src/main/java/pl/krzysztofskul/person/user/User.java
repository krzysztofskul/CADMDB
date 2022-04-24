package pl.krzysztofskul.person.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.krzysztofskul.person.Person;

@Entity
public class User extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nickname;
	
	private String email;
	
	private String password;
	
	/*
	 * enum UserRole .Admin .User
	 */
	//private UserRole userRole;
	
	/*
	 * 
	 */
	//private Emoplyee emploeyee;
		// private Company comapny
		/*
		 * enum EmplyeeRole .InvestorCompanyEmployee .ClinicEmployee .EquipmentManufacturerEmployee .EquipmentSupplierEmployee .Architect/Designer .Contractor
		 */
		// private EmployeeRole employeeRole
	
	
}
