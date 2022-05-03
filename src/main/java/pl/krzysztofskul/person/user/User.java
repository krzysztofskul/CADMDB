package pl.krzysztofskul.person.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.person.Person;
import pl.krzysztofskul.person.employment.Employment;

@Entity
public class User<T> extends Person {
	
	private String nickname;
	
	private String email;
	
	private String password;
	
	private UserRole userRole;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employment_id", referencedColumnName = "id")
	private Employment employment = new Employment();
	
	public User() {
		super();
	}

	public User(String nameFirst, String nameLast, String nickname, String email, String password, UserRole userRole) {
		super(nameFirst, nameLast);
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	
	public User(String nameFirst, String nameLast, String nickname, String email, String password, UserRole userRole,
			Employment employment) {
		super(nameFirst, nameLast);
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.employment = employment;
	}

	public User(String nickname, String email, String password, UserRole userRole) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}

	public User(String nickname, String email, String password, UserRole userRole, Employment employment) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.employment = employment;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}
		
}