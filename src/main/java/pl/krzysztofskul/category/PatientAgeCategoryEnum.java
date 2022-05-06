package pl.krzysztofskul.category;

public enum PatientAgeCategoryEnum implements CategoryEnumOperations {
	
	NEWBORN ("NEWBORN", "Newborn", "Nowordkowe", "Lorem ipsum...", "Lorem ipsum..."),
	NEONATAL ("NEONATAL", "Neonatal", "Neonatalogiczne", "Lorem ipsum..deko.", "Lorem ipsum..."),
	INFANT ("INFANT", "Infant", "Niemowlêce", "Lorem ipsum..deko.", "Lorem ipsum..."),
	CHILD ("CHILD", "Child", "Dzieciêce", "Lorem ipsum...", "Lorem ipsum..."),
	ADULT ("ADULT", "Adult", "Doroœli", "Lorem ipsum...", "Lorem ipsum..."),
	GERIATRIC ("GERIATRIC", "Geriatric", "Geriatryczne", "Lorem ipsum...", "Lorem ipsum...");

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
	private PatientAgeCategoryEnum(String code, String nameEN, String namePL, String descriptionEN,
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
