package pl.krzysztofskul.person.user;

public enum UserRole {
	
	ADMIN("ADMIN", "Admin", "Admin"), 
	ADMIN_DEMO("ADMIN-DEMO", "Demo admin", "Admin demo"), 
	USER("USER", "User", "U¿ytkownik"), 
	USER_DEMO("USER-DEMO", "Demo user", "U¿ytkownik demo"), 
	GUEST("GUEST", "Guest", "Goœæ"), 
	GUEST_ADMIN("GUEST-ADMIN", "Admin as a guest)", "Admin jako goœæ"), 
	GUEST_USER("GUEST-USER", "User as a guest", "U¿ytkownik jako goœæ");

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
