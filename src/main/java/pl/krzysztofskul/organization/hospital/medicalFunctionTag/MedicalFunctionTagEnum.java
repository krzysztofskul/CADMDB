package pl.krzysztofskul.organization.hospital.medicalFunctionTag;

public enum MedicalFunctionTagEnum {

    OFFICE ("BIUROWE", "OFFICE", null, null),
    PHARMACY ("APTECZNE", "PHARMACY", null, null),
    TECHNICAL ("TECHNICZNE", "TECHNICAL", null, null),
    CONSULTATIONS ("KONSULTACYJNE", "CONSULTATIONS", null, null),
    DIAGNOSTICS ("DIAGNOSTYCZNE", "DIAGNOSTICS", null, null),
    DIAGNOSTICS_AND_OPERATIONS ("DIAGNOSTYCZNO-ZABIEGOWE", "DIAGNOSTICS AND OPERATIONS", null, null),
    STANDARD_CARE ("OPIEKA STANDARDOWA", "STANDARD CARE", null, null),
    INTENSIVE_CARE ("OPIEKA INTENSYWNA", "INTENSIVE CARE", null, null),
    OPERATIONS ("OPERACYJNE", "OPERATIONS", null, null),
    SURGERY ("CHIRURGICZNE", "SURGERY", null, null),
    STERILIZATION_HYGIENIC_SANITARY ("HIGIENICZNO-SANITARNE", "STERILIZATION HYGIENIC SANITARY", null, null),
    LABORATORY ("LABORATORYJNE", "LABORATORY", null, null),
	MEDICAL ("MEDYCZNE", "MEDICAL", null, null);

    public String namePL;
    public String nameEN;

    public String descriptionPL;
    public String descriptionEN;


    MedicalFunctionTagEnum(String namePL, String nameEN, String descriptionPL, String descriptionEN) {
        this.namePL = namePL;
        this.nameEN = nameEN;
        this.descriptionPL = descriptionPL;
        this.descriptionEN = descriptionEN;
    }
}
