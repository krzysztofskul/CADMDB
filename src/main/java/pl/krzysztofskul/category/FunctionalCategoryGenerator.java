package pl.krzysztofskul.category;

import java.util.HashSet;
import java.util.Set;

public class FunctionalCategoryGenerator {

	/**
	 * params.
	 */
	
	private static FunctionalCategoryGenerator functionalCategoryGenerator;
	private static Set<FunctionalCategory> defaultFunctionalCategories = new HashSet<FunctionalCategory>();
	
	/**
	 * constr.
	 */
	
	private FunctionalCategoryGenerator() {
		FunctionalCategoryGenerator.setDefaultFunctionalCategories();
	};

	/**
	 * getters and setters
	 */
	
	public Set<FunctionalCategory> getDefaultFunctionalCategories() {
		return defaultFunctionalCategories;
	}

	private static void setDefaultFunctionalCategories(Set<FunctionalCategory> defaultFunctionalCategories) {
		FunctionalCategoryGenerator.defaultFunctionalCategories = defaultFunctionalCategories;
	}

	private static void setDefaultFunctionalCategories() {
		for (FunctionalCategoryEnum functionalCategoryEnum : FunctionalCategoryEnum.values()) {
			FunctionalCategory functionalCategory = new FunctionalCategory();
			functionalCategory.setFunctionalCategoryEnum(functionalCategoryEnum);
			defaultFunctionalCategories.add(functionalCategory);
		}
	}
	
	/**
	 * methods and functions
	 * @return
	 */
	
	public static FunctionalCategoryGenerator getFunctionalCategoryGenerator() {
		if (null == functionalCategoryGenerator) {
			functionalCategoryGenerator = new FunctionalCategoryGenerator();
		}
		return functionalCategoryGenerator;
	}

	
}
