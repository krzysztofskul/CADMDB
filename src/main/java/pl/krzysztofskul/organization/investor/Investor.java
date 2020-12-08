package pl.krzysztofskul.organization.investor;

import pl.krzysztofskul.organization.companyAddress.CompanyAddress;
import pl.krzysztofskul.organization.companyAddress.CompanyAddressDemoGenerator;
import pl.krzysztofskul.organization.companyType.CompanyType;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Investor {

    /**
     * params.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private CompanyType companyType;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CompanyAddress companyAddress = CompanyAddressDemoGenerator.getCompanyAddressDemo();

    @OneToMany(mappedBy = "investmentCompany")
    private List<User> employeeList = new ArrayList<>();

    @OneToMany(mappedBy = "investmentCompany")
    private List<Hospital> hospitalList = new ArrayList<>();

    /**
     * constr.
     */

    public Investor() {
    }

    /**
     * get. sett.
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public CompanyAddress getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(CompanyAddress companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<User> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<User> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }


    /**
     * additional methods
     */

    public void addEmployee(User employee) {
        this.employeeList.add(employee);
        employee.setInvestmentCompany(this);
    }

    public void removeEmployee(User employee) {
        this.employeeList.remove(employee);
        employee.setInvestmentCompany(this);
    }
    
    public void addHospital(Hospital hospital) {
        this.hospitalList.add(hospital);
        hospital.setInvestmentCompany(this);
    }

    public void removeHospital(Hospital hospital) {
        this.hospitalList.remove(hospital);
        hospital.setInvestmentCompany(this);
    }
    
}
