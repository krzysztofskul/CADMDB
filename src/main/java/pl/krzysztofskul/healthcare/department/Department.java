package pl.krzysztofskul.healthcare.department;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.healthcare.department.room.Room;

@Entity
public class Department<T> extends Healthcare {

	/**
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private T healthcareCompany;
	
	private DepartmentNameStandarizedEnum nameStandarized;
	
	private Set<Room> rooms = new HashSet<Room>();
	
	/**
	 * constr.
	 */
	
	public Department() {
		super();
	}
	
	/**
	 * getters and setters
	 */
	
		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public T getHealthcareCompany() {
		return healthcareCompany;
	}

	public void setHealthcareCompany(T healthcareCompany) {
		this.healthcareCompany = healthcareCompany;
	}

	public DepartmentNameStandarizedEnum getNameStandarized() {
		return nameStandarized;
	}

	public void setNameStandarized(DepartmentNameStandarizedEnum nameStandarized) {
		this.nameStandarized = nameStandarized;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	
	
}
