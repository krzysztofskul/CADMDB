package pl.krzysztofskul.investmentcompany;

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
import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.company.CompanyDemoGenerator;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class InvestmentCompanyServiceTest {

	private MockMvc mockMvc;
	
	@Autowired
	private InvestmentCompanyService investmentCompanyService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void test01_givenInvestmentCompany_whenSaveToDb_shouldReturnIdGreaterThanZero() {
		CompanyDemoGenerator.getCompanyDemoGenerator();
		List<InvestmentCompany> investmentCompanyList = List.copyOf(CompanyDemoGenerator.getCompanyDemoGenerator().getDemoInvestmentCompanies());
		
		for (InvestmentCompany investmentCompany : investmentCompanyList) {
			
				assertTrue(
							investmentCompanyService.save(investmentCompany).getId() > 0
						);
			
		}
		
	}

}
