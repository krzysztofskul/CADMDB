package pl.krzysztofskul.person.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum JobTitleEnum {

    MANAGER ("MANAGER", "Manager", "Kierownik/Dyrektor"),

    MANAGER_IN_INVESTMENT_COMPANY ("MANAGER IN INVESTMENT COMPANY", "Managerin investment company", "Kierownik/Dyrektor inwestora"),
    MANAGER_IN_HOSPITAL ("MANAGER IN HOSPITAL", "Manager in hospital", "Kierownik/Dyrektor szpitala"),
    MANAGER_IN_CLINIC ("MANAGER IN CLINIC", "Managerin clinic", "Kierownik/Dyrektor przychodni"),
    MANAGER_IN_DESIGNINIG_OFFICE ("MANAGER IN DESIGNNING OFFICE", "Manager in designing office", "Kierownik/Dyrektor biura projektowego"),
    MANAGER_IN_EQUIPMENT_MANUFACTURER ("MANAGER IN MANUFACTURER", "Manager in manufacturer", "Kierownik/Dyrektor producenta wyposa¿enia"),
    MANAGER_IN_CONTRACTOR ("MANAGER IN CONTRACTOR", "Manager in contractor company", "Kierownik/Dyrektor podwykonawcy"),

    DOCTOR ("DOCTOR", "Doctor", "Lekarz"),
    
    MEDICAL_PERSONEL ("MEDICAL-PEROSONEL", "Mecial personel", "Pracownik medyczny"),

    NURSE ("NURSE", "Nurse", "Pelêgniarka/Pielêgniarz"),
    
    DESIGNER ("DESIGNER", "Designer", "Projektant"),
    
    WORKER("WORKER", "Worker", "Pracownik");

    private String code;
    private String nameEN;
    private String namePL;

    JobTitleEnum(String code, String nameEN, String namePL) {
        this.code = code;
        this.nameEN = nameEN;
        this.namePL = namePL;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

	public String getNamePL() {
		return namePL;
	}

	public void setNamePL(String namePL) {
		this.namePL = namePL;
	}
    
    
    
}