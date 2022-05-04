package pl.krzysztofskul.category;

public enum PatientAgeCategoryEnum implements CategoryEnumOperations {
	
	HYGINIC ("HYG", "Hyginic", "Higieniczne", "Lorem ipsum...", "Lorem ipsum..."),
	CLEANING ("CLEAN", "Cleaning", "Myj¹ce", "Lorem ipsum..deko.", "Lorem ipsum..."),
	DECONTAMINANTION ("DEC", "Decontaminantion", "Dekontaminuj¹ce", "Lorem ipsum..deko.", "Lorem ipsum..."),
	STERILIZATION ("STER", "Sterilization", "Sterylizuj¹ce", "Lorem ipsum...", "Lorem ipsum...");

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
