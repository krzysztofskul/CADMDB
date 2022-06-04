package pl.krzysztofskul.healthcare;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.company.CompanyDemoGenerator;
import pl.krzysztofskul.healthcare.clinic.Clinic;
import pl.krzysztofskul.healthcare.hospital.Hospital;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class HealthcareServiceTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Autowired
	private HealthcareRepo healthcareRepo;
	
	@Autowired
	private HealthcareService healthcareService;
	
	@Test
	public void test01_givenHealthcareList_whenSaveToDb_shouldReturnId() {	
		List<Healthcare> healthcareList = List.copyOf(CompanyDemoGenerator.getCompanyDemoGenerator().getDemoHealthcareSet());
		
		for (Healthcare healthcare : healthcareList) {
			assertTrue(
						healthcareService.save(healthcare).getId() > 0
					);
			System.out.println("Healthcare object succefulky saved to DB: "+ healthcare.getClass().getName() + " id: " + healthcare.getId() + " | " + " | " + healthcare.getName());
		}

		
	}
	
	// todo 2022-06-03 ...
	@Test
	public void test02_givenHealthcareListInDb_whenLoadAll_shouldLoadAllInheritFromHealthcare() {
		Set<Healthcare> healthcareListFromDemoGenerator = CompanyDemoGenerator.getCompanyDemoGenerator().getDemoHealthcareSet();
		List<Healthcare> healthcareListFromDb = healthcareService.loadAll();
		
		assertTrue(healthcareListFromDb.size() == healthcareListFromDemoGenerator.size());
		
	}

}
