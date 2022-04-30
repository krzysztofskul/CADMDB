package pl.krzysztofskul.investor;

import java.util.List;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.person.employee.Employee;
import pl.krzysztofskul.person.user.User;

@Entity
public class Investor<T> extends Company<Investor> {

	public Investor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Investor(String name, String country, String postalCode, String city, String street,
			List<User<Investor>> userList, List<Employee<Investor>> employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public Investor(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public <T> Investor(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}



	
	
}
