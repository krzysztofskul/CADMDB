package pl.krzysztofskul.investment;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.investmentcompany.InvestmentCompany;
import pl.krzysztofskul.person.employment.Employment;

@Entity
public class Investment<T> {

	/*
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//private String name;
	
	//private String status;
	
	@ManyToOne
	private InvestmentCompany investmentCompany;
	
	//hospital, clinic or ambulatory
	@OneToOne(targetEntity = Healthcare.class)
	private T healthcare;
	
	private BigDecimal budget;

	/*
	 * constr.
	 */
	
	public Investment() {
		super();
	}

	/*
	 * getters and setters
	 */	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InvestmentCompany getInvestmentCompany() {
		return investmentCompany;
	}

	public void setInvestmentCompany(InvestmentCompany investmentCompany) {
		this.investmentCompany = investmentCompany;
	}

	public T getHealthcare() {
		return healthcare;
	}

	public void setHealthcare(T healthcare) {
		this.healthcare = healthcare;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
			
}
