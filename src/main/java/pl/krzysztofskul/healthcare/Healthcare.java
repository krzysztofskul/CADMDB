package pl.krzysztofskul.healthcare;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.healthcare.department.Department;
import pl.krzysztofskul.person.employment.JobTitleEnum;
import pl.krzysztofskul.person.user.User;


/**
 * 
 * @author krzysztofskul
 *	Healthcare class represents organization/administrative unit in public or private healthcare system 
 *	ex. hospital, clinic, ambulatory, hospital departments and rooms.
 *
 */
public class Healthcare extends Company {

	/**
	 * params.
	 */
	
	/*
	 * precision: 1 VA
	 */
	private int electricalPowerConnectionValue;
	
	/*
	 * precision: 1 meter
	 */
	private int area;
	
	// budget for equipment
	//private BigDecimal budgetEquipment;
	
	// budget for construction
	//private BigDecimal budgetConstruction;
	
	/**
	 * constr.
	 */
	
	public Healthcare() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Healthcare(List employeeList) {
		super(employeeList);
		// TODO Auto-generated constructor stub
	}

	public Healthcare(String name, String country, String postalCode, String city, String street, List userList,
			List employeeList) {
		super(name, country, postalCode, city, street, userList, employeeList);
		// TODO Auto-generated constructor stub
	}

	public Healthcare(String name, String country, String postalCode, String city, String street, String streetNo) {
		super(name, country, postalCode, city, street, streetNo);
		// TODO Auto-generated constructor stub
	}

	public Healthcare(User user, JobTitleEnum jobTitleEnum) {
		super(user, jobTitleEnum);
		// TODO Auto-generated constructor stub
	}

	public Healthcare(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	/**
	 * getters and setters
	 */
	
	public int getElectricalPowerConnectionValue() {
		return electricalPowerConnectionValue;
	}

	public void setElectricalPowerConnectionValue(int electricalPowerConnectionValue) {
		this.electricalPowerConnectionValue = electricalPowerConnectionValue;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
	
}
