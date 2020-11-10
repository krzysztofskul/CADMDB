package pl.krzysztofskul.user;

import org.mindrot.jbcrypt.BCrypt;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.user.userCategory.UserCategory;

import javax.persistence.*;
import java.util.ArrayList;
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

    //@ManyToOne
    //private UserCategory userCategory;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "users_usersCategories",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "userCategory_id")
    )
    private List<UserCategory> userCategoryList = new ArrayList<>();

    @ManyToOne
    private Hospital hospital;

    @OneToMany(mappedBy = "investor")
    private List<Hospital> hospitalListAsInvestor = new ArrayList<>();

    @OneToMany(mappedBy = "manager", cascade = CascadeType.PERSIST)
    private List<Hospital> hospitalManagingList = new ArrayList<>();

    @OneToMany(mappedBy = "userManager")
    private List<Department> departmentManagingList = new ArrayList<>();

    @OneToMany(mappedBy = "userManager")
    private List<Room> roomManagingList = new ArrayList<>();

    @ManyToOne
    private Manufacturer manufacturer;

    /** CONSTRUCTORS */

    public User() {
    }

    /** GETTERS AND SETTERS */

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


    public List<UserCategory> getUserCategoryList() {
        return userCategoryList;
    }

    public void setUserCategoryList(List<UserCategory> userCategoryList) {
        this.userCategoryList = userCategoryList;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Hospital> getHospitalListAsInvestor() {
        return hospitalListAsInvestor;
    }

    public void setHospitalListAsInvestor(List<Hospital> hospitalListAsInvestor) {
        this.hospitalListAsInvestor = hospitalListAsInvestor;
    }

    public List<Hospital> getHospitalManagingList() {
        return hospitalManagingList;
    }

    public void setHospitalManagingList(List<Hospital> hospitalManagerList) {
        this.hospitalManagingList = hospitalManagerList;
    }

    public List<Department> getDepartmentManagingList() {
        return departmentManagingList;
    }

    public void setDepartmentManagingList(List<Department> departmentManager) {
        this.departmentManagingList = departmentManager;
    }

    public List<Room> getRoomManagingList() {
        return roomManagingList;
    }

    public void setRoomManagingList(List<Room> roomManager) {
        this.roomManagingList = roomManager;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /** METHODS */

    public void addHospitalToUserManagingList(Hospital hospital) {
        hospitalManagingList.add(hospital);
        hospital.setManager(this);
    }

    public void addUserCategory(UserCategory userCategory) {
        userCategoryList.add(userCategory);
    }

    public void addHospitalToHospitalsAsInvestor(Hospital hospital) {
        hospitalListAsInvestor.add(hospital);
        hospital.setInvestor(this);
    }



}
