package pl.krzysztofskul.organization.hospital.department.room.roomCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomCategoryService {

    private RoomCategoryRepo roomCategoryRepo;

    @Autowired
    public RoomCategoryService(RoomCategoryRepo roomCategoryRepo) {
        this.roomCategoryRepo = roomCategoryRepo;
    }

    public void save(RoomCategory roomCategory) {
        roomCategoryRepo.save(roomCategory);
    }

    public List<RoomCategory> loadAll() {
        return roomCategoryRepo.findAll();
    }

    public RoomCategory loadById(Long id) {
        return roomCategoryRepo.findById(id).get();
    }

    public RoomCategory loadByCode(String code) {
        return roomCategoryRepo.findByCode(code);
    }

    public void delete(RoomCategory roomCategory) {
        roomCategoryRepo.delete(roomCategory);
    }

}
