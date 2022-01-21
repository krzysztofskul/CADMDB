package pl.krzysztofskul.organization.hospital.medicalFunction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalFunctionTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MedicalFunctionTagEnum medicalFunctionTagEnum;

    private String namePL;
    private String nameEN;

    private String descriptionPL;
    private String descriptionEN;

    private String medicalFunctionTagDescriptionPL;
    private String medicalFunctionTagDescriptionEN;

    /**
     * CONSTRUCTORS
     * */

    public MedicalFunctionTag() {

    }

    public MedicalFunctionTag(MedicalFunctionTagEnum medicalFunctionTagEnum) {
        this.medicalFunctionTagEnum = medicalFunctionTagEnum;
        this.namePL = medicalFunctionTagEnum.namePL;
        this.nameEN = medicalFunctionTagEnum.nameEN;
        this.descriptionPL = medicalFunctionTagEnum.descriptionPL;
        this.descriptionEN = medicalFunctionTagEnum.descriptionEN;
    }

    /**
     * GETTERS AND SETTERS
     * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalFunctionTagEnum getMedicalFunctionTagEnum() {
        return medicalFunctionTagEnum;
    }

    public void setMedicalFunctionTagEnum(MedicalFunctionTagEnum medicalFunctionTagEnum) {
        this.medicalFunctionTagEnum = medicalFunctionTagEnum;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getDescriptionPL() {
        return descriptionPL;
    }

    public void setDescriptionPL(String descriptionPL) {
        this.descriptionPL = descriptionPL;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public String getMedicalFunctionTagDescriptionPL() {
        return medicalFunctionTagDescriptionPL;
    }

    public void setMedicalFunctionTagDescriptionPL(String medicalFunctionTagDescriptionPL) {
        this.medicalFunctionTagDescriptionPL = medicalFunctionTagDescriptionPL;
    }

    public String getMedicalFunctionTagDescriptionEN() {
        return medicalFunctionTagDescriptionEN;
    }

    public void setMedicalFunctionTagDescriptionEN(String medicalFunctionTagDescriptionEN) {
        this.medicalFunctionTagDescriptionEN = medicalFunctionTagDescriptionEN;
    }
}
