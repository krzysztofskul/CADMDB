package pl.krzysztofskul.organization.hospital.department.departmentCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories/departments/")
public class DepartmentCategoryController {

    private DepartmentCategoryService departmentCategoryService;

    @Autowired
    public DepartmentCategoryController(DepartmentCategoryService departmentCategoryService) {
        this.departmentCategoryService = departmentCategoryService;
    }

    @GetMapping("/all")
    public String getAll(
            Model model
    ) {
        model.addAttribute("departmentsCategories", departmentCategoryService.loadAll());
        return "/categories/departments/all";
    }

}
