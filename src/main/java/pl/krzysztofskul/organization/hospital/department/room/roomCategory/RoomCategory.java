package pl.krzysztofskul.organization.hospital.department.room.roomCategory;

import pl.krzysztofskul.organization.hospital.department.room.Room;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RoomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @OneToMany(mappedBy = "roomCategory")
    private List<Room> roomList = new ArrayList<>();

    public RoomCategory() {
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

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
