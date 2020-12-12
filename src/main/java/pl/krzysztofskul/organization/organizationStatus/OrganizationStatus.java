package pl.krzysztofskul.organization.organizationStatus;

import pl.krzysztofskul.organization.hospital.department.room.Room;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrganizationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private OrganizationStatusEnum organizationStatusEnum;

    @OneToMany(mappedBy = "organizationStatus")
    private List<Room> roomList = new ArrayList<>();

    public OrganizationStatus() {
    }

    public OrganizationStatus(OrganizationStatusEnum organizationStatusEnum) {
        this.organizationStatusEnum = organizationStatusEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public OrganizationStatusEnum getOrganizationStatusEnum() {
        return organizationStatusEnum;
    }

    public void setOrganizationStatusEnum(OrganizationStatusEnum organizationStatusEnum) {
        this.organizationStatusEnum = organizationStatusEnum;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return this.getOrganizationStatusEnum().toString();
    }
}
