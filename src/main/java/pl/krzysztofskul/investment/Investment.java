package pl.krzysztofskul.investment;

import java.math.BigDecimal;

import javax.persistence.Entity;

import pl.krzysztofskul.investmentcompany.InvestmentCompany;
import pl.krzysztofskul.person.employment.Employment;

@Entity
public class Investment {

	/*
	 * params.
	 */
	
	private InvestmentCompany investmentCompany;
	
	//hospital, clinic or ambulatory
	private Object healthcareUnit;
	
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
		
	public InvestmentCompany getInvestmentCompany() {
		return investmentCompany;
	}

	public void setInvestmentCompany(InvestmentCompany investmentCompany) {
		this.investmentCompany = investmentCompany;
	}

	public Object getHealthcareUnit() {
		return healthcareUnit;
	}

	public void setHealthcareUnit(Object healthcareUnit) {
		this.healthcareUnit = healthcareUnit;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
			
}
