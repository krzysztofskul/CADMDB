package pl.krzysztofskul;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.company.CompanyDemoGenerator;
import pl.krzysztofskul.company.CompanyService;
import pl.krzysztofskul.investmentcompany.InvestmentCompany;

@Controller
public class InitDbController {

	private InitDbService initDbService;
	
	@Autowired
	public InitDbController(InitDbService initDbService) {
		super();
		this.initDbService = initDbService;
	}	

	@GetMapping("/initDemoDb")
	public String getInitDb() {
		initDbService.initDemoDb();
		return "redirect:/";
	}
	
	
}
