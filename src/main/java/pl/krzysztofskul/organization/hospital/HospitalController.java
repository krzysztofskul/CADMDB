package pl.krzysztofskul.organization.hospital;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private HospitalService hospitalService;
    private DepartmentService departmentService;
    private UserService userService;

    public HospitalController(
            HospitalService hospitalService,
            DepartmentService departmentService,
            UserService userService
    ) {
        this.hospitalService = hospitalService;
        this.departmentService = departmentService;
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newHospital(
            Model model
    ) {
        model.addAttribute("hospitalNew", new Hospital());
        return "hospitals/new";
    }

    @PostMapping("/new")
    public String newHospital(
            @ModelAttribute("hospitalNew") Hospital hospitalNew
    ) {
        hospitalService.save(hospitalNew);
        return "redirect:/hospitals/all";
    }

    @GetMapping("/all")
    public String all(
            Model model
    ) {
        List<Hospital> hospitals = hospitalService.loadAllHospitalsWithDepartments();
        model.addAttribute("hospitals", hospitals);
        return "hospitals/all";
    }

}
