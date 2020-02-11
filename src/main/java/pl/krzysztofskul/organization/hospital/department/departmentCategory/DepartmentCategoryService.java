package pl.krzysztofskul.organization.hospital.department.departmentCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentCategoryService {

    private DepartmentCategoryRepo departmentCategoryRepo;

    @Autowired
    public DepartmentCategoryService(DepartmentCategoryRepo departmentCategoryRepo) {
        this.departmentCategoryRepo = departmentCategoryRepo;
    }

    public void save(DepartmentCategory departmentCategory) {
        departmentCategoryRepo.save(departmentCategory);
    }

    public List<DepartmentCategory> loadAll() {
        return departmentCategoryRepo.findAll();
    }

    public DepartmentCategory loadById(Long id) {
        return departmentCategoryRepo.findById(id).get();
    }

    public void delete(DepartmentCategory departmentCategory) {
        departmentCategoryRepo.delete(departmentCategory);
    }

}
