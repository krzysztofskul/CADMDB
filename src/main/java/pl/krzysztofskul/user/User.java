package pl.krzysztofskul.user;

import org.mindrot.jbcrypt.BCrypt;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.user.userCategory.UserCategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameFirst;
    private String nameLast;
    private String email;
    private String password;

    @ManyToOne
    private UserCategory userCategory;

    @ManyToOne
    private Hospital hospital;

    @OneToMany(mappedBy = "userManager")
    private List<Department> departmentManager;

    @OneToMany(mappedBy = "userManager")
    private List<Room> roomManager;

    @ManyToOne
    private Manufacturer manufacturer;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
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
        //this.password = password;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Department> getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(List<Department> departmentManager) {
        this.departmentManager = departmentManager;
    }

    public List<Room> getRoomManager() {
        return roomManager;
    }

    public void setRoomManager(List<Room> roomManager) {
        this.roomManager = roomManager;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
