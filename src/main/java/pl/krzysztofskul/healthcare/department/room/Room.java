package pl.krzysztofskul.healthcare.department.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.healthcare.department.Department;
import pl.krzysztofskul.healthcare.department.DepartmentNameStandarizedEnum;

@Entity
public class Room extends Healthcare {

	/**
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne
	private Department department;
	
	private RoomNameStandarizedEnum nameStandarized;
	
	/**
	 * constr.
	 */

	public Room() {
		super();
	}

	public Room(RoomNameStandarizedEnum roomNameStandarizedEnum) {
		super();
		this.setNameStandarized(roomNameStandarizedEnum);
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public RoomNameStandarizedEnum getNameStandarized() {
		return nameStandarized;
	}

	public void setNameStandarized(RoomNameStandarizedEnum nameStandarized) {
		this.nameStandarized = nameStandarized;
	}
	
}
