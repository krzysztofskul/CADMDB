package pl.krzysztofskul.organization.hospital.medicalFunctionTag;

import java.util.ArrayList;
import java.util.List;

public class MedicalFunctionTagInit {

    private static MedicalFunctionTagInit medicalFunctionTagInit;

    public MedicalFunctionTagInit() {
    }

    public static MedicalFunctionTagInit getMedicalFunctionTagInit() {

        if (medicalFunctionTagInit == null) {
            medicalFunctionTagInit = new MedicalFunctionTagInit();
        }

        return medicalFunctionTagInit;
    }


    public List<MedicalFunctionTag> initAndGet() {

        List<MedicalFunctionTag> medicalFunctionTagList = new ArrayList<>();

        for(MedicalFunctionTagEnum medicalFunctionTagEnum : MedicalFunctionTagEnum.values()) {
            medicalFunctionTagList.add(new MedicalFunctionTag(medicalFunctionTagEnum));
        }

        return medicalFunctionTagList;

    }
}
