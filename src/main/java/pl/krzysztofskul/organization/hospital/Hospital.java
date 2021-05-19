package pl.krzysztofskul.organization.hospital;

import pl.krzysztofskul.organization.Organization;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.investor.Investor;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Hospital extends Organization {

    /**
     * PARAMS.
     */

    // private BigDecimal budget //budget for equipment from super class

    // private BigDecimal costOfDepartmentsPlan; // costs of equipment planned to buy to departments

    // private BigDecimal costOfDepartmentsFinished; // cost of equipment already bought iin departments

    @NotBlank(message = "The hospital name cannot be blank!")
    private String name;

    @NotBlank(message = "Country cannot be blank!")
    private String country;

    @NotBlank(message = "City cannot be blank!")
    private String city;

    private String postalCode;

    private String street;

    private Integer streetNo;

    private String www;

    private String email;

    private String phone;

    @NotNull(message = "The area of the hospital cannot be null! You can change it later, but it is needed to declare the value!")
    @DecimalMin(value = "100.00", message = "The area of the hospital cannot be less than 100 m2!")
    private Float area;

    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Department> departmentList = new ArrayList<>();

    @ManyToOne
    private User investor;

    @ManyToOne
    private Investor investmentCompany;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User manager;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST)
    private List<User> employeeList = new ArrayList<>();

    @Column(length = 2048)
    private String remarks;


    /**
     * CONSTRUCTORS
     */

    public Hospital() {
    }

    /**
     * GETTERS AND SETTERS
     */

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

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

    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
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

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
        for (Department department : departmentList) {
            department.setHospital(this);
            //this.costOfDepartmentsPlan += department.costOfRoomsPlan;
        }
    }

    public User getInvestor() {
        return investor;
    }

    public void setInvestor(User investor) {
        this.investor = investor;
    }

    public Investor getInvestmentCompany() {
        return investmentCompany;
    }

    public void setInvestmentCompany(Investor investmentCompany) {
        this.investmentCompany = investmentCompany;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<User> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<User> userList) {
        this.employeeList = userList;
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

    public void addDepartment(Department department) {
        this.departmentList.add(department);
        //this.costOfDepartmentsPlan += department.costOfRoomsPlan
        department.setHospital(this);
    }

    public void removeDepartment(Department department) {
        this.departmentList.remove(department);
        //this.costOfDepartmentsPlan -= department.costOfRoomsPlan
        department.setHospital(null);
    }

    public void addUser(User user) {
        this.employeeList.add(user);
        user.setHospital(this);
//        for (User u : this.employeeList) {
//            u.setHospital(this);
//        }
    }

    public void removeUser(User user) {
        this.employeeList.remove(user);
        user.setHospital(null);
//        for (User u : this.employeeList) {
//            u.setHospital(null);
//        }
    }

    public String getClassName() {
        return "hospital";
    }
}