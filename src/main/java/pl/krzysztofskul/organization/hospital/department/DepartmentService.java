package pl.krzysztofskul.organization.hospital.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public void save(Department department) {
        departmentRepo.save(department);
    }

    public List<Department> loadAll() {
        return departmentRepo.findAll();
    }

    public Department loadById(Long id) {
        return departmentRepo.findById(id).get();
    }

    public void delete(Department department) {
        departmentRepo.delete(department);
    }

}
