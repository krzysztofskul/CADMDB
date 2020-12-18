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

    private int sequence;

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

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
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

    @PrePersist
    public void prePersist() {
        if (this.getOrganizationStatusEnum().equals(OrganizationStatusEnum.PLANNING)) {
            this.sequence = 1;
        }
        if (this.getOrganizationStatusEnum().equals(OrganizationStatusEnum.DESIGNING)) {
            this.sequence = 2;
        }
        if (this.getOrganizationStatusEnum().equals(OrganizationStatusEnum.DESIGNING_FINISHED)) {
            this.sequence = 3;
        }
        if (this.getOrganizationStatusEnum().equals(OrganizationStatusEnum.CONSTRUCTION_WORKS)) {
            this.sequence = 4;
        }
        if (this.getOrganizationStatusEnum().equals(OrganizationStatusEnum.CONSTRUCTION_WORKS_FINISHED)) {
            this.sequence = 5;
        }
        if (this.getOrganizationStatusEnum().equals(OrganizationStatusEnum.IN_EXPLOITATION)) {
            this.sequence = 6;
        }
    }
}
