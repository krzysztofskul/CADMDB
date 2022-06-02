package pl.krzysztofskul.investmentcompany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.investment.Investment;
import pl.krzysztofskul.person.employment.Employment;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;

@Entity
public class InvestmentCompany extends Company {

	/*
	 * params.
	 */
	
	private Set<Investment> investments = new HashSet<Investment>();
	
	/*
	 * constr.
	 */
	
	public InvestmentCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvestmentCompany(String name, String country, String postalCode, String city, String street,
			List<User> userList, List<Employment> employeeList) {
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

	public InvestmentCompany(List<Employment> employeeList) {
		super(employeeList);
		// TODO Auto-generated constructor stub
	}

	public <T> InvestmentCompany(User user, JobTitleEnum jobTitleEnum) {
		super(user, jobTitleEnum);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * getters and setters
	 */
	


	public Set<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(Set<Investment> investments) {
		this.investments = investments;
	}
	
}
