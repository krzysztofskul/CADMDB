package pl.krzysztofskul.organization.hospital.department.room;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomService {

    private RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public void save(Room room) {
        roomRepo.save(room);
    }

    public List<Room> loadAll() {
        return roomRepo.findAll();
    }

    public Room loadById(Long id) {
        return roomRepo.findById(id).get();
    }

    public void delete(Room room) {
        roomRepo.delete(room);
    }

    public Room loadByIdWithProducts(Long roomId) {
        Room room = roomRepo.findById(roomId).get();
        Hibernate.initialize(room.getProductList());
        return room;
    }
}
