package pl.krzysztofskul.organization.hospital.department;

import pl.krzysztofskul.organization.Organization;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategory;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department extends Organization {

    @ManyToOne
    private Hospital hospital;

    private float area;

    @ManyToOne
    private User userManager;

    @ManyToOne
    private DepartmentCategory departmentCategory;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Room> roomList = new ArrayList<>();

    @Column(length = 255*8)
    private String remarks;

    public Department() {
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public User getUserManager() {
        return userManager;
    }

    public void setUserManager(User userManager) {
        this.userManager = userManager;
    }

    public DepartmentCategory getDepartmentCategory() {
        return departmentCategory;
    }

    public void setDepartmentCategory(DepartmentCategory departmentCategory) {
        this.departmentCategory = departmentCategory;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
        for (Room room : roomList) {
            room.setDepartment(this);
        }
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    public void removeRoom(Room room) {
        this.roomList.remove(room);
    }

}