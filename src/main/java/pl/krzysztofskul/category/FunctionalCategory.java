package pl.krzysztofskul.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FunctionalCategory<T> {

	/**
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private T functionalCategoryEnum;
	
	private Set<T> functionalSubCategory = new HashSet<T>();
	
	/**
	 * constr.
	 */
	
	public FunctionalCategory() {
		super();
	}

	public FunctionalCategory(T functionalCategoryEnum) {
		super();
		this.functionalCategoryEnum = functionalCategoryEnum;
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
	
	public Set<T> getFunctionalSubCategory() {
		return functionalSubCategory;
	}

	public void setFunctionalSubCategory(Set<T> functionalSubCategory) {
		this.functionalSubCategory = functionalSubCategory;
	}

	public T getFunctionalCategoryEnum() {
		return functionalCategoryEnum;
	}

	public void setFunctionalCategoryEnum(T functionalCategoryEnum) {
		this.functionalCategoryEnum = functionalCategoryEnum;
	}
	
	
}
