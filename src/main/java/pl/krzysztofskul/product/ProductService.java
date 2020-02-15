package pl.krzysztofskul.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private ProductRepo productRepo;
    private RoomService roomService;
    private DepartmentService departmentService;
    private HospitalService hospitalService;

    @Autowired
    public ProductService(
            ProductRepo productRepo,
            RoomService roomService,
            DepartmentService departmentService,
            HospitalService hospitalService
    ) {
        this.productRepo = productRepo;
        this.roomService = roomService;
        this.departmentService = departmentService;
        this.hospitalService = hospitalService;
    }

    public void save(Product product) {
        productRepo.save(product);
    }

    public List<Product> loadAll() {
        return productRepo.findAll();
    }

    public Product loadById(Long id) {
        return productRepo.findById(id).get();
    }

    public void delete(Product product) {
        productRepo.delete(product);
    }

    /**
     * ADD/REMOVE PRODUCT TO/FROM ROOM METHODS
     * @param productId
     * @param roomId
     */

    public void addProductToRoom(Long productId, Long roomId) {
        Product product = this.loadById(productId);
        Room room = roomService.loadById(roomId);
        Department department = departmentService.loadById(room.getDepartment().getId());
        Hospital hospital = hospitalService.loadById(department.getHospital().getId());

        room.addProduct(product);
        room.setBudget(room.getBudget().add(product.getPrice()));
        department.setBudget(department.getBudget().add(product.getPrice()));
        hospital.setBudget(hospital.getBudget().add(product.getPrice()));

        this.save(product);
        roomService.save(room);
        departmentService.save(department);
        hospitalService.save(hospital);

    }

    public void removeProductFromRoom(Long productId, Long roomId) {
        Product product = this.loadById(productId);
        Room room = roomService.loadById(roomId);
        Department department = departmentService.loadById(room.getDepartment().getId());
        Hospital hospital = hospitalService.loadById(department.getHospital().getId());

        room.removeProduct(product);
        room.setBudget(room.getBudget().subtract(product.getPrice()));
        department.setBudget(department.getBudget().subtract(product.getPrice()));
        hospital.setBudget(hospital.getBudget().subtract(product.getPrice()));

        this.save(product);
        roomService.save(room);
        departmentService.save(department);
        hospitalService.save(hospital);

    }

}
