package pl.krzysztofskul.organization.hospital.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategory;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategoryService;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentCategoryService departmentCategoryService;
    private DepartmentService departmentService;
    private HospitalService hospitalService;

    @Autowired
    public DepartmentController(
            DepartmentCategoryService departmentCategoryService,
            DepartmentService departmentService,
            HospitalService hospitalService
    ) {
        this.departmentCategoryService = departmentCategoryService;
        this.departmentService = departmentService;
        this.hospitalService = hospitalService;
    }

    @ModelAttribute("departmentCategoryList")
    public List<DepartmentCategory> getDepartmentCategoryList() {
        return departmentCategoryService.loadAll();
    }

    @ModelAttribute("hospitalList")
    public List<Hospital> getAllHospitals() {
        return hospitalService.loadAll();
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
        model.addAttribute("newDepartment", department);
        return "departments/new";
    }

    @PostMapping("/new")
    public String newDepartment(
            @ModelAttribute("newDepartment") Department newDepartment
    ) {
        departmentService.save(newDepartment);
        return "redirect:/hospitals/all";
    }

}
