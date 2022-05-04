package pl.krzysztofskul.category;

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
	
	private FunctionalCategory functionalParentCategory;
	private FunctionalCategory functionalSubCategory;
	
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

	public FunctionalCategory getFunctionalParentCategory() {
		return functionalParentCategory;
	}

	public void setFunctionalParentCategory(FunctionalCategory functionalParentCategory) {
		this.functionalParentCategory = functionalParentCategory;
	}

	public FunctionalCategory getFunctionalSubCategory() {
		return functionalSubCategory;
	}

	public void setFunctionalSubCategory(FunctionalCategory functionalSubCategory) {
		this.functionalSubCategory = functionalSubCategory;
	}
	
}
