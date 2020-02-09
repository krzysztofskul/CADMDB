package pl.krzysztofskul.organization.hospital;

import pl.krzysztofskul.organization.Organization;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital extends Organization {

    @OneToMany(mappedBy = "hospital")
    private List<Department> departmentList = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private List<User> userList = new ArrayList<>();

    public Hospital() {
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
