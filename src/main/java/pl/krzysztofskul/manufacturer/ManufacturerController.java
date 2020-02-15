package pl.krzysztofskul.manufacturer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private ManufacturerService manufacturerService;

    public ManufacturerController(
            ManufacturerService manufacturerService
    ) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/all")
    public String all(
            Model model
    ) {
        model.addAttribute("manufacturers", manufacturerService.loadAllWithProducts());
        return "manufacturers/all";
    }

}
