package pl.krzysztofskul.user;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.Room;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private HospitalService hospitalService;

    public UserController(
            HospitalService hospitalService
    ) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/admin/allHospitals")
    public String all(
            Model model
    ) {
        List<Hospital> hospitals = hospitalService.loadAllHospitalsWithDepartments();
        model.addAttribute("hospitals", hospitals);
        return "users/admin/allHospitals";
    }
}
