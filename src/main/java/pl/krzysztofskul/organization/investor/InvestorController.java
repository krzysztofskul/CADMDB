package pl.krzysztofskul.organization.investor;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/investors")
public class InvestorController {

    private InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping("/all")
    public String investorsAll(
            Model model
    ) {

        model.addAttribute("investorsAll", investorService.loadAllWithHospitalsAndEmployees());

        return "investors/all";
    }

    @GetMapping("/details/{id}")
    public String investorsDetails(
            @PathVariable("id") Long id,
            Model model
    ) {
        Investor investor = investorService.loadByIdWithHospitalsAndEmployees(id);
        model.addAttribute("investor", investor);
        return "investors/details";
    }

}
