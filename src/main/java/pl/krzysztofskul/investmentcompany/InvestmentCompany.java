package pl.krzysztofskul.investmentcompany;

import java.util.List;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.person.employee.Employee;
import pl.krzysztofskul.person.user.User;

@Entity
public class InvestmentCompany<T> extends Company<InvestmentCompany> {

	public InvestmentCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvestmentCompany(String name, String country, String postalCode, String city, String street,
			List<User<InvestmentCompany>> userList, List<Employee<InvestmentCompany>> employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public InvestmentCompany(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public <T> InvestmentCompany(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}



	
	
}
