package pl.krzysztofskul.healthcare.department;

import pl.krzysztofskul.category.CategoryEnumOperations;

public enum DepartmentNameStandarizedEnum implements CategoryEnumOperations {
	
	DEMO_DEPARTMENT ("DEMO", "Demo department", "Oddzia³ demonstracyjny", null, null),
	ADMINISTRATION ("ADM", "Administration", "Dzia³ administracji", null, null),
	OPERATING_THEATER("OR", "Operating theater", "Blok operacyjny", null, null),
	ICU ("ICU", "Intensive care unit", "Oddzia³ intensywnej terapii", null, null),
	CSSD ("CSSD", "Central sterile services department", "Centralna sterylizatornia", null, null),
	HEPATOLOGY ("HEPA", "Hepatology department", "Oddzia³ hepatologii", null, null),
	NEUROLOGY ("NEURO", "Neurology departmnent", "Oddzia³ neurologii", null, null),
	CARDIOLOGY ("CARDIO", "Cardiology department", "Oddzia³ kardiologii", null, null),
	GASTROLOGY ("GASTRO", "Gastrology department", "Oddzia³ gastrologii", null, null),
	ONCOLOGY ("ONCOLOGY", "Oncology department", "Oddzia³ onkologii", null, null),
	;

	private String code;
	private String nameEN;
	private String namePL;
	private String descriptionEN;
	private String descriptionPL;
	
	
	
	private DepartmentNameStandarizedEnum(String code, String nameEN, String namePL, String descriptionEN,
			String descriptionPL) {
		this.code = code;
		this.nameEN = nameEN;
		this.namePL = namePL;
		this.descriptionEN = descriptionEN;
		this.descriptionPL = descriptionPL;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getNameEN() {
		return nameEN;
	}

	@Override
	public String getNamePL() {
		return namePL;
	}

	@Override
	public String getDescriptionEN() {
		return getDescriptionEN();
	}

	@Override
	public String getDescriptionPL() {
		return descriptionPL;
	}

	
	
}