package pl.krzysztofskul.organization.investor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.organization.companyType.CompanyTypeService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class InvestorServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private InvestorDemoGenerator investorDemoGenerator;
    @Autowired
    private CompanyTypeService companyTypeService;
    @Autowired
    private InvestorService investorService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void whenSaveDemoInvestors_shouldBeInDbWithAddressesAndCompanyTypes() {
        //when
        companyTypeService.createCompanyTypesAndSaveToDB();
        for (int i = 0; i < 2; i++) {
            Investor investorDemo = investorDemoGenerator.getInvestorDemo();
            investorService.save(investorDemo);
        }

        //should
        List<Investor> investorListFromDb = investorService.loadAll();
        Assert.assertTrue(null != investorListFromDb && investorListFromDb.size() > 0);
        Assert.assertTrue(null != investorListFromDb.get(0).getCompanyAddress());
        Assert.assertTrue(null != investorListFromDb.get(0).getCompanyType());
        Assert.assertTrue(null != investorListFromDb.get(1).getCompanyAddress());
        Assert.assertTrue(null != investorListFromDb.get(1).getCompanyType());

    }

}