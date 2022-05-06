package pl.krzysztofskul.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FunctionalSanitarySubcategory<T> extends FunctionalCategory<T> {

	/**
	 * 
	 */
	public FunctionalSanitarySubcategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param functionalCategoryEnum
	 */
	public FunctionalSanitarySubcategory(T functionalCategoryEnum) {
		super(functionalCategoryEnum);
		// TODO Auto-generated constructor stub
	}

}
