package pl.krzysztofskul.organization.hospital.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategory;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategoryService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentCategoryService departmentCategoryService;
    private DepartmentService departmentService;
    private HospitalService hospitalService;
    private UserService userService;

    @Autowired
    public DepartmentController(
            DepartmentCategoryService departmentCategoryService,
            DepartmentService departmentService,
            HospitalService hospitalService,
            UserService userService
    ) {
        this.departmentCategoryService = departmentCategoryService;
        this.departmentService = departmentService;
        this.hospitalService = hospitalService;
        this.userService = userService;
    }

    @ModelAttribute("departmentCategoryList")
    public List<DepartmentCategory> getDepartmentCategoryList() {
        return departmentCategoryService.loadAll();
    }

    @ModelAttribute("hospitalList")
    public List<Hospital> getAllHospitals() {
        return hospitalService.loadAll();
    }

    @ModelAttribute("userHospitalManagerList")
    public List<User>  getUserHospitalManagerList() {
        return userService.loadUserHospitalManagerList();
    }

    @GetMapping("/new")
    public String newDepartment(
            Model model,
            @RequestParam(value = "hospitalId", required = false) Long id
    ) {
        Department department = new Department();
        if (id != null) {
            department.setHospital(hospitalService.loadById(id));
        }
        model.addAttribute("department", department);
        return "departments/new";
    }

    @PostMapping("/new")
    public String newDepartment(
            @ModelAttribute("department") Department department,
            @RequestParam(required = false) String backToPage
    ) {
        departmentService.save(department);
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
        return "redirect:/hospitals/all";
    }

    @GetMapping("/details/{id}")
    public String departmentDetails(
            @PathVariable Long id,
//            @RequestParam(required = false) String content,
//            @RequestParam(required = false) String edit,
            Model model
    ) {
        model.addAttribute("department", departmentService.loadByIdWithRoomsAndItsProducts(id));
        return "departments/details";
    }

}