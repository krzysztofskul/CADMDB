package pl.krzysztofskul.healthcare.department;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import pl.krzysztofskul.company.Company;
import pl.krzysztofskul.healthcare.Healthcare;
import pl.krzysztofskul.healthcare.department.room.Room;
import pl.krzysztofskul.healthcare.hospital.Hospital;

@Entity
public class Department<T> extends Healthcare<Department> {

	/**
	 * params.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne(targetEntity  = Company.class)
	private T healthcareCompany;
	
	private DepartmentNameStandarizedEnum nameStandarized;
	
//	@ManyToOne
//	private Department parentDepartment;
	
	@OneToMany(mappedBy = "healthcareCompany")
	private Set<Department> subDepartments = new HashSet<Department>();
	
	@OneToMany
	private Set<Room> rooms = new HashSet<Room>();
	
	/**
	 * constr.
	 */
	
	public Department() {
		super();
	}
	
	
	
	public Department(DepartmentNameStandarizedEnum nameStandarized) {
		super();
		this.nameStandarized = nameStandarized;
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
	
//	public Department getParentDepartment() {
//		return parentDepartment;
//	}
//
//	public void setParentDepartment(Department parentDepartment) {
//		this.parentDepartment = parentDepartment;
//	}

	public Set<Department> getSubDepartments() {
		return subDepartments;
	}

	public void setSubDepartments(Set<Department> subDepartments) {
		this.subDepartments = subDepartments;
	}

	/**
	 * methods
	 */
	
	public void addRoom(Room room) {
		this.rooms.add(room);
		room.setDepartment(this);
	}
	
//	public void addSubDepartment(Department subDepartment) {
//		this.subDepartments.add(subDepartment);
//		subDepartment.setParentDepartment(subDepartment);
//	}
}
