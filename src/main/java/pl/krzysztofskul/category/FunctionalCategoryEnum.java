package pl.krzysztofskul.category;

public enum FunctionalCategoryEnum implements CategoryEnumOperations {

	MEDICAL ("MED", "Medical", "Medyczne", "Lorepm ipsum...", "Lorepm ipsum..."),
	LABORATORY ("LAB", "Laboratory", "Laboratoryjne", "Lorepm ipsum...", "Lorepm ipsum..."),
	TECHNICAL ("TECH", "Technical", "Techniczne", "Lorepm ipsum...", "Lorepm ipsum..."),
	SANITARY ("SANIT", "Sanitary", "Sanitarne", "Lorepm ipsum...", "Lorepm ipsum..."),
	PHARAMCY ("PHARM", "Pharmaceutic", "Apteczne", "Lorepm ipsum...", "Lorepm ipsum..."),
	ADMINISTRATION ("ADMIN", "Administration/Office", "Administracyjne/Biurowe", "Lorepm ipsum...", "Lorepm ipsum...");
	
	/**
	 * PARAMS.
	 * 
	 */

	private String code;
	private String nameEN;
	private String namePL;
	private String descriptionEN;
	private String descriptionPL;
	
	/**
	 * CONSTR.
	 * 
	 */

	/**
	 * @param code
	 * @param nameEN
	 * @param namePL
	 * @param descriptionEN
	 * @param descriptionPL
	 */
	private FunctionalCategoryEnum(String code, String nameEN, String namePL, String descriptionEN,
			String descriptionPL) {
		this.code = code;
		this.nameEN = nameEN;
		this.namePL = namePL;
		this.descriptionEN = descriptionEN;
		this.descriptionPL = descriptionPL;
	}


	/**
	 * GETTERS AND SETTERS
	 * 
	 */

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the nameEN
	 */
	public String getNameEN() {
		return nameEN;
	}

	/**
	 * @return the namePL
	 */
	public String getNamePL() {
		return namePL;
	}

	/**
	 * @return the descriptionEN
	 */
	public String getDescriptionEN() {
		return descriptionEN;
	}


	/**
	 * @return the descriptionPL
	 */
	public String getDescriptionPL() {
		return descriptionPL;
	}


	/**
	 * @param code the code to set
	 */
	private void setCode(String code) {
		this.code = code;
	}


	/**
	 * @param nameEN the nameEN to set
	 */
	private void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}


	/**
	 * @param namePL the namePL to set
	 */
	private void setNamePL(String namePL) {
		this.namePL = namePL;
	}


	/**
	 * @param descriptionEN the descriptionEN to set
	 */
	private void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}


	/**
	 * @param descriptionPL the descriptionPL to set
	 */
	private void setDescriptionPL(String descriptionPL) {
		this.descriptionPL = descriptionPL;
	}
	

	
}
