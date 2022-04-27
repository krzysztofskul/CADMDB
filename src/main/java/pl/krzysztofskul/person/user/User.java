package pl.krzysztofskul.person.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.krzysztofskul.person.Person;
import pl.krzysztofskul.person.employee.Employee;

@Entity
public class User<T> extends Person {
	
	private String nickname;
	
	private String email;
	
	private String password;
	
	private UserRole userRole;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee emploeyee;

	@ManyToOne
	private T company;
	
	public User() {
		super();
	}
	
	
	public User(String nameFirst, String nameLast, String nickname, String email, String password, UserRole userRole,
			Employee emploeyee) {
		super(nameFirst, nameLast);
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.emploeyee = emploeyee;
	}



	public User(String nickname, String email, String password, UserRole userRole) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}

	public User(String nickname, String email, String password, UserRole userRole, Employee emploeyee) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.emploeyee = emploeyee;
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

	public Employee getEmploeyee() {
		return emploeyee;
	}

	public void setEmploeyee(Employee emploeyee) {
		this.emploeyee = emploeyee;
	}

	
	
}