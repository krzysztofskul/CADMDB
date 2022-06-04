package pl.krzysztofskul;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.krzysztofskul.company.CompanyDemoGenerator;
import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.healthcare.HealthcareService;

@Controller
public class HomePageController {

	private HealthcareService healthcareService;
		
	@Autowired
	public HomePageController(HealthcareService healthcareService) {
		super();
		this.healthcareService = healthcareService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/test")
	public String indexTest(
			Model model
		) {
		
		Set<Healthcare> healthcareSet = CompanyDemoGenerator.getCompanyDemoGenerator().getDemoHealthcareSet();
		for (Healthcare healthcare : healthcareSet) {
			healthcareService.save(healthcare);
		}
		
		model.addAttribute("modelTest", "test model atrribute");
		model.addAttribute("healthcareAll", healthcareService.loadAll());
		return "index";
	}
	
}
