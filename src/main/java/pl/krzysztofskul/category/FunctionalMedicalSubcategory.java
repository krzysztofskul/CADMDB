package pl.krzysztofskul.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class FunctionalMedicalSubcategory<T> extends FunctionalCategory<T> {

	/**
	 * 
	 */
	public FunctionalMedicalSubcategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param functionalCategoryEnum
	 */
	public FunctionalMedicalSubcategory(T functionalCategoryEnum) {
		super(functionalCategoryEnum);
		// TODO Auto-generated constructor stub
	}
	
}
