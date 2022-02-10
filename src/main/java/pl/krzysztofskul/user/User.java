package pl.krzysztofskul.user;

import org.mindrot.jbcrypt.BCrypt;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.investor.Investor;
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

    @OneToMany(mappedBy = "userInvestor")
    private List<Hospital> hospitalListWhereAsUserInvestor = new ArrayList<>();

    @ManyToOne
    private Investor investorCompany;

    @OneToMany(mappedBy = "manager")
    private List<Hospital> hospitalManagingList = new ArrayList<>();

    @OneToMany(mappedBy = "userManager", cascade = CascadeType.PERSIST)
    private List<Department> departmentManagingList = new ArrayList<>();

    @OneToMany(mappedBy = "userManager", cascade = CascadeType.PERSIST)
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

	/**
	 * @return the investorCompany
	 */
	public Investor getInvestorCompany() {
		return investorCompany;
	}

	/**
	 * @param investorCompany the investorCompany to set
	 */
	public void setInvestorCompany(Investor investorCompany) {
		this.investorCompany = investorCompany;
	}
    
//    public Investor getInvestmentCompany() {
//        return investorCompany;
//    }
//
//    public void setInvestmentCompany(Investor investmentCompany) {
//        this.investorCompany = investmentCompany;
//    }

	
	/**
	 * @return the hospitalListWhereAsUserInvestor
	 */
	public List<Hospital> getHospitalListWhereAsUserInvestor() {
		return hospitalListWhereAsUserInvestor;
	}

	/**
	 * @param hospitalListWhereAsUserInvestor the hospitalListWhereAsUserInvestor to set
	 */
	public void setHospitalListWhereAsUserInvestor(List<Hospital> hospitalListWhereAsUserInvestor) {
		this.hospitalListWhereAsUserInvestor = hospitalListWhereAsUserInvestor;
	}
	
//    public List<Hospital> getHospitalListAsInvestor() {
//        return hospitalListWhereAsUserInvestor;
//    }
//
//    public void setHospitalListAsInvestor(List<Hospital> hospitalListAsInvestor) {
//        this.hospitalListWhereAsUserInvestor = hospitalListAsInvestor;
//    }

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
    
    public void removeHospitalFromUserManagingList(Hospital hospital) {
		hospitalManagingList.remove(hospital);
		hospital.setManager(null);
	}

    public void addUserCategory(UserCategory userCategory) {
        userCategoryList.add(userCategory);
    }

    public void addHospitalToUserAsInvestor(Hospital hospital) {
        this.hospitalListWhereAsUserInvestor.add(hospital);
        hospital.setUserInvestor(this);
    }


}
