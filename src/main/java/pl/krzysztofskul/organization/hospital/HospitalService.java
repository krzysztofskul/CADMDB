package pl.krzysztofskul.organization.hospital;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.Room;

import java.util.List;

@Service
@Transactional
public class HospitalService {

    private HospitalRepo hospitalRepo;

    @Autowired
    public HospitalService(HospitalRepo hospitalRepo) {
        this.hospitalRepo = hospitalRepo;
    }

    public void save(Hospital hospital) {
        hospitalRepo.save(hospital);
    }

    public List<Hospital> loadAll() {
        return hospitalRepo.findAll();
    }

    public List<Hospital> loadAllHospitalsWithDepartments() {

        List<Hospital> hospitals = hospitalRepo.findAll();

        for (Hospital hospital : hospitals) {
            Hibernate.initialize(hospital.getDepartmentList());
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

    public void delete(Hospital hospital) {
        hospitalRepo.delete(hospital);
    }

}
