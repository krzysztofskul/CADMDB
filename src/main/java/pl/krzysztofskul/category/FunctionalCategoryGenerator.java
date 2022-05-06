package pl.krzysztofskul.category;

import java.util.HashSet;
import java.util.Set;

public class FunctionalCategoryGenerator {

	/**
	 * params.
	 */
	
	private static FunctionalCategoryGenerator functionalCategoryGenerator;
	private static Set<FunctionalCategory> defaultFunctionalCategories = new HashSet<FunctionalCategory>();
	private static Set<FunctionalMedicalSubcategory> defaultFunctionalMedicalSubcategories = new HashSet<FunctionalMedicalSubcategory>();
	private static Set<FunctionalSanitarySubcategory> defaultFunctionalSanitarySubcategories = new HashSet<FunctionalSanitarySubcategory>();
	
	/**
	 * constr.
	 */
	
	private FunctionalCategoryGenerator() {
		FunctionalCategoryGenerator.setDefaultFunctionalMedicalSubcategories();
		FunctionalCategoryGenerator.setDefaultFunctionalSanitarySubcategories();
		FunctionalCategoryGenerator.setDefaultFunctionalCategories();
	}

	/**
	 * getters and setters
	 */
	
	public Set<FunctionalCategory> getDefaultFunctionalCategories() {
		return defaultFunctionalCategories;
	}

	private static void setDefaultFunctionalCategories(Set<FunctionalCategory> defaultFunctionalCategories) {
		FunctionalCategoryGenerator.defaultFunctionalCategories = defaultFunctionalCategories;
	}
	
	public static void setDefaultFunctionalMedicalSubcategories() {
		for (FunctionalMedicalSubcategoryEnum functionalMedicalSubcategoryEnum : FunctionalMedicalSubcategoryEnum.values()) {
			defaultFunctionalMedicalSubcategories.add(new FunctionalMedicalSubcategory(functionalMedicalSubcategoryEnum));
		}
	}

	public static void setDefaultFunctionalSanitarySubcategories() {
		for (FunctionalSanitarySubcategoryEnum functionalSanitarySubcategoryEnum : FunctionalSanitarySubcategoryEnum.values()) {
			defaultFunctionalSanitarySubcategories.add(new FunctionalSanitarySubcategory(functionalSanitarySubcategoryEnum));
		}
	}

	private static void setDefaultFunctionalCategories() {
		for (FunctionalCategoryEnum functionalCategoryEnum : FunctionalCategoryEnum.values()) {
			FunctionalCategory functionalCategory = new FunctionalCategory();
			functionalCategory.setFunctionalCategoryEnum(functionalCategoryEnum);
			switch ((FunctionalCategoryEnum) functionalCategory.getFunctionalCategoryEnum()) {
			case MEDICAL:
				for (FunctionalMedicalSubcategory functionalMedicalSubcategory : defaultFunctionalMedicalSubcategories) {
						functionalCategory.getFunctionalSubCategory().add(functionalMedicalSubcategory);
				}
				break;
			case SANITARY:
				for (FunctionalSanitarySubcategory functionalSanitarySubcategory : defaultFunctionalSanitarySubcategories) {
					functionalCategory.getFunctionalSubCategory().add(functionalSanitarySubcategory);
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
