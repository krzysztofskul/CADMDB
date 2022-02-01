package pl.krzysztofskul.organization.hospital.medicalFunctionTag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalFunctionTagRepo extends JpaRepository<MedicalFunctionTag, Long> {

    public MedicalFunctionTag findByNameEN(String nameEN);

}
