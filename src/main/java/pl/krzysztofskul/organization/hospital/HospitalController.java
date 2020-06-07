package pl.krzysztofskul.organization.hospital;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("hospital", new Hospital());
        return "hospitals/new";
    }

    @PostMapping("/new")
    public String newHospital(
            @ModelAttribute("hospital") Hospital hospital,
            @RequestParam(name = "content", required = false) String content,
            @RequestParam(name = "backToPage", required = false) String backToPage
    ) {

        if (hospital.getUserList() != null) {
            for (User user : hospital.getUserList()) {
                user.setHospital(hospital);
                userService.save(user);
            }
        }

        hospitalService.save(hospital);
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
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

    @GetMapping("/details/{id}")
    public String details(
            @PathVariable Long id,
            Model model
    ) {
        Hospital hospital = hospitalService.loadByIdWithUsersWithDepartmentsItsRoomsAndItsProducts(id);
        if (hospital != null) {
            model.addAttribute("hospital", hospital);
//            model.addAttribute("userList", userService.loadAll());
            model.addAttribute("allUserList", userService.loadAll());
            return "hospitals/details";
        } else {
            return "redirect:/errorPage?comment=no-hospital-found";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ) {
        Hospital hospital = hospitalService.loadByIdWithUsersWithDepartmentsItsRoomsAndItsProducts(id);

        for (User user : hospital.getUserList()) {
            user.setHospital(null);
        }
        hospitalService.delete(hospital);
//        hospitalService.delete(hospitalService.loadById(id));
        return "redirect:/hospitals/all";
    }

}
