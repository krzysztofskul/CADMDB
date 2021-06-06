package pl.krzysztofskul.organization.hospital.department.room;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;

import java.util.List;

@Service
@Transactional
public class RoomService {

    private RoomRepo roomRepo;
    private DepartmentService departmentService;

    @Autowired
    public RoomService(
            RoomRepo roomRepo,
            DepartmentService departmentService
    ) {
        this.roomRepo = roomRepo;
        this.departmentService = departmentService;
    }

    public void save(Room room) {
        room.setDepartment(departmentService.loadByIdWithHospitalAndItsDepartmentList(room.getDepartment().getId()));
        if (room.getCountry() == null) {
            room.setCountry(room.getDepartment().getCountry());
        }
        if (room.getPostalCode() == null) {
            room.setPostalCode(room.getDepartment().getPostalCode());
        }
        if (room.getCity() == null) {
            room.setCity(room.getDepartment().getCity());
        }
        if (room.getStreet() == null) {
            room.setStreet(room.getDepartment().getStreet());
        }
        if (room.getStreetNo() == null) {
            room.setStreetNo(room.getDepartment().getStreetNo());
        }
        if (room.getPhone() == null) {
            room.setPhone(room.getDepartment().getPhone());
        }
        if (room.getEmail() == null) {
            room.setEmail(room.getDepartment().getEmail());
        }
        if (room.getWww() == null) {
            room.setWww(room.getDepartment().getWww());
        }
        roomRepo.save(room);
    }

    public List<Room> loadAll() {
        return roomRepo.findAll();
    }

    public Room loadById(Long id) {
        return roomRepo.findById(id).get();
    }

    public Room loadByIdWithUsers(Long id) {
        Room room = roomRepo.findById(id).get();
        //Hibernate.initialize(room.geUserList());
        return room;
    }

    public void delete(Room room) {
        roomRepo.delete(room);
    }

    public Room loadByIdWithProducts(Long roomId) {
        Room room = roomRepo.findById(roomId).get();
        Hibernate.initialize(room.getProductList());
        Hibernate.initialize(room.getDepartment());
        Hibernate.initialize(room.getRoomCategory());
        return room;
    }
}
