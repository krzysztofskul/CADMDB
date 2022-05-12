package pl.krzysztofskul.healthcare.hospital;

import java.util.List;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.person.employment.Employment;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;

@Entity
public class Hospital<T> extends Healthcare {

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(List employeeList) {
		super(employeeList);
		// TODO Auto-generated constructor stub
	}

	public Hospital(String name, String country, String postalCode, String city, String street, List userList,
			List employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public Hospital(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public Hospital(User user, JobTitleEnum jobTitleEnum) {
		super(user, jobTitleEnum);
		// TODO Auto-generated constructor stub
	}

	public Hospital(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	
	
}
