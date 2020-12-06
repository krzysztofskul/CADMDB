package pl.krzysztofskul.organization.hospital;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import java.util.List;

@Service
@Transactional
public class HospitalService {

    private HospitalRepo hospitalRepo;
    private UserService userService;

    @Autowired
    public HospitalService(
            HospitalRepo hospitalRepo,
            UserService userService
    ) {
        this.hospitalRepo = hospitalRepo;
        this.userService = userService;
    }

    /** CRUD create */

    public void save(Hospital hospital) {
        hospitalRepo.save(hospital);
    }

    /** CRUD read */

    public List<Hospital> loadAll() {
        return hospitalRepo.findAll();
    }

    public List<Hospital> loadAllHospitalsWithDepartments() {

        List<Hospital> hospitals = hospitalRepo.findAll();

        for (Hospital hospital : hospitals) {
            Hibernate.initialize(hospital.getDepartmentList());
            Hibernate.initialize(hospital.getEmployeeList());
            for (Department department : hospital.getDepartmentList()) {
                Hibernate.initialize(department.getRoomList());
                for (Room room : department.getRoomList()) {
                    Hibernate.initialize(room.getProductList());
                }
            }
        }

        return hospitals;
    }

    public Hospital loadById(Long id) {
        return hospitalRepo.findById(id).get();
    }

    public Hospital loadByIdWithUsers(Long hospitalId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).get();
        Hibernate.initialize(hospital.getEmployeeList());
        return hospital;
    }

    public Hospital loadByIdWithUsersWithDepartmentsItsRoomsAndItsProducts(Long id) {
        List<Hospital> hospitalList = loadAllHospitalsWithDepartments();
        for (Hospital hospital : hospitalList) {
            if (hospital.getId().equals(id)) {
                Hibernate.initialize(hospital.getEmployeeList());
                return hospital;
            }
        }
        return null;
    }

    /** CRUD update */

    public void addHospitalToUserManagingList(Long hospitalId, Long userId) {
        Hospital hospital = this.loadById(hospitalId);
        User user = userService.loadById(userId);

        user.addHospitalToUserManagingList(hospital);

        userService.save(user);
    }

    /** CRUD delete */

    public void delete(Hospital hospital) {
        Hibernate.initialize(hospital.getEmployeeList());
        if (hospital.getEmployeeList() != null) {
            for (User user : hospital.getEmployeeList()) {
                user.setHospital(null);
                userService.save(user);
            }
        }
        hospitalRepo.delete(hospital);
    }
}
