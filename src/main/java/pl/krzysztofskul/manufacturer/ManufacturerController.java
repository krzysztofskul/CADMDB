package pl.krzysztofskul.manufacturer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/new")
    public String newManufacturer(
            Model model
    ) {
        model.addAttribute("newManufacturer", new Manufacturer());
        return "manufacturers/new";
    }

    @PostMapping("/new")
    public String newManufacturer(
            @ModelAttribute("newManufacturer") Manufacturer manufacturer
    ) {
        manufacturerService.save(manufacturer);
        return "redirect:/manufacturers/all";
    }

}
