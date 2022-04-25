package pl.krzysztofskul.person.user;

public enum UserRole {
	
	ADMIN("ADMIN", "Admin", "Admin"), 
	USER("USER", "User", "U¿ytkownik"), 
	GUEST("GUEST", "Guest", "Goœæ"), 
	GUEST_ADMIN("GUEST-ADMIN", "Guest as Admin)", "Goœæ jako Admin)"), 
	GUEST_USER("GUEST-USER", "Guest as User", "Goœæ jako U¿ytkownik");

	private String code;
	private String userRoleToStringEN;
	private String userRoleToStringPL;
	
	private UserRole(String code, String userRoleToStringEN, String userRoleToStringPL) {
		this.code = code;
		this.userRoleToStringEN = userRoleToStringEN;
		this.userRoleToStringPL = userRoleToStringPL;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserRoleToStringEN() {
		return userRoleToStringEN;
	}

	public void setUserRoleToStringEN(String userRoleToStringEN) {
		this.userRoleToStringEN = userRoleToStringEN;
	}

	public String getUserRoleToStringPL() {
		return userRoleToStringPL;
	}

	public void setUserRoleToStringPL(String userRoleToStringPL) {
		this.userRoleToStringPL = userRoleToStringPL;
	}

	
	
}
