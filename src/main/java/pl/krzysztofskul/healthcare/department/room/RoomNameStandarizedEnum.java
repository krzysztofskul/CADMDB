package pl.krzysztofskul.healthcare.department.room;

import pl.krzysztofskul.category.CategoryEnumOperations;

public enum RoomNameStandarizedEnum implements CategoryEnumOperations {

	DEMO ("DEMO", "Demo room", "Pomieszczenie przyk³adowe", null, null),
	REGISTRATION ("REGISTRATION", "Registration", "Recepcja", null, null),
	SECRETARIAT ("SECRETARIAT", "Secretary's office", "Sekretariat", null, null),
	TECHNICAL_ROOM ("TECH", "Technical room", "Pomieszczenie techniczne", null, null),
	CONSULTATION_ROOM ("CONSULTATION", "Consultation room", "Pomieszczenie kosultacyjne", null, null),
	DIAGNOSTIC_ROOM ("DIAG", "Diagnostic room", "Pomieszczenie diagnostyczne", null, null),
	OPERATION_ROOM ("OPERATION", "Operation room", "Pomieszczenie zabiegowe", null, null),
	DIAGNOSTIC_AND_OEPRATION_ROOM ("DIAG-OPER", "Diagnostic and operation room", "Pomieszczenie diagnostyczno-zabiegowe", null, null)
	;
	
	private String code;
	private String nameEN;
	private String namePL;
	private String descriptionEN;
	private String descriptionPL;
		
	private RoomNameStandarizedEnum(String code, String nameEN, String namePL, String descriptionEN,
			String descriptionPL) {
		this.code = code;
		this.nameEN = nameEN;
		this.namePL = namePL;
		this.descriptionEN = descriptionEN;
		this.descriptionPL = descriptionPL;
	}

	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameEN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamePL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescriptionEN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescriptionPL() {
		// TODO Auto-generated method stub
		return null;
	}
}
