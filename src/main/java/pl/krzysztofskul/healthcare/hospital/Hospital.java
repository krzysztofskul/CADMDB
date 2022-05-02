package pl.krzysztofskul.healthcare.hospital;

import java.util.List;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.person.employee.Employee;
import pl.krzysztofskul.person.user.User;

@Entity
public class Hospital<T> extends Company<Hospital> {

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String name, String country, String postalCode, String city, String street,
			List<User<Hospital>> userList, List<Employee<Hospital>> employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public Hospital(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public Hospital(User<Hospital> user) {
		super(user);
		// TODO Auto-generated constructor stub
	}



	
	
}
