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

    private float area;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.REMOVE)
    private List<Department> departmentList = new ArrayList<>();

    @ManyToOne
    private User manager;

    @OneToMany(mappedBy = "hospital")
    private List<User> userList = new ArrayList<>();

    @Column(length = 2040)
    private String remarks;

    public Hospital() {
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
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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