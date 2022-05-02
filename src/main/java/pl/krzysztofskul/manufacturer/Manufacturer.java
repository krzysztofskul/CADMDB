package pl.krzysztofskul.manufacturer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.person.user.User;

@Entity
public class Manufacturer extends Company {

	/*
	 * params.
	 */
	
	private Set<Object> products = new HashSet<Object>();
	
	/*
	 * constr.
	 */
	
	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(List employeeList) {
		super(employeeList);
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(String name, String country, String postalCode, String city, String street, List userList,
			List employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	
	
}
