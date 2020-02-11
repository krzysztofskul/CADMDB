package pl.krzysztofskul.organization.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Hospital loadById(Long id) {
        return hospitalRepo.findById(id).get();
    }

    public void delete(Hospital hospital) {
        hospitalRepo.delete(hospital);
    }

}
