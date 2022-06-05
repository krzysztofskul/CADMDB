package pl.krzysztofskul;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.company.CompanyDemoGenerator;
import pl.krzysztofskul.company.CompanyService;

@Service
@Transactional
public class InitDbService {

	private CompanyService companyService;
	
	@Autowired
	public InitDbService(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	public void initDemoDb() {		
		initDemoInvestmentCompanies();	
	}

	private void initDemoInvestmentCompanies() {
		Set<Company> demoCompanies = CompanyDemoGenerator.getCompanyDemoGenerator().getDemoInvestmentCompanies();
		for (Company company : demoCompanies) {
			companyService.save(company);
		}
	}
	
}
