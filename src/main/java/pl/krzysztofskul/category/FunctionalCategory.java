package pl.krzysztofskul.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FunctionalCategory {

	/**
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private FunctionalCategoryEnum functionalCategoryEnum;
	
	private Set<FunctionalMedicalSubcategoryEnum> functionalMedicalSubcategoryEnums = new HashSet<FunctionalMedicalSubcategoryEnum>();
	private Set<FunctionalSanitarySubcategoryEnum> functionalSanitarySubcategoryEnums = new HashSet<FunctionalSanitarySubcategoryEnum>();
	
	
	/**
	 * constr.
	 */
	
	public FunctionalCategory() {
		super();
	}

	/**
	 * getters and setters
	 * 
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FunctionalCategoryEnum getFunctionalCategoryEnum() {
		return functionalCategoryEnum;
	}

	public void setFunctionalCategoryEnum(FunctionalCategoryEnum functionalCategoryEnum) {
		this.functionalCategoryEnum = functionalCategoryEnum;
	}
	
	public Set<FunctionalMedicalSubcategoryEnum> getFunctionalMedicalSubcategoryEnums() {
		return functionalMedicalSubcategoryEnums;
	}

	public void setFunctionalMedicalSubcategoryEnums(
			Set<FunctionalMedicalSubcategoryEnum> functionalMedicalSubcategoryEnums) {
		this.functionalMedicalSubcategoryEnums = functionalMedicalSubcategoryEnums;
	}

	public Set<FunctionalSanitarySubcategoryEnum> getFunctionalSanitarySubcategoryEnums() {
		return functionalSanitarySubcategoryEnums;
	}

	public void setFunctionalSanitarySubcategoryEnums(
			Set<FunctionalSanitarySubcategoryEnum> functionalSanitarySubcategoryEnums) {
		this.functionalSanitarySubcategoryEnums = functionalSanitarySubcategoryEnums;
	}
	
	
	
}
