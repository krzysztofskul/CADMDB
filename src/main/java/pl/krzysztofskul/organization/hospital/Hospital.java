package pl.krzysztofskul.organization.hospital;

import pl.krzysztofskul.organization.Organization;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital extends Organization {

    /**
     * PARAMS.
     */

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private int streetNo;

    private String www;

    private String email;

    private String phone;

    private float area;

    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Department> departmentList = new ArrayList<>();

    @ManyToOne
    private User investor;

    @ManyToOne
    private User manager;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST)
    private List<User> userList = new ArrayList<>();

    @Column(length = 2040)
    private String remarks;


    /**
     * CONSTRUCTORS
     */

    public Hospital() {
    }

    /**
     * GETTERS AND SETTERS
     */

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String url) {
        this.www = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
        for (Department department : departmentList) {
            department.setHospital(this);
        }
    }

    public User getInvestor() {
        return investor;
    }

    public void setInvestor(User investor) {
        this.investor = investor;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        for (User user : userList) {
            user.setHospital(this);
        }
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * ADDITIONAL METHODS
     */

    public void addDepratment(Department department) {
        this.departmentList.add(department);
        department.setHospital(this);
    }

    public void removeDepartment(Department department) {
        this.departmentList.remove(department);
        department.setHospital(null);
    }

    public void addUser(User user) {
        this.userList.add(user);
        for (User u : this.userList) {
            u.setHospital(this);
        }
    }

    public void removeUser(User user) {
        this.userList.remove(user);
        for (User u : this.userList) {
            u.setHospital(null);
        }
    }

}