package pl.krzysztofskul.organization.hospital.department.departmentCategory;

import pl.krzysztofskul.organization.hospital.department.Department;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DepartmentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private String namePL;

    private String nameEN;

    private String descriptionPL;

    private String getDescriptionEN;

    @OneToMany(mappedBy = "departmentCategory")
    private List<Department> departmentList = new ArrayList<>();

    public DepartmentCategory() {
    }

    public DepartmentCategory(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public DepartmentCategory(String code, String namePL, String nameEN) {
        this.code = code;
        this.namePL = namePL;
        this.nameEN = nameEN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getDescriptionPL() {
        return descriptionPL;
    }

    public void setDescriptionPL(String descriptionPL) {
        this.descriptionPL = descriptionPL;
    }

    public String getGetDescriptionEN() {
        return getDescriptionEN;
    }

    public void setGetDescriptionEN(String getDescriptionEN) {
        this.getDescriptionEN = getDescriptionEN;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
