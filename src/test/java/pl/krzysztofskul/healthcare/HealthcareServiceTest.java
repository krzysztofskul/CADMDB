package pl.krzysztofskul.healthcare;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void test01_givenHealthcare_whenSaveToDb_shouldReturnId() {	
		List<Healthcare> healthcareList = List.copyOf(CompanyDemoGenerator.getCompanyDemoGenerator().getDemoHealthcareSet());
		
		for (Healthcare healthcare : healthcareList) {
			assertTrue(
						healthcareRepo.save(healthcare).getId() > 0
					);
			System.out.println("Healthcare object succefulky saved to DB: "+ healthcare.getClass().getName() + " id: " + healthcare.getId() + " | " + " | " + healthcare.getName());
		}

		
	}

}
