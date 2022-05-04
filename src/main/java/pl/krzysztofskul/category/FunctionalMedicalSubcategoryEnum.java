package pl.krzysztofskul.category;

public enum FunctionalMedicalSubcategoryEnum implements CategoryEnumOperations {
	
	CONSULTATION ("CONSULT", "Consultation", "Konsultacyjne", "Lorem ipsum...", "Lorem ipsum..."),
	DIAGNOSTICS ("DIAG", "Diagnostics", "Diagnostyczne", "Lorem ipsum...", "Lorem ipsum..."),
	DIAGNOSTICS_AND_OPERATIONS ("DIAG-OP", "Diagnostics and operations", "Diagnostyczno-zabiegowe", "Lorem ipsum...", "Lorem ipsum..."),
	OPERATIONS ("OP", "Oparations", "Zabiegowe", "Lorem ipsum...", "Lorem ipsum..."),
	SURGERY_ANAESTHESIA_INTENSIVE_CARE ("ICU", "Surgery, anaesthesia and ICU", "Chirurgiczne, anestezjologiczne i intensywnej terapii", "Lorem ipsum...", "Lorem ipsum...");

	private String code;
	private String nameEN;
	private String namePL;
	private String descriptionEN;
	private String descriptionPL;
	
	
	/**
	 * @param code
	 * @param nameEN
	 * @param namePL
	 * @param descriptionEN
	 * @param descriptionPL
	 */
	private FunctionalMedicalSubcategoryEnum(String code, String nameEN, String namePL, String descriptionEN,
			String descriptionPL) {
		this.code = code;
		this.nameEN = nameEN;
		this.namePL = namePL;
		this.descriptionEN = descriptionEN;
		this.descriptionPL = descriptionPL;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getNameEN() {
		return this.nameEN;
	}

	@Override
	public String getNamePL() {
		return this.namePL;
	}

	@Override
	public String getDescriptionEN() {
		return this.descriptionEN;
	}

	@Override
	public String getDescriptionPL() {
		return this.descriptionPL;
	}


	
	
}
