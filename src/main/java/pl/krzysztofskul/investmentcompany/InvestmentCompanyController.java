package pl.krzysztofskul.investmentcompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/investment-company")
public class InvestmentCompanyController {

	private InvestmentCompanyService investmentCompanyService;
	
	@Autowired
	public InvestmentCompanyController(InvestmentCompanyService investmentCompanyService) {
		super();
		this.investmentCompanyService = investmentCompanyService;
	}


	@GetMapping("/all")
	public String getInvestmentCompanyAll(
			Model model
		) {
		model.addAttribute("investmentCompanyAll", investmentCompanyService.loadAll());
		return "investmentcompany/all";
	}
	
	@GetMapping("/details/{id}")
	public String getInvestmentCompanyDetails(
			@PathVariable Long id,
			Model model
		) {
		model.addAttribute("investmentCompany", investmentCompanyService.loadById(id));
		return "investmentcompany/details";
	}
	
}
