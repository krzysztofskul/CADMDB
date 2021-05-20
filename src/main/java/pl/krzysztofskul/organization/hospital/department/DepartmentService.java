package pl.krzysztofskul.organization.hospital.department;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.product.Product;

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

    public Department loadByIdWithUsers(Long id) {
        Department department = departmentRepo.findById(id).get();
        //Hibernate.initialize(department.getUsers());
        return department;
    }

    public Department loadByIdWithRooms(Long id) {
        Department department = departmentRepo.findById(id).get();
        Hibernate.initialize(department.getRoomList());
        return department;
    }

    public Department loadByIdWithRoomsAndItsProducts(Long id) {
        Department department = departmentRepo.findById(id).get();
        Hibernate.initialize(department.getRoomList());
        for (Room room : department.getRoomList()) {
            Hibernate.initialize(room.getProductList());
            for (Product product : room.getProductList()) {
                Hibernate.initialize(product.getPrice());
            }
        }
        return department;
    }

    public Department loadByIdWithHospitalAndItsDepartmentList(Long id) {
        Department department = departmentRepo.findById(id).get();
        Hibernate.initialize(department.getHospital().getDepartmentList());
        return department;
    }

    public void delete(Department department) {
        departmentRepo.delete(department);
    }

}
