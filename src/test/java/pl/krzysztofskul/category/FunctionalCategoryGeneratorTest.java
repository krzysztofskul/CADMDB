package pl.krzysztofskul.category;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FunctionalCategoryGeneratorTest {

	@Test
	public void test01() {
		Set<FunctionalCategory> defaultFunctionalCategories = FunctionalCategoryGenerator.getFunctionalCategoryGenerator().getDefaultFunctionalCategories();
		System.out.println("-----------------------------------------------------------");
		System.out.println("-------------- DEFAULT FUNCTIONAL CATEGORIES --------------");
		System.out.println("------------------with sub-categories----------------------");
		for (FunctionalCategory defaultFunctionalCategory : defaultFunctionalCategories) {
			System.out.println("- "+ defaultFunctionalCategory.getFunctionalCategoryEnum());			
			if (null != defaultFunctionalCategory.getFunctionalSubCategory()) {			
				Set<FunctionalCategory> functionalSubCategories = defaultFunctionalCategory.getFunctionalSubCategory();				
				for (FunctionalCategory functionalSubCategory: functionalSubCategories) {
					System.out.println("\t-- "+functionalSubCategory.getFunctionalCategoryEnum());
				}
			}		
		}
		
	}

}
