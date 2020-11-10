package pl.krzysztofskul.organization.investor;


import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.organization.companyAddress.CompanyAddressDemoGenerator;
import pl.krzysztofskul.organization.companyType.CompanyTypeService;

import java.util.Random;

@Service
@Transactional
public class InvestorDemoGenerator {

    private CompanyTypeService companyTypeService;

    @Autowired
    public InvestorDemoGenerator(CompanyTypeService companyTypeService) {
        this.companyTypeService = companyTypeService;
    }

    public Investor getInvestorDemo() {

        Investor investorDemo = new Investor();

        investorDemo.setName(LoremIpsum.getInstance().getTitle(1, 2)+ " Demo Investments");
        if (null != companyTypeService.loadAll() && companyTypeService.loadAll().size() > 0) {
            investorDemo.setCompanyType(companyTypeService.loadById((long) new Random().nextInt(companyTypeService.loadAll().size())+1));
        }
        investorDemo.setCompanyAddress(CompanyAddressDemoGenerator.getCompanyAddressDemo());

        return investorDemo;
    }

}
