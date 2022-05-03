package pl.krzysztofskul.subcontractor;

import java.util.List;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;

@Entity
public class Subcontractor<T> extends Company<Subcontractor> {

	public Subcontractor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subcontractor(List employeeList) {
		super(employeeList);
		// TODO Auto-generated constructor stub
	}

	public Subcontractor(String name, String country, String postalCode, String city, String street, List userList,
			List employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public Subcontractor(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public Subcontractor(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	public Subcontractor(User user, JobTitleEnum jobTitleEnum) {
		super(user, jobTitleEnum);
		// TODO Auto-generated constructor stub
	}


	
}
