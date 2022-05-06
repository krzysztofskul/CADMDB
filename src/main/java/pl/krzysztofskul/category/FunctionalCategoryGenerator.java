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
			switch (functionalCategory.getFunctionalCategoryEnum()) {
			case MEDICAL:
					for (FunctionalMedicalSubcategoryEnum functionalMedicalSubcategoryEnum : FunctionalMedicalSubcategoryEnum.values()) {
						functionalCategory.getFunctionalMedicalSubcategoryEnums().add(functionalMedicalSubcategoryEnum);
					}
				break;
			case SANITARY:
				for (FunctionalSanitarySubcategoryEnum functionalSanitarySubcategoryEnum: FunctionalSanitarySubcategoryEnum.values()) {
					functionalCategory.getFunctionalSanitarySubcategoryEnums().add(functionalSanitarySubcategoryEnum);
				}
			break;
			default:
				break;
			}
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
