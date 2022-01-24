package pl.krzysztofskul.organization.hospital.medicalFunctionTag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicalFunctionTagService {

    private final MedicalFunctionTagRepo medicalFunctionTagRepo;

    @Autowired
    public MedicalFunctionTagService(MedicalFunctionTagRepo medicalFunctionTagRepo) {
        this.medicalFunctionTagRepo = medicalFunctionTagRepo;
    }

    public void save(MedicalFunctionTag medicalFunctionTag) {
        medicalFunctionTagRepo.save(medicalFunctionTag);
    }

    public List<MedicalFunctionTag> loadAll() {
        return medicalFunctionTagRepo.findAll();
    }

    public void init() {
        for (MedicalFunctionTag medicalFunctionTag : MedicalFunctionTagInit.getMedicalFunctionTagInit().initAndGet()) {
            medicalFunctionTagRepo.save(medicalFunctionTag);
        }
    }

    public void delete(Long id) {
        medicalFunctionTagRepo.deleteById(id);
    }
}
