package pl.krzysztofskul.organization.investor;

import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.organization.companyAddress.CompanyAddress;
import pl.krzysztofskul.organization.companyAddress.CompanyAddressDemoGenerator;
import pl.krzysztofskul.organization.companyType.CompanyType;
import pl.krzysztofskul.organization.companyType.CompanyTypeService;
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

    //@OneToMany
    //private List<User> employeeList = new ArrayList<>();

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


}
